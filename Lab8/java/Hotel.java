
public class Hotel {

	public HotelSuite[] hotelroom;
	public int total;
	
	public Hotel(HotelSuite... hotelroom) {
		this.hotelroom=hotelroom;
		total=0;
	}
	
	public int getHotelCost() {
		for(int j=0; j<hotelroom.length; j++) {
			total+=hotelroom[j].calculateCost();
		}
		return total;
	}
}
