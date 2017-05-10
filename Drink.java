
public class Drink {
	static String[] types = {"The Classic Cup", "The Hauté Cup", "The Hipster Cup", "House Blend", "Classic Earl Grey", "Traditional Oolong"};
	static double[][] prices = {{3,4,5},{3,4,5},{3.5,4.5,5.5},{2,3,4},{2,3,4},{3,4,5}};
	static double[][] costs = {{.75,1.00,1.25 },{},{},{},{},{}};
	
	String type;
	int size;
	double cost;
	public Drink(){

	}
	public Drink(int type_, int size_){
		type = types[type_];
		size = size_;
		cost = prices[type_][size_];
	}
}


