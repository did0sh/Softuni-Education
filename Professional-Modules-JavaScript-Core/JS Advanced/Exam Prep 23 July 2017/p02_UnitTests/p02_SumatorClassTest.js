let expect = require('chai').expect;
let Sumator = require('../p02_SumatorClass').Sumator;

describe('Testing the sumator', function () {

    // check if functions exist
    describe('Initial Tests', function () {
        it('add is attached to proto', function () {
            expect(Sumator.prototype.hasOwnProperty('add')).to.equal(true, 'Function is not attached to prototype!');
        });
        it('sumNums is attached to proto', function () {
            expect(Sumator.prototype.hasOwnProperty('sumNums')).to.equal(true, 'Function nums is not attached to prototype!');
        });
        it('removeByFilter is attached to proto', function () {
            expect(Sumator.prototype.hasOwnProperty('removeByFilter')).to.equal(true, 'Function is not attached to prototype!');
        });
        it('toString is attached to proto', function () {
            expect(Sumator.prototype.hasOwnProperty('toString')).to.equal(true, 'Function is not attached to prototype!');
        });
    });

    //
    it('data should be empty at initialization', function () {
        let sumator = new Sumator();
        expect(sumator.data.length).to.equal(0, 'Data should be empty at initialization!');
    });

    it('should return empty for array with no items', function () {
        let sumator = new Sumator();
        expect(sumator.toString()).to.equal('(empty)');
    });

    it('should return 1', function () {
        let sumator = new Sumator();
        sumator.add(1);
        expect(sumator.toString()).to.equal('1');
    });

    it('should return joined array', function () {
        let sumator = new Sumator();
        sumator.add(1);
        sumator.add(2);
        sumator.add(3);
        expect(sumator.toString()).to.equal('1, 2, 3');
    });

    it('should return joined array', function () {
        let sumator = new Sumator();
        sumator.add(1);
        sumator.add(2);
        sumator.add({});
        sumator.add('asd')
        expect(sumator.toString()).to.equal('1, 2, [object Object], asd');
    });

    it('should return joined array', function () {
        let sumator = new Sumator();
        sumator.add(1.2);
        sumator.add([10,20]);
        sumator.add({});
        sumator.add('asd')
        expect(sumator.toString()).to.equal('1.2, 10,20, [object Object], asd');
    });

    it('should return joined array', function () {
        let sumator = new Sumator();
        sumator.add(1);
        sumator.add([]);
        sumator.add({pesho: 'ad', sasho: 123});
        sumator.add('asd');
        expect(sumator.toString()).to.equal('1, , [object Object], asd');
    });

    it('should sum the numbers only', function () {
        let sumator = new Sumator();
        sumator.add(1);
        sumator.add(20);
        sumator.add(new Date());
        sumator.add([]);
        sumator.add({pesho: 'ad', sasho: 123});
        sumator.add('asd');
        expect(sumator.sumNums()).to.equal(21);
    });

    it('should sum the numbers ', function () {
        let sumator = new Sumator();
        sumator.add(1);
        sumator.add(20);
        sumator.add(-15);
        sumator.add(4.2);
        expect(sumator.sumNums()).to.equal(10.2);
    });


    it('should return 0 ', function () {
        let sumator = new Sumator();
        sumator.add([]);
        sumator.add({});
        sumator.add('pesho');
        sumator.add(new Date());
        expect(sumator.sumNums()).to.equal(0);
    });

    it('should remove the filtered items ', function () {
        let sumator = new Sumator();
        sumator.add(2);
        sumator.add(3);
        sumator.add(11);
        sumator.add(4);
        sumator.removeByFilter(x => x % 2 === 0);
        expect(sumator.toString()).to.equal('3, 11');
    });

    it('should remove the filtered items ', function () {
        let sumator = new Sumator();
        sumator.add(2);
        sumator.add('pesho');
        sumator.add(11);
        sumator.add(4);
        sumator.removeByFilter(x => x % 2 === 1);
        expect(sumator.toString()).to.equal('2, pesho, 4');
    });

    it('should remove the filtered items ', function () {
        let sumator = new Sumator();
        sumator.add(2);
        sumator.add('pesho');
        sumator.add(11);
        sumator.add(4);
        sumator.add({});
        sumator.removeByFilter(x => typeof (x) === 'number');
        expect(sumator.toString()).to.equal('pesho, [object Object]');
    });

    it('should remove the filtered items ', function () {
        let sumator = new Sumator();
        sumator.add(2);
        sumator.add('pesho');
        sumator.add(11);
        sumator.add(4);
        sumator.add({});
        sumator.removeByFilter(x => typeof (x) !== 'number');
        expect(sumator.toString()).to.equal('2, 11, 4');
    });

    it('should remove the filtered items ', function () {
        let sumator = new Sumator();
        sumator.add(2);
        sumator.add(5);
        sumator.add(11);
        sumator.add(4);
        sumator.removeByFilter(x => typeof (x) === 'number');
        expect(sumator.toString()).to.equal('(empty)');
    });

    it('should remove the filtered items ', function () {
        let sumator = new Sumator();
        sumator.add('Krasi');
        sumator.add('Kami');
        sumator.add("ivan");
        sumator.add('Sasho');
        sumator.removeByFilter(x => x.startsWith('K'));
        expect(sumator.toString()).to.equal('ivan, Sasho');
    });
});