function find(string, word) {
    let regex = new RegExp("\\b"+word+"\\b", "gi");
    let match;
    let count = 0;
    while(match = regex.exec(string)){
        count++;
    }
    console.log(count);
}

find('There was one. Therefore I bought it. I wouldn’t buy it otherwise.',
    'there');