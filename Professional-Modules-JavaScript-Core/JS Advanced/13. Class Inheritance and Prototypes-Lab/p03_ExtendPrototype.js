function extendClass(classToExtend) {
    classToExtend.prototype.species = 'Human';
    classToExtend.prototype.toSpeciesString = function () {
        return `I am a ${this.species}. ${this.toString()}`;
    }
}

 class Person{
     constructor(name, email){
         [this.name, this.email] = [name, email];
     }
     toString(){
         return `${this.constructor.name} (name: ${this.name}, email: ${this.email})`
     }
 }


extendClass(Person);
new Person("Maria", "maria@gmail.com").toSpeciesString();

