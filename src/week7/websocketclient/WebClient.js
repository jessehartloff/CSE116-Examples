const socket = io.connect("http://localhost:8080", {transports: ['websocket']});

function setupSocket() {
    socket.on('ACK', function (event) {
        document.getElementById("display_message").innerHTML = event;
    });
}


function sendMessage() {
    let message = document.getElementById("chat_input").value;
    document.getElementById("chat_input").value = "";
    socket.emit("chat_message", message);
}
