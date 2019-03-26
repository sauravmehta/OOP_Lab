public class LivingRoom extends Room implements IOperatingCost {
	private int	electricityBill;
	private boolean tvState; 
	
	LivingRoom(int roomLength, int roomWidth, int roomHeight){
		super(roomLength, roomWidth, roomHeight);
		this.electricityBill=0;
		this.tvState=false;
		
	}
	
	public int getBill(){
		return electricityBill;
	}
 	
	public boolean getTvState() {
		return tvState;
	}
 	
	public void use​(java.lang.String name) {
		if(name.equals("TV")) {
		if(tvState==false) {
			this.electricityBill+=10;
			this.tvState=true;
		}else {
			this.tvState=false;
		}
		}
	}
}

