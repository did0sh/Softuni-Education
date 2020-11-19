function timeWalk(steps, footPrint, speed) {
    let fullPathInMeters = steps * footPrint;
    let minutesForRest = Math.floor(fullPathInMeters / 500);

    let fullPathInKilometers = fullPathInMeters / 1000;
    let partOfHour = fullPathInKilometers / speed;

    let totalMinutesPart = partOfHour * 60;
    let seconds = Math.round((totalMinutesPart - Math.floor(totalMinutesPart))*60);

    let minutes = Math.floor(totalMinutesPart);
    minutes += minutesForRest;

    let hours = Math.floor(minutes / 60);
    minutes = minutes % 60;

    if(hours < 10){
        hours = '0' + hours;
    }
    if(minutes < 10){
        minutes = '0' + minutes;
    }
    if(seconds < 10){
        seconds = '0' + seconds;
    }
    console.log(`${hours}:${minutes}:${seconds}`);
}

timeWalk(4000, 0.60, 5);