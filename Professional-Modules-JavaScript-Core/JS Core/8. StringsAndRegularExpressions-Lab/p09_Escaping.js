function escapeSymbols(arr) {
    let output = '<ul>\n';
    let replaceChars = {'&': '&amp;', '<': '&lt;', '>': '&gt;','"': '&quot;'};

    for (let i = 0; i < arr.length; i++) {
        output += ' <li>';
        let text = arr[i];

        for (let symbol in replaceChars) {
            text = text.split(symbol).join(replaceChars[symbol]);
        }
        output += text + '</li>\n';
    }

    output += '</ul>';
    console.log(output);
}

escapeSymbols(['<b>unescaped text</b>', 'normal text']);