function find(string) {
    let regex = /\b_[A-Za-z0-9]+\b/g;
    let result = [];
    let match;

    while(match = regex.exec(string)){
        result.push(match[0].substring(1));
    }

    console.log(result.join(','));
}

find('Calculate the _area of the _perfectRectangle object.\tarea,perfectRectangle')