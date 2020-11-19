function addOrRemove(arr) {

    let array = new Array();

    for(let i=0; i < arr.length; i++){
        let tokens = arr[i].split(' ');
        let command = tokens[0];

        if(command === "add"){
            let num = Number(tokens[1]);
            array.push(num);
        } else if (command === "remove"){
            let index = Number(tokens[1]);
            array.splice(index, 1);
        }
    }


    for(let element of array){
        console.log(element);
    }
}

addOrRemove(["add 3", "add 5", "remove 2", "remove 0", "add 7"]);