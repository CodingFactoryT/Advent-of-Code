const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

const regex = /Game ([0-9]+)[:] ((?:[\s]?[0-9]+ (?:green|red|blue)[,|;]?)+)/;
let sum = 0;
input.forEach((element) => {
    const matches = regex.exec(element);
    const gameID = matches[1];
    const groups = matches[2].split(/,|;/);
    let maxBlue = 0;
    let maxRed = 0;
    let maxGreen = 0;
    groups.forEach((pair) => {
        const splitPair = pair.trim().split(/\s/);
        const amount = splitPair[0];
        const color = splitPair[1];
        switch(color) {
            case "blue":
                if(maxBlue < amount) {
                    maxBlue = Number(amount);
                }
                break;
            case "red":
                if(maxRed < amount) {
                    maxRed = Number(amount);
                }
                break;
            case "green":
                if(maxGreen < amount) {
                    maxGreen = Number(amount);
                }
                break;
            default:
                console.error("Invalid color!");
                break;
        }
    });
    sum += maxBlue * maxRed * maxGreen;
});

console.log(sum);