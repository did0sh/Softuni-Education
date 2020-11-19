let expect = require('chai').expect;
let makeList = require('../p02_AddLeftRight').makeList;

describe('Testing the program', function(){

    describe('Should have all properties', function(){
        it('should have addLeft', function(){
            expect(makeList().hasOwnProperty('addLeft')).to.be.true;
        })
        it('should have addRight', function(){
            expect(makeList().hasOwnProperty('addRight')).to.be.true;
        })
        it('should have clear', function(){
            expect(makeList().hasOwnProperty('clear')).to.be.true;
        })
        it('should have toString', function(){
            expect(makeList().hasOwnProperty('toString')).to.be.true;
        })
    })

    describe('Testing the functions', function(){
        let myList = {};
        beforeEach(function(){
            myList = makeList();
        })
        it('right 1 item', function(){
            myList.addRight(1);
            expect(myList.toString()).to.be.equal('1');
        })

        it('right more items', function(){
            myList.addRight(1);
            myList.addRight('pesho');
            myList.addRight('{}');
            expect(myList.toString()).to.be.equal('1, pesho, {}');
        })

        it('left 1 item', function(){
            myList.addLeft(1);
            expect(myList.toString()).to.be.equal('1');
        })

        it('left more items', function(){
            myList.addLeft(1);
            myList.addLeft('pesho');
            myList.addLeft('{}');
            expect(myList.toString()).to.be.equal('{}, pesho, 1');
        })

        it('left + right', function(){
            myList.addLeft(1);
            myList.addLeft('pesho');
            myList.addLeft('{}');
            myList.addRight('right');
            expect(myList.toString()).to.be.equal('{}, pesho, 1, right');
        })

        it('clear the array', function(){
            myList.addLeft(1);
            myList.addLeft('pesho');
            myList.addLeft('{}');
            myList.addRight('right');
            myList.clear();
            expect(myList.toString()).to.be.equal('');
        })
    })

})