                            var request = new XMLHttpRequest();

                            function search() {
                                var keywrd = document.frmSearch.tukhoa.value;
                                var url = "ajaxTimKiem/" + keywrd;
                                if(!keywrd)
                                    var url = "ajaxTimKiem";

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

                            function search2() {
                                var keywrd = document.frmSearch2.tukhoa.value;
                                var url = "ajaxTimKiem/" + keywrd;
                                if(!keywrd)
                                    var url = "ajaxTimKiem";

                                try {
                                    request.onreadystatechange = function() {
                                        if (request.readyState == 4) {
                                            var val = request.responseText;
                                            document.getElementById('valueSearch2').innerHTML = val;
                                        }
                                    }

                                    request.open("GET", url, true);
                                    request.send();

                                } catch (e) {
                                }
                            }