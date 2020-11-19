function positiveOrNegative(nums) {
    nums = nums.map(Number);

    let countNegativeNums = 0;
    if(nums[0] < 0){
        countNegativeNums++;
    }

    if(nums[1] < 0){
        countNegativeNums++;
    }

    if (nums[2] < 0){
        countNegativeNums++;
    }

    if(nums[0] === 0 || nums[1] === 0 || nums[2] === 0){
        console.log('Positive')
    }else {
        if(countNegativeNums % 2 === 1){
            console.log('Negative')
        } else {
            console.log('Positive')
        }
    }

}

positiveOrNegative(["0", "-4", "-3"]);