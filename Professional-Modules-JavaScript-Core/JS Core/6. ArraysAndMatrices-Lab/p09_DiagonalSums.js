function calcDiagonalSum(matrix) {
    let count = 0;
    let sumMain = 0;
    let sumSecondary = 0;

    for (let matr of matrix) {
        sumMain += matr[count];
        sumSecondary += matr[matr.length-1-count]
        count++;
    }

    console.log(`${sumMain} ${sumSecondary}`);

}

calcDiagonalSum([[3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
);