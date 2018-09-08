<?php
    /*Just for your server-side code*/
    header('Content-Type: text/html; charset=ISO-8859-1');
?>
<html>
  <head>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load('current', {'packages':['timeline']});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var container = document.getElementById('timeline');
        var chart = new google.visualization.Timeline(container);
        var dataTable = new google.visualization.DataTable();

        dataTable.addColumn({ type: 'string', id: 'President' });
        dataTable.addColumn({ type: 'date', id: 'Start' });
        dataTable.addColumn({ type: 'date', id: 'End' });
        dataTable.addRows([

<?php
$servername = "localhost";
$username = "webboka";
$password = "webboka";
$dbname = "webboka";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);
// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
//select *, (select name from things where pkid=booked.ThingsID) from booked 
$sql = "SELECT (select name from things where pkid=booked.ThingsID) as Name,fromdate,todate FROM booked";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
	$from=date('Y,m,d,H,i', strtotime($row["fromdate"]));
	$to=date('Y,m,d,H,i', strtotime($row["todate"]));
        echo "['" . $row["Name"]. "', new Date(" .$from. "), new Date(" . $to. ")],";
    }
} else {
    echo "0 results";
}
$conn->close();
?>


]);
      	var options = {
          hAxis: {
            format : 'yyyy-MM-dd HH:ss'
          }
        };
	
        chart.draw(dataTable,options);
      }
    </script>
  </head>
  <body>
    <div id="timeline" style="height: 180px;"></div>
  </body>
</html>



