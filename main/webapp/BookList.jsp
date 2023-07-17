<%-- <%@page import="BookReview.BookListServlet"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="BookReview.books, java.util.List"%>
<%
List<books> booksList = (List<books>) request.getAttribute("listbook");
String user_name = (String) session.getAttribute("name");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookList</title>
</head>
<body>
	<h1>Book一覧</h1>
	<p><%=user_name%>:ログイン中
	<p>本のタイトル/著者名/出版日</p>
	</p>
	<p>
		<a href="FavoriteListServlet">あなたのお気に入りはこちら</a>
	<ul>
		<%
		for (books Books : booksList) {
		%>
		<li><a href="BookListServlet?ID=<%=Books.getId()%>"> <%=Books.getTitle()%>/<%=Books.getAuthor()%>/<%=Books.getCreated_at()%></a></li>
			<br>
			<%}%>
		
	</ul>
	<form action="/s2132008/BookListServlet" method="POST">
		<input type="submit" name="submit" value="ログイン画面に戻る" id="submit" />
	</form>
</body>
</html>