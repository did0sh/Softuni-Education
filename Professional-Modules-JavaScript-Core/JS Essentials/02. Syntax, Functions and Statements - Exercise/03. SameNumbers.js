function sameNumbers(number) {
    let areSame = true;
    let stringNumber = number.toString();
    let sumOfAllDigits = 0;
    for (let i = 0; i < stringNumber.length; i++) {
        sumOfAllDigits += Number(stringNumber[i]);
        if(stringNumber[0] !== stringNumber[i]){
            areSame = false;
        }
    }

    console.log(areSame);
    console.log(sumOfAllDigits);
}

sameNumbers(12345);