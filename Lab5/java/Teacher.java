public class Teacher extends SchoolMember {
	private int numCourses; //number of course
	private java.lang.String[] courses; //course codes
	private int[] credits; //credits for each course
	private int[] feedbacks;
	private static final int MAX_NUMBER_OF_COURSES =10; //10
	private static final int REQUIRED_PERCENTAGE_FOR_PROMOTION = 60; //60
	
	public Teacher(java.lang.String name, java.lang.String address) {
		super(name,address);
		this.numCourses=0;
		int credits[] = new int[MAX_NUMBER_OF_COURSES];
		int courses[] = new int[MAX_NUMBER_OF_COURSES];	
		int feedbacks[] = new int[MAX_NUMBER_OF_COURSES];	
	}
	
	public java.lang.String toString() {
		return super.toString();
	}
	
	public boolean floatCourse​(java.lang.String course, int credit) {
		for(int i=0; i<MAX_NUMBER_OF_COURSES; i++) {
		if(courses[i]==course && credits[i]==credit)
			return false;
		} return true;
		}
	
	public boolean addFeedback​(java.lang.String course, int feedback) {
		for(int i=0; i<MAX_NUMBER_OF_COURSES; i++) {
			if(courses[i]==course) {
				feedbacks[i]=feedback;
				return true;
			}
		}return false;
	}
	
	public int getAverageFeedback() {
		int average, sum=0;
		if(numCourses==0) { average=0;}

		for(int i=0; i < numCourses; i++) {
			sum=feedbacks[i];
		}
		average=sum/numCourses;
		super.setChanceOfPromotion​(average);
		
		return average;
	}
	
	public int promoted() {
		if(super.promoted()>60) {
			return 1;
		}
		else return 0;
	}

}
