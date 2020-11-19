function manipulate(num1, num2) {
    let wholePart;
    let left;
    let firstNum = Math.max(num1, num2);
    let secondNum = Math.min(num1, num2);
    while(true){
        wholePart = parseInt(firstNum / secondNum);
        left = firstNum % secondNum;

        if(left === 0){
            break;
        }

        firstNum = secondNum;
        secondNum = left;

    }
    return secondNum;
}

manipulate(252, 105);