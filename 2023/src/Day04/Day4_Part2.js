const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

const regex = /Card[\s]+([0-9]+):[\s]+((?:[0-9]+(?:[\s]+)?)+)\|[\s]*((?:[0-9]+(?:[\s]+)?)+)/;

const cardAmounts = initializeCardAmounts(input.length);

input.forEach((card, index) => {
    const [cardNumber, winningNumbers, havingNumbers] = parseCard(card);
    const matchingNumbersAmount = getMatchingNumbersAmount(winningNumbers, havingNumbers);

    for(let i = 1; i <= matchingNumbersAmount; i++) {
        cardAmounts[index + i] += cardAmounts[index];
    }
});

let sum = 0;
cardAmounts.forEach((element) => {
    sum += element;
});

console.log(sum);


function initializeCardAmounts(arrayLength) {
    const array = [];
    for(let i = 0; i < arrayLength; i++) {
        array.push(1);
    }

    return array;
}

function parseCard(card) {
    const matches = regex.exec(card);
    const cardNumber = matches[1];
    const winningNumbers = matches[2].trim().replace(/\s+/g, " ").split(" ");
    const havingNumbers = matches[3].trim().replace(/\s+/g, " ").split(" ");

    return [cardNumber, winningNumbers, havingNumbers];
}

function getMatchingNumbersAmount(winningNumbers, havingNumbers) {
    let matchingNumbers = 0;

    havingNumbers.forEach((number) => {
        if(winningNumbers.includes(number)) {
            matchingNumbers++;
        }
    });

    return matchingNumbers;
}
