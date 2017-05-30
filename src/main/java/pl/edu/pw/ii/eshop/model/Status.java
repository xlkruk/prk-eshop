package pl.edu.pw.ii.eshop.model;

/**
 * Klasa wyliczeniowa, reprezentuj¹ca status zamówienia
 * 
 * @author Agnieszka Œwiderska
 *
 */

public enum Status {
	NEW("NOWY"), PAYMENT_RECEIVED("ZAP£ACONE"), SENT("WYS£ANE"), COMPLETED("ZAKOÑCZONE");

	private String description;

	Status(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return getDescription();

	}
}
