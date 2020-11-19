function average(num) {
    let number = num.toString();
    let sum = 0;
    let digits = number.split("");

    for (let i = 0; i < number.length; i++) {
        sum += Number(digits[i]);
    }

    while (sum / number.length <= 5){
        number = number.concat("9");
        sum += 9;
    }

    console.log(number);
}

average(101);