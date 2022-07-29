package pr20390946.jdbc.rating.PR20390946_JDBC_Rating;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class TestFunctionClass {

	@Test
	public void testAddAssignment() throws SQLException {
		FunctionClass fclass = new FunctionClass();
		boolean b = fclass.addAssignment(22, "Rani", "Computing Techniques", "test_2", "3-Aug-16", 100);
		assertTrue(b);
	}

	@Test
	public void testRemoveAssignment() throws SQLException {
		FunctionClass fclass = new FunctionClass();
		boolean b = fclass.removeAssignment(20);
		assertTrue(b);
	}

	@Test
	public void testAddAssignmentCategory() throws SQLException {
		FunctionClass fclass = new FunctionClass();
		boolean b = fclass.addAssignmentCategory( "Pre-Lab", 5);
		assertTrue(b);
		

		boolean b1 = fclass.addAssignmentCategory( "Test", 5);
		assertFalse(b1);
	}

	@Test
	public void testRemoveAssignmentCategory() throws SQLException {
		FunctionClass fclass = new FunctionClass();
		boolean b = fclass.removeAssignmentCategory("Pre-Lab");
		assertTrue(b);
	}
}
