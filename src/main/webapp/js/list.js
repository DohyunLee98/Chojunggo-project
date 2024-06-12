        function redirectToServlet() {
            var select = document.getElementById("category");
            var selectedValue = select.options[select.selectedIndex].value;
            var url = '/list.do?category=' + encodeURIComponent(selectedValue);
            window.location.href = url;
        };
