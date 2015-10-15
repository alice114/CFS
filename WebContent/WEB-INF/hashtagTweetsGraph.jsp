<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="template-top.jsp" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<c:forEach var="error" items="${errors}">
	<h3 style="color: red">${error}</h3>
</c:forEach>

<script type="text/javascript"
	src="https://www.google.com/jsapi?autoload={
            'modules':[{
              'name':'visualization',
              'version':'1',
              'packages':['corechart']
            }]
          }"></script>

<script type="text/javascript">
	google.setOnLoadCallback(drawChart);

	function drawChart() {

		var data = google.visualization.arrayToDataTable([

				[ {
					label : 'Tag',
					id : 'string'
				}, {
					label : 'Count',
					type : 'number'
				}, // Use object notation to explicitly specify the data type.
				],
				<c:forEach items="${hashtag_map_count}" var="hash">[
						"# ${hash.key}", "${hash.value}"], </c:forEach> ]);

		var options = {
			title : 'HashTag Statistics',
			legend : {
				position : 'bottom'
			},
			vAxis : {
				title : 'Count'
			},

			hAxis : {
				title : 'Tags'
			}

		};

		// Create a formatter.
		// This example uses object literal notation to define the options.
		var formatter = new google.visualization.DateFormat({
			formatType : 'long'
		});

		// Reformat our data.
		formatter.format(data, 1);

		var chart = new google.visualization.LineChart(document
				.getElementById('curve_chart'));

		chart.draw(data, options);
	}
</script>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<h1>
		<span> Showing trending topics along with the search keyword:
			${keyword}<br> <br>
		</span>
	</h1>
	<div id="curve_chart" style="width: 900px; height: 500px"></div>

</body>
</html>
<jsp:include page="template-bottom.jsp" />