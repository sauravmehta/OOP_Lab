

public class WashRoom extends Room implements IOperatingCost{
	private int waterBill;
	
	public WashRoom(int roomLength, int roomWidth,int roomHeight) {
		super(roomLength,roomWidth, roomHeight);
		waterBill =0;
	}
	
	public int getBill() {
		return waterBill;
	}
	
	public int maintenanceCost() {
		return 42;
		}
	
	public void use​(java.lang.String name) {
		if(name.equals("Shower")) {
			waterBill+=10;
		}
		if(name.equals("Wash Basin")) {
			waterBill+=3;
		}
	}
}
