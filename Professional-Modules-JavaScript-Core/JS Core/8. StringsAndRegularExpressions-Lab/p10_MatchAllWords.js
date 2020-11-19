function match(string) {
    let regex = /\W+/;
    string = string.split(regex).filter(x => x !== '').join('|');
    console.log(string);
}

match('A Regular Expression needs to have the global flag in order to match all occurrences in the text');