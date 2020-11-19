function multipleValues(arr) {
    let obj = {};

    for(let i = 0; i < arr.length - 1; i++){
        let key = arr[i].split(' ')[0];
        let value = arr[i].split(' ')[1];

        if(!(key in obj)){
            obj[key] = [];
            obj[key].push(value);
        } else {
            obj[key].push(value);
        }

    }

    let searchKey = arr[arr.length-1];
    if(obj.hasOwnProperty(searchKey)){

        for(let element of obj[searchKey]){
            console.log(element);
        }
    } else {
        console.log('None');
    }
}
multipleValues(["3 test", "3 test1", "4 test2", "4 test3", "4 test5", "4"]);