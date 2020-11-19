function manipulate(arr) {
    let result = new Map();

    for (let string of arr) {
        let args = string.split(' -> ').filter(x => x !== '');
        let town = args[0];
        let product = args[1];

        let secondArgs = args[2].split(' : ').filter(y => y !== '');
        let amountSales = Number(secondArgs[0]);
        let priceForUnit = Number(secondArgs[1]);

        let income = amountSales * priceForUnit;

        if (!result.has(town)) {
            result.set(town, new Map());
            result.get(town).set(product, income);
        } else {
            if(!result.get(town).has(product)){
                result.get(town).set(product, income);
            } else {
                let oldIncome = result.get(town).get(product);
                result.get(town).get(product).set(oldIncome + income);
            }
        }
    }

        for (let [key, value] of result) {
            console.log(`Town - ${key}`);
            for (let [product, income] of result.get(key)) {
                console.log(`$$$${product} : ${income}`);
            }
        }

}

manipulate(['Sofia -> Laptops HP -> 200 : 2000',
'Sofia -> Raspberry -> 200000 : 1500',
'Sofia -> Audi Q7 -> 200 : 100000',
'Montana -> Portokals -> 200000 : 1',
'Montana -> Qgodas -> 20000 : 0.2',
'Montana -> Chereshas -> 1000 : 0.3']);