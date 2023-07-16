<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Login page</title>
</head>
<body>
	<h1>新規ログインページ</h1>
	<form action="/s2132008/NewLoginservlet" method="POST">
		ユーザー名<input type="text" name="newname" id="newname" required><br>
		パスワード<input type="password" name="newpasswd" id="newpasswd" required> <br>
		自己紹介<input type="text" name="newbiography" id="newbiography"> <br>
		<input type="submit" value="登録" id ="submit"><br>
	</form>
	<a href="LoginServlet">ログインはこちらから</a>
</body>
</html>