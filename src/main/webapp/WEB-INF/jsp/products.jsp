<script type="text/javascript">

    // init variables
    var $table = $('#productsTable');
    var $button = $('#button');

    $table.bootstrapTable(); //init table
    $button.on('click', removeProduct); //add event

</script>



<div class="container">

    <button type="button" onclick="showAddProductPage()">Create new product</button>

    <div id="toolbar">
        <button id="button" onclick="removeProduct" class="btn btn-default">remove</button>
    </div>

    <table id="productsTable" data-toggle="table" data-toolbar="#toolbar" data-url="/products.json" data-click-to-select="true">
        <thead>
        <tr>
            <th data-field="state" data-checkbox="true"></th>
            <th data-field="productName">Product name</th>
            <th data-field="price">Price</th>
        </tr>
        </thead>
    </table>
</div>



