package Food;

public class Main {
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        int itemsSoFar = 0;
        int CheeseAm = 0, AppleAm = 0, MilkAm = 0;
        Cheese Ch = new Cheese();
        Milk Mi = new Milk(null);
        Apple Ap = new Apple(null);

        for (String arg : args) {
            String[] parts = arg.split("/");
            if (parts[0].equals("Cheese")) {
                breakfast[itemsSoFar] = new Cheese();
                //breakfast[itemsSoFar].CalculateCalories();
            } else if (parts[0].equals("Apple")) {
                breakfast[itemsSoFar] = new Apple(parts[1]);
                //breakfast[itemsSoFar].CalculateCalories();
            }
            if (parts[0].equals("Milk")) {
                breakfast[itemsSoFar] = new Milk(parts[1]);
                //breakfast[itemsSoFar].CalculateCalories();
            }

            itemsSoFar++;
        }
        for (Food i: breakfast) {
        	if (i!=null)
        		i.CalculateCalories();
        	else break;
        }
        System.out.println("Amount of products:");
        for (int i = 0; i < 20; i++) {
            if (breakfast[i] != null) {
                if (breakfast[i].equals(Ch)) {
                    CheeseAm++;
                } else if (breakfast[i].equals(Ap)) {
                    AppleAm++;
                } else if (breakfast[i].equals(Mi)) {
                    MilkAm++;
                }
            } else break;
        }
        System.out.println("Amount of apples is " + AppleAm + ", Amount of cheese is " + CheeseAm + ", Amount of milk is " + MilkAm + "");
        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
            } else break;
        }
        System.out.println("Калорий в завтраке " + Food.getCalories());
        System.out.println("Have a nice day!");
    }
}
