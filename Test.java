package javaListes;

import java.util.HashMap;

public class Test {
	static HashMap<Produit, Integer> stock = new HashMap<Produit, Integer>();

	public static void main(String[] args) {
		remplirStock();	
		acheter(findInStock("livre 2"), 24);
	}

	static void remplirStock() {
		for (int i = 1; i <= 10; i++)
			stock.put(new Produit("Livre " + i), 25);
	}

	private static Produit findInStock(String libelle) {
		for (Produit elt : stock.keySet()) {
			if (elt.getLibelle().equalsIgnoreCase(libelle))
				return elt;
		}
		return null;
	}

	private static void afficherStock() {
		System.out.println("Le stock :");
		for (Produit elt : stock.keySet()) 
			System.out.println(elt.getLibelle() + " : " + stock.get(elt) + " unités");		
	}
	
	static void acheter(Produit prod, int quantite) {
		if (prod != null) {
			System.out.println("Achat de " + quantite + " unités de " + prod.getLibelle());
			diminuerStock(prod, quantite);	
		}
		else
			System.out.println("Achat non abouti");
		afficherStock();
	}

	private static void diminuerStock(Produit prod, int quantite) {
		augmenterStock(prod, quantite * -1);
	}

	private static void augmenterStock(Produit prod, int quantite) {
		for (Produit elt : stock.keySet()) {
			if (elt.getId() == prod.getId()) {
				if (quantite < 0) {
					if (stock.get(elt) + quantite >= 0)
						stock.put(elt, stock.get(elt) + quantite);
					else
						System.out.println("Le stock de produit " + prod.getLibelle() + " est insuffisant");
				} else
					stock.put(elt, stock.get(elt) + quantite);
			}
		}
	}
}
