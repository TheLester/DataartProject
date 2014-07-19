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

function checkNotNull() {
	document.getElementById("submitDemo").disabled = true;
	var sel = document.forms["reviewForm"].selector.value;
	if (sel == "") {
		document.getElementById("warn").style.display = 'block';
		setTimeout(function() {
			document.getElementById("warn").style.display = 'none';
			document.forms["reviewForm"].submit();
		}, 1500);
		document.forms["reviewForm"].NotNull.value = "false";
	} else {
		document.getElementById("suc").style.display = 'block';
		setTimeout(function() {
			document.getElementById("suc").style.display = 'none';
			document.forms["reviewForm"].submit();
		}, 1500);
	}
}