function manipulate(name, age, weight, height) {
    let ageNum = Math.round(Number(age));
    let weightNum = Math.round(Number(weight));
    let heightNum = Math.round(Number(height));

    let obj = {
        name: name,
        personalInfo: {
            age: ageNum,
            weight: weightNum,
            height: heightNum
        },
        BMI: Math.round(weightNum / (Math.pow((heightNum/100),2)))
    };
    
    if(obj.BMI < 18.5){
        obj.status = 'underweight';
    } else if(obj.BMI >= 18.5 && obj.BMI < 25){
        obj.status = 'normal';
    } else if(obj.BMI >= 25 && obj.BMI < 30){
        obj.status = 'overweight';
    } else if(obj.BMI >= 30){
        obj.status = 'obese';
        obj.recommendation = 'admission required';
    }

    return obj;
}

manipulate('Peter', 29, 75, 182);
manipulate('Honey Boo Boo', 9, 57, 137);
