import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Starbucks {
	int orderNumber;
	int time;
	int day;
	char weekDay;
	String item;
	String size;
	double price;
	double cost;
	String type;
	int store;
	int customernumber;

	static Starbucks[] fillArray(String file) { 
		//declarations:
		try {
			Scanner scan = new Scanner(new BufferedReader(new FileReader(file)));//starbucks data
			List<Starbucks> parsedInputs = new ArrayList<Starbucks>();


			while(scan.hasNext()) {
				String[] data = scan.nextLine().split(", ");//splitting the starbucks data

				Starbucks input = new Starbucks();//setting each item from starbucks data to a variable
				input.orderNumber = Integer.parseInt(data[0]);
				input.time = Integer.parseInt(data[1]);
				input.day = Integer.parseInt(data[2]);
				input.weekDay = data[3].toCharArray()[0];
				input.item = data[4];
				input.size = data[5];
				input.price = Double.parseDouble(data[6]);
				input.cost = Double.parseDouble(data[7]);

				parsedInputs.add(input);
			}//close while

			scan.close();
			return parsedInputs.toArray(new Starbucks[0]);
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();}
		return new Starbucks[0];}
	public static void main(String[] args) {
		Starbucks[] data = fillArray("starbucks_data");
		
		char initDay = 0; 
		int initMinutes = 0;
		int minutes = 0;
		boolean newInit = true;
		
		for(int i = 0; i < data.length; i++){
			if(newInit){
				initDay = data[i].weekDay;
				initMinutes = data[i].time;
				newInit = false;
			}
			if(initDay != data[i].weekDay){
				minutes += data[i-1].time - initMinutes;
				newInit = true;
			}
		}
		int numCustomers = data[data.length-1].orderNumber - data[0].orderNumber;
		System.out.println(numCustomers);
		int hours = minutes/60;
		System.out.println(hours);
		System.out.println(numCustomers/hours);
		
		
		


	}

}
