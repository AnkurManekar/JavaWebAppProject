package pr20390946.webapp.rating.PR20390946_webapp_Rating;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class updatingServlet extends HttpServlet {

    StudentDao studentDao = new StudentDao();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		String sName = request.getParameter("studentname");
        String sub = request.getParameter("subject");
        String assignCtgy = request.getParameter("assignmentCategory");
        String dos = request.getParameter("dateOfSubmission");
        int pnts = Integer. parseInt(request.getParameter("points"));
		
    	try {
			if(studentDao.updation(sName,sub,assignCtgy,dos,pnts)) {
				response.sendRedirect("success.jsp");
			}
			else {
				response.sendRedirect("failed.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
