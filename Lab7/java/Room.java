


public abstract class Room extends java.lang.Object implements IRoom{
	protected int roomLength;
	protected int roomWidth;
	protected int roomHeight;
	
	public Room(int roomLength, int roomWidth,int roomHeight) {
		this.roomLength=roomLength;
		this.roomWidth=roomWidth;
		this.roomHeight=roomHeight;
	}
	
	protected int getVolume() {
		return roomLength*roomWidth*roomHeight;
	}
	
	protected int getSurfaceArea() {
		return 2*(roomLength*roomWidth+roomLength*roomHeight+roomWidth*roomHeight);
	}
	
	public abstract int getBill() ; 
	
}
