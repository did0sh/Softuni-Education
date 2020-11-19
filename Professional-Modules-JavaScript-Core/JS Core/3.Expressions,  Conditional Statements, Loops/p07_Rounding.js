function round(arr) {
    let num = Number(arr[0]);
    let roundNum = Number(arr[1]);
    let digitsAfterPoint = num.toString().split('.')[1];

    if (digitsAfterPoint.length < roundNum){
        roundNum = digitsAfterPoint.length;
    }

    if (roundNum > 15){
        roundNum = 15;
    }

    let result = num.toFixed(roundNum);
    console.log(result);
}

round([10.5235123212312312331221321321, 16]);