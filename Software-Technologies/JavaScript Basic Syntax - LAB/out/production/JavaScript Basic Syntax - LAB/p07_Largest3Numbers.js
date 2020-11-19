function solution(arr) {
    let tokens = arr[0].split(' ');
    let sorted = tokens.sort((a,b) => b - a);

    if(sorted.length < 3){
        for (let i = 0; i < sorted.length; i++) {
            console.log(sorted[i]);
        }
    } else {
        for(let i=0; i < 3; i++){
            console.log(sorted[i]);
        }
    }

}
solution(['10 5 20 3 20']);