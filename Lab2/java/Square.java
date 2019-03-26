
public class Square {
	
	private int edge;
	private char colour;
	
 Square(int edge, char colour){
	this.edge = edge;
	this.colour = colour;
 }

public int getArea​() {
	return edge*edge;
}

public char getColour​() {
	return colour;
}	
	
}
