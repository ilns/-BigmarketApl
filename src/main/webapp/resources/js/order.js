function removeOrder() {
    var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id;
    });


    var orderIds = {'name':'orderIds', 'value': ids.toString()};

    $.ajax({
        url: '/delete-order',
        type: 'post',
        data: [orderIds],
        success: function (responce) {
            $table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
        },
        error: function (e) {
            console.error('Cannot delete order', e);
        }
    });
}


function submitOrder() {

    var productIds = $.map($('#productsTable').bootstrapTable('getSelections'), function (row) {
        return row.id;
    });

    var data = [
        {'name':'customerId', 'value': $("#customer-selector").val()},
        {'name':'productIds', 'value': productIds.toString()}
    ];

    $.ajax({
        url: '/add-order',
        type: 'POST',
        data: data,
        success: function () {
            showOrderPage();
        },
        error: function (e) {
            console.error('Whoa, error', e);
        }
    });
}