class Repository {
    constructor(props){
        this.props = props;
        this.data = new Map();
        this.id = 0;
        this._count = 0;
    }

    add (entity){
        let hasAllProps = true;
        for (let key in this.props) {
            if(!entity.hasOwnProperty(key)){
                hasAllProps = false;
                throw new Error(`Property ${key} is missing from the entity!`);
            } else if (typeof entity[key] !== this.props[key]){
                hasAllProps = false;
                throw new TypeError(`Property ${entity[key]} is of incorrect type!`);
            }
        }

        if(hasAllProps){
            this.data.set(this.id, entity);
            return this.id++;
        }
    }

    get (id){
        return this.data.get(id);
    }

    update (id, newEntity){
        if(!this.data.has(id)){
            throw new Error(`Entity with id: ${id} does not exist!`)
        }

        for (let key in this.props) {
            if(!newEntity.hasOwnProperty(key)){
                throw new Error(`Property ${key} is missing from the entity!`);
            } else if (typeof newEntity[key] !== this.props[key]){
                throw new TypeError(`Property ${newEntity[key]} is of incorrect type!`);
            }
        }

        this.data.set(id, newEntity);
    }

    del (id){
        if(!this.data.has(id)){
            throw new Error(`Entity with id: ${id} does not exist!`)
        }
        this.data.delete(id);
    }

    get count(){
        this._count = this.data.size;
        return this._count;
    }

}

let properties = {
    name: "string",
    age: "number",
    birthday: "object"
};
let repository = new Repository(properties);

let anotherEntity = {
    name1: 'Nakov',
    age: 26,
    birthday: new Date(1991, 0, 21)
};
//repository.add(anotherEntity); // should throw an Error
anotherEntity = {
    name: 'Nakov',
    age: 26,
    birthday: 1991
};
repository.add(anotherEntity); // should throw a TypeError
//repository.del(-1); //



