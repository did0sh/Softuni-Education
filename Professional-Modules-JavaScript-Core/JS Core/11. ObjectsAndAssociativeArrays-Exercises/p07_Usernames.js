function main(arr) {
    let result = new Map(); // can also be new Set();
    for (let string of arr) {
        if(!result.has(string)){
            result.set(string, 1);
        }
    }

    let ordered = Array.from(result.keys()).sort((a,b) => sortByLength(a,b));

    for (let key of ordered) {
        console.log(key);
    }

    function sortByLength(arg1, arg2) {
        if(arg1.length !== arg2.length){
            return arg1.length - arg2.length;
        } else {
            return arg1.localeCompare(arg2);
        }

    }
}

main(['Ashton',
'Kutcher',
'Ariel',
'Lilly',
'Keyden',
'Aizen',
'Billy',
'Braston']);