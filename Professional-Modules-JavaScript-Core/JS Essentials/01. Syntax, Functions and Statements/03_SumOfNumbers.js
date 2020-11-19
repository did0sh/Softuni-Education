function solve(firstString, secondString) {
    let sum = 0;
    let firstNum = Number(firstString);
    let lastNum = Number(secondString);
    for (let i = firstNum; i <= lastNum ; i++) {
        sum += i;
    }

    return sum;
}

solve('1', '5');