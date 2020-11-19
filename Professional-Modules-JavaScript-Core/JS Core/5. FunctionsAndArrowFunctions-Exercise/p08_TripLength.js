function findLength([x1, y1, x2, y2, x3, y3]) {
    let distance12 = Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2),2));
    let distance13 = Math.sqrt(Math.pow((x3 - x1), 2) + Math.pow((y3 - y1),2));
    let distance23 = Math.sqrt(Math.pow((x2 - x3), 2) + Math.pow((y2 - y3),2));

    let sum = 0;

    if((distance12 <= distance13) && (distance13 >= distance23)){
        sum = distance12 + distance23;
        console.log(`1->2->3: ${sum}`);

    } else if ((distance12 <= distance23) && (distance13 < distance23)){
        sum = distance12 + distance13;
        console.log(`2->1->3: ${sum}`);
    } else {
        sum = distance23 + distance13;
        console.log(`1->3->2: ${sum}`);
    }
}

findLength([5, 1, 1, 1, 5, 4]);