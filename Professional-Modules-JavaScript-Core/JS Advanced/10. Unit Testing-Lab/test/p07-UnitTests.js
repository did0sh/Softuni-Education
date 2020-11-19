let expect = require('chai').expect;
let createCalculator = require('../p07_AddSubstract').createCalculator;

describe('createCalculator()', function () {
    let calc;

    beforeEach(function () {
        calc = createCalculator();
    });

    it('should return 5 for add 2,3', function () {
        calc.add(2);
        calc.add(3);
        let value = calc.get();
        expect(value).to.be.equal(5);
    });

    it('should return 4.5 for add 2.3, 2.2', function () {
        calc.add(2.2);
        calc.add(2.3);
        let value = calc.get();
        expect(value).to.be.equal(4.5);
    });

    it('should return -5 for add -2,-3', function () {
        calc.add(-2);
        calc.add(-3);
        let value = calc.get();
        expect(value).to.be.equal(-5);
    });

    it('should return 0 for get()', function () {
        let value = calc.get();
        expect(value).to.be.equal(0);
    });

    it('should return -11 for subtract 9,2', function () {
        calc.subtract(9);
        calc.subtract(2);
        let value = calc.get();
        expect(value).to.be.equal(-11);
    });

    it('should return 7.1 for add 9.2, substract 2.1', function () {
        calc.add(9.2);
        calc.subtract(2.1);
        let value = calc.get();
        expect(value).to.be.equal(7.1);
    });


    it('should return 6 for add 2, subtract -4', function () {
        calc.add(2);
        calc.subtract(-4);
        let value = calc.get();
        expect(value).to.be.equal(6);
    });

    it("should return 2 after add(10); subtract('7'); add('-2'); subtract(-1)", function () {
        calc.add(10);
        calc.subtract('7');
        calc.add('-2');
        calc.subtract(-1);
        let value = calc.get();
        expect(value).to.be.equal(2);
    });

    it('should return NaN for add hello', function () {
        calc.add('hello');

        let value = calc.get();
        expect(value).to.be.NaN;
    });

    it('should return NaN for subtract hello', function () {
        calc.subtract('hello');
        let value = calc.get();
        expect(value).to.be.NaN;
    });

});