package pl.edu.pw.ii.eshop.service;

import java.util.List;

import pl.edu.pw.ii.eshop.model.Order;

public interface OrderService {

    void addOrder(Order customerOrder);

    double getOrderGrandTotal(int cartId);
    
    List<Order> getAllOrders();
    
    List<Order> getOrdersByStatus(String status);
    
    List<Order> getOrdersByCustomerId(int customerId);
    
    void setPaymentReceivedStatus(Order customerOrder);
    
    void setSentStatus(Order customerOrder);
    
    void setCompletedStaus(Order customerOrder);
}

