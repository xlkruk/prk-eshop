package pl.edu.pw.ii.eshop.service.implementation;

import pl.edu.pw.ii.eshop.dao.OrderDao;
import pl.edu.pw.ii.eshop.model.Cart;
import pl.edu.pw.ii.eshop.model.CartItem;
import pl.edu.pw.ii.eshop.model.Customer;
import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.Status;
import pl.edu.pw.ii.eshop.service.CartService;
import pl.edu.pw.ii.eshop.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    @Override
    public void addOrder(Order customerOrder) {
        customerOrderDao.addOrder(customerOrder);
    }

    @Override
    public double getOrderGrandTotal(int cartId) {
        double grandTotal=0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems) {
            grandTotal+=item.getTotalPrice();
        }

        return grandTotal;
    }

	@Override
	public List<Order> getAllOrders() {
		return customerOrderDao.getAllOrders();
	}

	@Override
	public List<Order> getOrdersByStatus(String status) {
		return customerOrderDao.getOrdersByStatus(status);
	}

	@Override
	public List<Order> getOrdersByCustomerId(int customerId) {
		return customerOrderDao.getOrdersByCustomerId(customerId);
	}

	@Override
	public void setPaymentReceivedStatus(Order customerOrder) {
		customerOrder.setStatus(Status.PAYMENT_RECEIVED.getDescription());
		customerOrderDao.updateOrder(customerOrder);
		
	}

	@Override
	public void setSentStatus(Order customerOrder) {
		customerOrder.setStatus(Status.SENT.getDescription());
		customerOrderDao.updateOrder(customerOrder);
		
	}

	@Override
	public void setCompletedStaus(Order customerOrder) {
		customerOrder.setStatus(Status.COMPLETED.getDescription());
		customerOrderDao.updateOrder(customerOrder);
		
	}

	@Override
	public Order getOrderById(int id) {
		return customerOrderDao.getOrderById(id);
	}
}
