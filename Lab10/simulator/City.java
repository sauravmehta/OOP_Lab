package simulator;
import resources.*;

/**
 * This class uses the classes in the Resources package to simulate tourists
 * coming to the city.
 * 
 * @author Ronak, Kunal, Hrishikesh, Alish
 * @version 20-November, 2018
 * 
 */
public class City {

	/**
	 * A Hotel with three star rating.
	 */
	public Hotel threeStarHotel;

	/**
	 * A Hotel with four star rating.
	 */
	public Hotel fourStarHotel;

	/**
	 * A Hotel with five star rating.
	 */
	public Hotel fiveStarHotel;

	/**
	 * A DiningHall
	 */
	public DiningHall diningHall;

	/**
	 * An array of Guests.
	 */
	public Guest[] guests;

	/**
	 * An array of Threads which are to be initialized with the guests.
	 */
	public Thread[] threads;
	
	public City(int numberOfRoomsInEachHotel, int baseRate, int diningHallCapacity, int[] wealth,int[] minHotelPreference) {
		this.threeStarHotel=new Hotel(3 , numberOfRoomsInEachHotel, 3*baseRate);
		this.fourStarHotel=new Hotel(4 , numberOfRoomsInEachHotel, 4*baseRate);
		this.fiveStarHotel=new Hotel(5 , numberOfRoomsInEachHotel, 5*baseRate);
		this.diningHall = new DiningHall(diningHallCapacity);
		
		guests= new Guest[wealth.length];
		threads = new Thread[wealth.length];
		
		
		for(int i=0; i<wealth.length; i++) {
			guests[i] = new Guest(wealth[i], minHotelPreference[i]);
			threads[i] = new Thread(guests[i]);
		}
	}

	public synchronized void simulateCity() {
		for(int i=0; i<guests.length; i++) {
			guests[i].initResources​(threeStarHotel, fourStarHotel, fiveStarHotel, diningHall);
			threads[i].setName("Guest"+threads[i].getId());
			threads[i].start();
		}
		for(int i=0; i<guests.length; i++) {
			try {
			threads[i].join();
			}catch(Exception ex) {
				System.out.print("s");
			}
		}
		
	}
}
