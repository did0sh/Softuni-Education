function calcSpeed(arr) {
    let currentSpeed = Number(arr[0]);
    let zone = arr[1];

    let limit = 0;
    let message = '';

    switch (zone){
        case "motorway":
            limit = 130;
            break;
        case "interstate":
            limit = 90;
            break;
        case "city":
            limit = 50;
            break;
        case "residential":
            limit = 20;
            break;
        default: return;
    }

    let overSpeed = currentSpeed - limit;

    if (overSpeed >= 1 && overSpeed <= 20){
        message = 'speeding';
    } else if (overSpeed >= 21 && overSpeed <= 40){
        message = 'excessive speeding';
    } else if (overSpeed >= 41) {
        message = 'reckless driving';
    } else {
        return;
    }

    console.log(message);
}

calcSpeed([200, 'motorway']);