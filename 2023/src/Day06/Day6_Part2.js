const time = 48938466;
const distance = 261119210191063;

let possibleRecordBreaks = 0;
for(let j = 0; j < time; j++) {
    if(j * (time-j) > distance) {
        possibleRecordBreaks++;
    }
}

console.log(possibleRecordBreaks);