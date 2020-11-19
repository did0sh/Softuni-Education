function calcVolumeAndArea(radius, height) {
    let volume = (Math.PI * Math.pow(radius,2) * height) / 3;
    let area = Math.PI * radius * (radius + (Math.sqrt(Math.pow(radius,2) + Math.pow(height,2))));
    console.log(`volume = ${volume}`);
    console.log(`area = ${area}`);
}

calcVolumeAndArea(3.3, 7.8);