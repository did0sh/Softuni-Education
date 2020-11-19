function solution(arr) {
    let spice = Number(arr[0]);
    let countDays = 0;
    let workersConsume = 26;
    let total = 0;

    while(true){
        if(spice < 100){
            break;
        }

        total += spice - workersConsume;
        spice -= 10;
        countDays++;

        if(spice < 100){
            if(total >= workersConsume){
                total -= workersConsume;
                break;
            }
            break;
        }
    }

    console.log(countDays);
    console.log(total);

}

solution(['100']);