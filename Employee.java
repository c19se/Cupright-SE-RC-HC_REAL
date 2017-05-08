public class Employee{
	static int salaryPerHour = 10;
	int peoplePerHour;
	public Employee(int peoplePerHour_){
		peoplePerHour = peoplePerHour_;
	}

	static double makeCoffee(Customer c){
		double cost = 0;
		for(int i = 0; i<Drink.types.length; i++){
			if(c.drink.type.equals(Drink.types[i])){
				cost = Drink.prices[i][c.drink.size];
				//				System.out.println(cost);
				break;
			}
		}
		return cost;
	}



}
