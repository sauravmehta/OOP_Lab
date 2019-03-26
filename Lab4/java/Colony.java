
public class Colony {
	private int numberOfHouses;
	private House[] houses;
	
	public Colony() {
		houses = new House[10];
		this.numberOfHouses = 0;
	}
	
	public boolean addHouse(House house) {
		if((this.numberOfHouses + 1) > 10) {
			return false;
		} else {
			houses[this.numberOfHouses] = house;
			this.numberOfHouses++;
			return true;
		}	
	}
	
	public int getNumberOfHouses() {
		return this.numberOfHouses;
	}
	
	public int goodWalls() {
		int totalBadWalls = 0;
		int totalWalls = 0;
		for(int i = 0;i < this.numberOfHouses;i++) {
			totalBadWalls += this.houses[i].getBadWalls();
			totalWalls += 6*this.houses[i].getCountRooms();
		}
		return (totalWalls - totalBadWalls);
	}
	
	public int getRevenue() {
		int totalRevenue = 0;
		for(int i = 0;i < this.numberOfHouses;i++) {
			totalRevenue += this.houses[i].getRent();
		}
		return totalRevenue;
	}
	
}
