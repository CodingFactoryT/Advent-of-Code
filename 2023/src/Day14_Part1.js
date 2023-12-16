const input = `...#.#.O....#.#.OO.OOO.O..O.......O#OO#.#..#....O...#.....O.O#..O..OO..O.#...#O..#...O...##O...OO...
#O....O#..O.#.#..O#...#O.O....#O.#.#O#........O...O..#.OOO#O#.......OO##O.#.OO.O.#...##.##....O#..O#
.O.......O.O.O.O..O.O.....#....O#..#.#O.#OO...#O.O#.O#..#O...#...O.O.......#.O....O.#..#.O##O#..O...
...O....#.OO..#..OO#..##....#O.......OOOOOO...OO..#...#.O..O....#O..OO.#O...#O#...O..O#..OO....#....
..O...##OOO....#..OO.OO#O##..#.#........O#.#.....#OO...#............#.###..#.#O...#..O.#O#.O#O.....#
...............O.....##..O...O#.O#........#.O.#..#...#..O..O.#...#......#......O.OO.OOO.#.O.....O##.
......#..#..###.OO.#......O..O.O##O..O.....OO.#.OO....O.....OO#O..O....#.....#.#.O#..O..O.OO.O#O.O.#
##O.....O.#.#O...#.#O###....#.O#.#..#..O.#O........O.OO..#..#O#.O#..OO..#.O.##O....#.##O.O.......##.
O#...###...O..#...#......O#.OO.....#...OOO...#.#O.#...##..OO#.......#OO.....#...O...#.#O.........O.O
..O....O....OO..O.O.O........#.O#..O.#..#..OO#.OO..#.O...O..#...O..##..O........O##..........OOO..OO
....##......#.#.O.O#O##.#....#..O#............#..#...#......#O.OO#....O.......O###....O...........OO
.O.OOO..O#....O...O..#.O#.#O.O...#.O..O#...OO#.#....#OO.#........#O.......O...#O......O...O....#...#
.#....#O...##..#.#..........O..#O........OOO.......O.OO.##...#..........#......#.O##.#O#OO#OO..#..O.
......#O...#.#.......O........#O....#O..##....O......O.#.O..#OO............O##O....#O.OO#..O#..O#...
..OO.....O#O..#OOOO#O.##.........O..#OO#......O.OO.....O......OO..O...O..O....O..O#O.......O..O.O#..
....O...OO....##.....OOO...O#O.#.O...O.....#........#.#O#.....O.O.OO.###.#.OO#OO....O.....O..#.#O...
.OO#..O#O#O...#..O.O....O#.O.#........O.O..O....#O#....#.#.O#.#...O.O..O..#..#...OO#O......#O.O..O.#
OO...O.O.#..#....#...#O.O##O#...#............##.O..OOO....O..OO....#OO....O.#....O#.O........OO..#..
..O#.OO#.#O#..O.......O.##.O.#....OO#.#O#.##.O..O#..####....#..#......#...##.O##...O....O..#.#......
#O.O#.....#....O...O.O..O.O.O#O.O#....#..O...#.O.#O...#..#.#O.....#O..##...O.......O.....O..OO#OO##.
..O.#..#...O....#.##.#.O......#.#.##.......#.O..##O#.#O.OOO..O...#O......#..O.....O.OO...O#.O.#OO#.O
.#..OO#.......OO....O.##...O......O.OO#.O......#O..O#..#..O.O..O.#..OO.O.#O..O..#......O...O....O#..
O....#.#O..O#...#..##..##.O.O.O..O.O#...O#..#O.O......#O.......O..O.O...#.#O..OO#.#.....#O#...O..#.O
...O...O.O.O.OO..O....O..O..O##..O.........O#O..O.#...#.O..O.#........#...O........O#.#.O..O.....#..
OO....O#...........#OO......O.....O...#...OO....OO..O.........O.#......##O....#...O##....O.#...#...#
#OO#....#......OO.O....O...#..O...#.OOOO..OOO.O.O...O#.......O....#O#O.O#O......#...#...OO#.O...#..#
....O#.#...O..#.................#.#...O...O...O.O#.##..O.#.#....####..OO....O.......#.OO.O....#...#.
.....O.#.#O..#O...#OO....OO...O#..O...O..#O..O....#.#O..#.......O...O.O.....#.##.#O.OO..#.#....###..
.#O..#...#...#.#.O.#O.#OO..#.#..#O#.#.#O#.O#O#..##..#...#O#.#..#.OO#..#..#..O...O...O..O...#.O....O.
..O.....#....#O#OO#O.....O.....O...OO.O......OO..O....O...#....O....#...OO....O..O...#...###O.....#.
##..##...#OOO...#.OO...#.#.O#.O.........O.O.#.O..O.OO#.O......#.###...#..#O.#....#...#.O..##...#O...
.O.#...O.O....O.......O...#O.....O......OO..OOO##.#...##OO.O......#....O..#..#.##.OO.......#O...#OO.
...#...O#..O.#.OO.#.OO..O.#O.#.O.#...O#....O#.O#......OO.#....#..#..#..#....O.#....##...............
.O.O#....#.#.....O...#.O#O#.......#.#O..OO.O...#....#.....O.#.#.#..#...#...##..O.O...#O..O.#..#O....
.#......O..O#...O.O.##O..#.OOOO.O#O....O#...#O..OO.#.#O......#..O..O.OO#OOO#O#.O.......OO.....O...#O
O##.O..OOO.#..O......#...#O#.O.O#..O.OO..#......O.O.O..O.O.OO..#....O.#O...O#.#..#..O.#...##O.O.....
.#OO#....#.....#..OO.OO...##.O......OOO.#O..O#.O.O.........O#.O.#.#...#..##...#O.O..OO.O#.#..O..O.O.
.O.....#.O#....O#.....#.O..O..O#..#..OOO#O....#OOOOO.#.#.........O#..O.#....#.#....O.#..##..#.......
..O.#OO....#O.#...#O...#.O#..#.O....O.#..O....O#.....O.OO..OO.OO#.#..#..#O.O.#...O....OO...O.#..O..O
.O.OO#...O#.OO....#.O....O.###...#..O.....O....#.O..O.#O.O.....#....#O#O...#..O...O........O...#....
#...#...#..O..#.##.#.....O#..#O.##.O...O...#....O.O.O..O.O........O.O.O.....O..#.......#...O..O.#.#O
#O...#...O.#....#.O.....OOO..O...OO#OO#.......#O.##...#.O#O#....#.....O#..OO.#.#.O.O..O.#OO.O.#..O..
......O.......O.#.O.#.O...........O.O.OO#....#OO........O#.......OO.O..#O...#....O#..O....OO..O##...
.##..O..#O...O.O....#O#..OO#O.#....#O.OO#O....#.....#...#.#OO#.OO.#.O.O.O.OO.#O.O.#.O....#O.O.O..O..
O#..O#O##.O....O..#......O....#..O##O.O#...O...O...OO#..#OO...O##.#....O#.O..O.......#..#......#O..#
O.OO..O..#.O..O#OO#O.....#O..O..#...#.OO.O..O...........O...O...OO##.#..O..#.#.OO.#.#...O.O......O.O
.O.O##.O....#O.O...O#.#..O....#O.....O..O#OO....OO##.#.O..#O.O...O..O.O...#O.OO.........#.##OO#..#..
..OO....O.....#....O.....O...OOO#...#.O.........O.O..OOO.###O.#.......#.#...O.OO.#..O.....#O.....#..
O...##O...O..##..#.#...#.#O#.O...#.#.O..O....##......#...#.O..O...OO.#...OOO#OO...O.O#O..OO.O##O..O.
..#.OO.#.##..O....#...OO.#O.......O.O#...O..#.#O..O.###O#.#.O.O...O.#O.#..#.O..O#O#..O.........#.#..
O.#.O##.......OO#....O#.......O..O.....#.........O.O.....#O.......#O..#.O...#....O.#....#......O.O.#
.OO.O...O.......#O#....#O#...#.........O..O.#.OO#.OO.O#...#O...O..#..O##O.#...O#..O.OO.O...#OO.##.#.
...O.O...OOO.O......#..O...#.##.O..O..#...O.O...#.O.O..OO..OO..#....O.O#..#...O.OO.#.....#...OO#...#
.#............#O.OO..O#.....O..#O.#O.##O....O.O....O..O#..O..O.#..O.#.O.#.O.#..#O.#.OO.O......##...O
#.....O.#..O.O........O#O#OO..OO.....#.#....OO##......O.O.##..##.#.O...O.#.#O......O..##.#.#.#..#O..
##.#.O..O...O..OO...O....O.O..O#...OO....OO#.#...#.#....OO#..........O..O...O...O........#..O##.#.#.
..OO.#..#.OO..#O..#.O...OO.O...O....#..OO....#OO..#........#...O..........#..O...OO.O.......#.#..##.
.#.#...#O.O.#.O..O.OO.OO#..OO#OOO#O....O..O#..OO.O..##..#.#....OOOOO#....OO..O....#..O..............
...O#.OO......O.#.O.#.#O.OOO...#OO..#....#.O.O.O.......#...##...O...OOO..##...O....O...O.#...O.O...O
..O...O..#.O.....#.#..##.......####...##.......O...O#.##....O.#..OO....#.#.O...##O.#O.###.OO#....O.O
.O#..#....OO...O.O.......O#OO..O#.O.O..#......#..O.#..#O......OO.O...O.....O........O#.#O.#.#.##.O#.
..O....O.#...#..##..O...#.O#..OO...O.......#OOO......#O..OO...O...#..O...##O.#...#.#.##...O...#.OO..
O.#..#...O#OO.O#.O..O.....O.O..#.#.##....O.O..O......OO.O.#.....#....#.##...#...O..O........#......#
.OO.OO.........#...#.#O...#..#..#.###O....#...OO#......#O.O..........#O...#.#.#O#..........#.O#...OO
##.#..#O#OO.#.....O......#....O..#.O#..#.OO.........#.......#.#..#..O.O#OO.###.O.#.#O..##....O.O..O#
#...O...O.......O#.O.#..#O#.O...O...O...O.O.#.O....O###..#.O..O.....O..OO#...O.#...#....O.#O..OO.O..
#O...O...O.##..#.#OO.....#O.#..O....#O.O....O.....#.O.....#.O.O....#.......O.#.O..#.O.##....O..O..O#
O..O.....#O..O...O........O..#.#..........##O#..#..O.#.#OOO..#..O...O..O..#.O....O...O...#...#...O..
#...O.......O#..#.O#.O.....#....O#O......O..O.....#.....O...#...O...#O..#.O..#..#....O....##O#.....#
O...O..#O#.OO..##..#.......O.........#......#...#..O.O..#..#O..O..O.OO......O#OO.#..O#....#.O.#.....
.....#.OOO..OOO....O...#O....O.#.O.#.#O..#O.......O#..O.#O.#.#..#......O#O###..#.#.O..OO.O#.##.OO#.#
O...#..O#.##O..#...#.....O...O.O............O#.....#.O....O#....O#.#O#O..O#.OO..........#.O.#OOO.O..
......#..#...O..O....OO#.O...OO..O....O..##O#..O#..O..##.O..#....##OO.....#..O#.O....#O.#....##.O...
.#..O.O..#..........O...O...O.#..O.#......O.O.....OO#..#...O.....O##..O.O..#.OO.#O.O....O...O..#..#.
.OO.#..O......#........#.#.O...#..........O..O.O.......OO..##O.....#...O...#..#O###..O..O.OOOOO.#.O.
.O..#..O..O...O..#O......OOO.O#..O#.#O...O#O.#...O....O..OO.#....#...O#................O.#O..O.#O..#
......O..O...##..O..##.O.####..OO.O.......#.#O..O#..O#O.......#..O.....##........#..O..O.#...O....OO
.....O.O.O.....O..OO..#O..O#.#OO....#O...#O#.#.OO.#..O...O.#.....#.#O#..O#...OO##.........##...##..#
....O..OOOO..O.O...#.....#.#..OOO...#OO.O#..O..O....#O.......#.O..OOO......OO...#.O#............O#.O
......O....#...#.#..O.O#.#...O..O.OO##.O..O#OO##...#.#..O.OO.........#..##O#...O.#..O.#OO.#O#...##O.
O..##.O...O..#.O.O.O..O.........#..O...#..O.O.##O#.O..#.#.....#..#O#..#.OOO#.O..O...OO#.O...O#......
.O.....O......O.......O#..O.OOOO..O..OO.O#.##.OO#O#.O......#...#.........O..O#...#O..#..#.O...O.#OO.
#O.O...#..OO.#...O.O#....#..#...#OOO##.O.OO#.....#.O#.O..O.#O#O.O.O..........O#.O#.#O###O..#..#.#OO#
#O###.O..O..O......#.O#.#....OO..O.O#....#...#...#.##...OO..O.#OO........O....O..O....OO......O..O.#
.O#O..O...#OOO...O.O...#.O#......#......#O.....O.#.#.O.#....O#.#O..#...#..#...OO#.....OOO....OO.....
..O.#.O....OO......O...O..##.O........#.O.#O.#...O...O.#.##OO.#O......O...O..O.O.O.##..O#.##.#.#O...
.#OO#.#.O#O....O.O....OO#....##.....#.##O..O...OO.....#..O.#....O#.......O....OO.OOO.#...#..O.O.#.OO
.O...O....#.O..O.#..#.........O.#O#.#...O..#O.O.O..O##.....OO..O.O..OO..O..#..#.#.O..#O..O.OO##....O
.##...#O.O..OO..O..#.#O.O.OO.#..#.OOOO.....O...O.O.O#...O#.#.O.............O..O...#.#..........OO#.#
.#....##O....##O..#.O.O..#..O##....#.#.OO........O.O#..#........#OO........O...#.OO..#.........#....
.##OO..#O.#.O..OO.#...#O#.....O....O.#....#O..O#O.#.O..##.O.O.....#.#...#.O..OO....O....#.#.#.......
O.O.O.#....#.OO.#...#...O..#.OO..#..O..#...O.OO.O...##...OO.O#O..O.OO.O##.....#..O#..#O....O.O#OO.#.
.#.O....#.#....#..O.O....OO......O......O.#...O...#.O.O..#.#.....O..#O.O.O..OOO#.O#..O...O#..OO.....
#.#O..#....#.....O.#....#......O.O..O.O.OO.O#...O.#.O.O...#....O...#..#...O.#.O..#.O...OO.#.#O###.OO
..#..O..#O##..#.....O...#..O...OO..#.#.O.#.O.O.....O..O#O#..O......#...#O.O.OO..O............#....#.
....O#....O#O###O.O..#.#..O.#.O.#.O....O........#O.OOO......O.OO....O.O.O.....##.O#....##O.#.OO..O.#
..#.O...OO.#O.#..OO.##..#...O#..O#..#O.O..#......O.....##....O...O.O#OO#O.......O##OOO.OO.O...O.#..#
O......#.O.....OO.OO.O...O.#O..O...O.#.#...#...O...#.OO.O.#.#OO.....#.O.#....OOO........##...##.##O.
#O...#....#...##O.#......O#...#O..........##O..#.O.#O#..#...OO.O....O..##..#...#...#..O..O....O..O#.
...OO....O#..O..#....O.#.#.....OO.#..#O..OO.#.#.#.#......O...O..#.#..##.....#...O.##.....O#.#..O#O..`.split("\n");

