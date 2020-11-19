function findBiggestElement(matrix) {
    let biggestNum = Number.NEGATIVE_INFINITY;
    for (let matr of matrix) {
            for (let number of matr) {
                if(number > biggestNum){
                    biggestNum = number;
                }
            }
    }

    console.log(biggestNum);
}

findBiggestElement([[20, 50, 10], [8, 33, 145]]);