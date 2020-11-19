function solve(arr) {
    let sum = 0;
    let inverseSum = 0;
    let concatenated = '';
    for(let num of arr){
        sum += num;
        inverseSum += 1/num;
        concatenated += num;
    }

    console.log(sum);
    console.log(inverseSum);
    console.log(concatenated)
}

solve([1,2,3]);