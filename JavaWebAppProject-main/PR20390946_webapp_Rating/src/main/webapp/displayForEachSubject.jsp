<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pr20390946.webapp.rating.PR20390946_webapp_Rating.Student" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Average Scores</title>
</head>
<body>		
		<%
	      	//java.util.ArrayList al = new java.util.ArrayList ();
			ArrayList<Student> al= new ArrayList<Student>();
			al = (ArrayList<Student>)request.getAttribute("student");

			out.println ("<h1>Average scores per assignment category for each subject</h1>");
			
	        if (al.size() == 0 )
	        out.println ("No Such Student");
	        else
	        {
	            for (Student student: al)
	            {
	            	out.println("<pre> -----------------------------------------</pre>");
	          		out.println ("Subject Name: " + student.getSubject());   
	          		out.println ("Test Score: " + student.getTestScore());   
	          		out.println ("Quiz Score: " + student.getQuizScore());   
	          		out.println ("Lab Score: " + student.getLabScore());   
	          		out.println ("Project Score: " + student.getProjectScore());   
	          		out.println ("Overall Ratings(%): " + student.getOverallRatings());   
	            }
	        }

      %>
</body>
</html>