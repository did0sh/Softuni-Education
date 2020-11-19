function count(string, text) {
    let count = 0;
    let index = text.indexOf(string);

    while(true){
        if(index < 0){
            break;
        }

        count++;
        index = text.indexOf(string, index + 1);
    }

    console.log(count);
}

count('ma',
    'Marine mammal training is the training and caring for marine life such as, dolphins, killer whales, sea lions, walruses, and other marine mammals.' +
    ' It is also a duty of the trainer to do mental and physical exercises to keep the animal healthy and happy.');