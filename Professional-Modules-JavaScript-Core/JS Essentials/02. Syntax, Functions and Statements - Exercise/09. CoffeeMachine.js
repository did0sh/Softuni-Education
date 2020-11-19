function solve(arr) {

    let globalIncome = 0;

    for (let i = 0; i < arr.length; i++) {
        let input = arr[i].split(/[\s,]+/);
        let insertedCoins = Number(input[0]);
        let drinkType = undefined;
        let milk = undefined;
        let sugar = undefined;
        
        if(input[2] === 'milk'){
            milk = input[2];
            drinkType = input[1];
            sugar = Number(input[3]);
        } else if(input[3] === 'milk'){
            milk = input[3];
            drinkType = input[1] + " " + input[2];
            sugar = Number(input[4]);
        } else if(input.length === 4){
            drinkType = input[1] + " " + input[2];
            sugar = Number(input[3]);
        } else if(input.length === 3){
            drinkType = input[1];
            sugar = Number(input[2]);
        }

        let coffeeCaffeinePrice = 0.8;
        let coffeeDecafPrice = 0.9;
        let teaPrice = 0.8;
        let sugarPrice = 0.1;

        function addSugar(totalAmount, sugar) {
            totalAmount += sugar;
            return totalAmount;
        }

        let change = 0;
        let totalAmount = 0;

        switch (drinkType) {
            case 'coffee caffeine':
                totalAmount += coffeeCaffeinePrice;
                if(milk !== undefined){
                    let milkPrice = (coffeeCaffeinePrice * 0.1);
                    totalAmount += (Math.round(milkPrice * 10)/10);
                }
                if(sugar > 0 && sugar <= 5){
                    totalAmount = addSugar(totalAmount, sugarPrice);
                }
                change = insertedCoins - totalAmount;
                if(change < 0){
                    console.log(`Not enough money for coffee. Need $${Math.abs(change).toFixed(2)} more.`)
                } else {
                    console.log(`You ordered coffee. Price: $${totalAmount.toFixed(2)} Change: $${change.toFixed(2)}`);
                    globalIncome += totalAmount;
                }
                break;
            case 'coffee decaf':
                totalAmount += coffeeDecafPrice;
                if(milk !== undefined){
                    let milkPrice = (coffeeDecafPrice * 0.1);
                    totalAmount += (Math.round(milkPrice * 10)/10);
                }
                if(sugar > 0 && sugar <= 5){
                    totalAmount = addSugar(totalAmount, sugarPrice);
                }
                change = insertedCoins - totalAmount;
                if(change < 0){
                    console.log(`Not enough money for coffee. Need $${Math.abs(change).toFixed(2)} more.`)
                } else {
                    console.log(`You ordered coffee. Price: $${totalAmount.toFixed(2)} Change: $${change.toFixed(2)}`);
                    globalIncome += totalAmount;
                }
                break;
            case 'tea':
                totalAmount += teaPrice;
                if(milk !== undefined){
                    let milkPrice = (teaPrice * 0.1);
                    totalAmount += (Math.round(milkPrice * 10)/10);
                }
                if(sugar > 0 && sugar <= 5){
                    totalAmount = addSugar(totalAmount, sugarPrice);
                }
                change = insertedCoins - totalAmount;
                if(change < 0){
                    console.log(`Not enough money for tea. Need $${Math.abs(change).toFixed(2)} more.`)
                } else {
                    console.log(`You ordered tea. Price: $${totalAmount.toFixed(2)} Change: $${change.toFixed(2)}`);
                    globalIncome += totalAmount;
                }
                break;
        }
    }

    console.log(`Income Report: $${globalIncome.toFixed(2)}`)
}

solve(['8.00, coffee, decaf, 4', '1.00, tea, 2']);