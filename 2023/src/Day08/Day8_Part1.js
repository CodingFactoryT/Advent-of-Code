const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n\n");

const instructions = input[0];
const network = input[1].split("\n");

const instructionMap = new Map();

fillInstructionMap();
const steps = calculateSteps();
console.log(steps);

function fillInstructionMap() {
    const regex = /([A-Z]{3}) = \(([A-Z]{3}), ([A-Z]{3})\)/
    network.forEach((node) => {
        const match = regex.exec(node);
        instructionMap.set(match[1], {left: match[2], right: match[3]});
    });
}

function calculateSteps() {
    let steps = 0;
    let instructionIndex = 0;
    let currentNode = "AAA";
    while(currentNode !== "ZZZ") {
        const instruction = instructions[instructionIndex % instructions.length];
        if(instruction === "L") {
            currentNode = instructionMap.get(currentNode).left;
        } else {    //instruction === "R"
            currentNode = instructionMap.get(currentNode).right;
        }

        instructionIndex++;
        steps++;
    }

    return steps;
}

