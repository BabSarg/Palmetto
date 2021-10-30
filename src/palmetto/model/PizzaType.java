package palmetto.model;

public enum PizzaType {

    REGULAR(0), CLOSED(0.5);

    private double price;

    PizzaType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
