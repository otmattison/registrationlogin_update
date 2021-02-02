<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action='update2' method='POST'>
		<p>
		<div class="container">
			<label>UserID :</label> <input type="text"
				placeholder="user id number" name="id" required> <br>
			<br> <label>FirstName : </label> <input type="text"
				placeholder="firstname" name="firstName" required> <br>
			<br> <label>LastName : </label> <input type="text"
				placeholder="lastname" name="lastName" required> <br>
			<br> <label>Username : </label> <input type="text"
				placeholder="Enter Username" name="username" required> <br>
			<br> <label>Password : </label> <input type="password"
				placeholder="Enter Password" name="password" required> <br>
			<br>
			<button type="submit">Update</button>
		</div>
		</p>




	</form>
</body>
</html>