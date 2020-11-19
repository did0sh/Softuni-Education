function calculate(inches) {
    let feet = Number.parseInt(inches / 12);
    let remainingInches = inches % 12;

    console.log(`${feet}'-${remainingInches}"`);
}
calculate(11);