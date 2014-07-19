$(function() {

	$('.subM').click(function() {
		return false;
	});

	$('.subM').hover(function() {
		$(this).next().show();
		$(this).addClass('selected');
	}, function() {
		$(this).next().hide();
		$(this).removeClass('selected');
	});

	$('.subMenu').hover(function() {
		$(this).prev().addClass('selected');
		$(this).show();
	}, function() {
		$(this).prev().removeClass('selected');
		$(this).hide();
	});

	var wd = 0;

	$('.topLvl>li').each(function() {
		wd += $(this).outerWidth();

	});
	wd += 4;
});
