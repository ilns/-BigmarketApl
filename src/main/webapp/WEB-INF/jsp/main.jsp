<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="Volodymyr">

  <title>Best Market application</title>

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link href="/resources/css/sidebar.css" rel="stylesheet">
  <link href="/resources/css/app.css" rel="stylesheet">

  <script type="text/javascript" src="https://code.jquery.com/jquery-git2.js"></script>
  <script type="text/javascript" src="/resources/js/app.js"></script>
  <script type="text/javascript" src="/resources/js/customer.js"></script>
  <script type="text/javascript" src="/resources/js/product.js"></script>
  <script type="text/javascript" src="/resources/js/order.js"></script>

  <%--for combo box--%>
  <link rel="stylesheet" href="/resources/js/jqwidgets/styles/jqx.base.css" type="text/css" />
  <script type="text/javascript" src="/resources/js/jquery-1.11.1.min.js"></script>
  <script type="text/javascript" src="/resources/js/jqwidgets/jqxcore.js"></script>
  <script type="text/javascript" src="/resources/js/jqwidgets/jqxdata.js"></script>
  <script type="text/javascript" src="/resources/js/jqwidgets/jqxscrollbar.js"></script>
  <script type="text/javascript" src="/resources/js/jqwidgets/jqxbuttons.js"></script>
  <script type="text/javascript" src="/resources/js/jqwidgets/jqxlistbox.js"></script>
  <script type="text/javascript" src="/resources/js/jqwidgets/jqxcombobox.js"></script>

  <!-- table plugin -->
  <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.8.1/bootstrap-table.min.css">

  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.8.1/bootstrap-table.min.js"></script>
  <script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.8.1/locale/bootstrap-table-zh-CN.min.js"></script>
</head>
<body>

<div id="wrapper">

  <!-- Sidebar -->
  <div id="sidebar-wrapper">
    <ul class="sidebar-nav">
      <li class="sidebar-brand">
        <a data-path="/" class="e_nav" >Best Market application</a>
      </li>
      <li>
        <a  data-path="customers" class="e_nav" >Customers</a>
      </li>

      <li>
        <a  data-path="products" class="e_nav" >Products</a>
      </li>

      <li>
        <a data-path="orders" class="e_nav" >Order</a>
      </li>

    </ul>
  </div>
  <!-- /#sidebar-wrapper -->

  <!-- Page Content -->
  <div id="page-content-wrapper">

    <div class="container-fluid">
      <div class="row">
        <div class="col-lg-12">
          <h1>Best Market application</h1>
          <p>You can create customers, products and make orders</p>
        </div>
      </div>
    </div>

  </div>

</div>

</body>
</html>
