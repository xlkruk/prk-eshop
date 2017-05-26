package pl.edu.pw.ii.eshop.model;

public enum Categories {
	CERAMICS("ceramika"), JEWELLERY("bi¿uteria"), CARDS("kartki i zaproszenia"), FERNITURES("meble"), PAINTINGS("obrazy i ramki"), BAGS("torby");

	private String description;

	Categories(String description) {
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
