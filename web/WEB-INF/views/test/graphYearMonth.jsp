<%@ page import="com.budong.R" %><%--
  Created by IntelliJ IDEA.
  User: S401-28
  Date: 2018-11-29
  Time: 오전 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
    <style> 
    	#chartContainer {
    	}
    	
    	.empty-div {
    		padding :2em;
    	}
    	.date-container {
    		float :right ;
    		padding : 2em;
    	}
    </style>
    <script type="text/javascript">
        window.onload = function (e) { 
        	   var date, year, month;          	 
        	   date = new Date(2016,0,01); 
        	   month = 12; 
        	   year = 2016; 
        	   
        	    var dataPoints = [];
                var options = {
                    animationEnabled: true,
                    theme: "light2",
                    title: {
                        text: "아파트 " + date.getFullYear() + "년 월별 매매가"
                    },
                    axisX: {
                        valueFormatString: "YYYY.MM",
                        interval: 1,
                        intervalType: "month"
                    },
                    axisY: {
                        title: "시세(만원)",
                        includeZero: false,
                        ValueFormatString: "#,###.###",
                        maximum: 40000
                    },
                    data: [{
                        type: "column",
                        xValueType: "dateTime",
                        xValueFormatString: "YYYY MM",
                        yValueFormatString: "#,###.###",
                        dataPoints: dataPoints
                    }]
                };
        	   updateData();
        		
        	   
        	      function addData(data) {
                      var max = 0;
                      $.each(data, function (key, value) {
                          console.log("input month =" + value["month"]);
                          console.log(new Date(value["year"], value["month"], 1));
                          dataPoints.push({
                              "x": new Date(value["year"] + "-" + value["month"] + "-1"),
                              "y": value["avg"]
                          });
                          if (max < value["avg"]) {
                              max = value["avg"];
                          }
                      });
                      roundUpMaximum(max);
                      console.log(dataPoints);
                      $("#chartContainer").CanvasJSChart(options);
                      /*var chart = new CanvasJS.Chart("chartContainer",options);
                      chart.render();*/
                      // setTimeout(updateData, 1500);
                  }
        	      
        	    function updateData() {
                    var fromMonth = 1;
                    var requestRest = "<%=request.getContextPath()+(R.rest.apartment_deal_info_avg_by_year_month)%>"
                        + "?monthFrom=" + fromMonth
                        + "&monthTo=" + month
                        + "&year=" + year;
                    $.getJSON(requestRest, addData);
                }
                function roundUpMaximum(max) {
                    max = Math.floor(max);
                    var ceilLength = max.toString().length - 1;
                    var tenPowCeilLength = Math.pow(10, ceilLength);
                    options["axisY"].maximum = Math.floor(max / tenPowCeilLength + 1) * tenPowCeilLength;
                    console.log(options["axisY"].maximum);
                }
                
            $("#datePicker").on("change", function () {
                  date = new Date($(this).val());
                  year = date.getFullYear();
                  month = date.getMonth() === 0 ? 12 : date.getMonth() + 1;
                console.log(date.getFullYear());
            
                updateData();
          
            
            });
        }
    </script>
</head>

<body>
<div class="date-container">
    <form>
        <input type="date" id="datePicker"/>
    </form>
</div>
<div class="empty-div"> &nbsp;</div>
<div id="chartContainer" style="height: 300px; width: 100%;"></div>
<div class="empty-div"> &nbsp;</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://canvasjs.com/assets/script/jquery.canvasjs.min.js"></script>
</body>
</html>