socket.on('battleState', function (event) {
    receiveBattleState(event);
});

socket.on('actionTaken', function (event) {
    const action = JSON.parse(event);
    if (state === "battle") {
        animate(action['source'], action['target'], action['deltaHP']);
    }
});

socket.on('allParties', function (event) {
    if (!inBattle) {
        drawParties(event);
    }
});
socket.on('battleEnded', function (event) {
    inBattle = false;
});

let partyIds = [];

let targets = [
    [false, false, false, false],
    [false, false, false, false]
];

let initialBattleState = null;
let backgroundColor = "#aaaaaa";

function yByParty(party) {
    return party === 0 ? 0.2 / 4.0 * windowHeight : (party === 1 ? 2.0 / 4.0 * windowHeight : 3.35 / 4.0 * windowHeight);
}

function xByPosition(position) {
    return (position + 0.5) / 5.0 * windowWidth;
}

function receiveBattleState(battleState) {
    inBattle = true;
    drawBattle(battleState);
}

function drawParties(partiesJSON) {
    context.clearRect(0, 0, windowWidth, windowHeight);
    context.fillStyle = backgroundColor;
    context.fillRect(0, 0, windowWidth, windowHeight);

    let parties = JSON.parse(partiesJSON);
    filteredParties = [];
    for(let i = 0; i < parties.length && i < 4; i++){
        if(parties[i] !== myPartyId){
            filteredParties.push(parties[i]);
        }
    }
    drawOptions(filteredParties);
}

function drawBattle(battleStateJSON) {
    context.clearRect(0, 0, windowWidth, windowHeight);
    context.fillStyle = backgroundColor;
    context.fillRect(0, 0, windowWidth, windowHeight);

    let battleState = JSON.parse(battleStateJSON);

    initialBattleState = battleState;

    partyIds = [battleState['enemyParty']['partyId'], battleState['playerParty']['partyId']];

    let i = 0;
    for (let enemy of battleState['enemyParty']['characters']) {
        drawCharacter(0, i, "#ff5555", enemy);
        targets[0][i] = enemy;
        i++
    }

    i = 0;
    for (let friendly of battleState['playerParty']['characters']) {
        drawCharacter(1, i, "#5555ff", friendly);
        targets[1][i] = friendly;
        i++;
    }


    for (let i of [0, 1, 2, 3]) {
        const x = xByPosition(i);
        const y = yByParty(2);
        context.strokeStyle = '#000000';
        context.strokeRect(x, y, characterSize(), optionSize());
    }

    drawOptions(currentBattleOptions);
}

function getPartyPositionByCharacterName(name) {
    for (let party of [0, 1]) {
        for (let position of [0, 1, 2, 3]) {
            if (targets[party][position]['name'] === name) {
                return [party, position];
            }
        }
    }
    return [-1, -1];
}


function animate(source, target, deltaHP) {

    const sourceInfo = getPartyPositionByCharacterName(source);
    const targetInfo = getPartyPositionByCharacterName(target);

    let color = "blue";
    if (deltaHP > 0) {
        color = "green";
    } else if (deltaHP < 0) {
        color = "red";
    }

    flashCharacter(sourceInfo[0], sourceInfo[1], "white", sourceInfo[0] === 1 ? "#5555ff" : "#ff5555", targets[sourceInfo[0]][sourceInfo[1]]);

    const hp = targets[targetInfo[0]][targetInfo[1]]['hp'];
    const maxHP = targets[targetInfo[0]][targetInfo[1]]['maxHP'];
    targets[targetInfo[0]][targetInfo[1]]['hp'] = Math.min(maxHP, Math.max(0, hp + deltaHP));

    setTimeout(function () {
            flashCharacter(targetInfo[0], targetInfo[1], color, targetInfo[0] === 1 ? "#5555ff" : "#ff5555", targets[targetInfo[0]][targetInfo[1]])
        }, 1000
    )

}


function optionSize() {
    return Math.min(windowHeight, windowWidth) / 10.0
}

function characterSize() {
    return Math.min(windowHeight, windowWidth) / 4.0
}

function drawOptions(options) {
    for (let i = 0; i < options.length; i++) {
        const x = xByPosition(i);
        const y = yByParty(2);
        context.fillStyle = '#ffffff';
        context.fillRect(x, y, characterSize(), optionSize());
        context.strokeStyle = '#000000';
        context.strokeRect(x, y, characterSize(), optionSize());
        context.fillStyle = 'black';
        const fontSize = 16;
        context.font = fontSize + "px Consolas";
        context.fillText(options[i], x + 5, y + optionSize() / 2);// + fontSize / 2);
    }
    for (let i = options.length; i < 4; i++) {
        const x = xByPosition(i);
        const y = yByParty(2);
        context.fillStyle = backgroundColor;
        context.fillRect(x, y, characterSize(), optionSize());
    }
}


function drawCharacter(party, position, color, character, overrideDeath = false) {
    const x = xByPosition(position);
    const y = yByParty(party);
    context.fillStyle = character['hp'] === 0 && !overrideDeath ? 'black' : color;
    context.fillRect(x, y, characterSize(), characterSize());
    context.strokeStyle = 'black';
    context.strokeRect(x, y, characterSize(), characterSize());
    context.fillStyle = character['hp'] === 0 ? 'white' : 'black';
    const fontSize = 16;
    context.font = fontSize + "px Consolas";
    context.fillText(character['name'], x + 5, y + 5 + fontSize);
    context.fillText(character['hp'] + "/" + character['maxHP'], x + 5, y + 5 + 2.1 * fontSize);
}

function flashCharacter(party, position, color, finalColor, character) {
    drawCharacter(party, position, '#ffff99', character, true);
    setTimeout(function () {
        drawCharacter(party, position, color, character, true);
    }, 200);
    setTimeout(function () {
        drawCharacter(party, position, finalColor, character);
    }, 700);

}
