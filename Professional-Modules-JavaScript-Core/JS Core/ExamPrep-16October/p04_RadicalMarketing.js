function manipulate(arr) {
    let result = new Map();
    let log = new Map();
    for (let str of arr) {
        let args = str.split('-');
        if(args.length === 2){
            let subscriber = args[0];
            let secondPerson = args[1];
            if(result.has(subscriber) && result.has(secondPerson) && subscriber !== secondPerson){
                if(!result.get(secondPerson).includes(subscriber)){
                    result.get(secondPerson).push(subscriber);
                    log.get(subscriber).push(secondPerson);
                }
            }
        } else {
            let person = args[0];
            if(!result.has(person)){
                result.set(person, []);
            }
            if(!log.has(person)){
                log.set(person, []);
            }
        }
    }

   let sorted = new Map([...result.entries()].sort(function (firstEntry, secondEntry) {
       let firstLength = firstEntry[1].length;
       let secondLenght = secondEntry[1].length;
       let last = secondLenght - firstLength;

       if(last === 0){
            let firstEntryLog = log.get(firstEntry[0]).length;
            let secondEntryLog = log.get(secondEntry[0]).length;
            last = secondEntryLog - firstEntryLog;
            return last;
       } else {
           return last;
       }
   }));

    for (let [key, value] of sorted) {
            console.log(key);
            let count = 0;
            for (let position of value) {
                count++;
                console.log(`${count}. ${position}`);
            }
        break;
    }
}

manipulate([`A`,
`B`,
`C`,
`D`,
`A-B`,
`A-B`,
`B-A`,
`C-A`,
`D-A`,
'D-B',
'C-B']);

manipulate([`J`,
`G`,
`P`,
`R`,
`C`,
`J-G`,
`G-J`,
`P-R`,
`R-P`,
`C-J`]);