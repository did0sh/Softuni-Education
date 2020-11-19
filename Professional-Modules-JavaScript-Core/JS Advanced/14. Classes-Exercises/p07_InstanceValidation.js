class CheckingAccount{
    constructor(clientId, email, firstName, lastName){
        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.products = [];
    }

    get clientId(){
        return this._clientId;
    }

     set clientId(newId){
        let idRegex = /^\d{6}$/g;
       if(typeof newId !== 'string'){
            throw new TypeError('Client ID must be a 6-digit number')
       }
       
       if(! idRegex.test(newId)){
           throw new TypeError('Client ID must be a 6-digit number')
       }
        this._clientId = newId;
    }

    get email(){
        return this._email;
    }

    set email(newEmail){
        let emailRegex = /^\w+@[a-zA-Z.]+$/g;
        if(! emailRegex.test(newEmail)){
            throw new TypeError("Invalid e-mail");
        }

        this._email = newEmail;
    }

    get firstName(){
        return this._firstName;
    }

    set firstName(newFirst){
        if(newFirst.length < 3 || newFirst.length > 20){
            throw new TypeError("First name must be between 3 and 20 characters long");
        }
        let firstNameRegex = /^[A-Za-z]+$/;
        if(! firstNameRegex.test(newFirst)){
            throw new TypeError("First name must contain only Latin characters");
        }

        this._firstName = newFirst;
    }

    get lastName(){
        return this._lastName;
    }

    set lastName(newLast){
        if(newLast.length < 3 || newLast.length > 20){
            throw new TypeError("Last name must be between 3 and 20 characters long");
        }
        let lastNameRegex = /^[A-Za-z]+$/;
        if(! lastNameRegex.test(newLast)){
            throw new TypeError("Last name must contain only Latin characters");
        }

        this._lastName = newLast;
    }
}

let acc = new CheckingAccount(314, 'ivansome.com', 'Ivan', 'Petrov');


