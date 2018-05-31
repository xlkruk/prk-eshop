package pl.edu.pw.ii.eshop.model;

/**
 * Klasa wyliczeniowa, reprezentująca status zamówienia
 * 
 * @author Łukasz Kruk
 *
 */

public enum Status {
	NEW("NOWY"), PAYMENT_RECEIVED("ZAPŁACONE"), SENT("WYSŁANE"), COMPLETED("ZAKOŃCZONE");

	private String description;

	Status(String description) {
		this.description = description;
	}

	/**
	 * Metoda zwracająca opis
	 * 
	 * @return opis
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metoda ustawiająca opis
	 * 
	 * @param description
	 *            opis
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return getDescription();

	}
}
