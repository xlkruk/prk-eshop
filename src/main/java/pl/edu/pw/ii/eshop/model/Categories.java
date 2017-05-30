package pl.edu.pw.ii.eshop.model;

/**
 * Klasa wyliczeniowa reprezentuj�ca kategorie produkt�w.
 * 
 * @author Agnieszka �widerska
 *
 */
public enum Categories {
	CERAMICS("ceramika"), JEWELLERY("bi�uteria"), CARDS("kartki i zaproszenia"), FERNITURES("meble"), PAINTINGS(
			"obrazy i ramki"), BAGS("torby");

	private String description;

	/**
	 * Kosntruktor
	 * 
	 * @param description
	 *            opis kategorii
	 */
	Categories(String description) {
		this.description = description;
	}

	/**
	 * Metoda zwracaj�ca opis kategorii.
	 * 
	 * @return opis kategorii
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metoda ustawiaj�ca opis kategorii
	 * 
	 * @param description
	 *            opis kategorii.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return getDescription();

	}
}
