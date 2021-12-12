package Food;

public class Milk extends Food {

    private String fat;
    public Milk (String fat)
    {
        super("Milk");
        this.fat = fat;
    }
    public void consume() {
        System.out.println(this + " was eaten");
    }
    public String getFat() {
        return fat;
    }
    public void setFat(String fat) {
        this.fat = fat;
    }

    public String toString() {
        return super.toString() + " fat '" + fat.toUpperCase() + "'";
    }
    
	public void CalculateCalories() {
    	if (Double.parseDouble(fat) == 1.5) {
    		Food.setCalories(Food.getCalories()+1);
    	}
    	else if (Double.parseDouble(fat) == 2.5) {
    		Food.setCalories(Food.getCalories()+2);
    	}	
    	else Food.setCalories(Food.getCalories()+3);
	}

}