<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="BookReview.books, BookReview.reviews, BookReview.detail, java.util.List"%>
<%
List<detail> detailList = (List<detail>) request.getAttribute("listdetail");
List<books> booksList = (List<books>) request.getAttribute("listbook");
List<reviews> reviewsList = (List<reviews>) request.getAttribute("listreview");
String user_name = (String) session.getAttribute("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookDetail</title>
</head>
<body>
	<h1>本の詳細とレビュー</h1>
	<%
	for (books Books : booksList) {
	%>
	<h2><%=Books.getTitle()%></h2>
	<p><%=user_name%>:ログイン中
	</p>
	<hr>
	<form action="/s2132008/BookListServlet" method="POST">
		<input type="submit" name="favorite" value="登録" ID="favorite">️
		<input type="submit" name="favorite" value="解除" ID="favorite">
	</form>
	<hr>
	<%
	}
	%>
	<%
	for (detail Detail : detailList) {
	%>
	<%
	if (Detail.getTitle() != null) {
	%>
	<p>
		<a href="BookDetailServlet?name=<%=Detail.getName()%>&user_id=<%=Detail.getUser_id()%>"><%=Detail.getName()%></a>
	</p>
	<p><%=Detail.getTitle()%></p>
	<p><%=Detail.getComment()%></p>
	<hr>

	<%
	}
	%>
	<%
	}
	%>

	<a href="BookReviewServlet">レビューを書く</a>
	<br>
	<a href="BookListServlet">一覧に戻る</a>
</body>
</html>