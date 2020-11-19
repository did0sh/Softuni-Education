function sortedList() {
    let obj = (() => {
        let size = 0;
        let arr = [];
        let sorting = (a,b) => a-b;
        function add(element) {
            arr.push(element);
            arr.sort(sorting);
            this.size++;
            return arr;
        }
        function remove (index) {
            if(index >=0 && index< arr.length) {
                arr.splice(index, 1);
                arr.sort(sorting);
                this.size--;
                return arr;
            }
        }
        function get (index) {
            if(index >= 0 && index< arr.length){
                return arr[index];
            }
        }
        return {add, remove, get, size}
    })();

    return obj;
}