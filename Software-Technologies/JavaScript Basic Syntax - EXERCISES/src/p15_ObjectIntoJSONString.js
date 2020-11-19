function turnIntoJSON(arr) {
    let obj = {};
    for(let pair of arr){
        let tokens = pair.split(' -> ');

        let key = tokens[0];
        let value = tokens[1];

        if(!isNaN(value)){
            value = parseFloat(value);
        }
        obj[key] = value;
    }
    let json = JSON.stringify(obj);
    console.log(json);
}
turnIntoJSON(["name -> Angel",
    "surname -> Georgiev",
    "age -> 20", "grade -> 6.00",
    "date -> 23/05/1995",
"town -> Sofia"]);