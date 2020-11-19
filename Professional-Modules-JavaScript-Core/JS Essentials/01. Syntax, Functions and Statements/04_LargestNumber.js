function findLargestNum(firstNum, secondNum, lastNum) {
    let largestNum = 0;
    if(firstNum > secondNum && firstNum > lastNum){
        largestNum = firstNum;
    } else if(secondNum > firstNum && secondNum > lastNum){
        largestNum = secondNum;
    } else {
        largestNum = lastNum;
    }

    console.log(`The largest number is ${largestNum}.`);
}

findLargestNum(-3, -5, -22.5);