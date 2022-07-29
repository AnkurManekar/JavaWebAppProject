package pr20390946.webapp.rating.PR20390946_webapp_Rating;

public class Student {
	
	private String studentName;
	private String subject;
	private float testScore;
	private float quizScore;
	private float labScore;
	private float projectScore;
	private float overallRatings;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public float getTestScore() {
		return testScore;
	}
	public void setTestScore(float t) {
		this.testScore = t;
	}
	public float getQuizScore() {
		return quizScore;
	}
	public void setQuizScore(float quizScore) {
		this.quizScore = quizScore;
	}
	public float getLabScore() {
		return labScore;
	}
	public void setLabScore(float labScore) {
		this.labScore = labScore;
	}
	public float getProjectScore() {
		return projectScore;
	}
	public void setProjectScore(float projectScore) {
		this.projectScore = projectScore;
	}
	public float getOverallRatings() {
		return overallRatings;
	}
	public void setOverallRatings(float overallRatings) {
		this.overallRatings = overallRatings;
	}

}
