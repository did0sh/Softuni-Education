function calcSum(arr) {
    let firstNum = Number(arr[0]);
    let lastNum = Number(arr[arr.length - 1]);

    let sum = firstNum + lastNum;
    console.log(sum);
}

let output = ['5', '10'];
calcSum(output);