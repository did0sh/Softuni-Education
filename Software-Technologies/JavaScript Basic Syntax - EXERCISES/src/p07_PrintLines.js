function printLines(arr) {
    for(let str of arr){
        if (str !== "Stop"){
            console.log(str);
        } else {
            return;
        }
    }
}

printLines(["line1", "asd", "bbb", "Stop"]);