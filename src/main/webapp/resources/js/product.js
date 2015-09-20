function removeProduct() {
    var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id;
    });


    var customerIds = {'name':'productIds', 'value': ids.toString()};

    $.ajax({
        url: '/delete-product',
        type: 'post',
        data: [customerIds],
        success: function (responce) {
            $table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
        },
        error: function (e) {
            console.error('Cannot delete product', e);
        }
    });
}

function submitProduct() {
    console.log('form submited');
    $.ajax({
        url: '/add-product',
        type: 'post',
        data: $("#addNewProduct").serializeArray(),
        success: function () {
            showProductPage();
        },
        error: function (e) {
            console.error('Whoa, error', e);
        }
    });
}
