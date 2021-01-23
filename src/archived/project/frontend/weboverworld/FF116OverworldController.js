const keyStates = {
    "w": false,
    "a": false,
    "s": false,
    "d": false
};


function setState(key, toSet) {
    if (keyStates[key] !== toSet) {
        keyStates[key] = toSet;
        sendDirection();
    }
}

function sendDirection() {
    let x = 0.0;
    let y = 0.0;

    if (keyStates['a'] && !keyStates['d']) {
        x = -1.0;
    } else if (!keyStates['a'] && keyStates['d']) {
        x = 1.0;
    }

    if (keyStates['w'] && !keyStates['s']) {
        y = -1.0;
    } else if (!keyStates['w'] && keyStates['s']) {
        y = 1.0;
    }

    const direction = {'x': x, 'y': y};
    socket.emit("overworldMovement", JSON.stringify(direction));
}


function handleEvent(event, toSet) {
    if (event.key === "w" || event.key === "ArrowUp") {
        setState("w", toSet);
    } else if (event.key === "a" || event.key === "ArrowLeft") {
        setState("a", toSet);
    } else if (event.key === "s" || event.key === "ArrowDown") {
        setState("s", toSet);
    } else if (event.key === "d" || event.key === "ArrowRight") {
        setState("d", toSet);
    }
}

document.addEventListener("keydown", function (event) {
    handleEvent(event, true);
});

document.addEventListener("keyup", function (event) {
    handleEvent(event, false);
});
