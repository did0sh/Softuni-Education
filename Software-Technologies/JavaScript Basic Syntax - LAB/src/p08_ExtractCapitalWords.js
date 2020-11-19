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
solution(['We start by HTML, CSS, JavaScript, JSON and REST.\n' +
'Later we touch some PHP, MySQL and SQL.' +
'Later we play with C#, EF, SQL Server and ASP.NET MVC.' +
'Finally, we touch some Java, Hibernate and Spring.MVC.']);