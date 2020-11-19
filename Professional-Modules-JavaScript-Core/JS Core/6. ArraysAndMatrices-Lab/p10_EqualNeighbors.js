function findNeighbors(matrix) {
    let neighbors = 0;

    for (let row = 0; row < matrix.length - 1; row++) {
        for (let col = 0; col < matrix[row].length; col++) { // vertical
            if (matrix[row][col] === matrix[row + 1][col]) {
                neighbors++;
            }
        }

    }

    for (let i = 0; i < matrix.length; i++) {
        for (let j = 0; j < matrix[i].length - 1; j++) { // horizontal
            if (matrix[i][j] === matrix[i][j + 1]) {
                neighbors++;
            }
        }

    }

    console.log(neighbors);
}


findNeighbors([['test', 'yes', 'yo', 'ho'],
    ['well', 'done', 'yo', '6'],
    ['not', 'done', 'yet', '5']]);