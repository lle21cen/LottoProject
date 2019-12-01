<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
	<title>Home</title>
</head>
<body>

<script type="text/javascript">
	<c:forEach items="${numbers}" var="item">
	document.write("${item.num} ${item.num_cnt}<br>");
	</c:forEach>
</script>

</body>
</html>