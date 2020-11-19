function main(base, increment) {
    let countHeight = 0;
    let stone = 0;
    let marble = 0;
    let lapis = 0;
    let gold = 0;

    while(base > 0){
        countHeight++;
        if(base === 2 || base === 1){
            gold += Math.pow(base,2) * increment;
            break;
        }

        stone += Math.pow((base-2),2) * increment;

        if(countHeight % 5 === 0){
            lapis += (Math.pow(base,2) - Math.pow((base-2),2)) * increment;
        } else {
            marble += (Math.pow(base,2) - Math.pow((base-2),2)) * increment;
        }

        base -= 2;
    }

    countHeight *= increment;

    console.log(`Stone required: ${Math.ceil(stone)}`);
    console.log(`Marble required: ${Math.ceil(marble)}`);
    console.log(`Lapis Lazuli required: ${Math.ceil(lapis)}`);
    console.log(`Gold required: ${Math.ceil(gold)}`);
    console.log(`Final pyramid height: ${Math.floor(countHeight)}`);
}

main(11,
    1);