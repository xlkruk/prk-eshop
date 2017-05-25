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
				String subject = "Potwierdzenie z�o�enia zam�wienia";
				String msg = "Witamy\nDzi�kujemy za z�o�enie zam�wienia.\n\nPrzedmioty wy�lemy po otrzymaniu wp�aty "
						+ order.getCart().getGrantTotal() + "z�.\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i �ukasz";
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
				String subject = "Potwierdzenie otrzymania wp�aty";
				String msg = "Witamy\n\nDzi�kujemy za dokonanie wp�aty " + payment + "z� za zam�wienie nr: "
						+ order.getOrderId() + ".\n\nPrzesy�k� wy�lemy w ci�gu 3 dni roboczych na adres:\n"
						+ order.getShippingAddress().getStreet() + " " + order.getShippingAddress().getApartmentNumber()
						+ "\n" + order.getShippingAddress().getZipCode() + " " + order.getShippingAddress().getCity()
						+ "\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i �ukasz";
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
				String subject = "Potwierdzenie wys�ania zam�wienia nr "+order.getOrderId();
				String msg = "Witamy\n\nPotwierdzenie wys�ania zam�wienia nr: "
						+ order.getOrderId() + " na adres:\n"
						+ order.getShippingAddress().getStreet() + " " + order.getShippingAddress().getApartmentNumber()
						+ "\n" + order.getShippingAddress().getZipCode() + " " + order.getShippingAddress().getCity()
						+ "\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i �ukasz";
				sendMail("PRK-eshop", order.getCart().getCustomer().getCustomerEmail(), subject, msg);
			}
		} catch (Exception e) {
		}

	}

}
