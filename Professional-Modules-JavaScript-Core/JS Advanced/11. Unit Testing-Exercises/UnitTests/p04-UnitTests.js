let expect = require('chai').expect;
let mathEnforcer = require('../p04_MathEnforcer').mathEnforcer;

describe('Enforcing math funcs', function(){
    describe('addFive', function(){
        it('should return undefined for not a number', function(){
            expect(mathEnforcer.addFive()).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.addFive({})).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.addFive('asdf')).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.addFive([1,2,3])).to.equal(undefined);
        });

        it('should return 6 for adding', function(){
            expect(mathEnforcer.addFive(1)).to.equal(6);
        });

        it('should return 3 for adding negative', function(){
            expect(mathEnforcer.addFive(-2)).to.equal(3);
        });

        it('should return 8.5 for adding negative', function(){
            expect(mathEnforcer.addFive(3.5)).to.equal(8.5);
        });
    });

    describe('subtractTen', function(){
        it('should return undefined for not a number', function(){
            expect(mathEnforcer.subtractTen()).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.subtractTen({})).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.subtractTen('asdf')).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.addFive([1,2,3])).to.equal(undefined);
        });

        it('should return -4 for subtracting', function(){
            expect(mathEnforcer.subtractTen(6)).to.equal(-4);
        });

        it('should return -12 for adding negative', function(){
            expect(mathEnforcer.subtractTen(-2)).to.equal(-12);
        });

        it('should return -7.5 for adding negative floating', function(){
            expect(mathEnforcer.subtractTen(2.5)).to.equal(-7.5);
        });

        it('should return 100 for adding negative', function(){
            expect(mathEnforcer.subtractTen(110)).to.equal(100);
        });
    });

    describe('sum', function(){
        it('should return undefined for not a number', function(){
            expect(mathEnforcer.sum()).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.sum({})).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.sum('asdf')).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.sum('asdf', 12)).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.sum(12, 'asdf')).to.equal(undefined);
        });

        it('should return undefined for not a number', function(){
            expect(mathEnforcer.addFive([1,2,3], {})).to.equal(undefined);
        });

        it('should return 5 for sum 2,3', function(){
            expect(mathEnforcer.sum(2,3)).to.equal(5);
        });

        it('should return 5.9 for adding floating nums', function(){
            expect(mathEnforcer.sum(2.5, 3.4)).to.equal(5.9);
        });

        it('should return 1.3 for adding negative floating', function(){
            expect(mathEnforcer.sum(2.5, -1.2)).to.equal(1.3);
        });

        it('should return -100 for adding two negatives', function(){
            expect(mathEnforcer.sum(-50, -50)).to.equal(-100);
        });
    })
});