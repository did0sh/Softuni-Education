function reversedNumsPrint(nums) {
    nums = nums.map(Number);

    for(let i = nums.length - 1; i >= 0; i--){
        console.log(nums[i]);
    }
}

reversedNumsPrint(["10", "20", "30"]);