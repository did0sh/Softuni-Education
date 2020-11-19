function manipulate(arr) {
    let obj = new Map();

    let finalResult = [];

    for (let string of arr) {
        let args = string.split(' => ').filter(x => x !== '');
        let juice = args[0].trim();
        let quantity = Number(args[1].trim());


        if(!obj.has(juice)){
            obj.set(juice, quantity);
            if(obj.get(juice) >= 1000){
                finalResult.push(juice);
            }
        } else  {
            let oldQuantity = obj.get(juice);
            obj.set(juice,oldQuantity + quantity);
            if(obj.get(juice) >= 1000 && finalResult.indexOf(juice) === -1){
                finalResult.push(juice);
            }
        }
    }

    for (let juice of finalResult) {
        console.log(`${juice} => ${parseInt(obj.get(juice) / 1000)}`);
    }
}

manipulate(['Orange => 2000',
'Peach => 1432',
'Banana => 450',
'Peach => 600',
'Strawberry => 549']);