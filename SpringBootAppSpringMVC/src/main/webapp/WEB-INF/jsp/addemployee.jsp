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
	<form action="addEmployeeInDB" method="POST" modelAttribute="emp">
		<table border="2">
		<tr>
				<td>Employee Id:</td>
				<td><input name="id" type="text" value="" /></td>
			</tr>
			<tr>
				<td>Employee Name:</td>
				<td><input name="name" type="text" value="" /></td>
			</tr>
			<tr>
				<td>Employee Salary:</td>
				<td><input name="salary" type="text" value="" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save Changes" /></td>
			</tr>
		</table>
	</form>
</body>
</html>