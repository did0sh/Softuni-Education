function validate(email) {
    let regex = /^[A-Za-z0-9]+@[a-z]+\.[a-z]+$/;
    let result = regex.test(email);

    if(result){
        console.log('Valid');
    } else {
        console.log('Invalid');
    }
}

validate('invalid@emai1.bg');