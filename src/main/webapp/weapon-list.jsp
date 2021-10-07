<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gear Collection - List</title>
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
<h1>Gear List</h1>
<form method = "post" action = "NavigationServlet">
<table>

<table>
<c:forEach items="${requestScope.allWeapons}" var="currentweapon">
<tr>
 <td><input type="radio" name="id" value="${currentweapon.id}"></td>
 <td>${currentweapon.name}</td>
 <td>${currentweapon.weaponType}</td>
 </tr>
</c:forEach>
</table>

</table>
<br />
<br />
<input type = "submit" value = "edit" name="doThisToWeapon">
<input type = "submit" value = "delete" name="doThisToWeapon">

</form>
<ul><li><a href = "index.html">Home</a></li></ul>
</body>
</html>