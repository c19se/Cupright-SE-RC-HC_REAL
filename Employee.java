public class Employee{
	final int salaryPerHour = 10;
	int peoplePerHour;
	public Employee(int peoplePerHour_){
		peoplePerHour = peoplePerHour_;
	}

	/**
	 * 
	 * @param a costumer
	 * @return the cost of their drink
	 */
	static double makeCoffee(Customer c, boolean hypothetical){
		double price = 0;
		for(int i = 0; i<Drink.types.length; i++){
			if(c.drink.type.equals(Drink.types[i])){
				if(hypothetical){
					price = Drink.prices[i][c.drink.size] - Drink .costs[i][c.drink.size];
				}else{
					price = Drink.prices[i][c.drink.size];
				}
				//				System.out.println(cost);
				break;
			}
		}
		return price;
	}



}
