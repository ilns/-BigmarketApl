function removeCustomer() {
    var ids = $.map($table.bootstrapTable('getSelections'), function (row) {
        return row.id;
    });


    var customerIds = {'name':'customerIds', 'value': ids.toString()};

    $.ajax({
        url: '/delete-customer',
        type: 'post',
        data: [customerIds],
        success: function (responce) {
            $table.bootstrapTable('remove', {
                field: 'id',
                values: ids
            });
        },
        error: function (e) {
            console.error('Cannot delete customer', e);
        }
    });
}

function submitCustomer() {
    console.log('form submited');
    $.ajax({
        url: '/add-customer',
        type: 'post',
        data: $("#addNewCustomer").serializeArray(),
        success: function () {
            $.get('customers', function (data) {
                pageContent.html(data);
            });
        },
        error: function (e) {
            console.error('Whoa, error', e);
        }
    });
}
