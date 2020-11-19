function manipulate(arr) {
    let result = [];
    let commandExecutor = (function () {
        function add(text) {
            result.push(text);
        }
        function remove(string) {
            result = result.filter(x => x!== string)
        }
        function print() {
            console.log(result.join(','));
        }

        return {add, remove, print};
    })();

    for (let str of arr) {
        let args = str.split(' ');
        let command = args[0];

        if(args.length > 1){
            commandExecutor[command](args[1]);
        } else {
            commandExecutor[command]();
        }
    }
}

manipulate(['add pesho', 'add gosho', 'add pesho', 'remove pesho','print']);