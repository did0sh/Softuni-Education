function printTable(n) {
    let html = "<table border=\"1\">\n";
    html += "<tr><th>x</th>";

    for (let i = 1; i <= n; i++) {
        if (i === n){
            html += `<th>${i}</th></tr>\n`;
        } else {
            html += `<th>${i}</th>`;
        }
    }

    for (let k = 1; k <= n; k++) {

        html += `<tr><th>${k}</th>`;

        for (let t = 1; t <= n; t++) {

            if (t === n){
                html += `<td>${t}</td></tr>\n`;
                break;
            } else {
                html += `<td>${t}</td>`;
            }

        }
    }

    html += "</table>";
    console.log(html);
}

printTable(5);