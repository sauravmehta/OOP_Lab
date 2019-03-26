public class SchoolMember
extends java.lang.Object{

	private java.lang.String name;
	private java.lang.String address;
	private int chanceOfPromotion; //In case of student, it will store the average grade and 
								   //in case of teacher, it stores the average feedback.
	
	public SchoolMember(java.lang.String name, java.lang.String address) {
		this.name=name;
		this.address=address;
	}
	
	protected void setChanceOfPromotion​(int chance) {
		this.chanceOfPromotion=chance;
	}
	
	//public java.lang.String toString(){
		
	//}
	
	public int promoted() {
		return chanceOfPromotion;
	}
}


	