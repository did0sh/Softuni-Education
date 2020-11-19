class Player{
    constructor(nickname){
        this.nickname = nickname;
        this.scores = [];
    }

    addScore (score){
        if(!isNaN(score) && isFinite(score)){
            this.scores.push(Number(score));
        }
        return(this);
    }

    get scoreCount(){
        return this.scores.length;
    }

    get highestScore(){
        if(this.scores.length === 0){
            return undefined;
        }
        return this.scores.sort((a, b) => b-a)[0];

    }

    get topFiveScore(){
        return this.scores.sort((a,b) => b-a).slice(0, 5);
    }

    toString(){
        return `${this.nickname}: [${this.scores.sort((a,b) => b-a)}]`
    }
}

let peter = new Player("Peter");
console.log('Highest score: ' + peter.highestScore);
console.log(`Top 5 score: [${peter.topFiveScore}]`);
console.log('' + peter);
console.log('Score count: ' + peter.scoreCount);

peter.addScore(450);
console.log('Highest score: ' + peter.highestScore);
console.log(`Top 5 score: [${peter.topFiveScore}]`);
console.log(peter.toString());

console.log();

peter.addScore(2000); peter.addScore(300); peter.addScore(50); peter.addScore(700); peter.addScore(700);




console.log('Highest score: ' + peter.highestScore);
console.log(`Top 5 score: [${peter.topFiveScore}]`);
peter.addScore(3000);
peter.addScore(4.5123);
console.log(`Top 5 score: [${peter.topFiveScore}]`);
console.log('' + peter);
console.log('Score count: ' + peter.scoreCount);

console.log();
let maria = new Player("Maria")
maria.addScore(350)
maria.addScore(779)
maria.addScore(180);
maria.addScore('Pesho');
console.log('Highest score: ' + maria.highestScore);
console.log(`Top 5 score: [${maria.topFiveScore}]`);
console.log('' + maria);
