package pr20390946.webapp.rating.PR20390946_webapp_Rating;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DisplayForEachSubjectServlet extends HttpServlet {
	StudentDao studentDao = new StudentDao();

	 ArrayList<Student> arrayList = new ArrayList<Student>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sName = request.getParameter("studentname");

		try {
			arrayList = studentDao.displayAverageScoresForEachSubject(sName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("student",arrayList);
		RequestDispatcher rd = request.getRequestDispatcher("displayForEachSubject.jsp");
		rd.forward(request, response);

	}

}
