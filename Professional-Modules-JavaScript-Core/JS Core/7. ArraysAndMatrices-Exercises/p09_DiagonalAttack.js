function manipulate(arr) {
    let matrix = [];
    let firstDiagonal = 0;
    let secondDiagonal = 0;

    for (let i = 0; i < arr.length; i++) {
        matrix[i] = [];
        arr[i] = arr[i].split(' ').map(Number).forEach(num => matrix[i].push(num));
    }

    let lastElement = matrix.length - 1;
    for (let row = 0; row < matrix.length; row++) {
       firstDiagonal += matrix[row][row];
       secondDiagonal += matrix[row][lastElement];
       lastElement--;
    }

    if(firstDiagonal === secondDiagonal){
        for (let r = 0; r < matrix.length; r++) {
            for (let c = 0; c < matrix[r].length; c++) {
                if((r !== c) && (r + c !== matrix[r].length - 1)){
                    matrix[r][c] = firstDiagonal;
                }
            }
        }
    }

    for (let array of matrix) {
        console.log(array.join(' '));
    }

}

manipulate(['5 3 12 3 1',
    '11 4 23 2 5',
    '101 12 3 21 10',
    '1 4 5 2 2',
    '5 22 33 11 1']);
