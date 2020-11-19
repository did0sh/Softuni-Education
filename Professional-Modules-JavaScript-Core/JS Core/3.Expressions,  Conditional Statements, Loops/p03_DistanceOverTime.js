function distanceCalc(arr) {
    let speed1 = Number(arr[0]);
    let speed2 = Number(arr[1]);
    let timeInSeconds = Number(arr[2]);

    let timeInHours = timeInSeconds / 3600;

    let firstDistance = speed1 * timeInHours;
    let secondDistance = speed2 * timeInHours;
    let distanceBetweenInMeters = Math.abs(firstDistance - secondDistance) * 1000;

    console.log(distanceBetweenInMeters);

}

distanceCalc([5, -5, 40]);