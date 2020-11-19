function print(arr) {
    let n = Number(arr[arr.length - 1]);
    arr.pop();

    for (let i = 0; i < arr.length; i += n) {
        console.log(arr[i]);
    }
}

print(['dsa', 'asd', 'test', 'test', '2']);