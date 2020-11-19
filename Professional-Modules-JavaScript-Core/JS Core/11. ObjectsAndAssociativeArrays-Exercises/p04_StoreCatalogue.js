function manipulate(arr) {
    let result = new Map();
    let orderedLetters = [];

    for (let string of arr) {
        let args = string.split(' : ');
        let product = args[0].trim();
        let price = Number(args[1].trim());
        let letter = product[0];

        result.set(product, price);
        if(orderedLetters.indexOf(letter) === -1){
            orderedLetters.push(letter);
        }
    }

    orderedLetters = orderedLetters.sort((a,b) => a.localeCompare(b));
    let orderedObject = Array.from(result.keys()).sort((a,b) => a.localeCompare(b));

    for (let i = 0; i < orderedLetters.length; i++) {
        console.log(orderedLetters[i]);
        for (let key of orderedObject) {
            if(key.startsWith(orderedLetters[i])){
                console.log(`  ${key}: ${result.get(key)}`);
            }
        }
    }
}

manipulate(['Banana : 2',
'Rubics Cube : 5',
'Raspberry P : 4999',
'Rolex : 100000',
'Rollon : 10',
'Rali Car : 2000000',
'Pesho : 0.000001',
'Barrel : 10']);