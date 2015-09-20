
<script type="text/javascript">

  var source =
  {
    datatype: "json",
    datafields: [
      {name: 'id'},
      {name: 'firstName'},
      {name: 'lastName'},
    ],
    url: "/customers.json",
    data: {
      featureClass: "P",
      style: "full",
      maxRows: 50,
      username: "jqwidgets"
    },
    async:false,
  };

  var dataAdapter = new $.jqx.dataAdapter(source);

  $(document).ready(function () {
    $('#productsTable').bootstrapTable();
    $("#customer-selector").jqxComboBox(
            {
              width: 300,
              height: 25,
              source: dataAdapter,
              selectedIndex: 0,
              displayMember: "id",
              renderer: function (index, label, value) {
                var datarecord = dataAdapter.records[index];
                return datarecord.firstName + " " + datarecord.lastName;
              },
              renderSelectedItem: function(index, item)
              {
                var item = dataAdapter.records[index];
                if (item != null) {
                  var label = item.firstName + " " + item.lastName;
                  return label;
                }
                return "";
              }
            }
    );

    $("#customer-selector").on('select', function (event) {
      if (event.args) {
        var item = event.args.item;
        if (item) {
          console.log(item.originalItem.id)
        }
      }
    });

  });
</script>

<div id='jqxWidget' style="font-size: 13px; font-family: Verdana; float: left;">
  <div id="customer-selector">

  </div>
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

<button type="button" onclick="submitOrder()" class="btn btn-default">Submit</button>


