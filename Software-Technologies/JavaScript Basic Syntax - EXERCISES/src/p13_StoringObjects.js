function storingObjects(arr) {

    let array = [];
    for (let i = 0; i < arr.length; i++) {

        let obj = {};
        let tokens = arr[i].split(' -> ');

        obj.Name = tokens[0];
        obj.Age = tokens[1];
        obj.Grade = tokens[2];

        array.push(obj);

    }

    for (let object of array) {
        for (let item of Object.keys(object)) {
            console.log(`${item}: ${object[item]}`);
        }
    }

}

storingObjects(["Pesho -> 13 -> 6.00", "Ivan -> 12 -> 5.57", "Toni -> 13 -> 4.90"]);