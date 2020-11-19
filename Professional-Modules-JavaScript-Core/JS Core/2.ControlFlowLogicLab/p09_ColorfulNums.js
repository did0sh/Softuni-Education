function colorNums(n) {
    console.log("<ul>");
    let color = "";
    for (let i=1; i <= n; i++){
        if (i % 2 === 0){
            color = 'blue';
        } else {
            color = 'green';
        }

        console.log(`    <li><span style='color:${color}'>${i}</span></li>`)
    }
    console.log('</ul>');
}

colorNums(10);

