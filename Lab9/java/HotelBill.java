import java.io.*;
import java.util.*;

public class HotelBill {
	private java.lang.String 	filename;
	private Hotel 	hotel;
	private static int 	MAX_NUMBER_OF_BED_ROOMS = 5;
	private static int 	MAX_NUMBER_OF_HOTEL_SUITES = 3;
	
	public HotelBill(java.lang.String filename) {
		this.filename = filename;
	}
	
	public int getCost() {
		if(this.hotel!=null)
			return this.hotel.getHotelCost();
		else return -1;
	}
	
	public int readContent() {
		try {
			HotelSuite[] suites = new HotelSuite[3];
			
			this.hotel = null;
			WashRoom w = null;
			LivingRoom l = null;
			BedRoom[] br = new BedRoom[5];
			
			int brcount=0;
			int suitecount=0;
			
			FileReader fin = new FileReader(this.filename);
			BufferedReader reader = new BufferedReader(fin);
			String line = reader.readLine();
			
			while(true) {
				line = reader.readLine();
				if(line == null)
					break;
				
				String[] list = line.split(":");
				
				if(list[0].equals("HotelSuite")) {

					suites[suitecount]=new HotelSuite(w,l,br);
					suitecount++;
					l = null;
					w = null;
					br = new BedRoom[5];
					brcount = 0;
				}
				else if(list[0].equals("Room")) {
					String[] lists = list[1].split(",");
					if(lists[0].equals("lr")) {
						l = new LivingRoom(Integer.parseInt(lists[1]),Integer.parseInt(lists[2]),Integer.parseInt(lists[3]));
					}
					else if(lists[0].equals("wr")) {
						w = new WashRoom(Integer.parseInt(lists[1]),Integer.parseInt(lists[2]),Integer.parseInt(lists[3]));
					}
					else if(lists[0].equals("br")) {

						
						br[brcount]=new BedRoom(Integer.parseInt(lists[1]),Integer.parseInt(lists[2]),Integer.parseInt(lists[3]));
						brcount++;
					}
				}
			}
			

			suites[suitecount]=new HotelSuite(w,l,br);
			suitecount++;
			
			reader.close();
			this.hotel = new Hotel(suites);
			return suitecount;
		
		}catch(IOException e) {
			System.out.println(e.toString());
			return -1;
		}
	}
	
	public void writeResult(java.lang.String content) {
		try(FileOutputStream fout = new FileOutputStream(this.filename))
				{
					fout.write('\n');
					for(int i=0;i<content.length();i++)
							fout.write(content.charAt(i));
				} catch(IOException e) {
					System.out.println(e);
				}
	}
	
	public static void main(java.lang.String[] args){
		int cost,rooms;
		String file = null;
		HotelBill bill;
		
		Scanner conin = new Scanner(System.in); 
		
		file = conin.nextLine();
		conin.close();
		
		bill = new HotelBill(file);
		rooms = bill.readContent();
		cost = bill.getCost();
		System.out.println("Total:"+rooms+","+cost);
		bill.writeResult("Total:"+rooms+","+cost);
		
	}
}
