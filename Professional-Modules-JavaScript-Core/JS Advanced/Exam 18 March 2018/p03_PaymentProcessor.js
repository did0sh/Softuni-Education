class PaymentProcessor{
    constructor(options){
        this.types = ['service', 'product', 'other'];
        this.precision = 2;
        this.options = options;

        this.payments = [];
    }

    checkOptions (options){
        if(this.options !== undefined){
            if (this.options.hasOwnProperty('types')) {
                this.types = this.options.types;
            }
            if (this.options.hasOwnProperty('precision')) {
                this.precision = this.options.precision;
            }
        }
    }

    registerPayment(id, name, type, value) {
        this.checkOptions();
        if(id === '' || name === ''){
            throw new Error();
        }
        if(Number(value) === undefined  || !this.types.includes(type)){
            throw new Error();
        }
        let existId = false;
        for (let obj of this.payments) {
            if(obj.id === id){
                existId = true;
            }
        }

        if(existId){
            throw new Error();
        }
        this.payments.push({id, name, type, value: value.toFixed(this.precision)})
    }

    deletePayment(id){
        let validId = false;
        for (let obj of this.payments) {
            if(obj.id === id){
                validId = true;
            }
        }

        if(validId === false){
            throw new Error();
        }
        let index= this.payments.map(function(x){ return x.id; }).indexOf(id);
        this.payments.splice(index,1);
    }

    get(id){
        let validId = false;
        for (let obj of this.payments) {
            if(obj.id === id){
                validId = true;
            }
        }

        if(validId === false){
            throw new Error();
        }
        let currentName;
        let currentType;
        let currentValue;
        for (let obj of this.payments) {
            if(obj.id === id){
                currentName = obj.name;
                currentType = obj.type;
                currentValue = obj.value;
            }
        }
        return `Details about payment ID: ${id}\n` + `- Name: ${currentName}\n` + `- Type: ${currentType}\n` + `- Value: ${currentValue}`
    }

    setOptions(options){
        if(options.hasOwnProperty('types')){
            this.types = options.types;
        }
        if(options.hasOwnProperty('precision')){
            this.precision = options.precision;
        }
    }

    toString(){
        let balance = 0;
        for (let obj of this.payments) {
            balance += Number(obj.value);
        }
        return `Summary:\n` + `- Payments: ${this.payments.length}\n` + `- Balance: ${balance.toFixed(this.precision)}`;
    }
}

let generalPayemnts = new PaymentProcessor({types: ['material']});
generalPayemnts.registerPayment('0001', 'Microchips', 'material', 15000);
generalPayemnts.registerPayment('01A3', 'Biopolymer', 'material', 23000);
generalPayemnts.registerPayment('0053', 'Interest', 'other', 0.00153);
generalPayemnts.registerPayment('0A42', 'Bulk transfer', 'custom', 1503000);
