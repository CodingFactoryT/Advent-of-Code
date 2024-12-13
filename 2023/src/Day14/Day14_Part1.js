const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

const MOVABLE_ROCK = "O";
const FREE_SPOT = ".";


rollNorth();
console.log(calculateTotalNorthBeamLoad());

function rollNorth() {
    for(let i = 0; i < input.length; i++) {
        for(let columnIndex = 0; columnIndex < input[0].length; columnIndex++) {
            for(let rowIndex = 0; rowIndex < input[0].length; rowIndex++) {
                const currentColumnValue = input[columnIndex];
                const currentRock = currentColumnValue[rowIndex];
                if(currentRock === MOVABLE_ROCK && isAboveSpotFree(columnIndex, rowIndex)) {
                    input[columnIndex] = replaceCharAt(currentColumnValue, FREE_SPOT, rowIndex);

                    const columnAboveValue = input[columnIndex - 1];
                    input[columnIndex - 1] = replaceCharAt(columnAboveValue, MOVABLE_ROCK, rowIndex);
                }
            }
        }
    }
}

function isAboveSpotFree(columnIndex, rowIndex) {
    if(columnIndex <= 0) {   //top edge
        return false;
    }

    const spotAbove = input[columnIndex - 1][rowIndex];

    return spotAbove === FREE_SPOT;
}

function calculateTotalNorthBeamLoad() {
    let northBeamLoad = 0;
    input.forEach((columnValue, columnIndex)=> {
        const loadPerRock = input.length - columnIndex;
        const rocks = columnValue.split("O").length - 1;
        northBeamLoad += loadPerRock * rocks;
    });

    return northBeamLoad;
}

function replaceCharAt(string, character, index) {
    return string.substring(0, index) + character + string.substring(index + 1);
}

