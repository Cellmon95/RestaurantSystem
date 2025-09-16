import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {


    List<Dish> menuDishes;


    public Menu() {

        menuDishes = new ArrayList<>(Arrays.asList(
                new Dish("Spaghetti", 100, "Jummy spaghetti."),
                new Dish("Cheeseburger", 120, "Classic cheeseburger with fries."),
                new Dish("Caesar Salad", 90, "Fresh Caesar salad with croutons."),
                new Dish("Margherita Pizza", 150, "Stone-baked pizza with mozzarella and basil."),
                new Dish("Chicken Curry", 140, "Spicy chicken curry with rice."),
                new Dish("Fish & Chips", 130, "Crispy fried fish with golden chips."),
                new Dish("Beef Steak", 200, "Juicy grilled beef steak with vegetables."),
                new Dish("Vegetable Soup", 80, "Warm and healthy vegetable soup."),
                new Dish("Pancakes", 70, "Fluffy pancakes with maple syrup."),
                new Dish("Ice Cream Sundae", 60, "Creamy ice cream with toppings.")
        ));
    }

    public void addDish(Dish dish)
    {
        menuDishes.add(dish);
    }

    public boolean removeDish(String dishName)
    {
        for (Dish menuDish : menuDishes)
        {
            if (menuDish.getName().equalsIgnoreCase(dishName))
            {
                menuDishes.remove(menuDish);
                return true;
            }
        }

        return false;
    }

    public Dish getDish(String dishName) {
        for (Dish menuItem : menuDishes)
        {
            if (menuItem.getName().equalsIgnoreCase(dishName)) {
                return  menuItem;
            }
        }
        return null;
    }

    public List<Dish> getAllDishes(){
        return menuDishes;
    }
}
