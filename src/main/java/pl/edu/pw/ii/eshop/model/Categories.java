package pl.edu.pw.ii.eshop.model;

/**
 * Klasa wyliczeniowa reprezentuj¹ca kategorie produktów.
 * 
 * @author Agnieszka Œwiderska
 *
 */
public enum Categories {
	CERAMICS("ceramika"), JEWELLERY("bi¿uteria"), CARDS("kartki i zaproszenia"), FERNITURES("meble"), PAINTINGS(
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
	 * Metoda zwracaj¹ca opis kategorii.
	 * 
	 * @return opis kategorii
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metoda ustawiaj¹ca opis kategorii
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
