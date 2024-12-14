const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

console.log(calculateSumOfPreviousValues());

function calculateSumOfPreviousValues() {
    let sum = 0;
    input.forEach((numberSequence) => {
        numberSequence = numberSequence.split(" ").map((numberString) => {
            return Number(numberString);
        });
        sum += getPreviousValueOfNumberSequence(numberSequence);
    });

    return sum;
}

function getPreviousValueOfNumberSequence(numberSequence) {
    const differenceArray = getDifferenceArray([numberSequence]);
    const extrapolatedArray = extrapolateDifferenceArray(differenceArray);
    const previousValueOfNumberSequence = extrapolatedArray[0][0];
    return previousValueOfNumberSequence;
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
            differenceArray[i].unshift(0);  //unshift puts a value at the beginning of the array
            continue;
        }

        const firstRowValueBelow = differenceArray[i + 1][0];
        const firstCurrentRowValue = differenceArray[i][0];
        differenceArray[i].unshift(firstCurrentRowValue - firstRowValueBelow );
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