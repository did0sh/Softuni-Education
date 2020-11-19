function createTag(arr) {
    let fileLocation = arr[0];
    let text = arr[1];

    console.log(`<img src="${fileLocation}" alt="${text}">`);
}
createTag(['smiley.gif', 'Smiley Face']);