public class Dish {

    String name;
    double price;
    String desc;

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
