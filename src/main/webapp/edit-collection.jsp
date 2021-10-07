<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Edit An Existing Collection</title>
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
<h1>Collection Editor</h1>
<form action = "editCollectionServlet" method="post">
<input type ="hidden" name = "id" value= "${collectionToEdit.id}">
Collection Name: <input type ="text" name = "collectionName" value="${collectionToEdit.collectionName}"><br />

Available Weapons:<br />

<select name="allItemsToAdd" multiple size="6">
<c:forEach items="${requestScope.allItems}" var="currentitem">
 <option value = "${currentitem.id}">${currentitem.name} - ${currentitem.weaponType}</option>
</c:forEach>
</select>
<br /><br />
<input type = "submit" value="Edit collection and add weapons">
</form>
<br />
<br />
<ul><li><a href = "index.html">Home</a></li></ul>
</body>
</html>