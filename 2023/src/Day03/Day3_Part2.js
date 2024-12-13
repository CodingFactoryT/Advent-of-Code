const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>
`.split("\n");
let sum = 0;
const GEAR = "*";
const EMPTY_SPACE = ".";

const gearPositions = getGearPositions();
console.log(calculateSummedGearRatios(gearPositions));

function getAdjacentNumbers(gearPosition) {
    let numbers = [];
    let replacableInput = [...input];
    
    for(let x = gearPosition.x - 1; x <= gearPosition.x + 1; x++) { //check for numbers top and bottom of the gear
        const [newReplacableInput, number] = getNumber(replacableInput, x, gearPosition.y - 1);
        numbers = numbers.concat(number);
        const [newReplacableInput2, number2] = getNumber(newReplacableInput, x, gearPosition.y + 1);
        numbers = numbers.concat(number2);

        replacableInput = newReplacableInput2;
    }    

    const [newReplacableInput, number] = getNumber(replacableInput, gearPosition.x - 1, gearPosition.y);
    numbers = numbers.concat(number);
    const [newReplacableInput2, number2] = getNumber(newReplacableInput, gearPosition.x + 1, gearPosition.y);
    numbers = numbers.concat(number2);
    return numbers;
}

function getNumber(input, x, y) {
    if(isDigit(getCharAt2DArray(input, x, y))) {
        const [number, startingPointNumberX] = getNumberByDigitPosition(input, x, y);
        input[y] = input[y].substring(0, startingPointNumberX) + ".".repeat(number.length) + input[y].substring(startingPointNumberX + number.length);
        return [input, [number]];
    }

    return [input, []];
}

function calculateSummedGearRatios(gearPositions) {
    let summedGearRatios = 0;

    gearPositions.forEach((gearPosition) => {
        let numbers = getAdjacentNumbers(gearPosition)
        if(numbers.length === 2) {
            summedGearRatios += numbers[0] * numbers[1];
        }
    });

    return summedGearRatios;
}

function getGearPositions() {
    const gearPositions = [];

    for(let i = 0; i < input.length; i++) {
        for(let j = 0; j < input[0].length; j++) {
            if(isGear(input[i][j])) {
                gearPositions.push({y: i, x: j});
            }
        }
    }

    return gearPositions;
}

function getNumberByDigitPosition(input, x, y) {
    const numberStartingPointX = getNumberStartingPointX(input, x, y);
    const [number, length] = getNumberWithLength(input, y, numberStartingPointX);
    return [number, numberStartingPointX];
}

function getNumberStartingPointX(input, digitX, digitY) {
    let startingPointX = digitX;
    while(startingPointX >= 0 && isDigit(input[digitY][startingPointX - 1])) {
        startingPointX--;
    }
    return startingPointX;
}

function getNumberWithLength(input, indexI, startingIndexJ) {
    let number = "";
    while(startingIndexJ < input[0].length && isDigit(input[indexI][startingIndexJ])) {    //as long as there are digits
        number += input[indexI][startingIndexJ];
        startingIndexJ++;
    }
    return [number, number.length];
}


function isDigit(character) {
    if(!character) return false;
    return character.match(/[0-9]/);
}

function isGear(character) {
    if(!character) return false;
    return character === GEAR;
}

function getCharAt2DArray(input, x, y) {
    if(x < 0 ||
       x >= input[0].length ||
       y < 0 ||
       y >= input.length) {
        return EMPTY_SPACE;
    }
    return input[y][x];
}