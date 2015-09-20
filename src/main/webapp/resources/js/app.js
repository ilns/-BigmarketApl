var pageContent;
$(document).ready(function(){

    pageContent = $('#page-content-wrapper');

});

// customer
function showCustomerPage() {
    $.get('customers', function (data) {
        loadHTML(data);
    });
}

function showAddCustomerPage() {
    $.get('add-customer', function (data) {
        loadHTML(data);
    });
}
//product
function showProductPage() {
    $.get('products', function (data) {
        loadHTML(data);
    });

}


function showAddProductPage() {
    $.get('add-product', function (data) {
        loadHTML(data);
    });
}

//order
function showOrderPage() {
    $.get('orders', function (data) {
        loadHTML(data);
    });
}

function showAddOrderPage() {
    $.get('add-order', function (data) {
        loadHTML(data);
    });
}

function loadHTML(html) {
    pageContent.html(html);
}

