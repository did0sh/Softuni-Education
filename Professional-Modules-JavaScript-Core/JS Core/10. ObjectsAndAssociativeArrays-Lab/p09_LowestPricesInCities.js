function manipulate(arr) {
    let result = new Map();
    for (let string of arr) {
        let args = string.split('|');
        let product = args[1].trim();
        let town = args[0].trim();
        let price = Number(args[2].trim());

        if(!result.has(product)){
            result.set(product, new Map());
            result.get(product).set(town, price);
        } else {
                result.get(product).set(town, price);
        }
    }

    for (let [product, towns] of result) {
        let minPrice = Number.POSITIVE_INFINITY;
        let minPriceTown;
        for (let [town, price] of towns) {
            if(price < minPrice){
                minPrice = price;
                minPriceTown = town;
            }
        }
        console.log(`${product} -> ${minPrice} (${minPriceTown})`);
    }
}

manipulate(['Sample Town | Sample Product | 1000',
'Sample Town | Sample Product | 2',
'Sample Town | Peach | 1',
'Sofia | Orange | 3',
'Sofia | Peach | 2',
'New York | Sample Product | 1000.1',
'New York | Burger | 10']);