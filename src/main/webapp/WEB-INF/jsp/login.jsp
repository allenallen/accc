<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Arcenal Car Care Center</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<header class="w3-container w3-red">
	<div class="w3-row">
		<div class="w3-col m8">
			<h3>Arcenal Car Care Center</h3>
		</div>
		<div class="w3-col m4">
			<a href="/viewJO">Job Orders</a>
		</div>
	</div>
	</header>


	<div class="w3-container">
		<form id="joForm" action="#">

			<div class="w3-row w3-padding">
				<div class="w3-col m4 w3-right">
					<label>JO Number</label> <input class="w3-input w3-border"
						type="text" name="joNumber" placeholder="JO Number" />
				</div>
			</div>

			<div class="w3-row w3-padding">
				<div class="w3-col w3-container" style="width: 50%">
					<label>Name</label> <input class="w3-input w3-border" type="text"
						name="name" placeholder="Name" />
				</div>
				<div class="w3-col w3-container w3-right" style="width: 35%">
					<label>Date</label> <input class="w3-input w3-border" type="date"
						name="date" value="Date" />
				</div>
			</div>

			<div class="w3-row w3-padding">
				<div class="w3-col w3-container" style="width: 50%">
					<label>Address</label> <input class="w3-input w3-border"
						type="text" name="address" placeholder="Address" />
				</div>
				<div class="w3-col w3-container w3-right" style="width: 35%">
					<label>Plate Number</label> <input class="w3-input w3-border"
						type="text" name="plateNumber" placeholder="Plate Number" />
				</div>
			</div>

			<div class="w3-row w3-padding">
				<div class="w3-col w3-container" style="width: 50%">
					<label>Contact Number</label> <input class="w3-input w3-border"
						type="text" name="contactNumber" placeholder="Contact Number" />
				</div>
				<div class="w3-col w3-container w3-right" style="width: 35%">
					<label>Vehicle Color</label> <input class="w3-input w3-border"
						type="text" name="vehicleColor" placeholder="Vehicle Color" />
				</div>
			</div>

			<div class="w3-row w3-padding">
				<div class="w3-col w3-container" style="width: 50%">
					<label>Make/Model</label> <input class="w3-input w3-border"
						type="text" name="make" placeholder="Make/Model" />
				</div>
				<div class="w3-col w3-container w3-right" style="width: 35%">
					<label>Odometer</label> <input class="w3-input w3-border"
						type="text" name="odometer" placeholder="Odometer" />
				</div>
			</div>

			<div id="jobDesc" class="w3-row w3-padding w3-border">
				<div class="w3-col w3-container" style="width: 50%">
					<label>Job Description</label> <input class="w3-input w3-border"
						type="text" name="jobDescriptions[]" placeholder="Job Description" />
				</div>
				<div class="w3-col w3-container" style="width: 40%">
					<label>Labor</label> <input class="w3-input w3-border" type="text"
						name="labor[]" placeholder="Labor" />
				</div>
				<div class="w3-col w3-container w3-cell-bottom" style="width: 10%">
					<button class="w3-button w3-red w3-block" id="addJobDesc"
						type="button">Add</button>
					<br />
				</div>
			</div>

			<div id="parts" class="w3-row w3-padding w3-border">
				<div class="w3-col w3-container" style="width: 50%">
					<label>Parts</label> <input class="w3-input w3-border" type="text"
						name="parts[]" placeholder="Parts" />
				</div>
				<div class="w3-col w3-container" style="width: 40%">
					<label>Amount</label> <input class="w3-input w3-border" type="text"
						name="amount[]" placeholder="Labor" />
				</div>
				<div class="w3-col w3-container w3-cell-bottom" style="width: 10%">
					<button class="w3-button w3-red w3-block" id="addPart"
						type="button">Add</button>
					<br />
				</div>
			</div>

			<div id="technicians" class="w3-row w3-padding w3-border">
				<div class="w3-col w3-container" style="width: 50%">
					<label>Technician</label> <input class="w3-input w3-border"
						type="text" name="technician" placeholder="Technician" />
				</div>
				<div class="w3-col w3-container w3-cell-bottom" style="width: 10%">
					<button class="w3-button w3-red w3-block" id="addTechnician"
						type="button">Add</button>
					<br />
				</div>
			</div>

			<div class="w3-row w3-padding">
				<div class="w3-col w3-container" style="width: 33%">
					<label>Total Amount Due</label> <input class="w3-input w3-border"
						type="text" name="totalAmountDue" placeholder="Total Amount Due" />
				</div>
				<div class="w3-col w3-container w3-right" style="width: 33%">
					<label>Date Paid</label> <input class="w3-input w3-border"
						type="date" name="datePaid" placeholder="Date Paid" />
				</div>
				<div class="w3-col w3-container w3-right" style="width: 33%">
					<label>Deposit Date</label> <input class="w3-input w3-border"
						type="date" name="dateDeposit" placeholder="Deposit Date" />
				</div>
			</div>

			<div class="w3-row w3-padding w3-center">
				<div class="w3-col w3-container" style="width: 50%">
					<button class="w3-button w3-red w3-block" id="formSubmit">Save</button>
				</div>
			</div>

		</form>
	</div>

	<script type="text/javascript">
		function returnVal() {
			return this.value;
		}
		$("button[id='addJobDesc']")
				.click(
						function() {
							var div = $("div[id='jobDesc']");
							div
									.append('<div class="w3-col w3-container" style="width:50%"><label>JobDescription</label><input class="w3-input w3-border" type="text" name="jobDescriptions[]" placeholder="Job Description"/></div><div class="w3-col w3-container" style="width:40%"><label>Labor</label><input class="w3-input w3-border" type="text" name="labor[]" placeholder="Labor"/></div>');
						});
		$("button[id='addPart']")
				.click(
						function() {
							var div = $("div[id='parts']");
							div
									.append('<div class="w3-col w3-container" style="width:50%"><label>Parts</label><input class="w3-input w3-border" type="text" name="parts[]" placeholder="Parts"/></div><div class="w3-col w3-container" style="width:40%"><label>Amount</label><input class="w3-input w3-border" type="text" name="amount[]]" placeholder="Labor"/></div>');
						});
		$("button[id='addTechnician']")
				.click(
						function() {
							var div = $("div[id='technicians']");
							div
									.append('<div class="w3-col w3-container" style="width:50%"><label>Technician</label><input class="w3-input w3-border" type="text" name="technician" placeholder="Technician"/></div>');
						});
		$("button[id='formSubmit']")
				.click(
						function() {
							var date = $("input[name='date']").val();
							var datePaid = $("input[name='datePaid']").val();
							var dateDeposit = $("input[name='dateDeposit']")
									.val();

							var jsonForm = {};

							jsonForm["date"] = date;
							jsonForm["joNumber"] = $("input[name='joNumber']")
									.val();
							jsonForm["address"] = $("input[name='address']")
									.val();
							jsonForm["contactNumber"] = $(
									"input[name='contactNumber']").val();
							jsonForm["make"] = $("input[name='make']").val();
							jsonForm["plateNumber"] = $(
									"input[name='plateNumber']").val();
							jsonForm["vehicleColor"] = $(
									"input[name='vehicleColor']").val();
							jsonForm["odometer"] = $("input[name='odometer']")
									.val();
							jsonForm["name"] = $("input[name='name']").val();

							var jobDescs = $("input[name='jobDescriptions[]']")
									.map(returnVal).get();
							var jobDescsLabor = $("input[name='labor[]']").map(
									returnVal).get();

							if (!Array.isArray(jobDescs)) {
								jobDescs = [ jobDescs ];
								jobDescsLabor = [ jobDescsLabor ];
							}
							var jobDescsForm = [];

							for (var i = 0; i < jobDescs.length; i++) {
								jobDescsForm.push({
									"jobDescription" : jobDescs[i],
									"labor" : jobDescsLabor[i]
								});
							}

							var parts = $("input[name='parts[]']").map(
									returnVal).get();
							var partsAmount = $("input[name='amount[]']").map(
									returnVal).get();

							if (!Array.isArray(parts)) {
								parts = [ parts ];
								partsAmount = [ partsAmount ];
							}
							var partsForm = [];

							for (var i = 0; i < parts.length; i++) {
								partsForm.push({
									"parts" : parts[i],
									"amount" : partsAmount[i]
								});
							}

							jsonForm["jobDescriptions"] = jobDescsForm;
							jsonForm["parts"] = partsForm;

							jsonForm["technician"] = [ "JR" ];
							jsonForm["totalAmountDue"] = $(
									"input[name='totalAmountDue']").val();
							jsonForm["datePaid"] = datePaid;
							jsonForm["depositDate"] = dateDeposit;

							var j = JSON.stringify(jsonForm);
							console.log(jsonForm);
							$.ajax({
								method : 'PUT',
								url : '/joborder/add',
								contentType : "application/json",
								data : j,
								success : function(msg) {
									if (msg) {
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