function solution(arr) {
    let tokens = arr.map(Number);
    let sorted = tokens.sort((a, b) => b - a);

    if(sorted.length < 3){
        for (let i = 0; i < sorted.length; i++) {
            console.log(sorted[i]);
        }
    } else {
        for(let k=0; k < 3; k++){
            console.log(sorted[k]);
        }
    }

}
solution(['10', '30', '15', '20', '50', '5']);