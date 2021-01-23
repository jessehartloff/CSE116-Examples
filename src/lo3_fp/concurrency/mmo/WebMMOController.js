let lastUpdate = new Date().getTime();
let updateInterval = 80;

document.getElementById('canvas').addEventListener("mousemove", function (event) {
    const currentTime = new Date().getTime();
    if (currentTime - lastUpdate > updateInterval) {
        socket.emit("location", JSON.stringify({"x": event.clientX, "y": event.clientY}));
        lastUpdate = currentTime;
    }
});
