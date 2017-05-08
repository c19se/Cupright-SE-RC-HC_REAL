import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class CuprightCoffee{
	public static void main(String[] args) throws InterruptedException {
		int customerRange = 30;
		int customerBase = 30;
		int numEmployees = 3;
		int serviceRange = 10;
		int serviceBase = 10;
		
		Scanner scan = new Scanner(System.in);
		int hoursLeft = 0;
		int hourMod;
		boolean continueReports = true;
		while(continueReports){
			boolean hourly = false;
			int hour = 0;
			while(true){
				System.out.println("Would you like to see an hourly report?(y/n)");
				String hourlyStr = scan.nextLine();
				if(hourlyStr.equals("y")){
					hourly = true;
					hourMod = 0;
					break;
				}
				System.out.println("Would you like to see an daily report?(y/n)");
				String dailyStr = scan.nextLine();
				if(dailyStr.equals("y")){
					hourMod = 1;
					break;
				}System.out.println("Would you like to see an 7 day report report?(y/n)");
				String weeklyStr = scan.nextLine();
				if(weeklyStr.equals("y")){
					hourMod = 7;
					break;
				}
				System.out.println("Would you like to see an 4 week report?(y/n)");
				String monthlyStr = scan.nextLine();
				if(monthlyStr.equals("y")){
					hourMod = 28;
					break;
				}
				System.out.println("Would you like to see an 52 week report?(y/n)");
				String yearlyStr = scan.nextLine();
				if(yearlyStr.equals("y")){
					hourMod = 52*7;
					break;
				}
				
			}
			hoursLeft = 9 * hourMod;

			Random gen = new Random();
			LinkedList<Customer> line = new LinkedList<Customer>();


			int money = 0;
			Employee[] employees = new Employee[numEmployees];


			while(hourly || hoursLeft > 0){
				hoursLeft--;
				hour++;
				//			System.err.println("leftOvers: "+ line.size());
				int servedThisHour = 0;
				money -= employees.length*Employee.salaryPerHour;


				for(int i = 0; i<employees.length;i++){
					employees[i] = new Employee(gen.nextInt(serviceRange)+serviceBase);
					servedThisHour += employees[i].peoplePerHour;
				}
				//			System.err.println("amountThisHour: " + servedThisHour);

				//The Hour Begins
				for(int i = 0; i < gen.nextInt(customerRange) + customerBase ;i++){
					int type = gen.nextInt(Drink.types.length);
					int size= gen.nextInt(Drink.prices[0].length);
					Customer customer = new Customer(type,size);
					line.add(customer);
				}
				//			System.err.println("new customers: " + count);
				//			System.err.println("cusomters: " + line.size());


				if(servedThisHour>line.size())servedThisHour = line.size();

				int startMoney = money;
				for(int i = 0; i < servedThisHour; i++){
					money += Employee.makeCoffee(line.pop());
				}
				System.out.println();
				System.out.println("Hour " + hour + " Report:");
				System.out.println("Revenue: " + (money-startMoney+employees.length*Employee.salaryPerHour));
				System.out.println("Net Gain from the hour: " + (money-startMoney-employees.length*Employee.salaryPerHour));
				System.out.println("Total Earnings: " + money);
				
				if(hourly){
					System.out.println("would you like to see another hour(y/n)");
					String continueHourly = scan.nextLine();
					hourly = true;
					if(continueHourly.equals("n")){
						hourly = false;
						System.out.println("Goodbye");
					}
				}



			}
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("Final Report: ");
			System.out.println("Revenue: " + (money+(employees.length*Employee.salaryPerHour*hourMod*9)));
			System.out.println("Net Earnings: " + money);


			System.out.println("would you like to see another report(y/n)");
			String continueHourly = scan.nextLine();
			continueReports = true;
			if(continueHourly.equals("n")){
				continueReports = false;
				System.out.println("Goodbye");
			}
		}




	}
}

