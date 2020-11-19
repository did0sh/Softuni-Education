function sum(arr) {
    let tokens = arr[0].split(' ');
    let num1 = Number(tokens[0]);
    let num2 = Number(tokens[1]);
    let num3 = Number(tokens[2]);

    if(num1 + num2 == num3){
        console.log(`${Math.min(num1, num2)} + ${Math.max(num1,num2)} = ${num3}`);
    } else if (num2 + num3 ==  num1){
        console.log(`${Math.min(num2, num3)} + ${Math.max(num3,num2)} = ${num1}`);
    } else if(num3 + num1 == num2){
        console.log(`${Math.min(num1, num3)} + ${Math.max(num1,num3)} = ${num2}`);
    } else {
        console.log('No')
    }
}
sum(['3 8 12']);