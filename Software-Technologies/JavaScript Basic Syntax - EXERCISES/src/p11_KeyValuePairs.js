function keyValuePairs(arr) {
    let obj = {};

    for(let i = 0; i < arr.length - 1; i++){
        let key = arr[i].split(' ')[0];
        let value = arr[i].split(' ')[1];

        if(!(key in obj)){
            obj[key] = value;
        } else {
            obj[key] = value;
        }

    }

    let searchKey = arr[arr.length-1];
    if(obj.hasOwnProperty(searchKey)){
        console.log(obj[searchKey]);
    } else {
        console.log('None');
    }
}
keyValuePairs(["3 test", "3 test1", "4 test2", "4 test3", "4 test5", "3"]);