function radar(array) {
    let motorwayMaxSpeed = 130;
    let interstateMaxSpeed = 90;
    let cityMaxSpeed = 50;
    let residentialMaxSpeed = 20;

    let speedMessage = '';
    let exceedingBy = 0;

    let speed = array[0];
    let place = array[1];
    switch (place) {
        case 'motorway':
            exceedingBy = speed - motorwayMaxSpeed;
            if(exceedingBy > 0 &&  exceedingBy <= 20){
                speedMessage = 'speeding';
            } else if (exceedingBy > 20 && exceedingBy <= 40){
                speedMessage = 'excessive speeding';
            } else if(exceedingBy > 40){
                speedMessage = 'reckless driving';
            }
            break;
        case 'interstate':
            exceedingBy = speed - interstateMaxSpeed;
            if(exceedingBy > 0 &&  exceedingBy <= 20){
                speedMessage = 'speeding';
            } else if (exceedingBy > 20 && exceedingBy <= 40){
                speedMessage = 'excessive speeding';
            } else if(exceedingBy > 40){
                speedMessage = 'reckless driving';
            }
            break;
        case 'city':
            exceedingBy = speed - cityMaxSpeed;
            if(exceedingBy > 0 &&  exceedingBy <= 20){
                speedMessage = 'speeding';
            } else if (exceedingBy > 20 && exceedingBy <= 40){
                speedMessage = 'excessive speeding';
            } else if(exceedingBy > 40){
                speedMessage = 'reckless driving';
            }
            break;
        case 'residential':
            exceedingBy = speed - residentialMaxSpeed;
            if(exceedingBy > 0 &&  exceedingBy <= 20){
                speedMessage = 'speeding';
            } else if (exceedingBy > 20 && exceedingBy <= 40){
                speedMessage = 'excessive speeding';
            } else if(exceedingBy > 40){
                speedMessage = 'reckless driving';
            }
            break;
    }

    console.log(speedMessage);
}

radar([200, 'motorway']);