package pl.edu.pw.ii.eshop.model;

/**
 * Klasa wyliczeniowa, reprezentująca status zamówienia
 * 
 * @author Agnieszka Świderska
 *
 */

public enum Status {
	NEW("NOWY"), PAYMENT_RECEIVED("ZAPŁACONE"), SENT("WYSŁANE"), COMPLETED("ZAKOŃCZONE");

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
