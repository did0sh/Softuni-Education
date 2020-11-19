function deckOfCards(cards) {
    function main(face, suit) {
        let validFaces = ['2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A'];
        let validSuits = {'S': '\u2660', 'H': '\u2665', 'D': '\u2666', 'C': '\u2663'};

        if(!validFaces.includes(face)){
            throw new Error('Invalid card face: ' + face)
        }
        if(!Object.keys(validSuits).includes(suit)){
            throw new Error('Invalid card suit: ' + suit)
        }
        let card = {
            face: face, suit: suit, toString: () => {
                return face + validSuits[suit];
            }
        };
        return card
    }

    let deck = [];
    for (let card of cards) {
        let face = card.substring(0, card.length - 1);
        let suit = card.substr(card.length - 1, 1);
        try {
            deck.push(main(face, suit));
        }catch (ex) {
            console.log('Invalid card: ' + card);
            return;
        }
    }

    console.log(deck.join(' '));
}

deckOfCards(['AS', '10D', 'KH', '2C']);
deckOfCards(['5S', '3D', 'QD', '1C']);