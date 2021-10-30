package palmetto.dto;

import palmetto.model.Ingredient;
import palmetto.model.PizzaType;

import java.util.ArrayList;
import java.util.List;

public class PizzaDto {

    private String name;
    private int quantity;
    private PizzaType pizzaType;
    private List<Ingredient> ingredients = new ArrayList<>();

    public PizzaDto() {
    }

    public PizzaDto(String name, int quantity, PizzaType pizzaType) {
        this.name = name;
        this.quantity = quantity;
        this.pizzaType = pizzaType;
    }

    public PizzaDto(String name, int quantity, PizzaType pizzaType, List<Ingredient> ingredients) {
        this.name = name;
        this.quantity = quantity;
        this.pizzaType = pizzaType;
        this.ingredients = ingredients;
    }

    public PizzaType getPizzaType() {
        return pizzaType;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
