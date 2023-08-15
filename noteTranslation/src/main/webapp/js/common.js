

function openNewWindow(url, window_title, width, height){
	let windowFeatures = "";
	if(!width && !height){
		windowFeatures = 'scrollbars=yes, width=460, height=530, resizable=yes';
	}else{
		windowFeatures = 'scrollbars=yes, width='+width+', height='+height+', resizable=yes';
	}
	window.open(url, window_title, windowFeatures);
}




