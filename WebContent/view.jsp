<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz</title>
<style type="text/css">
.question{
margin : 25px;
margin-color : black;
border : 100px;
border-color : red;

color : teal;
}
.option{
margin-color : black;
margin : 20px;

}
.answer
{
padding : 25px;
padding-color : black;
}
</style>

</head>
<body>
<% String ans=request.getAttribute("ans").toString(); 
	%>
	
<div class="question"><h1>Question : <%= request.getAttribute("question") %></h1></div>

<div class="option"> <h2> Option A: <%= request.getAttribute("option_A") %></h2> </div>
<div class="option"> <h2> Option B: <%= request.getAttribute("option_B") %></h2> </div>
<div class="option"> <h2> Option C: <%= request.getAttribute("option_C") %></h2> </div>
<div class="option"> <h2> Option D: <%= request.getAttribute("option_D") %></h2> </div>


<input type="button" value="Answer" onclick ="show()"> : <%= ans %>

<form action="index.jsp">
<br/>
<br/>
</br>
</br>
<center><input type="submit" value="Next Quiz"/></center>
</form>

<script type="text/javascript">
function show()
{
	document.write(ans);
	}
</script>
</body>
</html>