<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String user_name = (String) session.getAttribute("name");
int book_id = (int)session.getAttribute("book_id");
%>
<html>
<head>
<meta charset="UTF-8">
<title>BookReview</title>
</head>
<body>
	<h1>本のレビュー入力</h1>
	<form action="/s2132008/BookReviewServlet" method="POST">
		<p><%=user_name%>:ログイン中</p>
		レビュータイトル<input type="text" name="newtitle" id="newtitle" required><br>
		レビュー内容<textarea type="text" name="newreview" id="newreview" required></textarea><br>
		<input type="submit" value="登録" id = "submit"/>
		<a href="BookListServlet?ID=<%= book_id %>">一つ前に戻る</a>
	</form>
</body>
</html>