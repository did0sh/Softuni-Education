class Stringer{
    constructor(string, length){
        this.innerString = string;
        this.innerLength = Number(length);
    }

    increase(length){
        this.innerLength += Number(length);
        if(this.innerLength < 3){
            this.innerLength = 0;
        }
        return this.innerLength
    }

    decrease(length){
        this.innerLength -= Number(length);
        if(this.innerLength < 3){
            this.innerLength = 0;
        }
        return this.innerLength;
    }

    toString(){
        if(this.innerLength >= this.innerString.length){
            return this.innerString
        }

        if(this.innerLength === 0){
            return '...'
        }

        this.innerString = this.innerString.substr(0, this.innerLength) + '...';
        return this.innerString;
    }
}

let test = new Stringer("Test", 5);
console.log(test.toString()); //Test

test.decrease(3);
console.log(test.toString()); //Te...

test.decrease(5);
console.log(test.toString()); //...

test.increase(4);
console.log(test.toString()); //Test
