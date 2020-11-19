function manipulate(arr) {
    let words = arr[0].split(/\W+/).filter(w => w!=='');
    let result = {};

    for (let word of words) {
        if(!result.hasOwnProperty(word)){
            result[word] = 1;
        } else {
            result[word]++;
        }
    }

    console.log(JSON.stringify(result));
}

manipulate(['JS devs use Node.js for server-side JS.-- JS for devs']);