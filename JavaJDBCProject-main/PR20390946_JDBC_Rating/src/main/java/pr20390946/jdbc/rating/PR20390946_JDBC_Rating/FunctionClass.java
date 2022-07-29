package pr20390946.jdbc.rating.PR20390946_JDBC_Rating;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FunctionClass 
{
	private Connection connection = null;
	PreparedStatement pstmt = null;
	private Statement st = null;
	int scoreCalculatorCounter = 0;
	
	public FunctionClass(){
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

	public boolean removeAssignment(int sNo) throws SQLException 
	{
		boolean flag = false;
		String query = "delete from AssignmentsTable where serialNo = ?";

		pstmt = connection.prepareStatement(query);
		pstmt.setInt(1, sNo);
		
		flag = pstmt.executeUpdate()> 0 ? true : false;
		return flag;
	}

	public boolean addAssignmentCategory( String assignCtgy, int wght) throws SQLException 
	{
		 
        st = connection.createStatement();
		boolean flag = false;
		
        ResultSet rs = st.executeQuery("select assignmentCategory from DistributionsTable");
		ArrayList<String> arrayList = new ArrayList<String>();
		 
	    while(rs.next()) {
	         arrayList.add(rs.getString("assignmentCategory"));
	      }
	    if(arrayList.contains(assignCtgy)) {
	    	flag = false;
	    }
	    else{
	    	String query = "insert into DistributionsTable(assignmentCategory,weight) values('"+assignCtgy+"','"+wght+"' )";
			flag = st.executeUpdate(query)> 0 ? true : false;
	    }
				
		return flag;
	}
	
	public boolean removeAssignmentCategory(String assignCtgy) throws SQLException 
	{
		boolean flag = false;
		String query = "delete from DistributionsTable where assignmentCategory = ?";

		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, assignCtgy);
		
		flag = pstmt.executeUpdate()> 0 ? true : false;
		return flag;
	}

	public void displayAssignmentCategory() throws SQLException {
		 
         Statement st = connection.createStatement();
		 String query = "select assignmentCategory, weight from DistributionsTable";
		 
         ResultSet rs = st.executeQuery(query);
         System.out.println("--------------------------------------");
         System.out.printf("%10s %15s", "Assignment Category" , "Weight");
         System.out.println("\n--------------------------------------");
         while (rs.next()) {

             String assign = rs.getString("assignmentCategory");
             String wght = rs.getString("weight");
             System.out.printf("\n%10s %20s", assign , wght);
         }
         rs.close();
	}
	

	public void readEnrolledSubject(String s) throws SQLException 
	{

	    Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select subject from AssignmentsTable");
		ArrayList<String> arrayList = new ArrayList<String>();
		 
	    while(rs.next()) {
	         arrayList.add(rs.getString("subject"));
	      }
	    
	    if(arrayList.contains(s))
	    {
		    String query = "select * from AssignmentsTable where subject = ?";
		 
		    pstmt = connection.prepareStatement(query);
		    pstmt.setString(1, s);
		    rs = pstmt.executeQuery();
	 		
		    System.out.println("--------------------------------------------------------------------------------");
		    System.out.printf("%5s %20s %14s %28s %20s %11s", "Serial No","Student Name","Subject","Assignment Category", "Date Of Submission", "Weight");
		    System.out.println("\n------------------------------------------------------------------------------");
		     
		    while (rs.next()) {
	
	             int sno = rs.getInt("serialNo");
	             String studentName = rs.getString("studentName");
	             String sub = rs.getString("subject");
	             String assign = rs.getString("assignmentCategory");
	             String dateOfSubmission = rs.getString("dateOfSubmission");
	             String wght = rs.getString("points");
	             System.out.printf("\n%5s %18s %30s %15s %15s %15s",sno,studentName,sub, assign,dateOfSubmission, wght);
	         }
		    rs.close();
		 }
	    else {
	    	System.out.println("Enter the valid Subject Name");
	    }
	}
	
	public boolean updateEnrolledSubject( String newsub,String sName, String assignCtgy, String sub) throws SQLException 
	{
		boolean flag = false;
		String query = "update AssignmentsTable set subject = ? where studentName=? and subject=? and assignmentCategory = ?";

		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, newsub);
		pstmt.setString(2, sName);
		pstmt.setString(3, sub);
		pstmt.setString(4, assignCtgy);
		
		flag = pstmt.executeUpdate()> 0 ? true : false;
		return flag;
	}
	
	public boolean removeEnrolledSubject(String sub, String name, String asgnCtgy) throws SQLException 
	{
		boolean flag = false;
		String query = "delete from AssignmentsTable where subject = ? and studentName = ? and assignmentCategory = ?";

		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, sub);
		pstmt.setString(2, name);
		pstmt.setString(3, asgnCtgy);
		
		flag = pstmt.executeUpdate()> 0 ? true : false;
		return flag;
	}	
	
	public boolean removeEnrollAssignment(String sub, String name, String asgnCtgy) throws SQLException 
	{
		boolean flag = false;
		String query = "delete from AssignmentsTable where subject = ? and studentName = ? and assignmentCategory = ?";

		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, sub);
		pstmt.setString(2, name);
		pstmt.setString(3, asgnCtgy);
		
		flag = pstmt.executeUpdate()> 0 ? true : false;
		return flag;
	}


	public boolean removeAssignmentsToStudent(String sname) throws SQLException 
	{
    	boolean flag = false;

		String query = "delete from AssignmentsTable where studentName = ?";

		pstmt = connection.prepareStatement(query);
		pstmt.setString(1, sname);
		
		flag = pstmt.executeUpdate()> 0 ? true : false;
		return flag;
	}

	public void readAssignmentsToStudent(String sname) throws SQLException 
	{

	    Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("select studentName from AssignmentsTable");
		ArrayList<String> arrayList = new ArrayList<String>();
		 
	    while(rs.next()) {
	         arrayList.add(rs.getString("studentName"));
	      }
	    
	    if(arrayList.contains(sname))
	    {
		    String query = "select * from AssignmentsTable where studentName = ?";
		 
		    pstmt = connection.prepareStatement(query);
		    pstmt.setString(1, sname);
		    rs = pstmt.executeQuery();
	 		
		    System.out.println("------------------------------------------------------------------------------------------------------------------------");
		    System.out.printf("%5s %20s %14s %28s %20s %11s", "Serial No","Student Name","Subject","Assignment Category", "Date Of Submission", "Points");
		    System.out.println("\n----------------------------------------------------------------------------------------------------------------------");
		     
		    while (rs.next()) {
	
	             int sno = rs.getInt("serialNo");
	             String studentName = rs.getString("studentName");
	             String sub = rs.getString("subject");
	             String assign = rs.getString("assignmentCategory");
	             String dateOfSubmission = rs.getString("dateOfSubmission");
	             String points = rs.getString("points");
	             System.out.printf("\n%5s %18s %30s %15s %15s %15s",sno,studentName,sub, assign,dateOfSubmission, points);
	         }
		    rs.close();
		 }
	    else {
	    	System.out.println("Enter the valid Student Name");
	    }
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
	

	public void displayAverageScoresEachStudent(String name) throws SQLException 
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

	    System.out.println("---------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("%10s %25s %18s %18s %18s %20s", "Subject","Test Score","Quiz Score","Lab Score", "Project Score", "Overall Rating(%)");
	    System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
		
	    while(rs.next()) {
	    	String sub = rs.getString("subject");
	    	float ts = rs.getFloat("testScore");
	    	float qs = rs.getFloat("quizScore");
	    	float ls = rs.getFloat("labScore");
	    	float ps = rs.getFloat("projectScore");
	    	float or = rs.getFloat("overallRating");
	 		System.out.printf("\n%20s %10s %20s %18s %15s %18s", sub ,ts,qs,ls,ps,or);
	    }

		    
         rs.close();
	}
	

	public void displayAverageScoresAllStudent(String sub) throws SQLException 
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
	    ResultSet rs1 = pstmt.executeQuery();

	    System.out.println("---------------------------------------------------------------------------------------------------------------------");
	    System.out.printf("%18s %18s %18s %18s %18s %20s", "Student Name","Test Score","Quiz Score","Lab Score", "Project Score", "Overall Rating(%)");
	    System.out.println("\n-------------------------------------------------------------------------------------------------------------------");
		
	    while(rs1.next()) {
	    	String name = rs1.getString("studentName");
	    	float ts = rs1.getFloat("testScore");
	    	float qs = rs1.getFloat("quizScore");
	    	float ls = rs1.getFloat("labScore");
	    	float ps = rs1.getFloat("projectScore");
	    	float or = rs1.getFloat("overallRating");
	 		System.out.printf("\n%15s %18s %18s %18s %15s %18s", name ,ts,qs,ls,ps,or);
	    }

		    
         rs.close();
	}
}
