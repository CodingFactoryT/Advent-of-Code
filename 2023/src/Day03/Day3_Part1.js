const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");
let sum = 0;

for(let i = 0; i < input.length; i++) {
    for(let j = 0; j < input[0].length; j++) {
        if(isDigit(input[i][j])) {
            const [number, numberLength] = getNumberWithLength(i, j, input);
            if(isNumberAdjacentToSymbol(i, j, numberLength, input)) {
                sum += Number(number);
            }
            j += numberLength - 1;
        }
    }
}

console.log(sum);

function getNumberWithLength(indexI, startingIndexJ, array) {
    let number = "";
    while(startingIndexJ < array[0].length && isDigit(array[indexI][startingIndexJ])) {    //as long as there are digits
        number += input[indexI][startingIndexJ];
        startingIndexJ++;
    }

    return [number, number.length];
}

function isNumberAdjacentToSymbol(indexI, indexJ, numberLength, array) {
    let isAdjacent = false;
    if(indexJ > 0 && isSymbol(array[indexI][indexJ-1])) {    //check character left of the number
        isAdjacent = true;
    }
    if(indexJ + numberLength < array[0].length && isSymbol(array[indexI][indexJ + numberLength])) {    //check character right of the number
        isAdjacent = true;
    }

    for(let p = indexJ - 1; p < indexJ + numberLength + 1; p++) {
        if(indexI > 0 && isSymbol(array[indexI - 1][p])) {  //check top of each digit
            isAdjacent = true;
            break;
        }

        if(indexI < array[0].length - 1 && isSymbol(array[indexI + 1][p])) {  //check bottom of each digit
            isAdjacent = true;
            break;
        }
    }

    return isAdjacent;
}

function isDigit(character) {
    if(!character) return false;
    return character.match(/[0-9]/);
}

function isSymbol(character) {
    if(!character) return false;
    return !character.match(/[0-9, \.]/);
}