function moveItems(arr) {
    let result = [];
    
    for (let i = 0; i < arr.length; i++) {
        if(arr[i] < 0){
            result.unshift(arr[i]);
        } else {
            result.push(arr[i]);
        }
    }
    for (let index in result) {
        console.log(result[index]);
    }
}

moveItems([3, -2, 0, -1]);