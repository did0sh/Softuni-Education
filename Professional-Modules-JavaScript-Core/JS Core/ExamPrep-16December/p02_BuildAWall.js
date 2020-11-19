function main(arr) {
    arr = arr.map(Number).filter(x => x < 30);
    let result = [];
    let totalsum = 0;

    while (arr.length > 0) {
        let currentYards = arr.length * 195;
        totalsum += currentYards;
        result.push(currentYards);
        arr = arr.map(x => x+1).filter(y => y < 30);

}
    console.log(result.join(', '));
    console.log(`${totalsum * 1900} pesos`);

}



main([0,29]);