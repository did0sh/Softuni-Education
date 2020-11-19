function manipulate(arr) {
    arr = arr.map(Number);
    let biggestMulti = Number.NEGATIVE_INFINITY;

    for (let i = 0; i < arr.length; i++) {
        if(arr[i] > 0 && arr[i]< 10){
                let multiplication = arr[arr.indexOf(arr[i])+1];
                let index = arr.indexOf(arr[i]);
                for (let k = index + 2; k <= index + arr[i]; k++) {
                    multiplication = multiplication * arr[k];
                }
                arr.splice(index,1);
                i--;
                if(multiplication > biggestMulti){
                    biggestMulti = multiplication;
                }
            }
        }

    console.log(biggestMulti);
}

manipulate(['0', '1', '1', '-1', '2']);