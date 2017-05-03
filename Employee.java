public class Employee{
  int salary;
  String name;
  
  double makeCoffee(Customer c){
		c.hasDrink = true;
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
