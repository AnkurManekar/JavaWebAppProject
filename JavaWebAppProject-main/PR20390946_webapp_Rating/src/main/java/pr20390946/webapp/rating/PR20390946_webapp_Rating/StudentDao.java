package pr20390946.webapp.rating.PR20390946_webapp_Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentDao 
{
	private Connection connection = null;
	PreparedStatement pstmt = null;
	private Statement st = null;
	int scoreCalculatorCounter = 0;
	
	public StudentDao(){
		connection = ConnectionDone.getConnection();
	}
	public boolean addAssignment( int srlNo, String sName, String sub, String asgCtgry, String dos, int pnts) throws SQLException 
	{
		boolean flag = false;
		String query = "insert into AssignmentsTable(serialNo,studentName,subject,assignmentCategory,dateOfSubmission,points) values('"+srlNo+"', '"+sName+"','"+sub+"','"+asgCtgry+"','"+dos+"','"+pnts+"' )";
				
		st = connection.createStatement();
		flag = st.executeUpdate(query)> 0 ? true : false;
		return flag;
	}
	
	public boolean updation( String sName, String sub, String asgCtgry, String dos, int pnts) throws SQLException 
	{
		boolean flag = false;
		String query = "update AssignmentsTable set dateOfSubmission = ? , points = ? where studentName=? and subject=? and assignmentCategory = ?";

		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, dos);
		pstmt.setInt(2, pnts);
		pstmt.setString(3, sName);
		pstmt.setString(4, sub);
		pstmt.setString(5, asgCtgry);
		
		flag = pstmt.executeUpdate()> 0 ? true : false;
		return flag;
	}
	
	
	
	
	public void scoreCalculator() throws SQLException 
	{

	    String query = "select distinct studentName from AssignmentsTable";
	 
	    pstmt = connection.prepareStatement(query);
	    ResultSet rs = pstmt.executeQuery();
 		 
 		ArrayList<String> nameList = new ArrayList<String>();
		 
	    while(rs.next()) {
	    	nameList.add(rs.getString("studentName"));
	    }
	    
		for(String name : nameList) 
		{
		    query = "select distinct subject from AssignmentsTable where studentName = ?";
		 
		    pstmt = connection.prepareStatement(query);
		    pstmt.setString(1, name);
		    rs = pstmt.executeQuery();
	 		 
	 		ArrayList<String> arrayList = new ArrayList<String>();
			 
		    while(rs.next()) {
		    	 arrayList.add(rs.getString("subject"));
		    }
		    
		    for(String std : arrayList) {
		        float t = 0 , p= 0, q=0, l=0;
		        int ct = 0, cp = 0, cq = 0, cl = 0;
		    	query = "select assignmentCategory, points from AssignmentsTable where studentName = ? and subject = ? ";
		    	HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		    	
			    pstmt = connection.prepareStatement(query);
			    pstmt.setString(1, name);
			    pstmt.setString(2, std);
			    rs = pstmt.executeQuery();
		    
			    while(rs.next()) {
		             String assign = rs.getString("assignmentCategory");
		             int pnt = rs.getInt("points");
		             hashMap.put(assign, pnt);
			    }
	
			    for (Map.Entry<String,Integer> entry : hashMap.entrySet()) 
		    	{
			    	if((entry.getKey().split("_")[0]).equals("test")) {
			    		t = t + entry.getValue();
			    		ct = Math.max(Integer.parseInt(entry.getKey().split("_")[1]), ct);
			    	}
			    	
			    	else if((entry.getKey().split("_")[0]).equals("quiz")) {
			    		q = q + entry.getValue();
			    		cq = Math.max(Integer.parseInt(entry.getKey().split("_")[1]), cq);
			    	}
	
			    	else if((entry.getKey().split("_")[0]).equals("lab")) {
			    		l = l + entry.getValue();
			    		cl = Math.max(Integer.parseInt(entry.getKey().split("_")[1]), cl);
			    	}
			    	
			    	else if((entry.getKey().split("_")[0]).equals("project")) {
			    		p = p + entry.getValue();
			    		cp = Math.max(Integer.parseInt(entry.getKey().split("_")[1]), cp);
			    	}
			    	          
		    	}
				
			    if(t>0)
			    {
			    	String Test = "Test";
				    query = "select weight from DistributionsTable where assignmentCategory = ?";
				 
				    pstmt = connection.prepareStatement(query);
				    pstmt.setString(1, Test);
				    rs = pstmt.executeQuery();
				    rs.next();
				    
					int wp = rs.getInt("weight");	
				    
				    t = (t * wp) / (100 * ct);
			    }
			    
				
			    if(q>0)
			    {
			    	String Quiz = "Quiz";
				    query = "select weight from DistributionsTable where assignmentCategory = ?";
				 
				    pstmt = connection.prepareStatement(query);
				    pstmt.setString(1, Quiz);
				    rs = pstmt.executeQuery();
				    rs.next();
				    
				    int wp = rs.getInt("weight");
				    
				    q = (q * wp) / (100 * cq);
			    }
			    			
			    if(l>0)
			    {
			    	String Lab = "Lab Work";
				    query = "select weight from DistributionsTable where assignmentCategory = ?";
				 
				    pstmt = connection.prepareStatement(query);
				    pstmt.setString(1, Lab);
				    rs = pstmt.executeQuery();
				    rs.next();		
				    
				    int wp = rs.getInt("weight");
				    
				    l = (l * wp) / (100 * cl);
			    }
			    			
			    if(p>0)
			    {
			    	String Project = "Project";
				    query = "select weight from DistributionsTable where assignmentCategory = ?";
				 
				    pstmt = connection.prepareStatement(query);
				    pstmt.setString(1, Project);
				    rs = pstmt.executeQuery();
				    rs.next();	
				    
				    int wp = rs.getInt("weight");
				    
				    p = (p * wp) / (100 * cp);
			    }		    
		 		
			    float o = t + q + l + p;
			    
			    query = "insert into RatingCalculator(studentName,subject,testScore,quizScore,labScore,projectScore, overallRating) values('"+name+"', '"+std+"','"+t+"','"+q+"','"+l+"','"+p+"','"+o+"' )";

				st = connection.createStatement();
				st.executeUpdate(query);
			    
	    	}
		}

		query = "update RatingCalculator set counter = 1";

		st = connection.createStatement();
		st.executeUpdate(query);
		rs.close();
	}
	

	public ArrayList<Student> displayAverageScoresForEachSubject(String name) throws SQLException 
	{
		String query = "select counter from RatingCalculator";
		 
	    pstmt = connection.prepareStatement(query);
	    ResultSet rs = pstmt.executeQuery();
	    rs.next();
	    scoreCalculatorCounter = rs.getInt("counter");
	    
		if(scoreCalculatorCounter == 0) {
			scoreCalculator();
		}
		
		query = "select * from RatingCalculator where studentName = ?";

	    pstmt = connection.prepareStatement(query);
	    pstmt.setString(1, name);
	    rs = pstmt.executeQuery();
		 
		ArrayList<Student> arrayList = new ArrayList<Student>();
		 
	    while(rs.next()) {
	    	  Student student = new Student();
	    	 
	    	  student.setStudentName(rs.getString("studentName"));
	    	  student.setSubject(rs.getString("subject"));
	    	  student.setTestScore(rs.getFloat("testScore"));
	    	  student.setQuizScore(rs.getFloat("quizScore"));
	    	  student.setLabScore(rs.getFloat("labScore"));
	    	  student.setProjectScore(rs.getFloat("projectScore"));
	    	  student.setOverallRatings(rs.getFloat("overallRating"));
	          arrayList.add(student);
	      }

          rs.close();
	      return arrayList;
	}
	

	public ArrayList<Student> displayAverageScoresForAllStudent(String sub) throws SQLException 
	{
		String query = "select counter from RatingCalculator";
		 
	    pstmt = connection.prepareStatement(query);
	    ResultSet rs = pstmt.executeQuery();
	    rs.next();
	    scoreCalculatorCounter = rs.getInt("counter");
	    
		if(scoreCalculatorCounter == 0) {
			scoreCalculator();
		}
		
		query = "select * from RatingCalculator where subject = ?";

	    pstmt = connection.prepareStatement(query);
	    pstmt.setString(1, sub);
	    rs = pstmt.executeQuery();
		 
		ArrayList<Student> arrayList = new ArrayList<Student>();
		 
	    while(rs.next()) {
	    	  Student student = new Student();
	    	 
	    	  student.setStudentName(rs.getString("studentName"));
	    	  student.setSubject(rs.getString("subject"));
	    	  student.setTestScore(rs.getFloat("testScore"));
	    	  student.setQuizScore(rs.getFloat("quizScore"));
	    	  student.setLabScore(rs.getFloat("labScore"));
	    	  student.setProjectScore(rs.getFloat("projectScore"));
	    	  student.setOverallRatings(rs.getFloat("overallRating"));
	          arrayList.add(student);
	      }

          rs.close();
	      return arrayList;
	}
	

}
