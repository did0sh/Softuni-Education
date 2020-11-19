function manipulate([width, height, starRow, starCol]) {
    let row = width;
    let col = height;


    let matrix = [];
    for (let i = 0; i < row; i++) {
        matrix.push([]);
    }

    for (let r = 0; r < row; r++) {
        for (let c = 0; c < col; c++) {
            matrix[r][c] = Math.max(Math.abs(r - starRow), Math.abs(c - starCol)) + 1;
        }
    }

    for (let array of matrix) {
        console.log(array.join(' '));
    }
}

manipulate([5, 5, 2, 2]);