package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs warstwy serwisu, definiuj¹cy metody zwi¹zane z logik¹ biznesow¹
 * zwi¹zan¹ z wysy³aniem maili do klientów
 * 
 * @author £ukasz Kruk
 *
 */
public interface MailService {
	/**
	 * Metoda realizuj¹ca wys³anie wiadomoœci email
	 * 
	 * @param from
	 *            nadawca
	 * @param to
	 *            odbiorca
	 * @param subject
	 *            temat
	 * @param msg
	 *            wiadomoœæ
	 */
	public void sendMail(String from, String to, String subject, String msg);

	/**
	 * Metoda realizuj¹ca wys³anie wiadomoœci email z potwierdzeniem z³o¿enia
	 * zamówienia
	 * 
	 * @param order
	 *            zamówienie klienta {@link Order}
	 */
	public void sendOrderConfirmation(Order order);

	/**
	 * Metoda realizuj¹ca wys³anie wiadomoœci email z potwierdzeniem otzrymania
	 * wp³aty za zmówienie zamówienia
	 * 
	 * @param order
	 *            zamówienie klienta {@link Order}
	 */
	public void sendPaymentConfirmation(Order order);

	/**
	 * Metoda realizuj¹ca wys³anie wiadomoœci email z informuj¹ce o wys³aniu
	 * przesy³ki.
	 * 
	 * @param order
	 *            zamówienie klienta {@link Order}
	 */
	public void sendDeliveryConfirmation(Order order);
}
