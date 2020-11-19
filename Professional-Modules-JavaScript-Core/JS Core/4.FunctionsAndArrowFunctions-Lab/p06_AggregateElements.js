function calculations(arr) {
    let sum = 0;
    let inverseSum = 0;
    let stringConcat = '';

    for (let i = 0; i < arr.length; i++) {
        sum += Number(arr[i]);
        inverseSum += Number(1/arr[i]);
        stringConcat = stringConcat.concat(arr[i]);
    }

    console.log(sum);
    console.log(inverseSum);
    console.log(stringConcat);
}

calculations([2, 4, 8, 16]);