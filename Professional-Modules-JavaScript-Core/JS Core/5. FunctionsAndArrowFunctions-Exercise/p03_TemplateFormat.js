function template(arr) {
    let html = '<?xml version="1.0" encoding="UTF-8"?>\n' +
        '<quiz>\n';

    for (let i = 0; i < arr.length; i++) {
        if (i % 2 === 0){
            html += `   <question>\n   ${arr[i]}\n    </question>\n`;
        } else {
            html += `   <answer>\n   ${arr[i]}\n    </answer>\n`;
        }
    }

    html += '</quiz>';
    console.log(html);
}

template(["Dry ice is a frozen form of which gas?",
    "Carbon Dioxide",
    "What is the brightest star in the night sky?",
    "Sirius"]);