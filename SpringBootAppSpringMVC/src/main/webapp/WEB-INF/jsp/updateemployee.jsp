<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="updateEmployeeInDB" modelAttribute="updateemp">
		<table>
			<tr>
				<td><form:hidden path="id" /></td>
			</tr>
			<tr>
				<td><label>Employee Name</label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><label>Employee Salary</label></td>
				<td><form:input path="salary" /></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Update Employee"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>