package palmetto.model;

public enum Ingredient {
    TOMATO_PASTE("Tomato paste", 1), CHEESE("Cheese", 1), SALAMI("Salami", 1.5), BACON("Bacon", 1.2),
    GARLIC("Garlic", 0.3), CORN("Corn", 0.7), PEPPERONI("Pepperoni", 0.6), OLIVES("Olives", 0.5);


    private String ingredientName;
    private double price;


    Ingredient(String ingredientName, double price) {
        this.ingredientName = ingredientName;
        this.price = price;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public double getPrice() {
        return price;
    }
}
