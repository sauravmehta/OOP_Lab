
public class Student extends SchoolMember {
	private int numCourses;
	private int numCredits;
	private java.lang.String[] courses;
	private int[] grades;
	private static final int MAX_NUMBER_OF_COURSES=4; //(4)
	private static final int MAX_CREDITS=20; //20
	protected int minCredits;
	private static final int REQUIRED_PERCENTAGE_FOR_PROMOTION=75; //75
	
	public Student(java.lang.String name, java.lang.String address) {
		super(name,address);
		this.numCourses =0;
		this.minCredits =10;
		int grades[] = new int[4];
		int courses[] = new int[4];	
	}
	
	public java.lang.String toString(){
		return super.toString();
	}
	


	public boolean registerCourse​(java.lang.String course,int credit) {
		if(credit<=MAX_CREDITS) {
			for(int i=0; i<4; i++) {
				if(courses[i]==course) { return false;}
			}
			return true;
		}else return false;
	}
	
	public boolean isRegistrationSuccessful() {
		if(numCredits>=minCredits && numCredits<=MAX_CREDITS) {
			return true;
		}else return false;
	}

	public boolean addGrades​(java.lang.String course, int grade) {
		for(int i=0; i<4; i++) {
			if(courses[i]==course) {
				grades[i]=grade;
				return true;
			}
		}return false;
	}
	
	private boolean enoughCourseSlots() {
		if(numCourses<=MAX_NUMBER_OF_COURSES) {
			return true;
		}
		else return false;
	}
	
	private boolean exceedsMaxCredits​(int credit) {
		if(credit<=MAX_CREDITS) {
			return false;
		}return true;
	}
	
	public int getAverageGrade() {
		int average, sum=0;
		if(numCourses==0) { average=100;}

		for(int i=0; i < numCourses; i++) {
			sum=grades[i];
		}
		average=sum/numCourses;
		super.setChanceOfPromotion​(average);
		
		return average;
	}
	
	public int promoted() {
		if(super.promoted()>75) {
			return 1;
		}
		else return 0;
	}
	
	public boolean removeCourse​(java.lang.String course) {
		for(int i=0; i<4; i++) {
			if(courses[i]==course) {
				courses[i]=courses[i+1];
				return true;
			}
		}
		return false;
	}
	
	public int getMinCredits() {
		return minCredits;
	}
	
	public int getNumberOfCourses() {
		return numCourses;
	}
}

