const socket = io.connect("http://localhost:8080", {transports: ['websocket']});

socket.on('ACK', function (event) {
    document.getElementById("display_message").innerHTML = event;
});

socket.on('server_stopped', function (event) {
    document.getElementById("display_message").innerHTML = "The server has stopped";
});


function sendMessage() {
    let message = document.getElementById("chat_input").value;
    document.getElementById("chat_input").value = "";
    socket.emit("chat_message", message);
}
