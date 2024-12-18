const input = `<GET FROM ADVENT-OF-CODE-WEBSITE>`.split("\n");

const expandedImage = expandImage(input);
const galaxyCoordinates = getGalaxyCoordinates(expandedImage);
const summedDistances = getSummedDistances(galaxyCoordinates);
console.log(summedDistances);

function expandImage(image) {
    for(let row = 0; row < image.length; row++) {   
        if(image[row] === ".".repeat(image[0].length)) {   //horizontal replacements
            image.splice(row, 0, image[row]);
            row++;
        }
    }

    for(let column = 0; column < image[0].length; column++) {   //vertical replacements
        let areAllDots = true;
        for(let row = 0; row < image.length; row++) {
            if(image[row][column] !== ".") {
                areAllDots = false;
            }
        }
        if(areAllDots) {
            for(let row = 0; row < image.length; row++) {
                image[row] = image[row].substring(0, column) + "." + image[row].substring(column);
            }
            column++;
        }
    }
    

    return image;
}

function getGalaxyCoordinates(image) {
    let coordinates = [];
    for(let i = 0; i < image.length; i++) {
        for(let j = 0; j < image[0].length; j++) {
            if(image[i][j] === "#") {
                coordinates.push({x: j, y: i});
            }
        }
    }
    return coordinates;
}

function getSummedDistances(coordinates) {
    let result = 0;
    for(let i = 0; i < coordinates.length; i++) {
        for(let j = i + 1; j < coordinates.length; j++) {
            const distance = Math.abs(coordinates[i].x - coordinates[j].x) + Math.abs(coordinates[i].y - coordinates[j].y);
            result += distance;
        }
    }

    return result
}