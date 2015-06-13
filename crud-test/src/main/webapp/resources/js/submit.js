$(function() {
	"use strict";

	console.log("ready ");

	var urlContext = $('#urlContext').val();
	

	$('#submit')
			.click(
					function(event) {
						console.log("submit called");

						var formAttribute  = populateData();

						if (validateAttribute(formAttribute)) {

							var searchParam = {
								"param" : "param"
							};

							console.log("start request ajax ");

							var submitForm = $.ajax({
								url : urlContext + "submit/form",
								type : "POST",
								contentType : "application/json",
								data : JSON.stringify(formAttribute)
							});

							console.log("formAttribute " + formAttribute);
							
							

							// callback handler that will be called on success
							submitForm.done(function(repliedData) {
								console.log("repliedData " + repliedData);
								
								$('#userName').val("");
								$('#email').val("")
								$('#phoneNumber').val("");
								
								customReload();
//								alert("Data Submited");
								
							});

							// callback handler that will be called on failure
							submitForm.fail(function(jqXHR, textStatus,
									errorThrown) {
								alert("The following error occured: "
										+ textStatus, errorThrown);
							});

							// callback handler that will be called regardless
							// if the request failed
							// or
							// succeeded
							submitForm
									.always(function() {
										console
												.log("callback handler that will be called regardless if the request failed or succeeded");
									});

							console.log("end ajax");
							
							
							
							
						}

					});

});

function populateData(){
	var userName = $('#userName').val();
	var email = $('#email').val();
	var phoneNumber = $('#phoneNumber').val();

	var formAttribute = {
		userName : userName,
		email : email,
		phoneNumber : phoneNumber
	};
	
	return formAttribute;
}

function customReload() {
	   oTable_myTableId.fnReloadAjax();
}

function edit(data, type, full) {
	var urlContext = $('#urlContext').val();
	var editLink = urlContext+"edit/"+data;
//	return '<a role="button" class="btn btn-default" href="#edit-modal" data-toggle="modal" data-target="#edit-modal"><span  aria-hidden="true" class="glyphicon glyphicon-pencil"></span> <span class="glyphicon-class"></span></a>';
	return '<a role="button" class="btn btn-default" href="'+ editLink +'"> <span  aria-hidden="true" class="glyphicon glyphicon-pencil"></span> <span class="glyphicon-class"></span>';
}

function deleteData(data, type, full) {
	var urlContext = $('#urlContext').val();
	var delLink = urlContext+"delete/"+data;
	return '<a role="button" class="btn btn-default" href="'+ delLink +'"> <span  aria-hidden="true" class="glyphicon glyphicon-remove"></span> <span class="glyphicon-class"></span>';
}

function validateUpdate(){
	var formAttribute  = populateData();
	if (!validateAttribute(formAttribute)) {
		return false;
	}
}

function validateAttribute(formAttribute) {
	var isValid = false;

	var emailRegex = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
	var numberRegex = /^\d+$/;

	if (formAttribute.userName == '') {
		alert("All Fields are Mandatory ");
		return false;
	} else {
		isValid = true;
	}

	if (formAttribute.email == '') {
		alert("All Fields are Mandatory ");
		return false;
	} else {
		isValid = formAttribute.email.match(emailRegex);
		if (!isValid) {
			alert("Invalid Email Format ");
			return false;
		} else {
			isValid = true;
		}
	}

	if (formAttribute.phoneNumber == '') {
		alert("All Fields are Mandatory ");
		return false;
	} else {
		isValid = formAttribute.phoneNumber.match(numberRegex);
		if (!isValid) {
			alert("Invalid Phone Number ");
			return false;
		} else {
			isValid = true;
		}
	}

	return isValid;
}