function solve(input) {
    let arrayOfWords = input.split(/[^\w]+/);
    let arrayOfUpperCaseWords = [];
    for(let word of arrayOfWords){
        word = word.toUpperCase();
        arrayOfUpperCaseWords.push(word);
    }

    console.log(arrayOfUpperCaseWords.filter(word => word !== '').join(', '));
}

solve('Hi, how a.re y-ou?');