<%--
  Created by IntelliJ IDEA.
  User: volodymyr
  Date: 18.09.15
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<script type="text/javascript">

  // init variables
  var $table = $('#customerTable');
  var $button = $('#button');

  $table.bootstrapTable(); //init table
  $button.on('click', removeCustomer); //add event

</script>

<div class="container">

  <button type="button" onclick="showAddCustomerPage()">Create new customer</button>

  <div id="toolbar">
    <button id="button" onclick="removeCustomer" class="btn btn-default">remove</button>
  </div>

  <table id="customerTable" data-toggle="table" data-toolbar="#toolbar" data-url="/customers.json" data-click-to-select="true">
    <thead>
    <tr>
      <th data-field="state" data-checkbox="true"></th>
      <th data-field="firstName">First Name</th>
      <th data-field="lastName">Last Name</th>
      <th data-field="city">City</th>
      <th data-field="street">Street</th>
      <th data-field="numbHouse">House number</th>
    </tr>
    </thead>
  </table>
</div>
