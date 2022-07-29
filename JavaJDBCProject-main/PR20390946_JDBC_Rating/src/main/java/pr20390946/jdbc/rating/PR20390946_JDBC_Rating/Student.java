package pr20390946.jdbc.rating.PR20390946_JDBC_Rating;

import java.sql.SQLException;
import java.util.Scanner;

public class Student {	

	
    public static void main( String[] args ) throws SQLException
    {
		  FunctionClass fClass = new FunctionClass();
		 
		  Scanner sc = new Scanner(System.in);
		  int option = 0;
		  
		  do {
			  System.out.println("\n\nChoose Option: \n1.Add assignment to an existing list."
			  		+ "\n2.Remove assignment to an existing list."
			  		+ "\n3.Add assignment category with weights to an existing list."
			  		+ "\n4.Remove assignment category with weights to an existing list."
			  		+ "\n5.Display assignment categories with weights."
			  		+ "\n6.Create a student enrollment for subject."
			  		+ "\n7.Read student enrollment to subject."
			  		+ "\n8.Update student enrollment to subject."
			  		+ "\n9.Delete student enrollment for a subject."
			  		+ "\n10.Delete enrolling assignment to student."
			  		+ "\n11.Read enrolling assignment to student."
			  		+ "\n12.Display Average Scores per Assignment Category for each Subject"
			  		+ "\n13.Display Average Scores per Assignment Category for all Students"
			  		+ "\n14.Exit.");
	
		      
			  option = sc.nextInt();
			  
			  
			  int sNo = 0;
			  String name = null;
			  String subject = null;
			  String asgnCtgy = null; 
			  String dosub = null;
			  int point = 0;
			  int weight = 0;
		  	  boolean flag = false;
			  
			  switch (option) {
			  case 1: 
				  		System.out.println("Enter Serial");	    	
				  		sNo = sc.nextInt();
				  		
				  		System.out.println("Enter Student Name");
				  		name = sc.next();
				  		
				  		System.out.println("Enter Subject");
				  		sc.nextLine();
				  		subject = sc.nextLine();
				  		
				  		System.out.println("Enter Assignment Category");
				  		asgnCtgy = sc.next();
				  		
				  		System.out.println("Enter Date Of Submission");
				  		dosub = sc.next();
				  		
				  		System.out.println("Enter Points");
				  		point = sc.nextInt();
				  		
				  		flag = fClass.addAssignment(sNo, name, subject, asgnCtgy, dosub, point);
				  		
				  		if(flag) {
				    		System.out.println("Records has been added successfully");
				    	}
				    	else {
				    		System.out.println("Records has not been added successfully");
				    	}
				  		break;
			  		
			  case 2: 
			  		
			  		System.out.println("Enter Serial Number of the Assignment that you want to delete");
			  		sNo = sc.nextInt();
			  		
			  		flag = fClass.removeAssignment(sNo);
			  		
			  		if(flag) {
			    		System.out.println("Records has been removed successfully");
			    	}
			    	else {
			    		System.out.println("Records has not been removed successfully");
			    	}
			  		break;
			  		
			  
			  case 3: 
			  		
			  		System.out.println("Enter Assignment Category and Weight");
			  		asgnCtgy = sc.next();
			  		weight = sc.nextInt();
			  		
			  		flag = fClass.addAssignmentCategory(asgnCtgy, weight);
			  		
			  		if(flag) {
			    		System.out.println("Assignment Category with Weight has been added successfully");
			    	}
			    	else {
			    		System.out.println("Duplicate Assignment Categoryt!. Please enter different");
			    	}
			  		break;

			  case 4: 
			  		
			  		System.out.println("Enter Assignment Category that you want to delete");
			  		asgnCtgy = sc.next();
			  		
			  		flag = fClass.removeAssignmentCategory(asgnCtgy);
			  		
			  		if(flag) {
			    		System.out.println("Assignment Category with Weight has been removed successfully");
			    	}
			    	else {
			    		System.out.println("Assignment Category with Weight has not been removed successfully");
			    	}
			  		break;
			  		
			  case 5: 
			  		
				  	fClass.displayAssignmentCategory();
			  		break;
			  		
			  case 7: 
			  		
			  		System.out.println("Enter Subject name for the details of Enrollment Student");
			  		sc.nextLine();
			  		subject = sc.nextLine();
			  		
			  		fClass.readEnrolledSubject(subject);
			  		break;
			  		
			  case 8: 
			  		
			  		System.out.println("Enter Name, Assignment Category and Subject of a Student");
			  		name = sc.next();
			  		asgnCtgy = sc.next();
			  		sc.nextLine();
			  		subject = sc.nextLine();
			  		
			  		System.out.println("Enter the name of the Subject you want to enroll for");
			  		String newsub = sc.nextLine();
			  		
			  		flag = fClass.updateEnrolledSubject(newsub,name,asgnCtgy, subject);

			  		if(flag) {
			    		System.out.println("Student enrollment updated");
			    		
			    	}
			    	else {
			    		System.out.println("Please try again! Student enrollment not updated.");
			    	}				  		
			  		break;
			  	
			  case 9: 
			  		
			  		System.out.println("Enter Name,Assignment Category, Subject of Student for deleting enrollment ");
			  		name = sc.next();
			  		asgnCtgy = sc.next();
			  		sc.nextLine();
			  		subject = sc.nextLine();
			  		
			  		flag = fClass.removeEnrolledSubject(subject, name, asgnCtgy);
			  		
			  		if(flag) {
			    		System.out.println("Student enrollment removed");
			    		
			    	}
			    	else {
			    		System.out.println("Please try again! Student enrollment not removed.");
			    	}
			  		break;
			  		
			  case 10: 

				  	System.out.println("Enter Student Name");
			  		name = sc.next();
			  		
			  		flag = fClass.removeAssignmentsToStudent(name);
			  		
			  		if(flag) {
			    		System.out.println("Student enrollment removed");
			    		
			    	}
			    	else {
			    		System.out.println("Please try again! Student enrollment not removed.");
			    	}
			  		break;
			  		
			  case 11: 
				  
				  	System.out.println("Enter Student Name");
			  		name = sc.next();
			  		
			  		fClass.readAssignmentsToStudent(name);
			  		break;
			  		
			  case 12: 
			  		
			  		System.out.println("Enter Student Name");
			  		name = sc.next();
			  		
			  		fClass.displayAverageScoresEachStudent(name);
			  		break;
			  		
			  case 13: 
			  		
				  	System.out.println("Enter Subject Name");
				  	sc.nextLine();
			  		subject = sc.nextLine();
			  		
			  		fClass.displayAverageScoresAllStudent(subject);
			  		break;

		  		
		  }
			  
		  }while(option != 14);
    }
}
