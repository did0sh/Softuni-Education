function extract(string) {

    let text = '';
    let result = [];

    while(true){
        let start = string.indexOf('(');
        let end = string.indexOf(')');

        if((start < 0 || end < 0) || end < start){
            break;
        }

        text = string.substring(start + 1, end);
        string = string.substring(end + 1);
        result.push(text);
    }

    console.log(result.join(', '));
}

extract('Rakiya )asd(Bulgarian brandy) is self-made liquor (alcoholic drink)');