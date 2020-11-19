function chessBoard(input) {
    let html = '<div class="chessboard">\n';

    for(let i = 1; i <= input; i++){
        html += '   <div>\n';
        let color = (i % 2 === 1) ? 'black' : 'white';

        for(let k = 1; k <= input; k++){
            html += `       <span class="${color}"></span>\n`;
            color = (color === 'white') ? 'black' : 'white';
        }
        html += '   </div>\n'
    }
    html += '</div>';
    return html;
}

console.log(chessBoard(3));