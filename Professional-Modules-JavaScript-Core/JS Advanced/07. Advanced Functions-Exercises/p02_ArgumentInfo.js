function main(args) {
    let summary = [];
    let sorted = [];


    for (let i = 0; i < arguments.length; i++) {
        let obj = arguments[i];
        let type = typeof obj;
        console.log(`${type}: ${obj}`);

        if(!summary[type]){
            summary[type] = 1;
        } else {
            summary[type]++;
        }
    }

    for (let type in summary) {
        sorted.push({type: type, val: summary[type]});
    }
    
    sorted.sort(function (a, b) {
        return b.val - a.val;
    });

    for (let obj of sorted) {
        console.log(`${obj.type} = ${obj.val}`);
    }
}

main('cat', 42, function () { console.log('Hello world!'); });