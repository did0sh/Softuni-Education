function find(arr) {
    let regex = /[0-9]+/g;
    let match;
    let result = [];
    for (let string of arr) {
        while(match = regex.exec(string)){
            result.push(match);
        }
    }

    console.log(result.join(' '));
}

find(['The300',
    'What is that?',
        'I think it’s the 3rd movie.',
        'Lets watch it at 22:45']);