<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="utf-8">
  <link rel="icon" type="image/png" href="css/images/task-16.png">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>View All Orders</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/custom.css" rel="stylesheet">
    <link href="css/dashboard.css" rel="stylesheet">
    <link href="css/bootstrap-sortable.css" rel="stylesheet">

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      google.charts.setOnLoadCallback(drawChart2);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Asset', 'Percentage'],
          ['Equity',     11],
          ['Derivatives',      2],
          ['Mutual Funds',  2],
          ['ETF', 2],
          ['Bonds',    7]
        ]);

        var options = {
          title: 'Asset Allocation',
          is3D: true,
        };

        var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
        chart.draw(data, options);
      }

      function drawChart2() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Projected', 'Earnings'],
          ['2012',  1000,      800],
          ['2013',  1170,      600],
          ['20014',  660,       460],
          ['2015',  1030,      700]
        ]);

        var options = {
          title: 'Performance',
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));

        chart.draw(data, options);
      }
    </script>

</head>
<body>
<%--  Navigation Start--%>
  <nav class="navbar navbar-default navbar-fixed-top">
      <div class="">
          <div id="navbar" class="collapse navbar-collapse">
              <ul class="nav navbar-nav">
                  <li><a href="index.jsp">Home</a>
                  </li>
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Order Management <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                      <li><a href="createOrderAction.htm">Create Order</a></li>
                      <li><a href="blotterAction.htm">View Orders</a></li>
                      <li><a href="#">Review Orders</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="#">Billboard</a></li>
                      <li role="separator" class="divider"></li>
                      <li><a href="#">Reports</a></li>
                    </ul>
                  </li>
                  <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Product & Services <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="createOrderAction.htm">Equity</a></li>
                    <li><a href="blotterAction.htm">Derivatives</a></li>
                    <li><a href="#">Currency</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Mutual Fund</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Insurance</a></li>
                  </ul>
                </li>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Markets <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="createOrderAction.htm">Overview</a></li>
                    <li><a href="blotterAction.htm">News</a></li>
                    <li><a href="#">Indices</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">World Indices</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Market Stats</a></li>
                  </ul>
                </li>
              </ul>
              <ul class="nav navbar-nav pull-right">
                <li class="pull-right"><a href="#"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></a>
                </li>
            </ul>
          </div>
          <!--/.nav-collapse -->
      </div>
  </nav>
  <%--  Navigation End--%>
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">View Order</a></li>
    <li role="presentation"><a href="#vieworder" aria-controls="view order" role="tab" data-toggle="tab">Modify Orders</a></li>
    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Manage Orders</a></li>
    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Reports</a></li>
    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Dashboard</a></li>
  </ul>
  <!-- Tab panes -->
<div class="tab-content">
    <div role="tabpanel" class="tab-pane active" id="home">
      <div class="margin-top-bottom-10">
        <div class="col-md-2">
          <ul class="list-group">
            <li class="list-group-item active"><a href="#">Equity</li>
            <li class="list-group-item"><a href="#">Derivates</a></li>
            <li class="list-group-item"><a href="#">Currency</a></li>
            <li class="list-group-item"><a href="#">Mutual Funds</a></li>
            <li class="list-group-item"><a href="#">ETF</a></li>
            <li class="list-group-item"><a href="#">Life Insurance</a></li></li>
            <li class="list-group-item"><a href="#">General Insurance</a></li></li>
            <li class="list-group-item"><a href="#">Bonds</a></ li>
            <li class="list-group-item"><a href="#">Fixed Deposit</a></li>
            <li class="list-group-item"><a href="#">Loans</a></li>
            <li class="list-group-item"><a href="#">Tax</a></li>
            <li class="list-group-item"><a href="#">NPS</a></li>            
          </ul>
        </div>
        <div class="col-md-7 bg-color">
         <form:form action="/blotterAction">
  <!-- <h2 class="sub-header">View All Orders</h2> -->
         <div class="table-responsive margin-top-bottom-10 dashboard-table-custom">
            <table class="table table-striped table-hover table-condensed table-bordered sortable">
              <thead>
              <tr>
                <th id="orderId">OrderId</th>
                 <th id="securityTicker">SecurityTicker</th>
                <th id="status">Status</th>
                <th id="quantity">Quantity</th>
                <th id="orderType">OrderType</th>
                <th id="qualifier">OrderQualifier</th>
                <th id="accountType">AccountType</th>
                <th id="stopPrice">StopPrice</th>
                <th id="limitPrice">LimitPrice</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="order" items="${orders}">
                      <tr>
                          <td>${order.orderId}</td>
                          <td>${order.securityTicker}</td>
                          <td>${order.orderStatus}</td>
                          <td>${order.quantity}</td>
                          <td>${order.orderType}</td>
                          <td>${order.orderQualifier}</td>
                          <td>${order.accountType}</td>
                          <td>${order.stopPrice}</td>
                          <td>${order.limitPrice}</td>
                      </tr>
                  </c:forEach>
            </tbody>
            </table>
          </div>    
        </form:form>
        </div>
        <div class="col-md-3">
          <div id="piechart_3d" style="width: 320px; height: 250px;"></div>
          <div id="curve_chart" style="width: 320px; height: 250px"></div>
        </div>
      </div>
    </div>
    <div role="tabpanel" class="tab-pane" id="view">
    </div>
    <div role="tabpanel" class="tab-pane" id="messages"></div>
    <div role="tabpanel" class="tab-pane" id="settings"></div>
  </div>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap-sortable.js"></script>
</body>
</html>
