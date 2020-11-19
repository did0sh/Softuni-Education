function extract(arr) {
    let regex = /(www\.)([A-Za-z0-9\-]+)(\.[a-z]+)+/g;
    let match;
    for (let string of arr) {
        while(match = regex.exec(string)){
            console.log(match[0]);
        }
    }
}

extract(['Join WebStars now for free, at www.web-stars.com',
'You can also support our partners:',
'Internet - www.internet.com',
'WebSpiders - www.webspiders101.com',
'Sentinel - www.sentinel.-ko']);