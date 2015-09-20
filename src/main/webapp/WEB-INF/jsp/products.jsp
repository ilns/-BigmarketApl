


<div class="container">

    <button type="button"  data-path="add-product" class="e_btn">Create new product</button>

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

<script type="text/javascript">

    // init variables
    var $table = $('#productsTable');
    var $button = $('#button');

    $table.bootstrapTable(); //init table
    $button.on('click', removeProduct); //add event

    $('.e_btn').click(function(e){
        console.log('click')
        var path = $(e.target).data('path') || '/';
        $.get(path, function (html) {
            $('#page-content-wrapper').html(html);
        });
        return false;
    });

</script>




