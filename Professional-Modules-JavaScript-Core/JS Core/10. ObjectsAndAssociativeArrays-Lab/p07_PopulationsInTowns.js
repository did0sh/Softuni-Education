function manipulate(arr) {
    let obj = {};
    for (let string of arr) {
        let args = string.split(' <-> ');
        let town = args[0];
        let townPopulation = Number(args[1]);

        if(!obj.hasOwnProperty(town)){
            obj[town] = townPopulation;
        } else {
            obj[town] += townPopulation;
        }
    }

    for (let key in obj) {
        console.log(`${key} : ${obj[key]}`);
    }
}

manipulate(['Istanbul <-> 100000',
'Honk Kong <-> 2100004',
'Jerusalem <-> 2352344',
'Mexico City <-> 23401925',
'Istanbul <-> 1000']);