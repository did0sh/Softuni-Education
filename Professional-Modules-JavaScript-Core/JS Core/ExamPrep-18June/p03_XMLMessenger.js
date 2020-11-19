function solution(string) {
    let regex = /^<message((?:\s[a-z]+="[A-Za-z0-9\s.]+")+)>((?:.|\n)+)<\/message>$/g;
    let match = regex.exec(string);

    if(match !== null){
        let to = /\bto="([A-Za-z0-9 .]+)"/;
        let from = /\bfrom="([A-Za-z0-9 .]+)"/;

        if(to.exec(match[1]) !== null && from.exec(match[1]) !== null){
            let sender = from.exec(match[1])[1];
            let recipient = to.exec(match[1])[1];
            let html = `<article>\n  <div>From: <span class="sender">${sender}</span></div>\n  <div>To: <span class="recipient">${recipient}</span></div>\n  <div>\n`;

            let message = match[2].split('\n');
            for (let i = 0; i < message.length; i++) {
                html +=`    <p>${message[i]}</p>\n`;
            }
            html += '  </div>\n</article>';
            console.log(html);

        } else {
            console.log(`Missing attributes`);
        }
    } else {
        console.log(`Invalid message format`);
    }

}

solution(`<message to="Bob" from="Alice" timestamp="1497254114">Same old, same old
Let's go out for a beer</message>`);
