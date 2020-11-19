function isPalindrom(string) {
    let palindrom = '';
    let length = string.length;
    for (let i = 0; i < Math.floor(length/2); i++) {
        if (string[i] !== string[length - i - 1]){
            palindrom = false;
            console.log(palindrom);
            return;
        }
    }
    palindrom = true;
    console.log(palindrom);
}

isPalindrom('unitinu');