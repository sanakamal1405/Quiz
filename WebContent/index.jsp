<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Technical Quiz</title>

</head>
<body>
<form action = "<%= request.getContextPath()%>/Controller" method="post">
Category : <select name ="Category">
<option> Linux </option>
<option> Bash </option>
<option> Docker </option>
<option> SQL </option>
<option> CMS </option>
<option> Code </option>
<option> DevOps </option>
</select>	<br/>
Tags : <select name ="Tags">
<option> BASH </option>
<option> DevOps </option>
<option> Docker </option>
<option> HTML </option>
<option> JavaScript </option>
<option> Kubernetes </option>
<option> Laravel </option>
<option> MySQL </option>
<option> PHP </option>
<option> WordPress </option>
</select>	<br/>
</br>

<input type="submit" value ="Let's Start!"> </input>
</form>


</body>
</html>