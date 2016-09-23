<nav class="navbar navbar-default navbar-fixed-top">
    <div class="">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- <a class="navbar-brand" href="#">TDD Order Management</a> -->
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a>
                </li>
                <%-- <li><a href="createOrderAction.htm">Create New Order</a>
                </li>
                <li><a href="blotterAction.htm">View All Orders</a>
                </li> --%>
                <li class="dropdown">
                  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Order Management <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="createOrderAction.htm">Create Order</a></li>
                    <li><a href="blotterAction.htm">View Orders</a></li>
                    <li role="separator" class="divider"></li>
                    <li><a href="#">Review Orders</a></li>                    
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
                <li>
                    <a href="http://del2wssgt01.sapient.com:8085/allPlans.action" target="_blank">Bamboo</a>
                </li>
                <li>
                    <a href="http://del2wssgt01.sapient.com:9000/" target="_blank">Sonar</a>
                </li>
                <li>
                    <a href="http://del2wssgt01.sapient.com:8081/nexus" target="_blank">Nexus</a>
                </li>
                <li>
                    <a href="http://delvmlciin01.sapient.com:5601/app/kibana" target="_blank">Kibana</a>
                </li>
                <li>
                    <a href="http://delvmlciin01.sapient.com:9200/" target="_blank">ElasticSearch</a>
                </li>
                <li>
                    <a href="http://delvmlciin01.sapient.com:3000/" target="_blank">Grafana</a>
                </li>
                <li>
                    <a href="http://delvmlciin01.sapient.com:5044/" target="_blank">Logstash</a>
                </li>
                <li class="pull-right">
                    <a href="#"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></a>
                </li>
            </ul>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>
