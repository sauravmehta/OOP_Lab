
public class Triangle 
extends java.lang.Object{
	private int height;
	private int base;
	private static int countTriangle=0;
	
	public Triangle(int height,
            int base) {
		this.height=height;
		this.base=base;
		countTriangle++;
	}
	
	public boolean isEnough() {
		if(countTriangle>=5) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isEnough(int enoughNumber) {
		if(countTriangle >= enoughNumber) {
			return true;
		}
		else {
			return false;
		}
	}
	
}


