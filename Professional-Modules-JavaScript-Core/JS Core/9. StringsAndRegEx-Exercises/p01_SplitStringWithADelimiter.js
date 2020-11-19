function manipulate(string, delimiter) {
    let args = string.split(delimiter);
    for (let obj of args) {
        console.log(obj);
    }
}

manipulate('One-Two-Three-Four-Five',
    '-');