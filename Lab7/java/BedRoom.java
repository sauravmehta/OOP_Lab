public class BedRoom extends Room implements IOperatingCost{

	private Bed bed;
    private boolean acState;
    private boolean sleepState;
    private int electricityBill;
    
    public BedRoom(int roomLength, int roomWidth, int roomHeight, Bed bed) {
    	super(roomLength,roomWidth, roomHeight);
    	this.electricityBill=0;
    	this.acState =false;
    	this.sleepState = false;
    	this.bed= bed;
    }
    
    public boolean getSleepState() {
    	return this.sleepState;
    }
    
    public boolean getAcState() {
    	return this.acState;
    }
    
    public int maintenanceCost() {
    	return this.bed.getCost();
    }
    
    public int getBill() {
    	return this.electricityBill;
    }
    
    public void use​(java.lang.String name) {
        if(name.equals("AC")){
    	if(acState==false) {
    		this.acState=true;
    		this.electricityBill += 10*getVolume();
    	}else {
    		this.acState=false;
    	}
        }
    	
    	if(name.equals("Bed")){
    	if(sleepState==false) {
    		this.sleepState=true;
    	}else {
    		this.sleepState=false;
    	}
    	}
    }
    
    

}
