function matchDates(arr) {
    let regex = /\b([0-9]{1,2})-([A-Z][a-z]{2})-([0-9]{4})\b/g;
    let arrayMatches;
    
    for (let i = 0; i < arr.length; i++) {
        let string = arr[i];
        while(arrayMatches = regex.exec(string)){
            console.log(`${arrayMatches[0]} (Day: ${arrayMatches[1]}, Month: ${arrayMatches[2]}, Year: ${arrayMatches[3]})`);
        }

    }
}

matchDates(['I am born on 30-Dec-1994.',
'This is not date: 512-Jan-1996.',
'My father is born on the 29-Jul-1955.']
);