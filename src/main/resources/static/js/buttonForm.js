const tabs = [document.getElementById("nav-bag-tab"),
	document.getElementById("nav-place-tab"),
	document.getElementById("nav-status-tab"),
	document.getElementById("nav-kindOfPlace-tab")];
var tabsLen = tabs.length;
var submitButton = document.getElementById("submit-button");

function submitFunction() {
	console.log(tabsLen);

	for (let i = 0; i < tabsLen; i++) {
		console.log(tabs[i].value);
		if (tabs[i].classList.contains("active")) {
			submitButton.setAttribute("form", tabs[i].value);
		}
	}
}