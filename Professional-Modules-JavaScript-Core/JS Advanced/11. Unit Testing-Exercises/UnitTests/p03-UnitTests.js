let expect = require('chai').expect;
let should = require('chai').should();
let lookupChar = require('../p03_CharLookup').lookupChar;

describe('lookupChar', function(){

    it('should return undefined for floating point number ', function(){
        expect(lookupChar('didosdidos', 12.5)).to.equal(undefined, 'The function did not return the correct result');
    })

    it('should return undefined for not a string and valid index', function(){
        expect(lookupChar(12, 15)).to.equal(undefined);
    });

    it('should return undefined for not a string and valid index', function(){
        expect(lookupChar({}, 15)).to.equal(undefined);
    });

    it('should return undefined for a string and Invalid index', function(){
        expect(lookupChar(12, {})).to.equal(undefined);
    });

    it('should return undefined for a string and Invalid index', function(){
        expect(lookupChar(12, 'asdf')).to.equal(undefined);
    });

    it('should return message (Incorrect index) for string length = 5 and index = 5', function(){
        expect(lookupChar('didos', 5)).to.equal('Incorrect index');
    });

    it('should return message (Incorrect index) for string length = 5 and index = -1', function(){
        expect(lookupChar('didos', -1)).to.equal('Incorrect index');
    });

    it('should return Char (s) for string length = 5 and index = 4', function(){
        expect(lookupChar('didos', 4)).to.equal('s', 'The function did not return the correct result');
    });

    it('should return Char (d) for string length = 10 and index = 0', function(){
        expect(lookupChar('didosdidos', 5)).to.equal('d', 'The function did not return the correct result');
    });
    
})