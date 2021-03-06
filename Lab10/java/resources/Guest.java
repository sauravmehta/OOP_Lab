package resources;

/**
 * This class represents Guests who will be booking a room in a Hotel and eat in
 * a common Dining Hall.
 * 
 * @author Ronak, Kunal, Hrishikesh, Alish
 * @version 20-November, 2018
 * 
 */
public class Guest implements Runnable{

	
	
	/**
	 * This gives the wealth of the Guest, i.e. which hotel room he/she can afford.
	 */
	private int wealth;

	/**
	 * This is the minimum hotel rating preference of the particular Guest while
	 * booking a Hotel room.
	 */
	private int minHotelPreference;

	/**
	 * This stores the rating of the hotel. Initially it is 0. If no hotel is
	 * alloted to the Guest i.e. all hotels above his preference are not affordable
	 * to him, then it is set to -1.
	 */
	private int hotelAlloted;

	/**
	 * This is set true when the Guest has dined in the Dining Hall. Initially it is
	 * false.
	 */
	public boolean hasDined;

	/**
	 * This is array of hotels of size 3 in which 0th index contains threeStarHotel,
	 * 1st index contains fourStarHotel and 2nd preference contains fiveStarHotel.
	 */
	public Hotel hotels[]= new Hotel[3];

	/**
	 * This is the common dining hall of the city where a guest will have his
	 * breakfast if alloted a hotel.
	 */
	public DiningHall diningHall;

	/**
	 * Guest information should return a string, in the given format: <wealth> + " "
	 * + <minHotelPreference> + " " + <hotelAlloted> + " " + <hasDined> Example: If
	 * wealth of guest is 50, its min hotel preference is 4, hotel alloted to him is
	 * 5 and its hasdined is true. then the string it should return be "50 4 5 true"
	 * 
	 * @return Returns Guest information
	 */
	
	public Guest(int wealth, int minHotelPreference) {
	this.wealth=wealth;
	this.minHotelPreference=minHotelPreference;
	this.hotelAlloted =0;
	this.hasDined= false;
	}
	
	public void initResources​(Hotel threeStarHotel, Hotel fourStarHotel, Hotel fiveStarHotel,DiningHall diningHall) {
		this.hotels[0]=threeStarHotel;
		this.hotels[1]=fourStarHotel;
		this.hotels[2]=fiveStarHotel;
		this.diningHall=diningHall;
	}
	
public synchronized boolean bookRoom() {
		for(int i=2; i>=0; i--) {
		if(this.wealth>=this.hotels[i].getCost() && this.minHotelPreference<=hotels[i].getRating() && hotels[i].checkIn()) {
			hotelAlloted=hotels[i].getRating();
			try {
			Thread.sleep(1);
			}catch(Exception ex) {
				System.out.print("s");
			}
			return true;
		}
		}
		return false;	
		}
	
	
	public void run() {
		boolean book = this.bookRoom();
		boolean rebook = false;
		if(book==false) {
			try {
				Thread.sleep(5);
				}catch(Exception ex) {
					System.out.print("s");
				}
			rebook= this.bookRoom();
		if(rebook==false) {
			this.hotelAlloted=-1;
		}
		}
		
		if(book || rebook) {
			boolean enterDining= false;
			while(!(enterDining=this.diningHall.enterDiningHall())) {
				try {
					Thread.sleep(2);
					}catch(Exception ex) {
						System.out.print("s");
					}
			}
			
			if(enterDining) {
				try {
					Thread.sleep(1);
					}catch(Exception ex) {
						System.out.print("s");
					}
				
				this.hasDined=true;
				this.diningHall.exitDiningHall();
				this.hotels[this.hotelAlloted-3].checkOut();
			}
		}
	}
	
	
	
	
	public String getInfo() {
		return Integer.toString(this.wealth) + " " + Integer.toString(this.minHotelPreference) + " "
				+ Integer.toString(this.hotelAlloted) + " " + Boolean.toString(this.hasDined);
	}

}