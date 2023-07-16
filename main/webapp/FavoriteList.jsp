<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BookReview.favoritesbooks, java.util.List"%>
<%
List<favoritesbooks> favoritesList = (List<favoritesbooks>) request.getAttribute("listfavorite");
String user_name = (String) session.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FavoriteList</title>
</head>
<body>
	<h1><%=user_name %>のお気に入り</h1>
	<ul>
		<%
		for (favoritesbooks Favorites : favoritesList) {
		%>
		<li><a href="BookListServlet?ID=<%=Favorites.getBook_id()%>"> <%=Favorites.getTitle()%>/<%=Favorites.getAuthor()%>/<%=Favorites.getCreated_at()%></a></li>
		<br>
		<%}%>
	</ul>

</body>
</html>