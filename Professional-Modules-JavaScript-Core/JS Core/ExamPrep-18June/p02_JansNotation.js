function main(arr) {
    let result = [];
    for (let argument of arr) {
        if(!isNaN(argument)){
            result.push(argument);
        } else {
            let calc = 0;
            if(result.length >= 2){
                switch (argument){
                    case '+': calc = result[result.length - 2] + result[result.length - 1]; break;
                    case '-': calc = result[result.length - 2] - result[result.length - 1]; break;
                    case '*': calc = result[result.length - 2] * result[result.length - 1]; break;
                    case '/': calc = result[result.length - 2] / result[result.length - 1]; break;
                }
                result.pop();
                result.pop();
                result.push(calc);
            } else if (result.length < 2) {
                console.log(`Error: not enough operands!`);
                return;
            }
        }
    }

    if(result.length === 1){
        console.log(result[0]);
    } else if(result.length > 1){
        console.log(`Error: too many operands!`);
    }
}

main([-1,
    1,
    '+',
    101,
    '*',
    18,
    '+',
    3,
    '/']);