function display(arr) {
    let songName = arr[0];
    let artistName = arr[1];
    let duration = arr[2];

    console.log(`Now Playing: ${artistName} - ${songName} [${duration}]`);
}

display(['Number One', 'Nelly', '4:09']);