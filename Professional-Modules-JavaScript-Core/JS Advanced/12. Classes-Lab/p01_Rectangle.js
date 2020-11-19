class Rectangle {
    constructor(width, height, color){
        this.width = width;
        this.height = height;
        this.color = color;
    }

    calcArea(){
        return this.width * this.height;
    }
}

let rect  = new Rectangle(4,5, 'blue');
console.log(rect.calcArea());