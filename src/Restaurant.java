import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

    Kitchen kitchen;
    Menu menu;
    List<Staff> staff;

    boolean open;

    Scanner scanner;


    public Restaurant() {
        kitchen = new Kitchen();
        menu = new Menu();
        staff = new ArrayList<>();

        scanner = new Scanner(System.in);

        start();
    }

    private void start() {
        while(true)
        {
            displayMainMenu();
            if (!handleMainMenuChoice())
            {
                return;
            }
        }
    }

    private boolean handleMainMenuChoice() {

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1 -> closeOpenRestaurant();
            case 2 -> handleDishMenu();
            case 3 -> handlePersonnelMenu();
            case 0 -> {
            return false;
        }
        }
        return true;
    }

    private void handlePersonnelMenu() {
        displayPersonnelMenu();
        handlePersonnelMenuChoice();
    }

    private void handlePersonnelMenuChoice() {
        int choice =  scanner.nextInt();
        scanner.nextLine();
        switch (choice)
        {
            case 1 -> {handleAddPersonnel();}
        }
    }

    private void handleAddPersonnel() {

    }

    private void displayPersonnelMenu() {
        System.out.println("1. Lägg till personal");
        System.out.println("2. Ta bort personal");
        System.out.println("3. Se all personal");
        System.out.println("4. Se specifik personal");
        System.out.println("0. Gå tillbaka.");
    }

    private void handleDishMenu() {
        while(true)
        {
            displayMenuHandlingMenu();
            if (handleDishMenuChoice())
                return;
        }
    }

    private boolean handleDishMenuChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice)
        {
            case 1 -> handleAddDish();
            case 2 -> handleRemoveDish();
            case 3 -> showAllDishes();
            case 4 -> showSpecificDish();
            case 0 -> {
                return true;
            }
        }

        return false;
    }

    private void showSpecificDish() {
        String dishName = scanner.nextLine();
        Dish dish = menu.getDish(dishName);

        if (dish == null)
        {
            System.out.println("Den rätten finns inte.");
        }
        else
        {
            System.out.printf("Namn: %s, Pris: %s, Beskrivning: %s%n", dish.name, dish.price, dish.desc);
        }
    }


    private void showAllDishes() {
        List<Dish> dishes = menu.getAllDishes();

        for (Dish dish : dishes)
        {
            System.out.printf("Namn: %s, Pris: %s, Beskrivning: %s%n", dish.name, dish.price, dish.desc);
        }
    }

    private void handleRemoveDish() {
        System.out.println("Skriv namn på rätten som ska tas bort");
        String dishName = scanner.nextLine();

        if (menu.removeDish(dishName))
        {
            System.out.println("Rätten har tagits bort.");
        }
        else
        {
            System.out.println("Ingen rätt med det namnet.");
        }
    }

    private void handleAddDish() {
        System.out.println("Skriv in namn på rätten:");
        String dishName = scanner.nextLine();

        System.out.println("Skriv in kostnaden på rätten:");
        double dishPrice = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Skriv in en beskrivning på rätten:");
        String dishDescription = scanner.nextLine();

        menu.addDish(new Dish(dishName, dishPrice, dishDescription));
    }

    private void displayMenuHandlingMenu() {
        System.out.println("1. Lägg till maträtt.");
        System.out.println("2. Ta bort maträtt.");
        System.out.println("3. Se alla maträtter.");
        System.out.println("4. Se specifik maträtt.");
        System.out.println("0. Gå tillbaka.");

    }

    private void closeOpenRestaurant() {
        if (open)
        {
            open = false;
            System.out.println("Resturangen är nu stängd.");
        }
        else
        {
            open = true;
            System.out.println("Resturangen är nu öppen.");
        }
    }

    private void displayMainMenu() {

            System.out.println("Gör val:");
            if (!open){
                System.out.println("1. Öppna resturangen");
            }
            else {
                System.out.println("1. Stäng resturangen");
                System.out.println("2. Hantera meny");
                System.out.println("3. Hantera personal");
            }
            System.out.println("0. Avsluta");
    }
}
