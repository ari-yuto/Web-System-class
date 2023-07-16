<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="BookReview.books, BookReview.reviews, BookReview.detailuser, java.util.List"%>
<%
List<detailuser> detailList = (List<detailuser>) request.getAttribute("listdetailuser");
List<books> booksList = (List<books>) request.getAttribute("listbook");
List<reviews> reviewsList = (List<reviews>) request.getAttribute("listreview");
String user_name = (String) request.getAttribute("Name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserDetail</title>
</head>
<body>
	<h1><%= user_name %></h1>
	<p>自己紹介</p>
	<br>↓投稿レビュー一覧
	<hr>
	<%for (detailuser Detail : detailList) { %>
	<p>
		<%=Detail.getReviews_title()%>
	</p>
	<p>
		<%=Detail.getComment()%></p>
	<hr>
	<%
	}%>

</body>
</html>