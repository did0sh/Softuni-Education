function createObject(array) {
    let obj = {};
    for (let i = 0; i < array.length; i+=2) {
        let name = array[i];
        let calories = Number(array[i+1]);
        obj[name] = calories;
    }

    console.log(obj);
}

createObject(['Yoghurt', 48, 'Rise', 138, 'Apple', 52]);