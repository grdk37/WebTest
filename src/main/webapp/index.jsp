<%@page pageEncoding="UTF-8" %>
<html>
<body>
	<h2>Hello World!</h2>
	<img alt="img"
		src="<%=request.getContextPath()%>/resources/xiangqi.png">
	message:<%=request.getAttribute("message")%><br /> errorMessage:<%=request.getAttribute("errorMessage")%><br />
</body>
</html>

