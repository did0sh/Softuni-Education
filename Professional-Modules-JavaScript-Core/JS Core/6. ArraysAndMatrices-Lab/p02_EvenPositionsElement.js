function findEvenPosition(arr) {
    let result = '';
    for (let i = 0; i < arr.length; i++) {
        if(i % 2 === 0){
            result = result.concat(' ', arr[i]).trim();
        }
    }

    console.log(result);
}

findEvenPosition(['20', '30', '40']);