package palmetto.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Order {

    private int customerNumber;
    private int orderNumber;
    private List<Pizza> pizzaList;
    private LocalDateTime localDateTime;

    public Order(int customerNumber, int orderNumber, List<Pizza> pizzaList, LocalDateTime localDateTime) {
        this.customerNumber = customerNumber;
        this.orderNumber = orderNumber;
        this.pizzaList = pizzaList;
        this.localDateTime = localDateTime;
    }

    public Order() {
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return customerNumber == order.customerNumber && orderNumber == order.orderNumber && Objects.equals(pizzaList, order.pizzaList) && Objects.equals(localDateTime, order.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerNumber, orderNumber, pizzaList, localDateTime);
    }
}
