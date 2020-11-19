function sumAndVat(input) {
    let sum = 0;
    let vat = 0;
    let total = 0;

    for (let i = 0; i < input.length; i++){
        sum += input[i];
    }
    vat = 0.2 * sum;
    total = vat + sum;

    console.log(`sum = ${sum}`);
    console.log(`VAT = ${vat}`);
    console.log(`total = ${total}`);
}

sumAndVat([3.12, 5, 18, 19.24, 1953.2262, 0.001564, 1.1445]);