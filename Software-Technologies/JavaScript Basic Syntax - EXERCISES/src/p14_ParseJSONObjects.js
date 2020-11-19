function parseJSON(arr) {
    let array = [];
    for(let i = 0; i < arr.length; i++){
        let obj = JSON.parse(arr[i]);

        array.push(obj);
    }

    for(let item of array){
        for(let element of Object.keys(item)){
            console.log(`${element.substring(0,1).toUpperCase() + element.substr(1)}: ${item[element]}`);
        }
    }

}
parseJSON(["{\"name\":\"Gosho\",\"age\":10,\"date\":\"19/06/2005\"}",
"{\"name\":\"Tosho\",\"age\":11,\"date\":\"04/04/2005\"}"]);