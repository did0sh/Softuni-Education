function main(array, startIndex, endIndex) {
    if(!Array.isArray(array)){
        return NaN;
    }
    if(startIndex < 0){
        startIndex = 0;
    }
    if(endIndex > array.length - 1){
        endIndex = array.length - 1;
    }

    let sum = 0;
    for (let i = startIndex; i <= endIndex; i++) {
        sum += Number(array[i]);
    }
    return sum;
}

main([10, 20, 30, 40, 50, 60], 3, 300);
main([1.1, 2.2, 3.3, 4.4, 5.5], -3, 1);
main([10, 'twenty', 30, 40], 0, 2);
main('text', 0, 2);