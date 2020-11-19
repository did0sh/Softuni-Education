function drawDna(num) {
    let string = 'ATCGTTAGGG';
    let counter = 0;

    for (let i = 0; i < num; i++) {

        if (i % 4 === 0){
            console.log(`**${string[counter%10]}${string[counter%10+1]}**`);
        } else if (i % 4 === 1){
            console.log(`*${string[counter%10]}--${string[counter%10+1]}*`);
        } else if (i % 4 === 2) {
            console.log(`${string[counter%10]}----${string[counter%10+1]}`);
        } else if (i % 4 === 3) {
            console.log(`*${string[counter%10]}--${string[counter%10+1]}*`);
        }

        counter += 2;
    }
}

drawDna(10);