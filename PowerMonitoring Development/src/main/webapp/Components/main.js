/**
 * 
 */
/* hide the divisions used to show the status messages on the page load */
$(document).ready(function() 
{ 
if ($("#alertSuccess").text().trim() == "") 
 { 
 $("#alertSuccess").hide(); 
 } 
 $("#alertError").hide(); 
});
/*  add a click event handler for the Save button */
$(document).on("click", "#btnSave", function(event) 
{ 
	//clear status ssmessages
	$("#alertSuccess").text(""); 
    $("#alertSuccess").hide(); 
    $("#alertError").text(""); 
    $("#alertError").hide();

  // Form validation----------------
    var status = validateDeviceForm(); 
   // If not valid-------------------
   if (status != true) 
   { 
      $("#alertError").text(status); 
      $("#alertError").show(); 
      return; 
   } 
   
 
     $("#formDevice").submit(); 
  //}


});

  function validateDeviceForm() {
	
	//device
	if($("#txtAppliance").val().trim() == ""){
		return "Insert Electric device.";
	}


  if($("#txtPower").val().trim() == ""){
	return "Insert power usagr of device";
	
}
    
   if($("#txtHrs").val().trim() == ""){
	return "Insert Hours used by device";
}
   
   
   var userInput = $("#txtHrs").val().trim();
   if(userInput  < "1" || userInput > "24"){
	return "Please input between 1 and 24";
}
   

//No of devices
    if($("#txtNoDevices").val().trim() == ""){
	return "Insert number of devices";
}
  if($("#txtNoDevices").val().trim() == "0"){
	return "Insert number of devices";
}

   var tmpHrs = $("#txtHrs").val().trim();
   if(!$.isNumeric(tmpHrs)){
	return "Insert numeric value";
}

  var tmpPower = $("#txtPower").val().trim();
    if(!$.isNumeric(tmpPower)){
	return "Insert numeric value";
}
    //covert to decimal
    $("#txtPower").val(parseFloat(tmpPower).toFixed(2));
 
 
  var tmpNoDevices = $("#txtNoDevices").val().trim();
  if(!$.isNumeric(tmpNoDevices)){
	return "Insert numeric value";
}   
 
  return true;
}


//Update operation

$(document).on("click", ".btnUpdate", function(event) 
{ 
      $("#hidDeviceIDSave").val($(this).closest("tr").find('#hidDeviceIDUpdate').val()); 
      $("#txtAppliance").val($(this).closest("tr").find('td:eq(0)').text()); 
      $("#txtPower").val($(this).closest("tr").find('td:eq(1)').text()); 
      $("#txtHrs").val($(this).closest("tr").find('td:eq(2)').text()); 
      $("#txtNoDevices").val($(this).closest("tr").find('td:eq(3)').text()); 
});






















