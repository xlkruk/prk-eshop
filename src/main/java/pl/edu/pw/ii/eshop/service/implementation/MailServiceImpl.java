package pl.edu.pw.ii.eshop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.OrderItem;
import pl.edu.pw.ii.eshop.service.MailService;

@Service
public class MailServiceImpl implements MailService {

	@Autowired
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override

	public void sendMail(String from, String to, String subject, String msg) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom(from);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(msg);
		try {
			mailSender.send(message);
		} catch (Exception e) {
		}
	}

	@Override
	public void sendOrderConfirmation(Order order) {
		try {
			if (order != null) {
				String subject = "Potwierdzenie z³o¿enia zamówienia";
				String msg = "Witamy\nDziêkujemy za z³o¿enie zamówienia.\n\nPrzedmioty wyœlemy po otrzymaniu wp³aty "
						+ order.getCart().getGrantTotal() + "z³.\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i £ukasz";
				sendMail("PRK-eshop", order.getCart().getCustomer().getCustomerEmail(), subject, msg);
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void sendPaymentConfirmation(Order order) {
		double payment = 0;
		List<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem item : orderItems) {
			payment = +item.getTotalPrice();
		}

		try {
			if (order != null) {
				String subject = "Potwierdzenie otrzymania wp³aty";
				String msg = "Witamy\n\nDziêkujemy za dokonanie wp³aty " + payment + "z³ za zamówienie nr: "
						+ order.getOrderId() + ".\n\nPrzesy³kê wyœlemy w ci¹gu 3 dni roboczych na adres:\n"
						+ order.getShippingAddress().getStreet() + " " + order.getShippingAddress().getApartmentNumber()
						+ "\n" + order.getShippingAddress().getZipCode() + " " + order.getShippingAddress().getCity()
						+ "\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i £ukasz";
				sendMail("PRK-eshop", order.getCart().getCustomer().getCustomerEmail(), subject, msg);
			}
		} catch (Exception e) {
		}

	}

	@Override
	public void sendDeliveryConfirmation(Order order) {
		double payment = 0;
		List<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem item : orderItems) {
			payment = +item.getTotalPrice();
		}

		try {
			if (order != null) {
				String subject = "Potwierdzenie wys³ania zamówienia nr "+order.getOrderId();
				String msg = "Witamy\n\nPotwierdzenie wys³ania zamówienia nr: "
						+ order.getOrderId() + " na adres:\n"
						+ order.getShippingAddress().getStreet() + " " + order.getShippingAddress().getApartmentNumber()
						+ "\n" + order.getShippingAddress().getZipCode() + " " + order.getShippingAddress().getCity()
						+ "\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i £ukasz";
				sendMail("PRK-eshop", order.getCart().getCustomer().getCustomerEmail(), subject, msg);
			}
		} catch (Exception e) {
		}

	}

}
