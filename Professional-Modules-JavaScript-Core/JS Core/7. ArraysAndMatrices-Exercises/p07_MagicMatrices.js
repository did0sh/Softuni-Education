function manipulate(matrix) {
    let firstSum = matrix[0].reduce((a,b) => a+b);
    let isMagic = true;

    for (let row = 1; row < matrix.length; row++) {
        let currSum = 0;
        for (let col = 0; col < matrix[row].length; col++) {
            currSum += matrix[row][col];
        }
        if(currSum !== firstSum){
            console.log('false');
            return;
        }
    }

    for (let col = 0; col < matrix[0].length; col++) {
        let currSum = 0;
        for (let row = 0; row < matrix.length; row++) {
            currSum += matrix[row][col];
        }
        if(currSum !== firstSum){
            console.log('false');
            return;
        }
    }

    console.log(isMagic);
}

manipulate([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]);