function distanceBetweenPoints(x1, y1, x2, y2) {
    let firstPoint = {pointA: x1, pointB: y1};
    let secondPoint = {pointA: x2, pointB: y2};

    let distanceX = Math.pow((firstPoint.pointA - secondPoint.pointA),2);
    let distanceY = Math.pow((firstPoint.pointB - secondPoint.pointB), 2);

    console.log(Math.sqrt(distanceX + distanceY));
}

distanceBetweenPoints(2.34, 15.66, -13.55, -2.9985);