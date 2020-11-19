let expect = require('chai').expect;
let Console = require('../p05_Console').Console;

describe('Testing the class', function () {
    it('should return string message (hello world) for input string', function () {
        let str = 'hello world';
        expect(Console.writeLine(str)).to.equal(str);
    });
    it('should return json stringify of obj', function () {
        let obj = {pesho: 2, sasho: 3};
        expect(Console.writeLine(obj)).to.equal(JSON.stringify(obj));
    });

    it('should throw TypeErrror for first element not a string', function () {
        let notString = 123;
        expect(() => Console.writeLine(notString, 1, 2)).to.throw(TypeError);
    });

    it('should throw Range Error not corresponding parameters', function () {
        expect(() => Console.writeLine('{0}', 1, 2)).to.throw(RangeError);
    });

    it('should throw Range Error = placeholder not equal to number', function () {
        expect(() => Console.writeLine('{13}', 1)).to.throw(RangeError);
    });

    it('should correctly replace', function () {
        expect(Console.writeLine('This {0} to be replaced with {1}', 'name', 'dido')).to.equal('This name to be replaced with dido')
    });

    it('should correctly replace', function () {
        expect(Console.writeLine('This {0} to be replaced with {1} and with {2}', 'name', 'dido', 123)).to.equal('This name to be replaced with dido and with 123')
    });
})