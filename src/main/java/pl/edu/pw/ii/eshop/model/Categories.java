package pl.edu.pw.ii.eshop.model;

/**
 * Klasa wyliczeniowa reprezentująca kategorie produktów.
 * 
 * @author Łukasz Kruk
 *
 */
public enum Categories {
	CERAMICS("ceramika"), JEWELLERY("biżuteria"), CARDS("kartki i zaproszenia"), FERNITURES("meble"), PAINTINGS(
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
	 * Metoda zwracająca opis kategorii.
	 * 
	 * @return opis kategorii
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Metoda ustawiająca opis kategorii
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
