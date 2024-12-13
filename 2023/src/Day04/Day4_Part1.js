const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

const regex = /Card[\s]+([0-9]+):[\s]+((?:[0-9]+(?:[\s]+)?)+)\|[\s]*((?:[0-9]+(?:[\s]+)?)+)/;
let sum = 0;
input.forEach((entry) => {
    const matches = regex.exec(entry);
    const cardNumber = matches[1];
    const winningNumbers = matches[2].trim().replace(/\s+/g, " ").split(" ");
    const havingNumbers = matches[3].trim().replace(/\s+/g, " ").split(" ");
    
    let cardValue = 0;

    havingNumbers.forEach((number) => {
        if(winningNumbers.includes(number)) {
            if(cardValue == 0) {
                cardValue++;
            } else {
                cardValue *= 2;
            }
        }
    });

    sum += cardValue;
});
console.log(sum);