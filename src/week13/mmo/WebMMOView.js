const socket = io.connect("http://localhost:8080", {transports: ['websocket']});

socket.on('gameState', function (event) {
    update(event);
});


var canvas = document.getElementById("canvas");
var context = canvas.getContext("2d");
context.globalCompositeOperation = 'source-over';

const height = 600;
const width = 800;

canvas.setAttribute("height", height.toString() + "px");
canvas.setAttribute("width", width.toString() + "px");


function update(event) {
    console.log(event);
    const gameState = JSON.parse(event);

    context.clearRect(0, 0, width, height);

    for (let player of gameState['players']) {
        placeSquare(player['x'], player['y'], player['id'] === socket.id ? '#ffff00' : '#56bcff', 5.0);
    }
}


function placeSquare(x, y, color, size) {
    context.fillStyle = color;
    context.fillRect(x, y, size, size);
    context.strokeStyle = 'black';
    context.strokeRect(x , y , size, size);
}

