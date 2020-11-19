function manipulate(arr) {
    let html = '<table>\n';


    for (let string of arr) {
        let parsedArr = JSON.parse(string);
        html += '\t<tr>\n';
        for (let value of Object.values(parsedArr)) {
            html += `		<td>${value}</td>\n`;
        }
        html += '\t<tr>\n';
    }

    html += '</table>';
    console.log(html);
}

manipulate([`{"name":"Pesho","position":"Promenliva","salary":100000}`,
`{"name":"Teo","position":"Lecturer","salary":1000}`,
`{"name":"Georgi","position":"Lecturer","salary":1000}`]);