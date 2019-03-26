public class Shape {


private Triangle[] triangleList;
private Square[] squareList;
private int squareCount;
private int triangleCount;



public Shape() {
	triangleList = new Triangle[10];
	squareList = new Square[10];
	 squareCount=0;
	 triangleCount=0;
}

public int getSquareCount​() {
	return this.squareCount;
}

public int getTriangleCount​() {
	return this.triangleCount;
}

public boolean insertTriangle​(Triangle triangle) {
	if(triangleCount<10) {
		triangleList[triangleCount]=triangle;
		 triangleCount++;
		 return true;
	}else {
		return false;
	}
}

public boolean insertSquare​(Square square) {
	if(squareCount<10) {
		squareList[squareCount]=square;
		squareCount++;
		 return true;
	}else {
		return false;
	}
}


public char getColourOfMaxSquare​() {
	char ans = squareList[0].getColour​();
	int area= squareList[0].getArea​();
			
			if(squareCount==0) {
				return 'N';
			}
			
			for(int i=0; i<squareCount; i++) {
				 if(squareList[i].getArea​()>area) {
					area=squareList[i].getArea​();
					ans=squareList[i].getColour​();
				 }	
				}
			return ans;
}

public char getColourOfMaxTriangle​() {
	char ans = triangleList[0].getColour​();
	int Area= triangleList[0].getArea​();
			if(triangleCount==0) {
				return 'N';
			}
			for(int i=0; i<triangleCount; i++) {
				 if(triangleList[i].getArea​()>Area) {
					Area=triangleList[i].getArea​();
					ans=triangleList[i].getColour​();
				}
				}					
			return ans;
}

}
