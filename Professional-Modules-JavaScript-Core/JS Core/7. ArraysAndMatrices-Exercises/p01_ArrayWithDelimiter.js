function printArray(arr) {
    let delimiter = arr[arr.length - 1];
    let output = '';
    arr.pop();

    for (let i = 0; i < arr.length; i++) {
        if(i === 0){
            output += arr[i];
        } else {
            output += delimiter + arr[i];
        }
    }

    console.log(output);
}

printArray(['One', 'Two', 'Three', 'Four', 'Five', '-']);