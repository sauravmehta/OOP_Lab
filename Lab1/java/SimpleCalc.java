public class SimpleCalc {

public float calculate​(int firstOperand,int secondOperand, char operator) {
		if(operator=='+') {
			return (float)(firstOperand+secondOperand);
		}
		if(operator=='-') {
			return (float)(firstOperand-secondOperand);
		}
		if(operator=='*') {
			return (float)(firstOperand*secondOperand);
		}
		if(operator=='/') {
			if(secondOperand!=0) {
			return (float)(firstOperand/secondOperand);
			}
		}
		return (float)firstOperand;	
	}

	public void typeCast​(float value, char type){
		
		if(type =='b' ) {
			System.out.printf("Byte: "+(byte)value);
		}
		else if(type =='i' ) {
			System.out.printf("Int: "+(int)value);
		}
		else if(type =='c' ) {
			System.out.printf("Char: "+(char)value);
		}else {
			System.out.printf("Invalid type");
		}
	
	}
	
}
