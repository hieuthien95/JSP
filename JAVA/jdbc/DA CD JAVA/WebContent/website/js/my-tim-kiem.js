var request = new XMLHttpRequest();

function search() {
	var keywrd = document.frmSearch.keyword.value;
	var url = "/search.jsp?key=" + keywrd;

	try {
		request.onreadystatechange = function() {
			if (request.readyState == 4) {
				var val = request.responseText;
				document.getElementById('valueSearch').innerHTML = val;
			}
		}

		request.open("GET", url, true);
		request.send();

	} catch (e) {
	}
}