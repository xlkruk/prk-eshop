package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs warstwy serwisu, definiujący metody związane z logiką biznesową
 * związaną z wysyłaniem maili do klientów
 * 
 * @author Łukasz Kruk
 *
 */
public interface MailService {
	/**
	 * Metoda realizująca wysłanie wiadomości email
	 * 
	 * @param from
	 *            nadawca
	 * @param to
	 *            odbiorca
	 * @param subject
	 *            temat
	 * @param msg
	 *            wiadomość
	 */
	public void sendMail(String from, String to, String subject, String msg);

	/**
	 * Metoda realizująca wysyłanie wiadomości email z potwierdzeniem złożenia
	 * zamówienia
	 * 
	 * @param order
	 *            zamówienie klienta {@link Order}
	 */
	public void sendOrderConfirmation(Order order);

	/**
	 * Metoda realizująca wysyłanie wiadomości email z potwierdzeniem otrzymania
	 * wpłaty za zamówienie
	 * 
	 * @param order
	 *            zamówienie klienta {@link Order}
	 */
	public void sendPaymentConfirmation(Order order);

	/**
	 * Metoda realizująca wysłanie wiadomości email z informujące o wysłaniu
	 * przesyłki.
	 * 
	 * @param order
	 *            zamówienie klienta {@link Order}
	 */
	public void sendDeliveryConfirmation(Order order);
}
