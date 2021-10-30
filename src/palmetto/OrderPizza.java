package palmetto;

import palmetto.dto.OrderDto;
import palmetto.dto.PizzaDto;
import palmetto.model.Ingredient;
import palmetto.model.Order;
import palmetto.model.Pizza;
import palmetto.model.PizzaType;
import palmetto.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderPizza {


    private OrderRepository orderRepository;

    public OrderPizza() {
        this.orderRepository = new OrderRepository();
    }

    public void showPizzaAttributes(int orderNumber, int customerNumber, Pizza pizza) {

        System.out.println("[ " + orderNumber + " : " + customerNumber + " : " + pizza.getName() + " : " + pizza.getQuantity() + " ]");
    }

    private String checkName(String name, int index) {
        if (name.trim().length() <= 20 && name.trim().length() >= 4) {
            return name;
        } else {
            return "costumer_Name_" + index;
        }
    }

    private void addIngredient(Pizza pizza, Ingredient ingredient) {
        if (pizza.getIngredientsList().size() == 7) {
            System.out.println(pizza.getName() + " Ingredients are full");
        } else if (pizza.getIngredientsList().contains(ingredient)) {
            System.out.println(ingredient + " is already exists for " + pizza.getName());
        } else {
            pizza.getIngredientsList().add(ingredient);
        }
    }

    private void createOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setLocalDateTime(LocalDateTime.now());
        order.setCustomerNumber(orderDto.getCustomerNumber());
        List<Pizza> pizzaList = new ArrayList<>();
        int index = 1;
        for (PizzaDto pizzaDto : orderDto.getPizzaDto()) {
            Pizza pizza = new Pizza();
            pizza.setOrderType(pizzaDto.getPizzaType());
            pizza.setName(checkName(pizzaDto.getName(), index++));
            pizza.setQuantity(pizzaDto.getQuantity());
            for (Ingredient ingredient : pizzaDto.getIngredients()) {
                addIngredient(pizza, ingredient);
            }
            pizzaList.add(pizza);
        }
        order.setPizzaList(pizzaList);
        orderRepository.save(order);
    }

    private void printCheck() {
        List<Order> orders = orderRepository.getAll();
        for (Order order : orders) {
            System.out.println("*****************************************");
            System.out.println("Order: " + order.getOrderNumber());
            System.out.println("Client: " + order.getCustomerNumber());
            double totalAmount = 0;
            for (Pizza pizza : order.getPizzaList()) {
                double amount = 0;
                amount += pizza.getQuantity() * pizza.getPrice();
                amount += pizza.getOrderType().getPrice();
                System.out.println("Name: " + pizza.getName());
                System.out.println("----------------------------");
                System.out.println("Pizza Base: " + "(" + pizza.getOrderType() + ") " + ((pizza.getPrice() * pizza.getQuantity()) + pizza.getOrderType().getPrice()) + " $");
                for (Ingredient ingredient : pizza.getIngredientsList()) {
                    System.out.println(ingredient.getIngredientName() + " " + ingredient.getPrice() + " $");
                    amount += ingredient.getPrice();
                }
                System.out.println("----------------------------");
                System.out.println("Amount: " + amount + " $");
                System.out.println("Quantity: " + pizza.getQuantity());
                System.out.println("----------------------------");
                totalAmount += amount;
            }

            System.out.println("TotalAmount: " + totalAmount + " $");

            System.out.println("*****************************************");
        }
    }


    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza();
        orderPizza.createOrder(new OrderDto(7717,
                Arrays.asList(new PizzaDto("Margarita", 2, PizzaType.CLOSED,
                                Arrays.asList(Ingredient.BACON, Ingredient.TOMATO_PASTE, Ingredient.TOMATO_PASTE)),
                        new PizzaDto("Pe", 2, PizzaType.REGULAR,
                                Arrays.asList(Ingredient.BACON)))));
        orderPizza.createOrder(new OrderDto(4372,
                Arrays.asList(new PizzaDto("BasePZZ", 12, PizzaType.CLOSED,
                        Arrays.asList(Ingredient.BACON, Ingredient.TOMATO_PASTE, Ingredient.GARLIC)))));
        orderPizza.printCheck();
    }
}
