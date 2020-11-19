function printElements(arr) {
    let k = Number(arr[0]);
    console.log(arr.slice(1, k+1).join(' '));
    console.log(arr.slice((arr.length - k), arr.length).join(' '));
}

printElements([3, 6, 7, 8, 9]);