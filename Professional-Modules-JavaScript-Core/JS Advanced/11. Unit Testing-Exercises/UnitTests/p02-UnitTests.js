let expect = require('chai').expect;
let isOddOrEven = require('../p02_OddOrEven').isOddOrEven;

describe('Testing', function() {
    it('should return undefined for not a string', function(){
        expect(undefined).to.be.equal(isOddOrEven({}));
    });

    it('should return odd for length 5', function(){
        expect('odd').to.be.equal(isOddOrEven('abcde'));
    });

    it('should return even for 2', function(){
        expect('even').to.be.equal(isOddOrEven('di'));
    });

    it('should return 0 for empty string', function(){
        expect('even').to.be.equal(isOddOrEven(''));
    });
})