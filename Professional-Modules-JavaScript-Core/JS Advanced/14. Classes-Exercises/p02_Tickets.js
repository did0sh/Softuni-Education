function main(arr, sortingParam) {
    let result = [];

    class Ticket{
        constructor(destination, price, status){
            this.destination = destination;
            this.price = price;
            this.status = status;
        }
    }
    for (let obj of arr) {
        let args = obj.split('|');
       let [destination, price, status] = [args[0], args[1], args[2]];
       price = Number(price);
        result.push(new Ticket(destination, price, status));
    }

    let sorted;
    switch (sortingParam){
        case 'destination': sorted = result.sort((a,b) => a.destination.localeCompare(b.destination));
        break;
        case 'price': sorted = result.sort((a,b) => a.price - b.price);
        break;
        case 'status': sorted = result.sort((a,b) => a.status.localeCompare(b.status));
    }

   return sorted;

}

main(['Philadelphia|94.20|available',
        'New York City|95.99|available',
        'New York City|95.99|sold',
        'Boston|126.20|departed'],
    'destination'
);