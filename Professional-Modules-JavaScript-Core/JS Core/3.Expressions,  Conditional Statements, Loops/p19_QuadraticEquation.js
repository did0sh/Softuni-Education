function findRootsOfEquaiton(a, b, c) {
    let discriminant = (b ** 2) - (4 * a * c);
    let x1;
    let x2;

    if (discriminant > 0){
        x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        x2 = (-b - Math.sqrt(discriminant)) / (2 * a);

        if (x1 > x2){
            console.log(x2);
            console.log(x1);
        } else {
            console.log(x1);
            console.log(x2);
        }
    } else if (discriminant === 0){
        x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
        console.log(x1);
    } else {
        console.log("No");
    }
}

findRootsOfEquaiton(5, 2, 1);