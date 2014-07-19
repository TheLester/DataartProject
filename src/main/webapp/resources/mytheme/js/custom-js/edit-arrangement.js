$(function() {
	document.getElementById("warn").style.display = 'none';
	document.getElementById("suc").style.display = 'none';
	document.getElementById('warn').addEventListener('click', function(e) {
		document.getElementById("warn").style.display = 'none';
	});
	document.getElementById('suc').addEventListener('click', function(e) {
		document.getElementById("suc").style.display = 'none';
	});
});

function setFields() {
	var selector_value = document.forms["reviewForm"].selector.value;
	console.log("Selector: " + selector_value);
	if (selector_value != "") {
		var res = selector_value.split("/");
		console.log(res);
		document.forms["reviewForm"].arrangement_id.value = res[0];
		document.forms["reviewForm"].name.value = res[1];
		var datetime = res[2].split(" ");
		document.forms["reviewForm"].date.value = datetime[0];
		document.forms["reviewForm"].time.value = datetime[1];
	} else // hide input fields
	{
		document.getElementById("name").readOnly = true;
		document.getElementById("date").readOnly = true;
		document.getElementById("time").readOnly = true;
	}
}

function setInputs(status) {
	document.getElementById("name").style.display = status;
	document.getElementById("date").style.display = status;
	document.getElementById("time").style.display = status;
}

function checkForNull() {
	document.getElementById("submitDemo").disabled = true;

	var nameSel = document.forms["reviewForm"].name.value;
	var dateSel = document.forms["reviewForm"].date.value;
	var timeSel = document.forms["reviewForm"].time.value;
	var selector_value = document.forms["reviewForm"].selector.value;

	if (!nameSel || !dateSel || !timeSel || !selector_value) {
		document.getElementById("warn").style.display = 'block';
		setTimeout(function() {
			document.getElementById("warn").style.display = 'none';
			document.forms["reviewForm"].submit();
		}, 1500);

	} else {
		document.getElementById("suc").style.display = 'block';
		setTimeout(function() {
			document.getElementById("suc").style.display = 'none';
			document.forms["reviewForm"].submit();
		}, 1500);
	}
	console.log(check);
}