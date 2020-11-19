function main(arr) {
    let result = new Map();
    for (let string of arr) {
        let args = string.split('|').filter(x => x !== '');
        let carBrand = args[0].trim();
        let carModel = args[1].trim();
        let producedCars = Number(args[2].trim());

        if(!result.has(carBrand)){
            result.set(carBrand, new Map());
            result.get(carBrand).set(carModel, producedCars);
        } else {
            if(!result.get(carBrand).has(carModel)){
                result.get(carBrand).set(carModel, producedCars);
            } else {
                let oldQuantity = result.get(carBrand).get(carModel);
                result.get(carBrand).set(carModel, oldQuantity + producedCars);
            }
        }
    }

    for (let [key, value] of result) {
        console.log(key);
        for (let [carModel, producedCars] of value) {
            console.log(`###${carModel} -> ${producedCars}`);
        }
    }
}

main([`Audi | Q7 | 1000`,
`Audi | Q6 | 100`,
`BMW | X5 | 1000`,
`BMW | X6 | 100`,
`Citroen | C4 | 123`,
`Volga | GAZ-24 | 1000000`,
`Lada | Niva | 1000000`,
`Lada | Jigula | 1000000`,
`Citroen | C4 | 22`,
`Citroen | C5 | 10`,]);