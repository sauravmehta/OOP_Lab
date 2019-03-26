public class Quadrilateral 
extends java.lang.Object{

	private int[] edge;
	
	public Quadrilateral(int e) {
		edge=new int[4];
		this.edge[0]=e;
		this.edge[1]=e;
		this.edge[2]=e;
		this.edge[3]=e;
	}
	
	public Quadrilateral(int length,
            int breadth) {
		edge=new int[4];
		this.edge[0]=length;
		this.edge[1]=length;
		this.edge[2]=breadth;
		this.edge[3]=breadth;
	}
	
	public Quadrilateral(int edge1, int edge2, int edge3,int edge4) {
		edge=new int[4];
		this.edge[0]=edge1;
		this.edge[1]=edge2;
		this.edge[2]=edge3;
		this.edge[3]=edge4;
	}
	
	public int getPerimeter() {
		int sum=0;
		for(int i=0; i<4; i++) {
			sum+=edge[i];
		}
		return sum;
	}
	
	@Override
	public boolean equals(java.lang.Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null || obj.getClass()!=this.getClass() ) {
			return false;
		}
		
		Quadrilateral quadrilateral = (Quadrilateral) obj;
		
		if(this.getPerimeter()==quadrilateral.getPerimeter()) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		int x;
		 x = 17*37+edge.hashCode();
		
		return x;
		
	}
	
	
	
}
