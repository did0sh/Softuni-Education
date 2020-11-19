function uppercase(string) {
    let words = string
        .split(new RegExp('\\W+'))
        .filter(x => x.length > 0)
        .map(x => x.toUpperCase())
        .join(', ');

    console.log(words);
}
uppercase('Helllo, how are you doing? I am doing fine!');