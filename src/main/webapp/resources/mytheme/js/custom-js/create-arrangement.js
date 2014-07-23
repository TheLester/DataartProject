$(function() {
	document.getElementById("warn").style.display = 'none';
	document.getElementById("suc").style.display = 'none';
	/*
	 * document.getElementById('warn').addEventListener('click',function(e){
	 * document.getElementById("warn").style.display = 'none'; });
	 */
});
function checkForNull() {
	document.getElementById("submitButton").disabled = true;

	var nameSel = document.forms["reviewForm"].name.value;
	var dateSel = document.forms["reviewForm"].date.value;
	var timeSel = document.forms["reviewForm"].time.value;
	var check = document.forms["reviewForm"].NotNull.value;

	if (!nameSel || !dateSel || !timeSel) {
		document.getElementById("warn").style.display = 'block';
		setTimeout(function() {
			document.getElementById("warn").style.display = 'none';
			document.forms["reviewForm"].submit();
		}, 1500);

		document.forms["reviewForm"].NotNull.value = "false";
	} else {
		console.log(check);
		document.getElementById("suc").style.display = 'block';
		setTimeout(function() {
			document.getElementById("suc").style.display = 'none';
			document.forms["reviewForm"].submit();
		}, 1500);

	}
}
function setFields() {
	var selectorValue = document.forms["reviewForm"].sectorSelector.value;

	console.log("Selector: " + selectorValue);

	var res = selectorValue.split("/");
	console.log(res);
	// document.forms["reviewForm"].arrangement_id.value = res[0];
	// document.forms["reviewForm"].name.value = res[1];
	document.forms["reviewForm"].sectorPrice.value = res[2];

}

function setSectorPrice() {
	var sectors = "${sectors}";
	console.log(sectors);
}