package palmetto.dto;

import java.util.List;

public class OrderDto {

    private int customerNumber;
    private List<PizzaDto> pizzaDto;

    public OrderDto(int customerNumber, List<PizzaDto> pizzaDto) {
        this.customerNumber = customerNumber;
        this.pizzaDto = pizzaDto;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public List<PizzaDto> getPizzaDto() {
        return pizzaDto;
    }
}
