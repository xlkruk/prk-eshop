package pl.edu.pw.ii.eshop.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import pl.edu.pw.ii.eshop.model.Order;
import pl.edu.pw.ii.eshop.model.OrderItem;
import pl.edu.pw.ii.eshop.service.MailService;
/**
 * Klasa implementująca interfejs {@link MailService}
 * @author Łukasz Kruk
 *
 */
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
				String subject = "Potwierdzenie złożenia zamówienia";
				String msg = "Witamy\n\nDziękujemy za złożenie zamówienia.\n\nPrzedmioty wyślemy po otrzymaniu wpłaty "
						+ order.getCart().getGrantTotal() + "zł.\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i Łukasz";
				sendMail("PRK-eshop", order.getCart().getCustomer().getCustomerEmail(), subject, msg);
			}
		} catch (Exception e) {
		}
	}

	@Override
	public void sendPaymentConfirmation(Order order) {
		double payment = 0;
		//Obliczenie należności za zamówienie
		List<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem item : orderItems) {
			payment = +item.getTotalPrice();
		}

		try {
			if (order != null) {
				String subject = "Potwierdzenie otrzymania wpłaty";
				String msg = "Witamy\n\nDziękujemy za dokonanie wpłaty " + payment + "zł za zamówienie nr: "
						+ order.getOrderId() + ".\n\nPrzesyłkę wyślemy w ciągu 3 dni roboczych na adres:\n"
						+ order.getShippingAddress().getStreet() + " " + order.getShippingAddress().getApartmentNumber()
						+ "\n" + order.getShippingAddress().getZipCode() + " " + order.getShippingAddress().getCity()
						+ "\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i Łukasz";
				sendMail("PRK-eshop", order.getCart().getCustomer().getCustomerEmail(), subject, msg);
			}
		} catch (Exception e) {
		}

	}

	@Override
	public void sendDeliveryConfirmation(Order order) {
		double payment = 0;
		//wyliczenie należności za zamówienie
		List<OrderItem> orderItems = order.getOrderItems();
		for (OrderItem item : orderItems) {
			payment = +item.getTotalPrice();
		}

		try {
			if (order != null) {
				String subject = "Potwierdzenie wysłania zamówienia nr "+order.getOrderId();
				String msg = "Witamy\n\nPotwierdzenie wysłania zamówienia nr: "
						+ order.getOrderId() + " na adres:\n"
						+ order.getShippingAddress().getStreet() + " " + order.getShippingAddress().getApartmentNumber()
						+ "\n" + order.getShippingAddress().getZipCode() + " " + order.getShippingAddress().getCity()
						+ "\n\nPozdrawiamy" + "\nAgnieszka, Krzysiek i Łukasz";
				sendMail("PRK-eshop", order.getCart().getCustomer().getCustomerEmail(), subject, msg);
			}
		} catch (Exception e) {
		}

	}

}
