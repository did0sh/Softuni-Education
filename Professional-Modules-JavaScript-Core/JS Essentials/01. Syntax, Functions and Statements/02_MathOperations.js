function mathOperations(num1, num2, str) {
    let finalValue = 0;
    switch (str) {
        case '+':
            finalValue = num1 + num2;
            break;
        case '-':
            finalValue = num1 - num2;
            break;
        case '*':
            finalValue = num1 * num2;
            break;
        case '/':
            finalValue = num1 / num2;
            break;
        case '%':
            finalValue = num1 % num2;
            break;
        case '**':
            finalValue = Math.pow(num1, num2);
            break;
    }

    console.log(finalValue);
}

mathOperations(3, 5.5, '*');