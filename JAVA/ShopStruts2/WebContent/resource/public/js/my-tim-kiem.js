						function search() {
							var keywrd = document.frmSearch.keyword.value;
							$.ajax({
								type: "POST",
								data:{keyword : keywrd},
								url: '${pageContext.request.contextPath}/search',
								success: function(reponse) {
									$('#valueSearch').html(reponse);
								}
							});
						}
						
						function search2() {
							var keywrd = document.frmSearch2.keyword.value;
							$.ajax({
								type: "POST",
								data:{keyword : keywrd},
								url: '${pageContext.request.contextPath}/search',
								success: function(reponse) {
									$('#valueSearch2').html(reponse);
								}
							});
						}