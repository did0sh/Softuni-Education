function cook(array) {
    let number = Number(array[0]);
    for (let i = 1; i < array.length ; i++) {
        let cookType = array[i];
        switch (cookType) {
            case 'chop':
                number = number / 2;
                break;
            case 'dice':
                number = Math.sqrt(number);
                break;
            case 'spice':
                number++;
                break;
            case 'bake':
                number *= 3;
                break;
            case 'fillet':
                number *= 0.8;
                break;
        }
        console.log(number);
    }
}

cook(['32', 'chop', 'chop', 'chop', 'chop', 'chop']);