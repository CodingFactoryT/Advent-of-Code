const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

const regex = /Game ([0-9]+)[:] ((?:[\s]?[0-9]+ (?:green|red|blue)[,|;]?)+)/;
let sum = 0;
input.forEach((element) => {
    let isGameValid = true;
    const matches = regex.exec(element);
    const gameID = matches[1];
    const groups = matches[2].split(/,|;/);
    groups.forEach((pair) => {
        const splitPair = pair.trim().split(/\s/);
        const amount = splitPair[0];
        const color = splitPair[1];
        if((color === "red" && amount > 12) ||
            (color === "green" && amount > 13) ||
            (color === "blue" && amount > 14)) {

            isGameValid = false;
        }
    });

    if(isGameValid) {
        sum += Number(gameID);
    }
});

console.log(sum);