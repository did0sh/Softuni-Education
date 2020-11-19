function gradsToDegrees(input) {
    let grads = Number(input);

    grads = grads % 400;
    if (grads < 0) {
        grads += 400;
    }

    let degrees = grads * 0.9;
    console.log(degrees);
}

gradsToDegrees(-50);