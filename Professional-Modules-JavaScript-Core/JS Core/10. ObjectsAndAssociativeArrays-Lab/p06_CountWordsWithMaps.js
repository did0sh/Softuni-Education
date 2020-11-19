function manipulate(arr) {
    let words = arr[0].toLowerCase().split(/\W+/).filter(w => w!=='');
    let result = new Map();

    for (let word of words) {
        if(!result.has(word)){
            result.set(word, 1);
        } else {
            result.set(word, result.get(word)+1);
        }
    }

    let sorted = Array.from(result.keys()).sort();
    sorted.forEach(w => console.log(`\'${w}\' -> ${result.get(w)} times`))
}

manipulate(['Far too slow, you\'re far too slow.']);