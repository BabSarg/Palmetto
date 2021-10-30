package palmetto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pizza {

    private String name;
    private List<Ingredient> ingredientList = new ArrayList<>();
    private PizzaType type;
    private int quantity;
    private int price = 1;

    public Pizza() {
    }

    public Pizza(String name, List<Ingredient> ingredientList, PizzaType type, int quantity) {
        this.name = name;
        this.ingredientList = ingredientList;
        this.type = type;
        this.quantity = quantity;
    }

    public Pizza(String name, PizzaType type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientList;
    }

    public void setIngredientsList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public PizzaType getOrderType() {
        return type;
    }

    public void setOrderType(PizzaType pizzaType) {
        this.type = pizzaType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return quantity == pizza.quantity && Objects.equals(name, pizza.name) && Objects.equals(ingredientList, pizza.ingredientList) && type == pizza.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredientList, type, quantity);
    }
}
