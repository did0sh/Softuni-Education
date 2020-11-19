function addRemove(arr) {
    let result = [1];
    let count = 1;
    for (let i = 1; i < arr.length; i++) {
        let command = arr[i];
        if(command === 'add'){
            count++;
            result.push(count);
        } else if (command === 'remove'){
            count++;
            result.pop();
        }
    }

    if(result.length === 0){
        console.log("Empty");
    } else {
        console.log(result.join('\n'));
    }
}

addRemove(['add', 'add', 'remove', 'add', 'add'])
addRemove(['remove', 'remove', 'remove']);