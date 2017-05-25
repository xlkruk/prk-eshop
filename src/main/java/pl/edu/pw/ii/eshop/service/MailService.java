package pl.edu.pw.ii.eshop.service;

import org.springframework.stereotype.Service;

import pl.edu.pw.ii.eshop.model.Order;


public interface MailService {
	public void sendMail(String from, String to, String subject, String msg);
	public void sendOrderConfirmation(Order order);
	public void sendPaymentConfirmation(Order order);
	public void sendDeliveryConfirmation(Order order);
}
