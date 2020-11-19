function manipulate(arr) {
    let result = [];
    let sum = 0;

    for (let i = 0; i < arr.length; i++) {
        if(i % 2 === 0){
            result.push(arr[i]);
        } else {
            sum += Number(arr[i]);
        }
    }

    console.log(`You purchased ${result.join(', ')} for a total sum of ${sum}`);
}

manipulate(['Beer Zagorka', '2.65', 'Tripe soup', '7.80','Lasagna', '5.69']);
manipulate(['Cola', '1.35', 'Pancakes', '2.88']);