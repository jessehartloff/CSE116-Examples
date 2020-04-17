const socket = io.connect("http://localhost:8080", {transports: ['websocket']});
let registered = false;

socket.on('chat_history', update);

socket.on('new_message', addMessage);

function addMessage(newMessage) {
    const message = JSON.parse(newMessage);
    const formattedMessage = "<b>" + message['username'] + "</b>: " + message['message'] + "<br/>";
    const chatElement = document.getElementById("chat_history");
    chatElement.innerHTML = formattedMessage + chatElement.innerHTML;
}

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
