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
	<a href="/viewJO">Job Orders</a>

	<br/><br/>
	<form id="joForm" action="#">
		<input type="date" name="date" value="Date"/> <br/>
		<input type="text" name="name" placeholder="Name"/> <br/>
		<input type="text" name="joNumber" placeholder="JO Number" /> <br/>
		<input type="text" name="address" placeholder="Address" /> <br/>
		<input type="text" name="contactNumber" placeholder="Contact Number"/> <br/>
		<input type="text" name="make" placeholder="Make/Model"/> <br/>
		<input type="text" name="plateNumber" placeholder="Plate Number"/> <br/>
		<input type="text" name="vehicleColor" placeholder="Vehicle Color"/> <br/>
		<input type="text" name="odometer" placeholder="Odometer"/> <br/>
		<div id="jobDesc">
		<input type="text" name="jobDescriptions[]" placeholder="Job Description"/> <input type="text" name="labor[]" placeholder="Labor"/> <button id="addJobDesc" type="button">Add</button><br/>
		</div>
		
		<div id="parts">
		<input type="text" name="parts[]" placeholder="Parts"/> <input type="text" name="amount[]" placeholder="Amount"/> <button id="addPart" type="button">Add</button><br/>
		</div>
		
		<div id="technicians">
		<input type="text" name="technician" placeholder="Technician"/> <button id="addTechnician" type="button">Add</button><br/>
		</div>
		<input type="text" name="totalAmountDue" placeholder="Total Amount Due"/> <br/>
		<input type="date" name="datePaid" value="Date Paid" /> <br/>
		<input type="date" name="dateDeposit" value="Deposit Date" /> <br/>
		<button id="formSubmit" >Save</button>
	</form> 
	<script type="text/javascript">
		function returnVal(){
			return this.value;
		}
		$("button[id='addJobDesc']").click(function(){
			var div = $("div[id='jobDesc']");
			div.append('<input type="text" name="jobDescriptions[]" placeholder="Job Description"/> <input type="text" name="labor[]" placeholder="Labor"/><br/>');
		});
		$("button[id='addPart']").click(function(){
			var div = $("div[id='parts']");
			div.append('<input type="text" name="parts[]" placeholder="Parts"/> <input type="text" name="amount[]" placeholder="Amount"/><br/>');
		});
		$("button[id='addTechnician']").click(function(){
			var div = $("div[id='technicians']");
			div.append('<input type="text" name="technician" placeholder="Technician"/><br/>');
		});
		$("button[id='formSubmit']").click(function(){
			var date = $("input[name='date']").val();
			var datePaid = $("input[name='datePaid']").val();
			var dateDeposit = $("input[name='dateDeposit']").val();
			
			var jsonForm = {};
			
			jsonForm["date"] = date;
			jsonForm["joNumber"] = $("input[name='joNumber']").val();
			jsonForm["address"] = $("input[name='address']").val();
			jsonForm["contactNumber"] = $("input[name='contactNumber']").val();
			jsonForm["make"] = $("input[name='make']").val();
			jsonForm["plateNumber"] = $("input[name='plateNumber']").val();
			jsonForm["vehicleColor"] = $("input[name='vehicleColor']").val();
			jsonForm["odometer"] = $("input[name='odometer']").val();
			jsonForm["name"] = $("input[name='name']").val();

			var jobDescs = $("input[name='jobDescriptions[]']").map(returnVal).get();
			var jobDescsLabor = $("input[name='labor[]']").map(returnVal).get();
			
			if(!Array.isArray(jobDescs)){
				jobDescs = [jobDescs];
				jobDescsLabor = [jobDescsLabor];
			}
			alert(jobDescs.length);
			var jobDescsForm = [];
			
			for(var i=0;i<jobDescs.length; i++){
				jobDescsForm.push({"jobDescription":jobDescs[i],"labor":jobDescsLabor[i]});
			}
			
			var parts = $("input[name='parts[]']").map(returnVal).get();
			var partsAmount = $("input[name='amount[]']").map(returnVal).get();
			
			if(!Array.isArray(parts)){
				parts = [parts];
				partsAmount = [partsAmount];
			}
			alert(parts.length);
			var partsForm = [];
			
			for(var i=0;i<parts.length; i++){
				partsForm.push({"parts":parts[i],"amount":partsAmount[i]});
			}
			
			jsonForm["jobDescriptions"] = jobDescsForm;
			jsonForm["parts"] = partsForm;
			
			jsonForm["technician"] = ["JR"];
			jsonForm["totalAmountDue"] = $("input[name='totalAmountDue']").val();
			jsonForm["datePaid"] = datePaid;
			jsonForm["depositDate"] = dateDeposit;
			
			var j = JSON.stringify(jsonForm);
			console.log(jsonForm);
			$.ajax({
				method:'PUT',
				url:'/joborder/add',
				contentType:"application/json",
				data:j,
				success:function(msg){
					if(msg){
						alert("Save Successful");
						window.location = '/';
					} else {
						alert("error");
					}
				}
			});
			return false;
		});
	</script>
</body>
</html>