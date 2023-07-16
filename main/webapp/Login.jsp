<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login page</title>
</head>
<body>
	<h1>ログインページ</h1>
	<form action="/s2132008/LoginServlet" method="POST">
		ユーザー名<input type="text" name="name" required> <br> 
		パスワード <input type="password" name="passwd" required> <br> 
		<input type="submit" name="submit" value="ログイン"> <br>
	</form>
	<a href="NewLoginservlet">新規登録はこちら</a>
</body>
</html>