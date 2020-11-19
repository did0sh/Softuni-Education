function calcDistance(arr) {
    let x1 = Number(arr[0]);
    let y1 = Number(arr[1]);
    let z1 = Number(arr[2]);

    let x2 = Number(arr[3]);
    let y2 = Number(arr[4]);
    let z2 = Number(arr[5]);

    let sideA = Math.abs(x1 - x2);
    let sideB = Math.abs(y1 - y2);
    let sideC = Math.abs(z1 - z2);

    let distance = Math.sqrt(Math.pow(sideA,2) + Math.pow(sideB,2) + Math.pow(sideC,2));
    console.log(distance);
}

calcDistance([1, 1, 0, 5, 4, 0]);