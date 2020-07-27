package javaListes;

public class Produit {
	private int id;
	private String libelle;
	private static int compteur=0;
	
	public Produit(int id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public Produit(String libelle) {
		compteur++;
		this.id=compteur;
		this.libelle = libelle;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + "]";
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
