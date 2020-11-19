function manipulate(string) {
    let regex = /[\s(),;\.]/;
    string.split(regex).filter(x => x!== '').forEach(str => console.log(str));
}

manipulate('let sum = 4 * 4,b = "wow";');