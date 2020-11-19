function printUsername(arr) {
    let finalResult = [];
    for (let i = 0; i < arr.length; i++) {
        let args = arr[i].split('@');
        let firstPart = args[0] + '.';
        let secondPart = args[1].split('.');

        for (let word of secondPart) {
            firstPart += word[0];
        }

        finalResult.push(firstPart);
    }

    console.log(finalResult.join(', '));
}

printUsername(['peshoo@gmail.com', 'todor_43@mail.dir.bg', 'foo@bar.com']);