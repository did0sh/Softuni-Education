function multiplyOrDivide(nums) {
    let num1 = Number(nums[0]);
    let num2 = Number(nums[1]);

    if(num2 >= num1){
        return num1*num2;
    }else {
        return num1/num2;
    }
}

console.log(multiplyOrDivide(["3", "3"]));