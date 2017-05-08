import java.util.Random;

public class Customer{
	Random gen = new Random();
	//customer money (randomly generate per customer) 
	Drink drink = new Drink();
	public Customer(int drinkType, int drinkSize){
		drink = new Drink(drinkType, drinkSize);
		

	}


} 
