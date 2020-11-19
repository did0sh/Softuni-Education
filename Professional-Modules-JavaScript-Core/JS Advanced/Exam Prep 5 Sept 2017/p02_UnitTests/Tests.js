let expect = require('chai').expect;
let StringBuilder = require('../p02_StringBuilder').StringBuilder;

describe('Testing the class', function () {
    let stringBuilder;
    beforeEach(function () {
        stringBuilder = new StringBuilder('test');
    })
    describe('Testing the properties',function () {
        it('should have constructor property', function () {
            expect(StringBuilder.prototype.hasOwnProperty('constructor')).to.be.true;
        });
        it('should have append property', function () {
            expect(StringBuilder.prototype.hasOwnProperty('append')).to.be.true;
        });
        it('should have prepend property', function () {
            expect(StringBuilder.prototype.hasOwnProperty('prepend')).to.be.true;
        });
        it('should have insertat property', function () {
            expect(StringBuilder.prototype.hasOwnProperty('insertAt')).to.be.true;
        });
        it('should have remove property', function () {
            expect(StringBuilder.prototype.hasOwnProperty('remove')).to.be.true;
        });
        it('should have tostring property', function () {
            expect(StringBuilder.prototype.hasOwnProperty('toString')).to.be.true;
        });
    });

    describe('Testing in general with values', function () {
        it('no string throw Error', function () {
            expect(() => new StringBuilder(123)).to.throw(TypeError);
        });

        it('not string throw Error', function () {
            expect(() => new StringBuilder({})).to.throw(TypeError);
        });

        it('same value', function () {
            expect(stringBuilder.toString()).to.equal('test');
        });

        it('should return space', function () {
            expect(new StringBuilder()._stringArray.length).to.be.equal(0);
            expect(new StringBuilder().toString()).to.equal('');
        });


        it('append', function () {
            stringBuilder.append(' class');
            expect(stringBuilder._stringArray.length).to.be.equal(10);
            expect(stringBuilder.toString()).to.equal('test class');
        });

        it('append with obj', function () {
            stringBuilder.append(' {}');
            stringBuilder.append(' 123');
            expect(stringBuilder._stringArray.length).to.be.equal(11);
            expect(stringBuilder.toString()).to.equal('test {} 123');
        });

        it('append error', function () {
            stringBuilder.append(' {}');
            expect(() => stringBuilder.append(123)).to.throw(TypeError)
        });

        it('prepend error', function () {
            stringBuilder.prepend('function ');
            expect(() => stringBuilder.prepend({})).to.throw(TypeError);
        });

        it('valid prepend', function () {
            stringBuilder.prepend('function ');
            expect(stringBuilder._stringArray.length).to.be.equal(13);
            expect(stringBuilder.toString()).to.equal('function test');
        });

        it('valid insertat', function () {
            stringBuilder.insertAt('abc', 0);
            expect(stringBuilder._stringArray.length).to.be.equal(7);
            expect(stringBuilder.toString()).to.equal('abctest');
        });

        it('insertat error', function () {
            expect(() => stringBuilder.insertAt([], 2)).to.throw(TypeError)
        });

        it('should remove 3 things', function () {
            stringBuilder.remove(0, 3);
            expect(stringBuilder._stringArray.length).to.be.equal(1);
            expect(stringBuilder.toString()).to.equal('t');
        });

        it('should remove nothing', function () {
            stringBuilder.remove(0, 0);
            expect(stringBuilder._stringArray.length).to.be.equal(4);
            expect(stringBuilder.toString()).to.equal('test');
        });
    })
});

