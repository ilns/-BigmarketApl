<script>
  $('#productsTable').bootstrapTable();

</script>


<form id="addNewProduct">

  <div class="form-group">
    <label for="productName">Product name</label>
    <input type="text" class="form-control" name="productName" id="productName" placeholder="Product name">
  </div>

  <div class="form-group">
    <label for="price">Price</label>
    <input type="text" class="form-control" name="price" id="price" placeholder="Price">
  </div>

  <button type="button" onclick="submitProduct()" class="btn btn-default">Submit</button>

</form>