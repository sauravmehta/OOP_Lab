
public class HotelSuite {

	public WashRoom w;
	public LivingRoom l;
	public BedRoom[] br;
	public int totalCost;
	
	public HotelSuite(WashRoom w, LivingRoom l, BedRoom... br) {
		this.totalCost=0;
		this.w = w;
		this.l=l;
		this.br=br;
	}
	
	public int calculateCost() {
		totalCost=w.getBill()+l.getBill();
		for(int i=0; i<br.length; i++) {
			totalCost+=br[i].getBill()+br[i].maintenanceCost();
		}
		return totalCost;
	}
}
