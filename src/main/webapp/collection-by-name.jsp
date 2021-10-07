<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Lists</title>
<style>
a:link {text-decoration: none;}
a:visited {text-decoration: none;}
a:link {color: black;}
a:visited {color: black;}
a:hover {color: purple;}
body {background-color: #bce6df;}
</style>
</head>
<body>
<h1>All Collections</h1>
<form method = "post" action = "collectionNavigationServlet">

<table>
<c:forEach items="${requestScope.allLists}" var="currentlist">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.id}"></td>
		<td><h2>${currentlist.collectionName}</h2></td></tr>
	
	<c:forEach var = "listVal" items = "${currentlist.listOfWeapons}">
		<tr><td></td>
			<td colspan="3">
			${listVal.name}, ${listVal.weaponType}
			</td>
		</tr>
	</c:forEach>
</c:forEach>
</table>

<br />
<br />

<input type = "submit" value = "edit" name="doThisToList">
<input type = "submit" value = "delete" name="doThisToList">


</form>

<br />
<br />
<ul>
	<li><a href="addWeaponsForCollectionServlet">Create a new Collection</a></li>
	<li><a href="index.html">Home</a></li>
</ul>


</body>
</html>