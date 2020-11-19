function manipulate(arr) {
    let result = [];
    let biggestElement;
    for (let i = 0; i < arr.length - 1; i++) {
        if(i === 0){
            biggestElement = arr[i];
            result.push(biggestElement);
        }

        if(arr[i + 1] >= biggestElement){
            biggestElement = arr[i + 1];
            result.push(biggestElement);
        }
    }

    console.log(result.join('\n'));
}

manipulate([20, 20, 2, 15, 6, 1]);