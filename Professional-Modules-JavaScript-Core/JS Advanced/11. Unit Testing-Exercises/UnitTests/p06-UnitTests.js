let expect = require('chai').expect;
let jsdom = require('jsdom-global')();
let $ = require('jquery');
let nuke = require('../p06_ArmageDOM').nuke;

describe('ArmageDom', function(){
    beforeEach(() =>
        document.body.innerHTML = `<div id="target">
    <div class="nested target">
        <p>This is some text</p>
    </div>
    <div class="target">
        <p>Empty div</p>
    </div>
    <div class="inside">
        <span class="nested">Some more text</span>
        <span class="target">Some more text</span>
    </div>
</div>`)

    before(() => global.$ = $);

    it('should remain the same with two equal selectors', function(){
        let beforeNuke = $('body').html();
        nuke('#target', '#target');
        let afterNuke = $('body').html();
        expect(beforeNuke).to.equal(afterNuke);
    })

    it('should remain the same with one omitted selector', function(){
        let beforeNuke = $('body').html();
        nuke('#target');
        let afterNuke = $('body').html();
        expect(beforeNuke).to.equal(afterNuke);
    })

    it('should remain the same with one invalid selector', function(){
        let beforeNuke = $('body').html();
        nuke('','#target');
        let afterNuke = $('body').html();
        expect(beforeNuke).to.equal(afterNuke);
    })

    it('should remove span class nested', function(){
        nuke('.nested','span');
        expect($('span.nested').length).to.equal(0);
    })

    it('should remove one div class target and one paragraph', function(){
        nuke('.target','div');
        expect($('div.target').length).to.equal(0);
        expect($('div.target p').length).to.equal(0);
    })


    it('should delete all nodes that match .target and .nested',function () {
        nuke('.target','.nested');
        expect($('.target').filter('.nested').length).to.be.equal(0);
    });

    it('should delete all nodes that match div and p',function () {
        nuke('div','p');
        expect($('p').filter('div').length).to.be.equal(0);
    });
})