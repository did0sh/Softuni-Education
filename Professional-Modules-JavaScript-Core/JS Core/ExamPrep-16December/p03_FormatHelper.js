function main(arr) {
   let firstReg = /[ ]*([.,!?:;])[ ]*/g;
   let secondReg = /\. (?=[0-9])/g;
   let thirdReg = /" *(.+?) *"/g;
   let lastReg = /([.,!?:;]) (?=[.,!?:;])/g;
   let string = arr[0];

    console.log(string.replace(firstReg, (match, group1) => `${group1} `)
        .replace(secondReg, `.`)
        .replace(thirdReg, (match, group1) => `"${group1}"`)
        .replace(lastReg, (match, group1) => `${group1}`));
}

main(['Terribly formatted text      .  With chaotic spacings." Terrible quoting   "! Also this date is pretty confusing : 20   .   12.  16 .']);