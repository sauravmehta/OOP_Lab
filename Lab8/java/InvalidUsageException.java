
public class InvalidUsageException extends Exception{

	private String roomType;
	private String object;
	
	
	public InvalidUsageException (java.lang.String roomType, java.lang.String object) {
		super(roomType +  "cannot have" +object);
	}
}
