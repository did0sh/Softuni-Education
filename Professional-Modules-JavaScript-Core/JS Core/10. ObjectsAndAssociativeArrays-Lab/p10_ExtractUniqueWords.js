function extr(arr) {
    let result = new Map();
    let regex = /[A-Za-z]+/g;
    for (let string of arr) {
        let words = string.toLowerCase().match(regex);
        for (let w of words) {
            if(!result.has(w)){
                result.set(w,1);
            }
        }
    }

    let joinedOutput = Array.from(result.keys()).join(', ');;
    console.log(joinedOutput);
}

extr(['Lorem ipsum dolor sit amet, consectetur adipiscing elit.',
'Pellentesque quis hendrerit dui.',
    ' Quisque fringilla est urna, vitae efficitur urna vestibulum fringilla.',
    'Vestibulum dolor diam, dignissim quis varius non, fermentum non felis.',
    'Vestibulum ultrices ex massa, sit amet faucibus nunc aliquam ut.',
    'Morbi in ipsum varius, pharetra diam vel, mattis arcu.',
    'Integer ac turpis commodo, varius nulla sed, elementum lectus.',
    'Vivamus turpis dui, malesuada ac turpis dapibus, congue egestas metus.']);