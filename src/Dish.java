public class Dish {

    private final String name;
    private final double price;
    private final String desc;

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public Dish(String name, double price, String desc) {
        this.name = name;
        this.price = price;
        this.desc = desc;
    }
}
