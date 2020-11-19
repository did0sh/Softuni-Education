class PaymentManager {
    constructor(title) {
        this.title = title;
    }

    render(id) {
       let table = $('<table>');
       let caption = $(`<caption>${this.title} Payment Manager</caption>`);
       let head = $('<thead>');
       let tableRow = $('<tr>');
       let thName = $('<th class="name">Name</th>');
        let thCategory = $('<th class="category">Category</th>');
        let thPrice = $('<th class="price">Price</th>');
        let tbody = $('<tbody class="payments"></tbody>');

        let tfoot = $('<tfoot class="input-data">');
        let td = $('<td>');
        let inputName = $('<input name="name" type="text">');
        let inputCategory = $('<input name="category" type="text">');
        let inputPrice = $('<input name="price" type="number">');

        let buttonAdd = $('<button>Add</button>').on('click', function () {
            let name;
            let categ;
            let price;
            for (let i = 0; i < $('input').length; i+=3) {
                name = $('input')[i];
                categ = $('input')[i+1];
                price = $('input')[i+2];

                if(name.value !== '' && categ.value !== '' && price.value !== '' ){
                    tbody.append($('<tr>').append($(`<td>${name.value}</td>`)).append($(`<td>${categ.value}</td>`))
                        .append($(`<td>${Number(price.value)}</td>`)).append($(`<button>Delete</button>`).on('click',function () {
                            $(this).parent().remove();
                        })));

                }
                name.value = '';
                categ.value = '';
                price.value = '';
            }
        });


        let final = table.append(caption).append($('<thead>').append($('<tr>').append(thName).append(thCategory).append(thPrice).append($('<th>Actions</th>'))))
            .append(tbody).append((tfoot).append((tableRow).append($('<td>').append(inputName)).append($('<td>').append(inputCategory))
            .append($('<td>').append(inputPrice)).append($('<td>').append(buttonAdd))));


        $('#' + id).append(final);

    }
}