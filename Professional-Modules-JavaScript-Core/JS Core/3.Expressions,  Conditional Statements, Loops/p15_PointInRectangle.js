function pointInRectangle(input) {
    let [x, y, xMin, xMax, yMin, yMax] = input;

    if (x <= xMax && x >= xMin && y <= yMax && y >= yMin){
        console.log("inside");
    } else {
        console.log("outside");
    }
}

pointInRectangle([8, -1, 2, 12, -3, 3]);