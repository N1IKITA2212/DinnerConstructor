import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class DinnerConstructor {
    private HashMap<String, ArrayList<String>> dishes = new HashMap<>();
    private Random random = new Random();

    public void addDish(String typeOfDish, String dish) {
        dishes.computeIfAbsent(typeOfDish, k -> new ArrayList<>()).add(dish);
    }

    public ArrayList<String> makeCombo(ArrayList<String> typesOfDishes) {
        ArrayList<String> combo = new ArrayList<>();
        for (String type : typesOfDishes) {
            ArrayList<String> dishesByType = dishes.get(type);
            combo.add(dishesByType.get(random.nextInt(dishesByType.size())));
        }
        return combo;
    }

    public void printDishes() {
        for (String type : dishes.keySet()) {
            System.out.print("В категории '" + type + "' имеются следующие блюда: " + dishes.get(type));
            System.out.println();
        }
    }

    public boolean hasType(String type) {
        return dishes.containsKey(type);
    }

    public boolean isEmpty() {
        return dishes.isEmpty();
    }

    public Set<String> getSet() {
        return dishes.keySet();
    }
}
