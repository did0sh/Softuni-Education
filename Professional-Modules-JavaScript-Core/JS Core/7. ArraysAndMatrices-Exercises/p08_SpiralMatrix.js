function drawSpiralMatrix(rows,cols) {
    let matrix = [];
    let maxCount = rows * cols;
    let count = 0;
    let minRow = 0; let maxRow = rows - 1;
    let minCol = 0; let maxCol = cols - 1;

    for (let k = 0; k < rows; k++) {
        matrix[k] = [];
    }

    while(count < maxCount){
        for (let i = minCol; i <= maxCol && count < maxCount; i++) {
            matrix[minRow][i] = ++count;
        }
        minRow++;

        for (let t = minRow; t <= maxRow && count < maxCount; t++) {
            matrix[t][maxCol] = ++count;
        }
        maxCol--;

        for (let u = maxCol; u >= minCol && count < maxCount; u--) {
            matrix[maxRow][u] = ++count;
        }
        maxRow--;

        for (let r = maxRow; r >= minRow && count < maxCount; r--) {
            matrix[r][minCol] = ++count;
        }
        minCol++;
    }

    matrix.forEach(row => console.log(row.join(' ')));
}

drawSpiralMatrix(6,6);