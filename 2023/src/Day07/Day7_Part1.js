const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

let handsWithBidsAndType = [];

input.forEach((element) => {
    const splittedElement = element.split(" ");
    const hand = splittedElement[0];
    const bid = splittedElement[1];
    const type = getType(hand);

    handsWithBidsAndType.push({hand: hand, bid: bid, type: type});
});

handsWithBidsAndType = handsWithBidsAndType.sort((a, b) => {
    const difference = parseInt(a.type) - parseInt(b.type);
    const replacementTable = new Map([
        ["A", 13],
        ["K", 12],
        ["Q", 11],
        ["J", 10],
        ["T", 9],
        ["9", 8],
        ["8", 7],
        ["7", 6],
        ["6", 5],
        ["5", 4],
        ["4", 3],
        ["3", 2],
        ["2", 1],
    ]);

    if(difference !== 0) {
        return difference;
    } else {
        for(let i = 0; i < a.hand.length; i++) {
            if(a.hand[i] !== b.hand[i]) {
                const strengthA = replacementTable.get(a.hand[i]);
                const strengthB = replacementTable.get(b.hand[i]);
                return strengthA - strengthB;
            }
        }
    }
});

let sum = 0;
handsWithBidsAndType.forEach((element, index) => {
    sum += parseInt(element.bid) * (index + 1);
});

console.log(sum);



function getType(hand) {
    const characters = new Map();
    for(let i = 0; i < hand.length; i++) {
        const count = characters.get(hand[i]) ?? 0; //?? = nullish conceiling: If the left is undefined, use the right value
        characters.set(hand[i], count + 1);
    }
    
    switch(characters.size) {
        case 1:
            return 7;  //Five of a kind
            break;
        case 2:
            let isFourOfAKind = false;
            for (let [key, value] of characters) {
                if(value === 4) {
                    isFourOfAKind = true;
                }
            }

            if(isFourOfAKind) {
                return 6;  //Four of a kind
            }
            return 5;  //Full house
            break;
        case 3:
            let isThreeOfAKind = false;
            for (let [key, value] of characters) {
                if(value === 3) {
                    isThreeOfAKind = true;
                }
            }

            if(isThreeOfAKind) {
                return 4;  //Three of a kind
            }
            return 3;  //Two pair
            break;
        case 4:
            return 2;  //One pair
            break;
        case 5:
            return 1;  //High card
            break;
        default:
            console.error("ERROR: Hand had no known type: " + hand);
            return -1;
    }
}