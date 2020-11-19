function printFigure(n) {
    let char = "-";
    let whiteSpace = " ";
    let firstAndLastPart = `+${char.repeat(n - 2)}+${char.repeat(n - 2)}+`;
    let betweenPart = `|${whiteSpace.repeat(n - 2)}|${whiteSpace.repeat(n - 2)}|`;

    for (let i = 1; i <= 3; i++) {
        if (i === 3) {
            console.log(firstAndLastPart);
            return;
        } else {
            console.log(firstAndLastPart);
        }

        for (let j = 0; j < parseInt((n - 3) / 2); j++) {
            console.log(betweenPart);
        }
    }

}

printFigure(7);