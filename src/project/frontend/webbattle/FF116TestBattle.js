
const party1 = {
    "partyId": "partyId_1",
    "characters": [
        {"name": "Hero", "hp": 70, "maxHP": 70, "battleOptions": ["attack", "power attack", "small stab", "thrust"]},
        {"name": "Comic Relief", "hp": 50, "maxHP": 70, "battleOptions": ["do nothing"]},
        {"name": "The Mage", "hp": 50, "maxHP": 70, "battleOptions": ["attack", "magic attack", "big bang"]}
    ]
};
const party2 = {
    "partyId": "partyId_2",
    "characters": [
        {"name": "Goblin A", "hp": 50, "maxHP": 50, "battleOptions": ["sword swipe", "move around"]},
        {"name": "Goblin B", "hp": 0, "maxHP": 50, "battleOptions": ["sword swipe", "move around"]},
        {"name": "God Emperor", "hp": 30, "maxHP": 80, "battleOptions": ["attack up", "heal", "poke", "super nova"]},
        {"name": "Metal Slime", "hp": 3, "maxHP": 3, "battleOptions": ["run away"]}
    ]
};

const battleState = {"playerParty": party1, "enemyParty": party2};

receiveBattleState(JSON.stringify(battleState));
setTimeout(function () {
    animate("Hero", "Goblin B", -95);
}, 500);
setTimeout(function () {
    animate("Comic Relief", "God Emperor", 0);
}, 2500);
setTimeout(function () {
    animate("Metal Slime", "Goblin B", 95);
}, 4500);
setTimeout(function () {
    turnReady("Comic Relief");
}, 100);
setTimeout(function () {
    turnReady("The Mage");
}, 200);
setTimeout(function () {
    turnReady("Hero");
}, 300);
setTimeout(function () {
    turnReady("Comic Relief");
}, 10000);