<!-- <div class="jumbotron">
<div class="container">
<h1>TDD Order Management</h1>
<p>{Description of application goes here...}</p>
<p><a class="btn btn-primary btn-lg" href="createOrderAction.htm" role="button">Create New Order &raquo;</a>
<a class="btn btn-primary btn-lg" href="blotterAction.htm" role="button">View All Orders &raquo;</a>
</p>
</div>
</div> -->
<div class="row" style="width: 99%; margin-top: 20px;">
    <div class="col-md-5" style="margin-left:10px">
        <div class="">
            <!-- Default panel contents -->
            <!-- 1 -->
            <div class="" role="tab" id="headingDevops">
                <h4>DevOps</h4>
            </div>
            <div class="">
                <p>DevOps is the union of people, process and products to enable continuous delivery of value to our end users (<a href="https://vox.sapient.com/docs/DOC-134318" target="_blank">Video</a> , click on view, click on play)</p>
            </div>
            <!-- 2 -->
            <div class="" role="tab" id="headingEtnerprise">
                <h4>
                    Enterprise DevOps Vox Group
                </h4>
            </div>
            <div class="">
                <p>VOX <a href="https://vox.sapient.com/groups/enterprise-devops/overview" target="_blank">Group Link</a>
                </p>
            </div>
                    <!-- 3 -->
            <div class="" role="tab" id="headingShowcase">
                <h4>
                    Showcase project
                </h4>
            </div>
            <div class="">
                <p>This is a showcase project with a complete automated pipeline using various DevOps tools. Any code change to the code repository of the said application is auto deployed to QA environment and thereafter Production environment with completely automated functional and performance tests. Also, log monitoring and application monitoring tools are hooked with QA and production environment to analyze various system, technical and business statistics e.g. CPU utilization, heap utilization, time taken to book an order, time taken to view orders etc.</p>
                <p><strong><em>Note: It is not a functionally rich application , as the idea is to showcase a DevOps pipeline rather than focusing on business functionality.  There are two simple use cases</em></strong>
                </p>
                <!-- List group -->
                <ul class="list-group">
                    <li class="list-group-item"><strong><em>a)  Book an order of various types</em></strong>
                    </li>
                    <li class="list-group-item"><strong><em>b)  View all orders</em></strong>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <div class="col-md-6 pull-right" style="border: solid 1px #ddd; margin-top: 5px;">
        <!-- <div class=""> -->
          <table class="table table-striped table-hover table-condensed" style="margin-bottom: 0px !important;">
            <thead>
                <tr>
                    <th>Fully Automated Pipeline / Tools used</th>
                </tr>
                <tr>
                    <th style="background-color: rgb(44, 62, 80); color: rgb(255, 255, 255);">DEV: Continuous Integration</th>
                </tr>
            </thead>
            <tbody>

                <tr>
                    <td><span class="tools">Checkout:</span>
                        <img src="css/images/git.png">
                        <img src="css/images/stash.jpg">
                    </td>
                </tr>
                <tr>
                    <td><span class="tools">Build:</span>
                        <img src="css/images/maven.png">
                        <img src="css/images/bamboo.png">
                    </td>
                </tr>
                <tr>
                    <td><span class="tools">Quality Control:</span>
                        <img src="css/images/sonar.png">
                    </td>
                </tr>
                    <td><span class="tools">Package and Archiving:</span>
                        <img src="css/images/nexus.png">
                    </td>
                </tr>
            </tbody>
          </table>
        <!-- </div> -->
        <!-- <div class=""> -->
          <table class="table table-striped table-hover table-condensed" style="margin-bottom: 0px !important;">
            <thead>
                <tr>
                    <th style="background-color: rgb(44, 62, 80); color: rgb(255, 255, 255);">OPS: Continuous Delivery and Monitoring on QA</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><span class="tools">Environment Provisioning on QA:</span>
                        <img src="css/images/bamboo.png">
                        <img src="css/images/salt.png">
                    </td>
                </tr>
                <tr>
                    <td><span class="tools">Deploy to QA:</span>
                        <img src="css/images/salt.png">
                    </td>
                </tr>
                <tr>
                    <td><span class="tools">Integration Testing:</span>
                        <img src="css/images/cucumber.png">
                        <img src="css/images/selenium.png">
                    </td>
                </tr>
                    <td><span class="tools">Performance Testing:</span>
                        <img src="css/images/jmeter.jpg">
                    </td>
                </tr>
            </tbody>
          </table>
        <!-- </div> -->
        <div class="">
          <table class="table table-striped table-hover table-condensed" style="margin-bottom: 0px !important;">
            <thead>
                <tr>
                    <th style="background-color: rgb(44, 62, 80); color: rgb(255, 255, 255);">OPS: Continuous Delivery and Monitoring on Prod</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><span class="tools">Environment Provisioning on Prod:</span>
                        <img src="css/images/bamboo.png">
                        <img src="css/images/salt.png">
                    </td>
                </tr>
                <tr>
                    <td><span class="tools">Deploy to Prod:</span>
                        <img src="css/images/salt.png">
                    </td>
                </tr>
                <tr>
                    <td><span class="tools">Application Monitoring on Prod:</span>
                        <img src="css/images/grafana.png">
                        <img src="css/images/elastalert.png">
                        <img src="css/images/kibana.png">
                    </td>
                </tr>
                    <td><span class="tools">Centralized Log Monitoring on Prod:</span>
                        <img src="css/images/elastic.png">
                        <img src="css/images/logstash.png">
                        <img src="css/images/kibana.png">
                    </td>
                </tr>
            </tbody>
          </table>
        </div>
    </div>
</div>

<footer class="footer">
  <div class="container">
    <p class="text-muted pull-left"><strong>Contact us: Enterprise DevOps Core Team <a href="mailto:EnterpriseDevOpsCoreTeam@sapient.com">EnterpriseDevOpsCoreTeam@sapient.com</a></strong></p>
  </div>
</footer>
        <%-- <table style="top:300px">
            <tr>
                <td>
                    <h1>TDD Order Management</h1>
                </td>
            </tr>
            <tr>
                <td id="createNewOrder"><a href="createOrderAction.htm"> Create New Order</a>
                </td>
            </tr>
            <tr>
                <td><strong></strong>
                </td>
            </tr>
            <tr>
                <td id="viewAllOrders"><a href="blotterAction.htm"> View All Orders</a>
                </td>
            </tr>
            </table> --%>
