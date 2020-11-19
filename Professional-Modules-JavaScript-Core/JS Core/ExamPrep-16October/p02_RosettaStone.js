function manipulate(arr) {
    let result = '';
    let firstNum = Number(arr.shift());

    let addNums = [];
    for (let i = 0; i < firstNum; i++) {
        addNums.push(arr.shift().split(' ').map(Number));
    }

    let matrix = [];
    for (let i = 0; i < arr.length; i++) {
        matrix.push(arr[i].split(' ').map(Number));
    }

    for (let row = 0; row < matrix.length; row++) {
        for (let col = 0; col < matrix[row].length; col++) {
            let current = matrix[row][col];
            let modifier = addNums[row % addNums.length][col % addNums[0].length];
            result+= String.fromCharCode(((current + modifier)%27) + 64);
        }
    }
    
    result = result.replace(/@/g, ' ');
    console.log(result);

}

manipulate([ '2',
    '59 36',
    '82 52',
    '4 18 25 19 8',
    '4 2 8 2 18',
    '23 14 22 0 22',
    '2 17 13 19 20',
    '0 9 0 22 22' ]
);