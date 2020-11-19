function rotate(arr) {
    let rotations = Number(arr[arr.length - 1]);
    arr.pop();
    for (let i = 0; i < rotations % arr.length; i++) {
        let lastElement = arr.pop();
        arr.unshift(lastElement);
    }

    console.log(arr.join(' '));
}

rotate(['1', '2', '3', '4', '2']);
rotate(['Banana', 'Orange', 'Coconut', 'Apple', '15']);