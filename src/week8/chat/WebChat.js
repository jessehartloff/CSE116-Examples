const socket = io.connect("http://localhost:8080", {transports: ['websocket']});
let registered = false;

socket.on('chat_history', function (event) {
    update(event);
});

function update(history) {
    const chatHistory = JSON.parse(history);
    let formattedHistory = "";
    for (const message of chatHistory) {
        formattedHistory += "<b>" + message['username'] + "</b>: " + message['message'] + "<br/>"
    }
    document.getElementById("chat_history").innerHTML = formattedHistory;
}

function register() {
    let username = document.getElementById("username").value;
    socket.emit("register", username);
    document.getElementById("username_div").innerHTML = "";
    registered = true;
}

function sendMessage() {
    if (registered) {
        let message = document.getElementById("chat_input").value;
        document.getElementById("chat_input").value = "";
        socket.emit("chat_message", message);
    }
}
