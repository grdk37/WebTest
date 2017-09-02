<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/securityurity/tags" %>
<html>
<body>
	<h2>Hello World!</h2>
	Hello <security:authentication property="principal.username" />
	<security:authentication property="credentials" />
	<security:authentication property="details" />
	<security:authentication property="principal" />
	<security:authentication property="principal.username"
							 var="loginId" />
	message:<%=request.getAttribute("message")%><br /> errorMessage:<%=request.getAttribute("errorMessage")%><br />

	<security:authorize access="hasRole('ROLE_SPITTER')">
		<s:url value="/spittles" var="spittle_url" />
		<sf:form modelAttribute="spittle"
				 action="${spittle_url}">
			<sf:label path="text"><s:message code="label.spittle"
											 text="Enter spittle:"/></sf:label>
			<sf:textarea path="text" rows="2" cols="40" />
			<sf:errors path="text" />
			<br/>
			<div class="spitItSubmitIt">
				<input type="submit" value="Spit it!"
					   class="status-btn round-btn disabled" />
			</div>
		</sf:form>
	</security:authorize>

	<security:authorize
			access="isAuthenticated() and principal.username=='habuma'">
		<a href="/admin">Administration</a>
	</security:authorize>

	
</body>
</html>

