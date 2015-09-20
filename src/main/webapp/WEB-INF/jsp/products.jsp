<%--<html lang="en">--%>
<%--&lt;%&ndash;<head>&ndash;%&gt;--%>
<%--&lt;%&ndash;</head>&ndash;%&gt;--%>
<%--&lt;%&ndash;<body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</body>&ndash;%&gt;--%>
<%--&lt;%&ndash;</html>&ndash;%&gt;--%>
    <%--<meta charset="utf-8">--%>

    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"/>--%>
    <%--<script type="text/javascript" src="https://code.jquery.com/jquery-git2.js"></script>--%>

    <%--<script type="text/javascript" src="/resources/js/app.js"></script>--%>

    <%--<!-- table plugin -->--%>
    <%--<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.8.1/bootstrap-table.min.css">--%>
    <%--<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.8.1/bootstrap-table.min.js"></script>--%>
    <%--<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.8.1/locale/bootstrap-table-zh-CN.min.js"></script>--%>


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
            <%--<th data-field="quantity">Quantity</th>--%>
        </tr>
        </thead>
    </table>
</div>



