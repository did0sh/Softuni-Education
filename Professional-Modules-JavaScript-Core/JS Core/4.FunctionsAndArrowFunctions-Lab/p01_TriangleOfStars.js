function drawTriangle(n) {
    let symbol = "*";

    for (let i = 1; i <= n; i++) {
        console.log(symbol.repeat(i));
    }

    for (let k = n-1; k >= 1; k--) {
        console.log(symbol.repeat(k));
    }
}

drawTriangle(5);