function sortArray(arr) {
    arr.sort(sortBy2Criteria);
    console.log(arr.join('\n'))

    function sortBy2Criteria(a,b) {
        if(a.length > b.length){
            return 1;
        } else if(a.length < b.length){
            return -1;
        } else {
            return a > b;
        }
    }
}

sortArray(['Isacc',
    'Theodor',
    'Jack',
    'Harrison',
    'George'])