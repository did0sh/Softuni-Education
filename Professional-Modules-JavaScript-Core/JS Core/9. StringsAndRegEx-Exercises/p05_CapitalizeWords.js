function capitalize(string) {
    string = string.toLowerCase().split(' ').map(word => word[0].toUpperCase() + word.substring(1)).join(' ');
    console.log(string);
}

capitalize('Capitalize these words');
capitalize('Was that Easy? tRY thIs onE for SiZe!');