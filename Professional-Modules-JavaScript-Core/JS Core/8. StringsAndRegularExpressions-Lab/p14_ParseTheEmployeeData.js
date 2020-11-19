function parse(arr) {
    let regex = /^([A-Z][a-zA-Z]*) - ([1-9][0-9]*)+ - ([a-zA-Z0-9\- ]+)$/;
    for (let string of arr) {
        let match = regex.exec(string);
        if(match){
            console.log(`Name: ${match[1]}`);
            console.log(`Position: ${match[3]}`);
            console.log(`Salary: ${match[2]}`);
        }
    }
}

parse(['Isacc - 1000 - CEO',
'Ivan - 500 - Employee',
'Peter - 500 - Employee']
);