function setIndexes(arr) {
    let arrayLength = Number(arr[0]);

    let array = new Array();

    for(let k=0; k < arrayLength; k++){
        array.push(0);
    }

    for(let i = 1; i < arr.length; i++){
        let tokens = arr[i].split(' - ');
        let index = tokens[0];
        let value = tokens[1];

        array[index] = value;
    }

    for(let element of array){
        console.log(element);
    }
}

setIndexes(["3", "0 - 5", "1 - 6", "1 - 7"]);