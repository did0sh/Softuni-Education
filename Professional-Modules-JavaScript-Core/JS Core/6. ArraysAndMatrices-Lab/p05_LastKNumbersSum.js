function calc(n, k) {
    let arr = [];
    arr.push(1);


    for (let i = 1; i < n; i++) {
        let sum = 0;
        for (let j = i - k; j < i; j++) {
            if(arr[j] !== undefined){
                sum += arr[j];
            }
        }
        arr.push(sum);
    }

    console.log(arr.join(' '));
}

calc(8, 2);