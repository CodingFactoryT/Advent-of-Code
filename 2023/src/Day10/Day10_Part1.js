const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

const pipeMap = new Map([
    ["|", {north: true, east: false, south: true, west: false}],    //true if it connects, false if it doesn´t connect
    ["-", {north: false, east: true, south: false, west: true}],
    ["L", {north: true, east: true, south: false, west: false}],
    ["J", {north: true, east: false, south: false, west: true}],
    ["7", {north: false, east: false, south: true, west: true}],
    ["F", {north: false, east: true, south: true, west: false}],
    [".", {north: false, east: false, south: false, west: false}],
    ["S", {north: true, east: true, south: true, west: true}]
]);

let startingPosition = {x: 0, y: 0}
input.forEach((element, indexY) => {
    let indexX;
    if((indexX = element.indexOf("S")) !== -1) {
        startingPosition = {x: indexX, y: indexY}
    }
});
console.log(computeDistance(startingPosition, startingPosition, 0, input));

let maxDistance = 0;

function computeDistance(startingPosition, currentPosition, distance, array){ //deep recursive function, you probably have to increase the stack size to execute it
    const currentPipe = getPipeAtArrayPosition(currentPosition, array);
    if(currentPipe !== "S") {
        array[currentPosition.y] = array[currentPosition.y].substring(0, currentPosition.x) + "." + array[currentPosition.y].substring(currentPosition.x + 1);  //replace current position with "." so the next computed pipe won´t go back
    }
    
    if(currentPosition.x === startingPosition.x && currentPosition.y === startingPosition.y && distance > 2) {
        return distance / 2;
    }
    
    distance++;

    const leftPipe = getPipeAtArrayPosition({x: currentPosition.x - 1, y: currentPosition.y}, array);
    const rightPipe = getPipeAtArrayPosition({x: currentPosition.x + 1, y: currentPosition.y}, array);
    const abovePipe = getPipeAtArrayPosition({x: currentPosition.x, y: currentPosition.y - 1}, array);
    const belowPipe = getPipeAtArrayPosition({x: currentPosition.x, y: currentPosition.y + 1}, array);

    if(pipeMap.get(currentPipe).west && pipeMap.get(leftPipe).east && (leftPipe !== "S" || distance > 2)) {   //current and left pipe are connected
        return computeDistance(startingPosition, {x: currentPosition.x - 1, y: currentPosition.y}, distance, array);
    }
    if(pipeMap.get(currentPipe).east && pipeMap.get(rightPipe).west && (rightPipe !== "S" || distance > 2)) {   //current and right pipe are connected
        return computeDistance(startingPosition, {x: currentPosition.x + 1, y: currentPosition.y}, distance, array);
    }
    if(pipeMap.get(currentPipe).north && pipeMap.get(abovePipe).south && (abovePipe !== "S" || distance > 2)) {   //current and above pipe are connected
        return computeDistance(startingPosition, {x: currentPosition.x, y: currentPosition.y - 1}, distance, array);
    }
    if(pipeMap.get(currentPipe).south && pipeMap.get(belowPipe).north && (belowPipe !== "S" || distance > 2)) {   //current and below pipe are connected
        return computeDistance(startingPosition, {x: currentPosition.x, y: currentPosition.y + 1}, distance, array);
    }
}

function getPipeAtArrayPosition(position, array) {
    if(position.x < 0 ||
        position.x >= array[0].length ||
        position.y < 0 ||
        position.y >= array.length) {
        return "."
    }

    return array[position.y][position.x];
}