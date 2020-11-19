function checkValid(arr) {
    let x1 = Number(arr[0]), y1 = Number(arr[1]);
    let x2 = Number(arr[2]), y2 = Number(arr[3]);

    let firstDistance = Math.sqrt(Math.pow(x1 ,2) + Math.pow(y1 ,2));
    let secondDistance = Math.sqrt(Math.pow(x2 ,2) + Math.pow(y2 ,2));
    let thirdDistance = Math.sqrt(Math.pow((x1 - x2),2) + Math.pow((y1-y2),2));

    if (firstDistance === parseInt(firstDistance)){
        console.log(`{${x1}, ${y1}} to {0, 0} is valid`);
    } else {
        console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    }

    if (secondDistance === parseInt(secondDistance)){
        console.log(`{${x2}, ${y2}} to {0, 0} is valid`)
    } else {
        console.log(`{${x2}, ${y2}} to {0, 0} is invalid`)
    }

    if (thirdDistance === parseInt(thirdDistance)){
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`)
    } else {
        console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`)
    }
}

checkValid([2, 1, 1, 1]);