function findBiggestNum(input) {
    let num1 = Number(input[0]);
    let num2 = Number(input[1]);
    let num3 = Number(input[2]);

    console.log(Math.max(num1, num2, num3));
}

findBiggestNum([43, 43.1, 43.2]);