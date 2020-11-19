// function main(arr) {
//     let commandProcessor = (function () {
//         let text = "";
//         return {
//             append: newText => text += newText,
//             removeStart: count => text = text.slice(count),
//             removeEnd: count => text = text.slice(0, text.length-count),
//             print: () => console.log(text)
//         }
//     }());
//
//     for(let cmd of commands){
//         let[cmdName, arg] = cmd.split(' ');
//         commandProcessor[cmdName](arg);
//     }
// }

function main(arr) {
    let text = "";
    for (let string of arr) {
        let args = string.split(' ');
        let cmd = args[0];

        if(cmd === 'append'){
            text = text + args[1];
        } else if (cmd === 'removeStart'){
            text = text.slice(Number(args[1]));
        } else if (cmd === 'removeEnd'){
            text = text.slice(0, text.length - Number(args[1]));
        } else if(cmd === 'print'){
            console.log(text);
        }
    }
}

main(['append hello',
    'append again',
    'removeStart 3',
    'removeEnd 4',
    'print']);