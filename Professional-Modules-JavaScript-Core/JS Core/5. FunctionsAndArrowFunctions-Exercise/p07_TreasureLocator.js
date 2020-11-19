function findTreasure(arr) {
    let output = '';

    for (let i = 0; i < arr.length; i+=2) {
        let x = Number(arr[i]);
        let y = Number(arr[i+1]);

        if ((x >= 0 && x <= 2) && (y >= 6 && y <= 8)){
            output = 'Tonga';
        } else if ((x >= 1 && x <= 3) && (y >= 1 && y <= 3)){
            output = 'Tuvalu';
        } else if ((x >= 5 && x <= 7) && (y >= 3 && y <= 6)){
            output = 'Samoa';
        } else if ((x >= 4 && x <= 9) && (y >= 7 && y <= 8)) {
            output = 'Cook';
        } else if ((x >= 8 && x <= 9) && (y >= 0 && y <= 1)) {
            output = 'Tokelau';
        } else {
            output = 'On the bottom of the ocean';
        }

        console.log(output);

    }
}

findTreasure([4, 2, 1.5, 6.5, 1, 3]);
