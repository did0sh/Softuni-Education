let expect = require('chai').expect;
let sum = require('../p04_SumNumbers').sum;

describe('Sum', function() {
    it('should return 3 for [1,2]', function() {
        let expectedSum = 3;
        let actualSum = sum([1,2]);
        expect(actualSum).to.be.equal(expectedSum);
    });

    it('should return 1 for [1]', function() {
        let expectedSum = 1;
        let actualSum = sum([1]);
        expect(actualSum).to.be.equal(expectedSum);
    });

    it('should return 0 for empty array', function() {
        let expectedSum = 0;
        let actualSum = sum([]);
        expect(actualSum).to.be.equal(expectedSum);
    })

});