package pl.edu.pw.ii.eshop.service;

import pl.edu.pw.ii.eshop.model.Order;

/**
 * Interfejs warstwy serwisu, definiuj�cy metody zwi�zane z logik� biznesow�
 * zwi�zan� z wysy�aniem maili do klient�w
 * 
 * @author �ukasz Kruk
 *
 */
public interface MailService {
	/**
	 * Metoda realizuj�ca wys�anie wiadomo�ci email
	 * 
	 * @param from
	 *            nadawca
	 * @param to
	 *            odbiorca
	 * @param subject
	 *            temat
	 * @param msg
	 *            wiadomo��
	 */
	public void sendMail(String from, String to, String subject, String msg);

	/**
	 * Metoda realizuj�ca wys�anie wiadomo�ci email z potwierdzeniem z�o�enia
	 * zam�wienia
	 * 
	 * @param order
	 *            zam�wienie klienta {@link Order}
	 */
	public void sendOrderConfirmation(Order order);

	/**
	 * Metoda realizuj�ca wys�anie wiadomo�ci email z potwierdzeniem otzrymania
	 * wp�aty za zm�wienie zam�wienia
	 * 
	 * @param order
	 *            zam�wienie klienta {@link Order}
	 */
	public void sendPaymentConfirmation(Order order);

	/**
	 * Metoda realizuj�ca wys�anie wiadomo�ci email z informuj�ce o wys�aniu
	 * przesy�ki.
	 * 
	 * @param order
	 *            zam�wienie klienta {@link Order}
	 */
	public void sendDeliveryConfirmation(Order order);
}
