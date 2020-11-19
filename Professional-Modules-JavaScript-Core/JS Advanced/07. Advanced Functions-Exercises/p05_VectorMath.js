(() => {
    let add = (vec1, vec2) => [vec1[0] + vec2[0], vec1[1] + vec2[1]];
    let multiply = (vec1, scalar) => [vec1[0] * scalar, vec1[1]*scalar];
    let length = (vec1) => Math.sqrt(vec1[0] * vec1[0] + vec1[1] * vec1[1]);
    let dot = (vec1, vec2) => vec1[0] * vec2[0] + vec1[1] * vec2[1];
    let cross = (vec1,vec2) => vec1[0] * vec2[1] - vec2[0] * vec1[1];

    let obj = {add, multiply, length, dot, cross};
    return obj;
})()
