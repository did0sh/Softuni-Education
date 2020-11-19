function calc(arr) {
    let principalSum = Number(arr[0]);
    let interestRate = Number(arr[1]) * 0.01;
    let compoundingPeriodInMonths = Number(arr[2]);
    let timespanInYears = Number(arr[3]);
    let frequency = 12 / compoundingPeriodInMonths;

    let value = principalSum *
        Math.pow((1 + interestRate / frequency), frequency * timespanInYears);

    console.log(value.toFixed(2));
}

calc([100000, 5, 12, 25]);