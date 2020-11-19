function manipulate(arr) {
    let result = [];
    let obj = {};
    for (let string of arr) {
        let args = string.split('/').filter(x => x!=='');
        let heroName = args[0].trim();
        let heroLevel = Number(args[1].trim());

        let items = [];
        if(args.length > 2){
            items = args[2].trim().split(', ');
        }


        obj = {
            name: heroName, level: heroLevel, items: items
        };

        result.push(obj);
    }

    console.log(JSON.stringify(result));
}

manipulate(['Isacc / 25 /',
'Derek / 12 / BarrelVest, DestructionSword',
'Hes / 1 / Desolator, Sentinel, Antara',]);