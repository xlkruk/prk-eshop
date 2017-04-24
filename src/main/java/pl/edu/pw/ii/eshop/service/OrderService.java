package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Order;

public interface OrderService {

    void addOrder(Order customerOrder);

    double getOrderGrandTotal(int cartId);
}

