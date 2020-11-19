(function extendObj() {

    let extId = 0;
    return class Extensible {
        constructor() {
            this.id = extId;
            extId++;
        }

        extend(template) {
            for (let property of Object.keys(template)) {
                if (typeof(template[property]) === 'function') {
                    Object.getPrototypeOf(this)[property] = template[property];
                } else {
                    this[property] = template[property];
                }
            }
        }
    }
}());

