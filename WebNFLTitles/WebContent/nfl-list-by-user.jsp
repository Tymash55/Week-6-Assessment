<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NFL List</title>
</head>
<body>
	<form method = "post" action = "listnavigationServlet">
	<table>
	<c:forEach items="${requestScope.allLists}" var ="currentList">
	<tr>
		<td><input type="radio" name="id" value="${currentList.id}"></td>
		<td><h2>${currentList.listName }</h2></td></tr>
		<tr><td colspan="3"> Trip Date: ${currentList.nflDate }</td></tr>
		<tr><td colspan="3"> User: ${currentList.User.userName}</td></tr>
		<c:forEach var="listVal" items="${currentList.listOfItems}">
			<tr><td></td><td colspan="3">${listVal.team }, ${ListVal.titles}</td>
			</tr>
			</c:forEach>
			</c:forEach>
	</table>
	<input type = "submit" value ="edit" name="doThisToList">
	<input type = "submit" value ="delete" name="doThisToList">
	<input type = "submit" value ="add" name="doThisToList">
	</form>
	<a href="viewAllListsServlet">View all Lists</a> <br />
	<a href="addItemsForListServlet">Create a new List of Super Bowl Guesses</a>
</body>
</html>