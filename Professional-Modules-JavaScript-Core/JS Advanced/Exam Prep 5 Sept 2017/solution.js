class Dialog{
    constructor(message, callbackFunction){
        this.message = message;
        this.callback = callbackFunction;
        this.result = [];
        this.element = null;
    }

    addInput (label, name, type){
        this.result.push({label, name, type});
    }

    render (){
        this.element = $(`<div class="overlay">`);
        let appendDiv = $('<div class="dialog">');

        this.element.append(appendDiv.append(`<p>${this.message}</p>`));

        for (let obj of this.result) {
            appendDiv.append(`<label>${obj.label}</label>
    <input name=${obj.name} type=${obj.type}>`)
        }

        let okButton = $(' <button>OK</button>').on('click', this.okBtn.bind(this))
        let cancButton = $('    <button>Cancel</button>').on('click', this.cancBtn.bind(this) );


        appendDiv.append(okButton);
        appendDiv.append(cancButton);

        $('body').append(this.element);
    }

    cancBtn (){
       $(this.element).remove();
    }

    okBtn(){
        let obj = {};
        let inputs = $(this.element).find('input').toArray();
        inputs.forEach(i => obj[$(i).attr('name')] = $(i).val());
        this.callback(obj);
        this.cancBtn();
    }
}