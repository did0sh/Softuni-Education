function isInside(arr) {
    let x;
    let y;
    let z;

    let xMin = 10;
    let yMin = 20;
    let zMin = 15;

    let xMax = 50;
    let yMax = 80;
    let zMax = 50;

    for (let i = 0; i < arr.length; i+=3) {
        x = Number(arr[i]);
        y = Number(arr[i+1]);
        z = Number(arr[i+2]);

        if ((x >= xMin && x <= xMax)
            && (y >= yMin && y <= yMax)
            && (z >= zMin && z <= zMax)) {
            console.log("inside");
        } else {
            console.log("outside");
        }
    }
}

isInside([13.1, 50, 31.5,
    50, 80, 50,
    -5, 18, 43]);