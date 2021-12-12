package Food;
public class Cheese extends Food {

    public Cheese() {
        super("Cheese");
    }
    public void consume() {
        System.out.println(this + " was eaten");
    }
    
	public void CalculateCalories() {
		Food.setCalories(Food.getCalories()+1);
	}
}