function sortArray(array, command) {

    if(command === 'asc'){
        return array.sort(function (a,b){
            return a-b;
        });
    } else {
        return array.sort(function (a,b) {
            return b - a;
        });

    }

}

sortArray([14, 7, 17, 6, 8], 'desc');