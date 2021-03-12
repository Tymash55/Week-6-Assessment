<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New list Creator</title>
</head>
<body>
	<form action="createNewListServlet" method="post">
	List Name: <input type ="text" name="listName"><br />
	NFL Date: <input type="text" name ="month"  placeholder="mm" size="4"> <input type ="text" name ="day" placeholder="dd" size="4">
	,<input type ="text" name = "year"  placeholder ="yyyy" size="4">
	
	Users Name: <input type="text" name="userName"><br />
	
	Available Items:<br />
	<select name="allItemsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allItems }" var ="currentItem">
		<option value = "${currentItem.id }">${currentItem.team } | ${currentItem.titles }</option>
	</c:forEach>
	</select>
	<br />
	<input type="submit" value ="Create list and Add Items">
	</form>
	<a href ="index.html">Add new Items Instead</a>
</body>
</html>