const MOVABLE_ROCK = "O";
const FREE_SPOT = ".";


rollNorth();
console.log(calculateTotalNorthBeamLoad());

function rollNorth() {
    for(let i = 0; i < input.length; i++) {
        for(let columnIndex = 0; columnIndex < input[0].length; columnIndex++) {
            for(let rowIndex = 0; rowIndex < input[0].length; rowIndex++) {
                const currentColumnValue = input[columnIndex];
                const currentRock = currentColumnValue[rowIndex];
                if(currentRock === MOVABLE_ROCK && isAboveSpotFree(columnIndex, rowIndex)) {
                    input[columnIndex] = replaceCharAt(currentColumnValue, FREE_SPOT, rowIndex);

                    const columnAboveValue = input[columnIndex - 1];
                    input[columnIndex - 1] = replaceCharAt(columnAboveValue, MOVABLE_ROCK, rowIndex);
                }
            }
        }
    }
}

function isAboveSpotFree(columnIndex, rowIndex) {
    if(columnIndex <= 0) {   //top edge
        return false;
    }

    const spotAbove = input[columnIndex - 1][rowIndex];

    return spotAbove === FREE_SPOT;
}

function calculateTotalNorthBeamLoad() {
    let northBeamLoad = 0;
    input.forEach((columnValue, columnIndex)=> {
        const loadPerRock = input.length - columnIndex;
        const rocks = columnValue.split("O").length - 1;
        northBeamLoad += loadPerRock * rocks;
    });

    return northBeamLoad;
}

function replaceCharAt(string, character, index) {
    return string.substring(0, index) + character + string.substring(index + 1);
}
