function manipulate(arr) {
    let result = [];
    for (let i = 1; i < arr.length; i++) {
        let args = arr[i].split(/\s*\|\s*/).filter(x => x!=='');
        let town = args[0];
        let lat = Number(args[1]);
        let long = Number(args[2]);

        let obj = {Town: town, Latitude: lat, Longitude: long};
        result.push(obj);
    }
    console.log(JSON.stringify(result));
}

manipulate(['| Town | Latitude | Longitude |',
    '| Sofia | 42.696552 | 23.32601 |',
    '| Beijing | 39.913818 | 116.363625 |']);