function manipulate(arr) {
        let obj = JSON.parse(arr);
        let html = '<table>\n';
    html += '   <tr>';

    for (let key of Object.keys(obj[0])) {
        html += `<th>${key}</th>`;
    }

    html += '</tr>\n';


        for (let object of obj) {
            html += '   <tr>';
            for (let key of Object.keys(object)) {
                html += `<td>${htmlEscape(object[key])}</td>`;
            }
            html += '</tr>\n'
        }

        html += '</table>';
        console.log(html);

    function htmlEscape(key) {
        let replaced = key.toString();
        replaced = replaced.split('&').join('&amp;');
        replaced = replaced.split('<').join('&lt;');
        replaced = replaced.split('>').join('&gt;');
        replaced = replaced.split('"').join('&quot;');
        replaced = replaced.split('\'').join('&#39;');

        return replaced;
    }
}

manipulate('[{"Name":"Tomatoes & Chips","Price":2.35},{"Name":"J&B Chocolate","Price":0.96}]');