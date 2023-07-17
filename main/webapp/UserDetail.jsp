<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="BookReview.users, BookReview.detailuser, java.util.List"%>
<%
List<detailuser> detailList = (List<detailuser>) request.getAttribute("listdetailuser");
List<users> usersList = (List<users>) request.getAttribute("listuser");
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
	<%for (users Users : usersList) { %>
	<%= Users.getBiography() %>
	<%
	}	%>
	<br>
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