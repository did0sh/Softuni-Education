function main() {
    class Melon{
        constructor(weight, melonSort){
            if(new.target === Melon){
                throw new Error('Abstract class cannot be instantiated directly')
            }

            this.weight = Number(weight);
            this.melonSort = melonSort;
        }

        toString(){
            return `\nSort: ${this.melonSort}` + `\nElement Index: ${this.elementIndex}`
        }
    }

    class Watermelon extends Melon{
        constructor(weight, melonSort){
            super(weight, melonSort);
            this.elementIndex = weight * melonSort.length
            this.element = 'Water';
        }

        get elemIndex() {
            return this.elementIndex
        }

        toString(){
            return `Element: ${this.element}` + super.toString()
        }

    }
    class Firemelon extends Melon{
        constructor(weight, melonSort){
            super(weight, melonSort);
            this.elementIndex = weight * melonSort.length
            this.element = 'Fire';
        }

        get elemIndex() {
            return this.elementIndex
        }

        toString(){
            return `Element: ${this.element}` + super.toString()
        }
    }
    class Earthmelon extends Melon{
        constructor(weight, melonSort){
            super(weight, melonSort);
            this.elementIndex = weight * melonSort.length
            this.element = 'Earth';
        }

        get elemIndex() {
            return this.elementIndex
        }

        toString(){
            return `Element: ${this.element}` + super.toString()
        }
    }
    class Airmelon extends Melon{
        constructor(weight, melonSort){
            super(weight, melonSort);
            this.elementIndex = weight * melonSort.length
            this.element = 'Air';
        }

        get elemIndex() {
            return this.elementIndex
        }

        toString() {
            return `Element: ${this.element}` + super.toString();
        }

    }

    class Melolemonmelon extends Watermelon{
        constructor(weight, melonSort){
            super(weight, melonSort);
        }

        morph(){
            if(this.element === "Water"){
                this.element = "Fire";
            } else if (this.element === "Fire"){
                this.element = "Earth";
            } else if(this.element === "Earth"){
                this.element = "Air";
            } else if(this.element === 'Air'){
                this.element = "Water";
            }
        }
    }

    return{
        Melon, Watermelon, Airmelon, Firemelon, Earthmelon, Melolemonmelon
    }
}



//let test = new Melon(100, "Test");
//Throws error

let watermelon = new Watermelon(12.5, "Kingsize");
console.log(watermelon.toString());

// Element: Water
// Sort: Kingsize
// Element Index: 100

