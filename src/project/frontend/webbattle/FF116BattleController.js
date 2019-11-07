socket.on('turnReady', function (event) {
    turnReady(event);
});

let turnState = "none"; // "chooseOption" "chooseTarget"
let turnQueue = [];
let chosenOption = "";

let currentBattleOptions = [];
let currentTurnName = "";
let filteredParties = [];

function turnReady(event) {
    if (turnQueue.length === 0 && turnState === "none") {
        takeTurn(event);
    } else {
        turnQueue.push(event)
    }
}

function takeTurn(characterName) {
    currentTurnName = characterName;
    let i = 0;
    for (let friend of initialBattleState['playerParty']['characters']) {
        if (friend['name'] === characterName) {
            currentBattleOptions = friend['battleOptions'];
            drawCharacter(1, i, "white", friend);
            drawOptions(currentBattleOptions);
            turnState = "chooseOption"
        }
        i++;
    }
}

function processClick(x, y) {
    if (!inBattle) {
        const party = 2;
        for (let position = 0; position < filteredParties.length; position++) {
            const px = xByPosition(position);
            const py = yByParty(party);
            if (x >= px && x <= px + characterSize() &&
                y >= py && y <= py + optionSize()) {
                const attackParty = filteredParties[position];
                socket.emit("startBattle", attackParty)
            }
        }
    } else if (turnState === "chooseOption") {
        const party = 2;
        for (let position = 0; position < currentBattleOptions.length; position++) {
                const px = xByPosition(position);
                const py = yByParty(party);
                if (x >= px && x <= px + characterSize() &&
                    y >= py && y <= py + optionSize()) {
                    chosenOption = currentBattleOptions[position];
                    turnState = "chooseTarget";
                    currentBattleOptions = [];
                    drawOptions();
                }
        }
    } else if (turnState === "chooseTarget") {
        for (let party of [0, 1]) {
            for (let position of [0, 1, 2, 3]) {
                if (targets[party][position] !== false) {
                    const px = xByPosition(position);
                    const py = yByParty(party);

                    if (x >= px && x <= px + characterSize() &&
                        y >= py && y <= py + characterSize()) {

                        let targetPartyId = partyIds[party];
                        let targetName = targets[party][position]['name'];

                        const message = {
                            "action": chosenOption,
                            "targetPartyId": targetPartyId,
                            "target": targetName,
                            "source": currentTurnName
                        };

                        console.log(currentTurnName + " chooses " + chosenOption + " targeting " + targetName);

                        socket.emit("battleAction", JSON.stringify(message));

                        if (turnQueue.length !== 0) {
                            takeTurn(turnQueue[0]);
                            turnQueue.shift();
                        } else {
                            turnState = "none";
                        }

                    }

                }
            }
        }
    }
}

function handleEvent(event) {
    processClick(event.layerX, event.layerY);
}

document.getElementById('canvas').addEventListener("click", handleEvent);
document.getElementById('canvas').addEventListener("touch", handleEvent);