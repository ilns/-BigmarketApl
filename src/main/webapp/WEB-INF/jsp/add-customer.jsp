<script>
  $('#customerTable').bootstrapTable();

</script>


<form id="addNewCustomer">

  <div class="form-group">
    <label for="firstName">First name</label>
    <input type="text" class="form-control" name="firstName" id="firstName" placeholder="First name">
  </div>

  <div class="form-group">
    <label for="lastName">Last Name</label>
    <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Last name">
  </div>

  <div class="form-group">
    <label for="city">City</label>
    <input type="text" class="form-control" name="city" id="city" placeholder="City">
  </div>

  <div class="form-group">
    <label for="street">Street</label>
    <input type="text" class="form-control" name="street" id="street" placeholder="Street">
  </div>

  <div class="form-group">
    <label for="numberHouse">House number</label>
    <input type="text" class="form-control" name="numberHouse" id="numberHouse" placeholder="House number">
  </div>

  <button type="button" onclick="submitCustomer()" class="btn btn-default">Submit</button>

</form>
<%--</body>--%>
<%--</html>--%>
