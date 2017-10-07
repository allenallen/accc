<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Arcenal Car Care Center</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<table border="1">
	<thead>
		<tr>
			<th>JO Number</th>
			<th>Date</th>
			<th>Name</th>
			<th>Car</th>
			<th>Plate Number</th>
			<th>Job Description</th>
			<th>Total Amount</th>
		</tr>
	</thead>
	<tbody></tbody>
</table>

<script type="text/javascript">
	function addTableData(data){
		$("table tbody").append(
			"<tr><td>"+ data.joNumber + "</td><td>"+ data.date +"</td><td>"+ data.name +"</td><td>"+ data.make +"</td><td>"+ data.plateNumber 
			+ "</td><td>"+ data.jobDescriptions[0].jobDescription +"</td><td>"+ data.totalAmountDue +"</td></tr>"		
		);
	}
	$(document).ready(function(){
		$.ajax({
			method:'GET',
			url:'/joborder/',
			success:function(data){
				for(var i=0;i <data.length;i++){
					addTableData(data[i]);
				}
			}
		});
	});
</script>


</body>
</html>