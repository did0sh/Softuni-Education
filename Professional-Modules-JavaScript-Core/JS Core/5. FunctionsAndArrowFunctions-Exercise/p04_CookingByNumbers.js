function operations(arr) {
    let num = Number(arr[0]);

    for (let i = 1; i < arr.length; i++) {
        let activity = arr[i];

        if (activity === 'chop'){
            num = num / 2;
            console.log(num);
        } else if (activity === 'dice'){
            num = Math.sqrt(num);
            console.log(num);
        } else if (activity === 'spice'){
            num += 1;
            console.log(num);
        } else if (activity === 'bake'){
            num *= 3;
            console.log(num);
        } else if (activity === 'fillet') {
            num = 0.8 * num;
            console.log(num);
        }
    }
}

operations([9, 'dice', 'spice', 'chop', 'bake', 'fillet']);