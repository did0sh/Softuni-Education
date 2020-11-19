function solution(arr) {
    let joined = arr.join(",");
    let words = joined.split(/\W+/);
    let nonEmptyWords = words.filter(word => word.length > 0);
    let upWords = nonEmptyWords.filter(isUpperCase);

    console.log(upWords.join(", "));

    function isUpperCase(str) {
        if(str === str.toUpperCase()){
            return true;
        }else {
            return false;
        }
    }
}
solution(['PHP, Java and HTML'])