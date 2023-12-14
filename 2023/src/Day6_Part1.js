
const times = [48, 93, 84, 66];
const distances = [261, 1192, 1019, 1063];

let result = 1;
for(let i = 0; i < times.length; i++) {
    let possibleRecordBreaks = 0;
    for(let j = 0; j < times[i]; j++) {
        if(j * (times[i]-j) > distances[i]) {
            possibleRecordBreaks++;
        }
    }
    result *= possibleRecordBreaks;
}

console.log(result);