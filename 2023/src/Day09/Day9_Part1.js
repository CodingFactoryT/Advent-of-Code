const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

console.log(calculateSumOfNextValues());

function calculateSumOfNextValues() {
    let sum = 0;
    input.forEach((numberSequence) => {
        numberSequence = numberSequence.split(" ").map((numberString) => {
            return Number(numberString);
        });
        sum += getNextValueOfNumberSequence(numberSequence);
    });

    return sum;
}

function getNextValueOfNumberSequence(numberSequence) {
    const differenceArray = getDifferenceArray([numberSequence]);
    const extrapolatedArray = extrapolateDifferenceArray(differenceArray);

    const lastIndex = extrapolatedArray[0].length - 1
    const nextValueOfNumberSequence = extrapolatedArray[0][lastIndex];
    return nextValueOfNumberSequence;
}

function getDifferenceArray(numberSequence) {
    const lastIndex = numberSequence.length - 1;
    if(areAllValuesOfArrayZero(numberSequence[lastIndex])) {
        return numberSequence;
    }

    numberSequence.push(getDifferences(numberSequence[lastIndex]));
    return getDifferenceArray(numberSequence);
}

function getDifferences(numberSequence) {
    const differences = [];
    for(let i = 0; i < numberSequence.length - 1; i++) {
        differences.push(numberSequence[i + 1] - numberSequence[i]);
    }

    return differences;
}

function extrapolateDifferenceArray(differenceArray) {
    const lastIndex = differenceArray.length - 1;
    for(let i = lastIndex; i >= 0; i--) {
        if(i === lastIndex) {
            differenceArray[i].push(0);
            continue;
        }

        const arrayLength = differenceArray[i].length;
        const lastRowIndexBelow = differenceArray[i + 1][arrayLength - 1];
        const indexLeftFromCurrentPosition = differenceArray[i][arrayLength - 1]
        differenceArray[i].push(lastRowIndexBelow + indexLeftFromCurrentPosition);
    }

    return differenceArray;
}

function areAllValuesOfArrayZero(array) {
    let areAllZero = true;

    array.forEach((number) => {
        if(number !== 0) {
            areAllZero = false;
        }
    });

    return areAllZero;
}