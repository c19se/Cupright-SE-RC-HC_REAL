import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class CuprightCoffee{
	static Scanner scan = new Scanner(System.in);
	/**
	 * asks the user if they would like to see hourly reports or a report of a specified amount of days 
	 * @return the number of days
	 */
	static int determineTypeReport(){
		int numDays = 0;
		boolean determiningType = true;
		while(determiningType){
			determiningType = false;
			System.out.println("Would you like to see an hourly, daily, 7 day, 4 week, or 52 week report?(h/d/w/m/y)");
			String reportType = scan.nextLine();
			switch(reportType){
			case "h":
				numDays = 0;
				break;
			case "d":
				numDays = 1;
				break;
			case "w":
				numDays = 7;
				break;
			case "m":
				numDays = 28;
				break;
			case "y":
				numDays = 364;
				break;
			default:
				determiningType = true;//continues loop
				break;
			}
		}

		return numDays;
	}

	final static int hoursPerDay = 9;

	public static void main(String[] args){



		boolean continueReports = true;
		while(continueReports){
			int hoursLeft = 0;
			int hour = 0;
			int numDays = 0;

			numDays = determineTypeReport();//sets the number of days
			hoursLeft = hoursPerDay * numDays;//sets the number of hours based on the number of days

			boolean hourly = false;
			if(hoursLeft == 0)hourly = true;//if hours is set to 0 then the reports go hour by hour

			CoffeeShop cupright = new CoffeeShop(10,7,3,10,7);//initialize coffee shop (customerRange, customerBase, numEmployees, serviceRange, serviceBase)
			double revenue;//initializes the revenue

			while(hourly || hoursLeft > 0){//continues if it is hourly or if there are more hours left to calculate
				revenue=0;//resets revenue
				hoursLeft--;
				hour++;
				revenue = cupright.Run();//sets the revenue for the hour
				System.out.println();
				System.out.println("Hour " + hour + ":");
				System.out.println("Hourly Revenue: " + revenue);
				revenue -= cupright.employees.length*cupright.employees[0].salaryPerHour;
				System.out.println("Hourly Net Gain: " + revenue);
				cupright.money += revenue;
				System.out.println("Total Profit: " + cupright.money);

				if(hourly){
					while(true){
						System.out.println("Would you like to see another hour?(y/n)");
						String continueHourly = scan.nextLine();
						hourly = true;
						if(continueHourly.equals("n")){
							hourly = false;
						}
						if(continueHourly.equals("n")||continueHourly.equals("y"))break;//continues  until either yes or no 
					}
				}
			}

			System.out.println();
			System.out.println("Final Report");
			System.out.println("Total Revenue: " + (cupright.money+(cupright.employees.length*cupright.employees[0].salaryPerHour*hour) ));
			System.out.println("Final Profit: " + cupright.money);
			int hypothetical = (int) (cupright.hypo-(cupright.employees.length*cupright.employees[0].salaryPerHour*hour));
			System.out.println("Hypothetical Final Profit including costs of drinks: " + (hypothetical));

			while(true){
				System.out.println("Would you like to see another report?(y/n)");
				String moreReports = scan.nextLine();
				continueReports = true;
				if(moreReports.equals("n")){
					continueReports = false;
					System.out.println("Goodbye");
					scan.close();
				}
				if(moreReports.equals("y") || moreReports.equals("n"))break;//continues until a yes or no

			}
		}




	}
}

class CoffeeShop{
	/**
	 * 
	 * @param customerRange_
	 * @param customerBase_
	 * @param numEmployees_
	 * @param serviceRange_
	 * @param serviceBase_
	 */
	
	CoffeeShop(int customerRange_, int customerBase_, int numEmployees_, int serviceRange_, int serviceBase_ ){
		customerRange = customerRange_;
		customerBase = customerBase_;
		numEmployees = numEmployees_;
		serviceRange = serviceRange_;
		serviceBase = serviceBase_;
		Employee[] employees_ = new Employee[numEmployees];
		employees = employees_.clone();
	}
	
	static LinkedList<Customer> line = new LinkedList<Customer>();
	
	int customerRange;
	int customerBase;
	static int numEmployees;
	int serviceRange;
	int serviceBase;


	double money;
	double startMoney;
	Employee[] employees;
	double hypo;


	/**
	 * 
	 * @return the money gained in an hour
	 */
	double Run(){
		double money_ = 0;
		Random gen = new Random();
		int servedThisHour = 0;

		for(int i = 0; i<employees.length;i++){
			employees[i] = new Employee(gen.nextInt(serviceRange)+serviceBase);//sets the amount an employee can serve
			servedThisHour += employees[i].peoplePerHour;//sums up those amounts
		}

		int numCustomers = gen.nextInt(customerRange) + customerBase;//sets the amount of costumers for an hour
		for(int i = 0; i <  numCustomers ;i++){
			int type = gen.nextInt(Drink.types.length);//randomly generates the type
			int size= gen.nextInt(Drink.prices[0].length);//randomly generates the size
			Customer customer = new Customer(type,size);
			line.add(customer);//adds the costumer to the line 
		}
		if(servedThisHour>line.size())servedThisHour = line.size();//if the employees can serve more than come, they just serve as many that come

		startMoney = money_;
		for(int i = 0; i < servedThisHour; i++){
			Customer c = line.pop();
			money_ += Employee.makeCoffee(c,false);//gives the first person in line to the employee to make coffee.
			hypo += Employee.makeCoffee(c,true);
		}
		return money_;
	}




}

