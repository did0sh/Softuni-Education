function calcArea(a, b, c) {
    let semiPerimeter = (a + b + c) / 2;
    let triangleArea = Math.sqrt(semiPerimeter
        * (semiPerimeter - a)
        * (semiPerimeter - b)
        * (semiPerimeter - c)); //heron`s formula
    console.log(triangleArea);
}

calcArea(2, 3.5, 4);