import java.util.List;
import java.util.Scanner;

public class Restaurant {

    Kitchen kitchen;
    Menu menu;
    StaffList staffList;

    boolean open;

    Scanner scanner;


    public Restaurant() {
        kitchen = new Kitchen();
        menu = new Menu();
        staffList = new StaffList();

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
        while (true)
        {
            displayPersonnelMenu();
            if(!handlePersonnelMenuChoice())
            {
                return;
            };
        }

    }

    private boolean handlePersonnelMenuChoice() {
        int choice =  scanner.nextInt();
        scanner.nextLine();
        switch (choice)
        {
            case 1 -> handleAddPersonnel();
            case 2 -> handleRemovePersonnel();
            case 3 -> handleSeeAllPersonnel();
            case 4 -> handleSeeSpecificPersonnel();
            case 0 -> {
            return false;
        }
            default -> System.out.println("Felaktigt val.");
        }
        return true;
    }

    private void handleSeeSpecificPersonnel() {
        System.out.println("Skriv in personnummer på personen du vill se");
        String SSN = scanner.nextLine();

        Staff staff = staffList.getStaff(SSN);

        if (staff == null)
        {
            System.out.println("Personen finns inte");
        }
        else
        {
            System.out.printf("Förnamn: %s, Efternamn %s, Personnummer %s, roll: %n", staff.firstName, staff.lastName, staff.SSN);
        }
    }

    private void handleSeeAllPersonnel() {
        List<Staff> allStaff = staffList.getAllStaff();

        for (Staff staff : allStaff)
        {
            System.out.printf("Förnamn: %s, Efternamn %s, Personnummer %s, roll: %s%n", staff.firstName, staff.lastName, staff.SSN, staff.role);
        }
    }

    private void handleRemovePersonnel() {
        System.out.println("Skriv in personnummer på den du vill ta bort");
        String SSN = scanner.nextLine();

        if (staffList.removeStaff(SSN))
        {
            System.out.println("Personen borttagen.");
        }
        else
        {
            System.out.println("Personen finns inte.");
        }
    }

    private void handleAddPersonnel() {
        System.out.println("Skriv in förnamn");
        String firstName = scanner.nextLine();

        System.out.println("Skriv in efternamn");
        String lastName = scanner.nextLine();

        System.out.println("Skriv in personnummer");
        String SSN = scanner.nextLine();


        StaffRole staffRole = null;
        boolean running;

        do
        {
        running = false;

        System.out.println("Välj roll");
        System.out.println("1. Köksmästare");
        System.out.println("2. Kock");
        System.out.println("3. Servitör");
        System.out.println("4. Bartender");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice){
                case 1 -> staffRole = StaffRole.CHEF;
                case 2 -> staffRole = StaffRole.COOK;
                case 3 -> staffRole = StaffRole.SERVER;
                case 4 -> staffRole = StaffRole.BARTENDER;
                default -> {
                    System.out.println("Felaktigt val");
                    running = true;
                }
            }
        } while (running);

        staffList.addStaff(new Staff(firstName, lastName, SSN, staffRole));

        System.out.println("Personen har lagts till.");
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
            if (!handleDishMenuChoice())
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
                return false;
            }
        }

        return true;
    }

    private void showSpecificDish() {
        System.out.println("Skriv namn på rätten du vill se.");

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
            System.out.println("Restaurangen är nu stängd.");
        }
        else
        {
            open = true;
            System.out.println("Restaurangen är nu öppen.");
        }
    }

    private void displayMainMenu() {

            System.out.println("Gör val:");
            if (!open){
                System.out.println("1. Öppna restaurangen");
            }
            else {
                System.out.println("1. Stäng restaurangen");
                System.out.println("2. Hantera meny");
                System.out.println("3. Hantera personal");
            }
            System.out.println("0. Avsluta");
    }
}
