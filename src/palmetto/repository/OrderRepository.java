package palmetto.repository;

import palmetto.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private List<Order> orderList = new ArrayList<>();
    private int orderNumber = 10000;


    public void save(Order order) {
        order.setOrderNumber(orderNumber++);
        orderList.add(order);
    }

    public List<Order> getAll() {
        return new ArrayList<>(orderList);
    }
}
