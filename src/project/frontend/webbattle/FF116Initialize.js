const socket = io.connect("http://localhost:8080", {transports: ['websocket']});

let myPartyId = "???";

socket.on('yourPartyId', function (event) {
    myPartyId = event;
});

let inBattle = false;

const canvas = document.getElementById("canvas");
const context = canvas.getContext("2d");

const tileSize = 30;
const screenHeight = 20;
const screenWidth = 30;

const windowHeight = tileSize * screenHeight;
const windowWidth = tileSize * screenWidth;

canvas.setAttribute("height", (screenHeight * tileSize) + "px");
canvas.setAttribute("width", (screenWidth * tileSize) + "px");
