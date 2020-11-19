function replaceText(string, arr) {
    for (let i = 0; i < arr.length; i++) {
        let replacePart = arr[i];
        let replaceSymbol = '-'.repeat(replacePart.length);

        while(true){
            let index = string.indexOf(replacePart);
            if(index < 0){
                break;
            }

            string = string.replace(replacePart, replaceSymbol);
        }
    }

    console.log(string);
}

replaceText('roses are red, violets are blue', [', violets are', 'red']);