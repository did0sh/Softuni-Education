function manipulate(arr) {
    let result = '';
    for (let i = 0; i < arr.length; i++) {
        result = result.concat(arr[i]);
    }

    result = result.split('').reverse().join('');
    console.log(result);
}

manipulate(['I', 'am', 'student']);