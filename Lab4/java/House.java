
public class House {
	private int baseLength;
	private int baseWidth;
	private int countRooms;
	private int height;
	private int houseNumber;
	private char houseType;
	private int pyramidHeight;
	public Cuboid[] rooms;
	public Pyramid houseTop;
	
	public House(int maxNoOfRooms, int houseNumber, int baseLength, int baseWidth, int height, int pyramidHeight, char houseType) {
		this.rooms = new Cuboid[maxNoOfRooms];
		this.houseNumber = houseNumber;
		this.baseLength = baseLength;
		this.baseWidth = baseWidth;
		this.height = height;
		this.pyramidHeight = pyramidHeight;
		this.houseType = houseType;	
	}
	
	public int getHouseNumber() {
		return this.houseNumber;
	}
	
	public int getCountRooms() {
		return this.countRooms;
	}
	
	public int getBadWalls() {
		int badWalls = 0;
		for(int i = 0; i < this.countRooms;i++) {
			for(int j = 0;j < 6;j++) {
				if(this.rooms[i].walls[j].getWallCondition() == 'b') {
					badWalls++;
				}
			}
		}
		return badWalls;
	}
	
	public int getSurfaceArea() {
		return 2*(this.height)*(this.baseLength + this.baseWidth) + this.houseTop.getSurfaceArea();
	}
	
	public char getHouseType() {
		return this.houseType;
	}
	
	public int getRent() {
		int rent = 0;
		if(this.houseType == 'c') {
			for(int i = 0;i < this.countRooms;i++) {
				rent += this.rooms[i].getCost();
			}
		} else if(this.houseType == 'r') {
			rent =  this.getSurfaceArea();
		}
		return rent;
	}
	
	public int freeSpace() {
		int constructedArea = 0;
		int baseArea;
		baseArea = this.baseLength*this.baseWidth*this.height;
		for(int i = 0;i < this.countRooms;i++) {
			constructedArea += this.rooms[i].getVolume();
		}
		return (baseArea - constructedArea);
	}
	
	public int houseVolume(){
		return this.baseLength*this.baseWidth*this.height + this.houseTop.getVolume();
	}
	public class Pyramid{
		private int pyramidBaseLength;
		private int pyramidBaseWidth;
		private int pyramidHeight;
		public Triangle[] roofWalls;
		
		public Pyramid() {
			this.pyramidHeight = House.this.pyramidHeight;
			this.pyramidBaseLength = House.this.baseLength;
			this.pyramidBaseWidth = House.this.baseWidth;
			this.roofWalls = new Triangle[4];
		}
		
		public class Triangle{
			private int baseSide;
			private char triangleType;
			private int wallSide1;
			private int wallSide2;
			
			public Triangle(char triangleType, int side1, int side2) {
				if(triangleType == 'w') {
					this.baseSide = Pyramid.this.pyramidBaseWidth;
				} else if(triangleType == 'l') {
					this.baseSide = Pyramid.this.pyramidBaseLength;
				}
				this.wallSide1 = side1;
				this.wallSide2 = side2;
			}
			
			public int getTriangleArea() {
				final int s = (this.wallSide1 + this.wallSide2 + this.baseSide)/2;
				return (s)*(s-this.wallSide1)*(s-this.wallSide2)*(s-this.baseSide);
			}
		}
		
		public int getVolume() {
			return (this.pyramidHeight)*(this.pyramidBaseLength)*(this.pyramidBaseWidth)/3;
		}
		
		public int getSurfaceArea() {
			int surfaceArea = 0;
			for(int i = 0;i < 4;i++) {
				surfaceArea += Pyramid.this.roofWalls[i].getTriangleArea();
			}
			return surfaceArea;
		}
	}
	
	public class Cuboid{
		private int cost;
		private int roomHeight;
		private int roomLength;
		private int roomWidth;
		public Rectangle[] walls;
		
		public Cuboid(int length, int width, int cost) {
			House.this.countRooms++;
			this.walls = new Rectangle[6];
			this.roomHeight = height;
			this.roomLength = length;
			this.roomWidth = width;
			this.cost = cost;
		}
		
		public Cuboid(int length, int width) {
			House.this.countRooms++;
			this.walls = new Rectangle[6];
			this.cost = 0;
			this.roomHeight = House.this.height;
			this.roomLength = length;
			this.roomWidth = width;
		}
		
		public int getCost() {
			return this.cost;
		}
		
		public int getVolume() {
			return (this.roomHeight)*(this.roomLength)*(this.roomWidth);
		}
		
		public class Rectangle{
			private int wallLength;
			private char wallState;
			private char wallType;
			private int wallWidth;
			
			public Rectangle(char wallType, boolean isRaining) {
				this.wallType = wallType;
				if(isRaining)
					this.wallState = 'b';
				else this.wallState = 'g';
			}
			
			public int getArea() {
				return (this.wallLength)*(this.wallWidth);
			}
			
			public char getWallCondition() {
				return this.wallState;
			}
		}
	}
}
