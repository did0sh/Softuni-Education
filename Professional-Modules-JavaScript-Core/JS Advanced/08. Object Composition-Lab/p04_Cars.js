function cars(input) {
    let result = {};
    let commandProcessor = (function () {
        function create(args) {
            if(args.length > 2){
                result[args[1]] = Object.create(result[args[3]])
            } else {
                result[args[1]] = {};
            }
        }
        function set(args) {
            let obj = args[1];
            let key = args[2];
            let value = args[3];
            result[obj][key] = value;
        }
        function print(args) {
            let array = [];
            let obj = result[args[1]];
            for (let key in obj) {
                array.push(`${key}:${obj[key]}`);
            }
            console.log(array.join(', '));
        }
        return {create, set, print};
    })();

    for (let str of input) {
        let args = str.split(' ');
        let cmd = args[0];
        commandProcessor[cmd](args);
    }
}

cars(['create c1',
    'create c2 inherit c1',
    'set c1 color red',
    'set c2 model new',
    'print c1',
    'print c2']
);
