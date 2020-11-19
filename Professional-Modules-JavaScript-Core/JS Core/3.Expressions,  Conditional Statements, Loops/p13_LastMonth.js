function calcLastDay(arr) {
    let day = Number(arr[0]);
    let month = Number(arr[1]);
    let year = Number(arr[2]);

    let date = new Date(year, month-1, 0);
    let days = date.getDate();

    console.log(days);
}
calcLastDay([17, 3, 2002]);
