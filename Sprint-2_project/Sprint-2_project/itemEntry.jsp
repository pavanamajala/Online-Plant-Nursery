<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
try{
	Class.forName("org.postgresql.Driver");
	Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/project","postgres","Pa1@123!");
	java.sql.Statement st=con.createStatement();
	
	String itemid=request.getParameter("user");
	String name=request.getParameter("pass");
	
	
	String qry="insert into test values("+ itemid+", '"+name+"')";
	int x=st.executeUpdate(qry);
	if(x>0) out.println("insertion successfull check your table!!!");
	con.close();
	
} catch(Exception e){
	System.out.println("Error is : "+e);
}

%>
</body>
</html>