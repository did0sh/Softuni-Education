function draw(n) {
    let dollarChar = '$';
    for (let i = 1; i <= n; i++) {
        console.log(dollarChar.repeat(i));
    }
}
draw(4);