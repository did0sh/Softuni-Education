function manipulate(arr) {
    // let obj = {
    //         namesRegex: /\*[A-Z]{1}[a-zA-Z]*(?= |\t|$)/g,
    //         phoneRegex: /\+[0-9\-]{10}(?= |\t|$)/g,
    //         idRegex: /![A-Za-z0-9]+(?= |\t|$)/g,
    //     baseRegex: /_[A-Za-z0-9]+(?= |\t|$)/g
    //     };

    let regex = /\*[A-Z]{1}[a-zA-Z]*(?= |\t|$)|\+[0-9\-]{10}(?= |\t|$)|![A-Za-z0-9]+(?= |\t|$)|_[A-Za-z0-9]+(?= |\t|$)/g;
    
    let match;

    for (let line of arr) {
            while(match = regex.exec(line)){
                line = line.replace(match[0], "|".repeat(match[0].length));
        }
        console.log(line);
    }
}

manipulate(['Agent *Ivankov was in the *D room when *Asd  it all happened.',
'The person in the room was heavily armed.',
'Agent *Ivankov had to act quick in order.',
'He picked up his phone and called some unknown number.',
'I think it was +555-49-796',
'I can\'t really remember...',
'He said something about "finishing work" with subject !2491a23BVB34Q and returning to Base _Aurora21',
'Then after that he disappeared from my sight.',
'As if he vanished in the shadows.',
'A moment, shorter than a second, later, I saw the person flying off the top floor.',
'I really don\'t know what happened there.',
'This is all I saw, that night.',
'I cannot explain it myself...']);