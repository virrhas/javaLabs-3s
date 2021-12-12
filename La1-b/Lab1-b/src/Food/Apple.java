package Food;

public class Apple extends Food {
    private  String size;
    public Apple (String size)
    {
        super("Apple");
        this.size=size;
    }

    public void consume() {
        System.out.println(this + " was eaten");
    }
    public String getSize() {
        return size;
    }
    public void setSize(String size) {
        this.size = size;
    }

    public String toString() {
        return super.toString() + " size '" + size.toUpperCase() + "'";
    }
    
	public void CalculateCalories() {
	   	if (size == "Большое") {
    		Food.setCalories(Food.getCalories()+3);
    	}
    	else if (size == "Среднее") {
    		Food.setCalories(Food.getCalories()+2);
    	}	
    	else Food.setCalories(Food.getCalories()+1);
	}
}
