let mapHeight = 0;
let mapWidth = 0;
let tiles = [[]];

const partySize = 2.5;

socket.on('overworldMap', function (event) {
    setup(event);
});

socket.on('overworldState', function (event) {
    let parsed = JSON.parse(event);
    let playerParty = {};
    let otherParties = [];
    for (const party of parsed) {
        if (party['partyId'] === myPartyId) {
            playerParty = party
        } else {
            otherParties.push(party)
        }
    }
    update(JSON.stringify({'playerParty': playerParty, 'otherParties': otherParties}));
});

function setup(jsonOverworld) {
    const overworld = JSON.parse(jsonOverworld);
    mapHeight = overworld['mapSize']['y'];
    mapWidth = overworld['mapSize']['x'];
    tiles = overworld['tiles'];
}

function update(jsonOverworldState) {
    const overworldState = JSON.parse(jsonOverworldState);

    context.clearRect(0, 0, windowWidth, windowHeight);

    const playerParty = overworldState['playerParty'];
    const otherParties = overworldState['otherParties'];

    const playerLocation = playerParty['location'];

    const upperLeft = {
        'x': Math.max(0, playerLocation['x'] - screenWidth / 2.0),
        'y': Math.max(0, playerLocation['y'] - screenHeight / 2.0)
    };

    drawGameBoard(upperLeft);

    for (const otherParty of otherParties) {
        const x = otherParty['location']['x'];
        const y = otherParty['location']['y'];
        if (x > upperLeft['x'] && x < upperLeft['x'] + screenWidth &&
            y > upperLeft['y'] && y < upperLeft['y'] + screenHeight) {
            const redShade = Math.min(255, otherParty['level'] * 25 + 100);
            const enemyColor = otherParty['inBattle'] ? '#888888' : rgb(redShade, 0, 0);
            placeParty(x - upperLeft['x'], y - upperLeft['y'], enemyColor);
        }
    }

    const shade = Math.max(0, 150 - playerParty['level'] * 25);
    const playerColor = rgb(shade, shade, 255);
    placeParty(playerLocation['x'] - upperLeft['x'],
        playerLocation['y'] - upperLeft['y'],
        playerColor);

}


function drawGameBoard(upperLeft) {
    const x = upperLeft['x'];
    const y = upperLeft['y'];

    for (let i = Math.floor(x); i < x + screenWidth; i++) {
        for (let j = Math.floor(y); j < y + screenHeight; j++) {
            if (i < 0 || y < 0 || i >= mapWidth || j >= mapHeight) {
                placeTile(i - x, j - y, '#000000');
            } else {
                const tile = tiles[j][i];
                placeTile(i - x, j - y, tile['passable'] ? '#66ff66' : '#222266');
            }
        }
    }

}

function placeTile(x, y, color) {
    context.fillStyle = color;
    context.fillRect(x * tileSize, y * tileSize, tileSize, tileSize);
    context.strokeStyle = 'black';
    context.strokeRect(x * tileSize, y * tileSize, tileSize, tileSize);
}

function placeParty(x, y, color) {
    const scaledSize = partySize / 5.0 * tileSize;
    const scaledX = x * tileSize + scaledSize;
    const scaledY = y * tileSize + scaledSize;
    context.fillStyle = color;
    context.beginPath();
    context.arc(scaledX, scaledY, scaledSize, 0, 2 * Math.PI);
    context.fill();
    context.strokeStyle = 'black';
    context.stroke();
}


function cleanInt(input) {
    const value = Math.round(input);
    const asString = value.toString(16);
    return value > 15 ? asString : "0" + asString;
}

function rgb(r, g, b) {
    return "#" + cleanInt(r) + cleanInt(g) + cleanInt(b);
}
