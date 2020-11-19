function manipulate(matrix) {
    let result = [];
    for (let arr of matrix) {
        let width = Number(arr[0]);
        let height = Number(arr[1]);
            let obj = {
                width: width,
                height: height,
                area: function () {
                    return this.width * this.height
                },
                compareTo: function (other) {
                    let areaOrder = other.width * other.height - this.area();
                    return areaOrder || other.width - this.width;
                }
            };

            result.push(obj);
    }
    result.sort((a,b) => a.compareTo(b));
    return result;
}

manipulate([[10,5], [3,20], [5,12]]);