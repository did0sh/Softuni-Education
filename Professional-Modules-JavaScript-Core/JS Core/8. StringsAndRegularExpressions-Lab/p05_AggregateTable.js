function manipulate(arr) {
    let result = [];
    let totalSum = 0;
    for (let i = 0; i < arr.length; i++) {

        let args = arr[i].split('|').filter(x => x !== '');
        let city = args[0].trim();
        let income = Number(args[1].trim());

        result.push(city);
        totalSum += income;
    }
    console.log(result.join(', '));
    console.log(totalSum);
}

manipulate(['| Sofia           | 300',
    '| Veliko Tarnovo  | 500',
    '| Yambol          | 275'])