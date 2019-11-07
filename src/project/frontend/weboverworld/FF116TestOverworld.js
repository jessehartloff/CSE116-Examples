let tilesTest = [];

for (let i = 0; i < 500; i++) {
    let row = [];
    for (let j = 0; j < 500; j++) {
        row.push({"type": "", "passable": Math.random() > 0.1});
    }
    tilesTest.push(row);
}

const map = {'mapSize': {'x': tilesTest[0].length, 'y': tilesTest.length}, 'tiles': tilesTest};

setup(JSON.stringify(map));


let playerX = 146.7;
let playerY = 496.3;


function testUpdate() {

    const stateTest = {
        'playerParty': {'location': {'x': playerX, 'y': playerY}, 'level': 1, 'inBattle': false},
        'otherParties': [
            {'location': {'x': 136.7, 'y': 490.8}, 'level': 2, 'inBattle': false},
            {'location': {'x': 140.7, 'y': 493.8}, 'level': 3, 'inBattle': true},
            {'location': {'x': 140.9, 'y': 493.2}, 'level': 4, 'inBattle': true},
            {'location': {'x': 139.9, 'y': 488.0}, 'level': 5, 'inBattle': false},
            {'location': {'x': 132.3, 'y': 490.0}, 'level': 10, 'inBattle': false},
            {'location': {'x': 150.3, 'y': 492.0}, 'level': 7, 'inBattle': false}
        ]
    };

    update(JSON.stringify(stateTest));
}



function handleEventTest(event) {
    if (event.key === "w" || event.key === "ArrowUp") {
        playerY -= 0.4;
    } else if (event.key === "a" || event.key === "ArrowLeft") {
        playerX -= 0.4;
    } else if (event.key === "s" || event.key === "ArrowDown") {
        playerY += 0.4;
    } else if (event.key === "d" || event.key === "ArrowRight") {
        playerX += 0.4;
    }
    testUpdate();
}

document.addEventListener("keydown", function (event) {
    handleEventTest(event);
});


testUpdate();