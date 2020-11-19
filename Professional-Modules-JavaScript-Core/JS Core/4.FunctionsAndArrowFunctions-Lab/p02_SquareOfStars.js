function drawSquare(n) {
    let symbol = '*';

    if (n === undefined){
        for (let i = 1; i <= 5; i++) {
            console.log(symbol.repeat(5));
        }
        return;
    }

    for (let i = 1; i <= n; i++) {
        console.log(symbol.repeat(n));
    }
}

drawSquare();