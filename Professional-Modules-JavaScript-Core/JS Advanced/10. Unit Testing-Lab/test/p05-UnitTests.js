let expect = require('chai').expect;
let isSymmetric = require('../p05_CheckForSymmetry').isSymmetric;

describe('Is symmetric', function() {
    it('should return true for [a,b,a]', function(){
        let expOutput = true;
        let actualOutput = isSymmetric(['a','b','a']);
        expect(expOutput).to.be.equal(actualOutput);
    });

    it('should return false for {}', function(){
        let expOutput = false;
        let actualOutput = isSymmetric({});
        expect(expOutput).to.be.equal(actualOutput);
    });

    it('should return false for [5,\'hi\',{a:5},new Date(),{X:5},\'hi\',5]', function(){
        let expOutput = false;
        let actualOutput = isSymmetric([5,'hi',{a:5},new Date(),{X:5},'hi',5]);
        expect(expOutput).to.be.equal(actualOutput);
    });

    it('should return true for  [5,\'hi\',{a:5},new Date(),{a:5},\'hi\',5]', function(){
        let expOutput = true;
        let actualOutput = isSymmetric([5,'hi',{a:5},new Date(),{a:5},'hi',5]);
        expect(expOutput).to.be.equal(actualOutput);
    });

    it('should return false for [-1, 2, 1]', function(){
        let expOutput = false;
        let actualOutput = isSymmetric([-1, 2, 1]);
        expect(expOutput).to.be.equal(actualOutput);
    });

    it('should return true for [-1, 2, -1]', function(){
        let expOutput = true;
        let actualOutput = isSymmetric([-1, 2, -1]);
        expect(expOutput).to.be.equal(actualOutput);
    });

    it('should return true for [-1]', function(){
        let expOutput = true;
        let actualOutput = isSymmetric([-1]);
        expect(expOutput).to.be.equal(actualOutput);
    });

    it('should return false for 1,2,3', function(){
        let expOutput = false;
        let actualOutput = isSymmetric(1,2,3);
        expect(expOutput).to.be.equal(actualOutput);
    });
});
