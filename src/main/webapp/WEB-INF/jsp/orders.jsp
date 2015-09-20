
<script type="text/javascript">

  // init variables
  var $table = $('#orderTable');
  var $button = $('#button');

  $table.bootstrapTable(); //init table
  $button.on('click', removeOrder); //add event


  function customerFormatter(value, row) {
    return row.customer.firstName + " " + row.customer.lastName;
  }

  function productFormatter(value, row) {
    var allProducts = "";
    for(var i=0;i<row.products.length;i++){
      if (i>0) allProducts += ", ";
      var product = row.products[i];
      allProducts += product.productName;
    }
    return allProducts;
  }
  $('.e_btn').click(function(e){
    var path = $(e.target).data('path') || '/';
    $.get(path, function (html) {
      $('#page-content-wrapper').html(html);
    });
    return false;
  });

</script>

<div class="container">

  <button type="button"  data-path="add-order" class="e_btn">Create new order</button>

  <div id="toolbar">
    <button id="button" onclick="removeOrder" class="btn btn-default">remove</button>
  </div>

  <table id="orderTable" data-toggle="table" data-toolbar="#toolbar" data-url="/orders.json" data-click-to-select="true">
    <thead>
    <tr>
      <th data-field="state" data-checkbox="true"></th>
      <th data-field="fullName" data-formatter="customerFormatter">Full name</th>
      <th data-field="product_name" data-formatter="productFormatter">Product name</th>
    </tr>
    </thead>
  </table>
</div>