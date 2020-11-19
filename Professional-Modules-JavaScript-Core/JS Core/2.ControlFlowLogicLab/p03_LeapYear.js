function leapYearCheck(year) {

    let isDivisible = false;

    if (year % 4 === 0 && year % 100 !== 0){
        isDivisible = true;
    } else if (year % 400 === 0){
        isDivisible = true;
    } else {
        isDivisible = false;
    }

    if (isDivisible){
        console.log("yes");
    } else {
        console.log("no");
    }
}

leapYearCheck(1900);