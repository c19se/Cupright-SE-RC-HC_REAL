
public class Drink {
	static String[] types = {"The Classic Cup", "The Hauté Cup", "The Hipster Cup", "House Blend", "Classic Earl Grey", "Traditional Oolong"};
	static double[][] prices = {{3,4,5},{3,4,5},{3.5,4.5,5.5},{2,3,4},{2,3,4},{3,4,5}};
	String type;
	int size;
	
	public Drink(){

	}
	public Drink(String type_, int size_){
		type = type_;
		size = size_;
	}
}
