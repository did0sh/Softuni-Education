function fibonacciNums() {
    let startNum = 0;
    let nextNum = 1;
    return function () {
        let result = startNum + nextNum;
        startNum = nextNum;
        nextNum = result;

        return startNum
    }
}



let fib = fibonacciNums();
fib();
fib();
fib();
fib();
fib();
fib();