function manipulate(arr) {
    let replaceChars = {'&': '&amp;', '<': '&lt;', '>': '&gt;','"': '&quot;', '\'': '&#39;'};
    let obj = JSON.parse(arr);
    let html = '<table>\n';
    html += `    <tr><th>name</th><th>score</th></tr>\n`;

    for (let object of obj) {
        for (let symbol in replaceChars) {
            object['name'] = object['name'].split(symbol).join(replaceChars[symbol]);
        }
        html += `    <tr><td>${object['name']}</td><td>${object['score']}</td></tr>\n`;
    }

    html += '</table>';
    console.log(html);
}

manipulate('[{"name":"Pesho & Kiro","score":479},{"name":"Gosho, Maria & Viki","score":205}]');