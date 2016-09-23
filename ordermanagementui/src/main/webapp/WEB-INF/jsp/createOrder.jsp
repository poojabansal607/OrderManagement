<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Create Order</title>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="css/images/task-16.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<link href="<%= request.getContextPath()%>/css/jquery-ui-1.8.18.custom.css" rel="stylesheet" type="text/css" />
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">

<body>
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="">
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="index.jsp">Home</a>
                </li>
                <li class="dropdown active">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Order Management <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="createOrderAction.htm">Create Order</a></li>
                    <li><a href="blotterAction.htm">View Orders</a></li>
                    <li><a href="#">Review Orders</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Dashboard</a></li>
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

  <div class="">
  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Create Order</a></li>
    <li role="presentation"><a href="#vieworder" aria-controls="view order" role="tab" data-toggle="tab">Modify Orders</a></li>
    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Manage Orders</a></li>
    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Reports</a></li>
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
        <div class="col-md-6 bg-color">
          <form:form id="createOrder" method="post" name="createOrder" modelAttribute="equityOrder" commandName="equityOrder" class="form-horizontal margin-top-bottom-10">
            <div class="form-group">
                            <form:label path="securityTicker" class="col-sm-3 control-label">
                                <spring:message code="label.securityTicker" />
                            </form:label>
                            <div class="col-sm-8">
                                <form:input id="limitPrice" path="securityTicker" class="form-control" />
                                <form:errors path="securityTicker" cssClass="errors" />
                            </div>
                        </div>
            <div class="form-group" id="orderTable">
                <form:label path="side" class="col-sm-3 control-label">
                    <spring:message code="label.side" />
                </form:label>

                <div class="col-sm-8">
                    <label class="radio-inline">
                        <form:radiobutton id="buySide" path="side" value="Buy" />
                        <spring:message code="label.buy" />
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton id="sellSide" path="side" value="Sell" />
                        <spring:message code="label.sell" />
                    </label>
                </div>
            </div>
            <div class="form-group">
                <form:label path="orderType" class="col-sm-3 control-label">
                    <spring:message code="label.orderType" />
                </form:label>
                <div class="col-sm-8">
                    <label class="radio-inline">
                        <form:radiobutton id="market" path="orderType" value="Market" />
                        <spring:message code="label.orderType.market" />
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton id="limit" path="orderType" value="Limit" />
                        <spring:message code="label.orderType.limits" />
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton id="stop" path="orderType" value="Stop" />
                        <spring:message code="label.orderType.stop" />
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton id="stopLimit" path="orderType" value="StopLimit" />
                        <spring:message code="label.orderType.stopLimit" />
                    </label>
                </div>
            </div>
            <div class="form-group">
                <form:label path="orderQualifier" class="col-sm-3 control-label">
                    <spring:message code="label.orderQualifier" />
                </form:label>
                <div class="col-sm-8">
                    <label class="radio-inline">
                        <form:radiobutton id="dayOrderQualifier" path="orderQualifier" value="DayOrder" />
                        <spring:message code="label.orderQualifier.dayOrder" />
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton id="gtcOrderQualifier" path="orderQualifier" value="GoodTillCancelled" />
                        <spring:message code="label.orderQualifier.goodTillCancelled" />
                    </label>
                </div>
            </div>
            <div class="form-group">
                <form:label path="accountType" class="col-sm-3 control-label">
                    <spring:message code="label.accountType" />
                </form:label>
                <div class="col-sm-8">
                    <label class="radio-inline">
                        <form:radiobutton id="accountTypeCash" path="accountType" value="Cash" />
                        <spring:message code="label.accountType.cash" />
                    </label>
                    <label class="radio-inline">
                        <form:radiobutton id="accountTypeMargin" path="accountType" value="Margin" />
                        <spring:message code="label.accountType.margin" />
                    </label>
                </div>
            </div>
            <div class="form-group">
                <form:label path="quantity" class="col-sm-3 control-label">
                    <spring:message code="label.Quantity" />
                </form:label>
                <div class="col-sm-8">
                    <form:input id="quantity" path="quantity" class="form-control" />
                    <form:errors path="quantity" cssClass="errors" />
                </div>
            </div>
            <div class="form-group">
                <form:label path="stopPrice" class="col-sm-3 control-label">
                    <spring:message code="label.stopPrice" />
                </form:label>
                <div class="col-sm-8">
                    <form:input id="stopPrice" path="stopPrice" class="form-control" />
                    <form:errors path="stopPrice" cssClass="errors" />
                </div>
            </div>
            <div class="form-group">
                <form:label path="limitPrice" class="col-sm-3 control-label">
                    <spring:message code="label.limitPrice" />
                </form:label>
                <div class="col-sm-8">
                    <form:input id="limitPrice" path="limitPrice" class="form-control" />
                    <form:errors path="limitPrice" cssClass="errors" />
                </div>
            </div>

            <div class="form-group">
                <form:label path="notes" class="col-sm-3 control-label">
                    <spring:message code="label.notes" />
                </form:label>
                <div class="col-sm-8">
                    <form:textarea id="notes" path="notes" rows="2" cols="40" class="form-control" />
                    <form:errors path="notes" cssClass="errors" />
                </div>
            </div>
            <div class="centerize margin-top-bottom-10">
                <input id="Save" type="submit" value="Save" class="btn btn-primary" />
                <input id="Cancel" type="reset" value="Cancel" class="btn btn-primary" />
            </div>
          </form:form>
        </div>
        <div class="col-md-4">
            <!-- TradingView Widget BEGIN -->
            <div id="tv-miniwidget-b9a98"></div>
            <script type="text/javascript" src="https://d33t3vvu2t2yu5.cloudfront.net/tv.js"></script>
            <script type="text/javascript">
            new TradingView.MiniWidget({
              "container_id": "tv-miniwidget-b9a98",
              "tabs": [
                "Equities",
                "Commodities",
                "Bonds",
                "Forex"
              ],
              "symbols": {
                "Equities": [
                  [
                    "S&P500",
                    "SPX500"
                  ],
                  [
                    "NQ100",
                    "NAS100"
                  ],
                  [
                    "Dow30",
                    "DOWI"
                  ],
                  [
                    "Nikkei225",
                    "JPN225"
                  ],
                  [
                    "Apple",
                    "AAPL "
                  ],
                  [
                    "Google",
                    "GOOG"
                  ]
                ],
                "Commodities": [
                  [
                    "Emini",
                    "ES1!"
                  ],
                  [
                    "Euro",
                    "E61!"
                  ],
                  [
                    "Gold",
                    "GC1!"
                  ],
                  [
                    "Oil",
                    "CL1!"
                  ],
                  [
                    "Gas",
                    "NG1!"
                  ],
                  [
                    "Corn",
                    "ZC1!"
                  ]
                ],
                "Bonds": [
                  [
                    "Eurodollar",
                    "CME:GE1!"
                  ],
                  [
                    "T-Bond",
                    "CBOT:ZB1!"
                  ],
                  [
                    "Ultra T-Bond",
                    "CBOT:UD1!"
                  ],
                  [
                    "Euro Bund",
                    "FX:BUND"
                  ],
                  [
                    "Euro BTP",
                    "EUREX:II1!"
                  ],
                  [
                    "Euro BOBL",
                    "EUREX:HR1!"
                  ]
                ],
                "Forex": [
                  "FX:EURUSD",
                  "FX:GBPUSD",
                  "FX:USDJPY",
                  "FX:USDCHF",
                  "FX:AUDUSD",
                  "FX:USDCAD"
                ]
              },
              "gridLineColor": "#E9E9EA",
              "fontColor": "#83888D",
              "underLineColor": "#dbeffb",
              "trendLineColor": "#4bafe9",
              "activeTickerBackgroundColor": "#EDF0F3",
              "large_chart_url": "https://www.tradingview.com/chart/",
              "noGraph": false,
              "width": 420,
              "height": 510,
              "locale": "en"
            });
            </script>
            <!-- TradingView Widget END -->
        </div>
      </div>
    </div>
    <div role="tabpanel" class="tab-pane" id="view">
    </div>
    <div role="tabpanel" class="tab-pane" id="messages"></div>
    <div role="tabpanel" class="tab-pane" id="settings"></div>
  </div>
</div>
  <script src="js/jquery.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
</body>

</html>
