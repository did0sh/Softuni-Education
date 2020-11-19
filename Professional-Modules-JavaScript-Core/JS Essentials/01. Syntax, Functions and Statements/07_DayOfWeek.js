function printDay(day) {
    let dayOfWeek = 0;
    switch (day.toLowerCase()) {
        case 'monday':
            dayOfWeek = 1;
            break;
        case 'tuesday':
            dayOfWeek = 2;
            break;
        case 'wednesday':
            dayOfWeek = 3;
            break;
        case 'thursday':
            dayOfWeek = 4;
            break;
        case 'friday':
            dayOfWeek = 5;
            break;
        case 'saturday':
            dayOfWeek = 6;
            break;
        case 'sunday':
            dayOfWeek = 7;
            break;
        default:
            dayOfWeek = 'error';
            break;
    }

    return dayOfWeek;
}

console.log(printDay('invalid'));