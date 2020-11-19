function symetric(num) {
    let count = Number(num[0]);
    let result = "";

    for (let i = 1; i <= count; i++) {
        if (isSymetric(i.toString())) {
            result += i + " ";
        }
    }
    console.log(result);

    function isSymetric(str) {
        for (let k = 0; k < str.length / 2; k++) {
            if (str[k] != str[str.length - k - 1]) {
                return false;
            }
        }
        return true;
    }
}
symetric(['750']);