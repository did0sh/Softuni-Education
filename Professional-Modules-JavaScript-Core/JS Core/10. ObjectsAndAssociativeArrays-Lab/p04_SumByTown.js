function manipulate(arr) {
    let result = {};
    for (let i = 0; i < arr.length; i+=2) {
       let town = arr[i];
       let townIncome = Number(arr[i+1]);

       if(!result.hasOwnProperty(town)){
            result[town] = townIncome;
       } else {
           result[town] += townIncome;
       }
    }

    console.log(JSON.stringify(result));
}

manipulate(['Sofia', '20', 'Varna', '3', 'Sofia', '5', 'Varna', '4']);