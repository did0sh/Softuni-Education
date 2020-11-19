let expect = require('chai').expect;
let PaymentPackage = require('../p02_PaymentPackage').PaymentPackage;

describe("TODO …", function () {
    let builder;
    beforeEach(function () {
        builder = new PaymentPackage('dsa', 1)
    });
    it("It should have initialized all methods …", function () {
        expect(Object.getPrototypeOf(builder).hasOwnProperty('name')).to.be.equal(true);
        expect(Object.getPrototypeOf(builder).hasOwnProperty('value')).to.be.equal(true);
        expect(Object.getPrototypeOf(builder).hasOwnProperty('VAT')).to.be.equal(true);
        expect(Object.getPrototypeOf(builder).hasOwnProperty('active')).to.be.equal(true);
        expect(Object.getPrototypeOf(builder).hasOwnProperty('toString')).to.be.equal(true);
    });
    it("no string throw error", function () {
        expect(() => {
            builder.name = ''
        }).to.throw();
    });

    it("no string throw error", function () {
        expect(() => {
            builder.name = {}
        }).to.throw();
    });

    it("no string throw error", function () {
        expect(() => {
            builder.name = 123
        }).to.throw();
    });
    it("- value throw error", function () {
        expect(() => {
            builder.value = -1
        }).to.throw();
    });

    it("- value throw error", function () {
        expect(() => {
            builder.value = Infinity
        }).to.not.throw();
    });

    it("- value throw error", function () {
        expect(() => {
            builder.value = Number(false)
        }).to.not.throw();
    });

    it("- value throw error", function () {
        expect(() => {
            builder.VAT = -Infinity
        }).to.throw();
    });
    it("- value throw error", function () {
        expect(() => {
            builder.VAT = -1
        }).to.throw();
    });
    it("- value throw error", function () {
        expect(() => {
            builder.VAT = 0
        }).to.not.throw();
    });

    it("- value throw error", function () {
        expect(() => {
            builder.value = 0
        }).to.not.throw();
    });
    it("- value throw error", function () {
        expect(() => {
            builder.active = ''
        }).to.throw();
        expect(() => {
            builder.active = {}
        }).to.throw();
        expect(() => {
            builder.active = []
        }).to.throw();
        expect(() => {
            builder.active = 21
        }).to.throw();

        expect(() => {
            builder.active = 1
        }).to.throw();
    });
    it("It should throw Error", function () {
        expect(() => {
            builder = new PaymentPackage('HR Services')
        }).to.throw;
    });
    it("It should throw Error", function () {
        expect(() => {
            builder = new PaymentPackage()
        }).to.throw;
    });
    it("It should throw Error", function () {
        expect(() => {
            builder = new PaymentPackage(100)
        }).to.throw;
    });
    it("It should throw Error", function () {
        const packages = [
            new PaymentPackage('HR Services', 1500),
            new PaymentPackage('Consultation', 800),
            new PaymentPackage('Partnership Fee', 7000),
        ];
        expect(packages.join('\n')).to.be.equal('Package: HR Services\n- Value (excl. VAT): 1500\n- Value (VAT 20%): 1800\nPackage: Consultation\n- Value (excl. VAT): 800\n- Value (VAT 20%): 960\nPackage: Partnership Fee\n- Value (excl. VAT): 7000\n- Value (VAT 20%): 8400')
    });
    it("It should throw Errordsadsadsa", function () {
        const wrongPack = new PaymentPackage('Transfer Fee', 100);
        expect(() => {
            wrongPack.active = null
        }).to.throw();
    });
    it("It should throw Errordsadsadsa", function () {
        const wrongPack = new PaymentPackage('Transfer Fee', 100);
        wrongPack.active = false;
        expect(wrongPack.toString()).to.be.equal('Package: Transfer Fee (inactive)\n- Value (excl. VAT): 100\n- Value (VAT 20%): 120');
    });
    it("It should throw Errordsadsadsa", function () {
        const wrongPack = new PaymentPackage('Transfer Fee', 100);
        wrongPack.active = true;
        expect(wrongPack.toString()).to.be.equal('Package: Transfer Fee\n- Value (excl. VAT): 100\n- Value (VAT 20%): 120');
    });


});