package Service;

public class ProjectStart {

	/**
	 * Cette classe est le point d'enter du project et donne accès 
	 * au données persistantes de l'application. Peut aussi être utiliser
	 * pour des tests.
	 */
	
	private static Table theTables = new Table();
	private static Facture[] facture = new Facture[4];// 4 facture par table
	// for testing 
	private Repas[][] listRepas = new Repas[4][10];//4 convive pour 10 repas chacun max
		
	private ProjectStart() {
		// next line is for testing
		testData();
	}	
	
	public static void main(String[] args) {		
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantGUI().setVisible(true);
            }
        });
	}
	
	public static Table getTables(){		
		return theTables;		
	}
	// get/set pour les factures
	public static Facture[] getFacture() {
		return facture;
	}
	
	// for testing purposes
	public void testData(){

		// crée une liste de repas fictive pour les besoins de test
		///////// CONVIVE 1: 3 entrée, 3 plats principaux, 3 deserts.
		// Dans l'ordre les attribues sont: type de repas, nom du repas
		// prix du repas et quantité du repas
		listRepas[0][0].LoadRepas("Entrée", "Café", 1.99, 1);
		listRepas[0][1].LoadRepas("Entrée", "Jus", 2.99, 2);
		listRepas[0][2].LoadRepas("Entrée", "Boisson gazeuse", 1.99, 1);

		listRepas[0][3].LoadRepas("Principal", "Hamburger du chef", 8.99, 2);
		listRepas[0][4].LoadRepas("Principal", "Burrito", 7.99, 1);
		listRepas[0][0].LoadRepas("Principal", "Frites", 3.99, 2);

		listRepas[0][5].LoadRepas("Désert", "Galettes de sarrazin", 11.99, 4);
		listRepas[0][6].LoadRepas("Désert", "Scones", 6.99, 2);
		listRepas[0][7].LoadRepas("Désert", "Soupe du jour", 5.99, 1);

		/////////// CONVIVE 2: 1 entrée, 1 plats principaux, 1 deserts
		//listRepas[1][0].LoadRepas("Entrée", "Café", 1.99, 1);
		//listRepas[1][1].LoadRepas("Entrée", "Jus", 2.99, 2);
		listRepas[1][2].LoadRepas("Entrée", "Boisson gazeuse", 1.99, 1);

		listRepas[1][3].LoadRepas("Principal", "Hamburger du chef", 8.99, 2);
		//listRepas[1][4].LoadRepas("Principal", "Burrito", 7.99, 1);
		//listRepas[1][0].LoadRepas("Principal", "Frites", 3.99, 2);

		//listRepas[1][5].LoadRepas("Désert", "Galettes de sarrazin", 11.99, 4);
		listRepas[1][6].LoadRepas("Désert", "Scones", 6.99, 2);
		//listRepas[1][7].LoadRepas("Désert", "Soupe du jour", 5.99, 1);
		
		////////// CONVIVE 3: 2 entrée, 2 plats principaux, 2 deserts
		listRepas[2][0].LoadRepas("Entrée", "Café", 1.99, 1);
		listRepas[2][1].LoadRepas("Entrée", "Jus", 2.99, 2);
		//listRepas[3][2].LoadRepas("Entrée", "Boisson gazeuse", 1.99, 1);

		//listRepas[2][3].LoadRepas("Principal", "Hamburger du chef", 8.99, 2);
		listRepas[2][4].LoadRepas("Principal", "Burrito", 7.99, 1);
		listRepas[2][0].LoadRepas("Principal", "Frites", 3.99, 2);

		listRepas[2][5].LoadRepas("Désert", "Galettes de sarrazin", 11.99, 4);
		//listRepas[2][6].LoadRepas("Désert", "Scones", 6.99, 2);
		listRepas[2][7].LoadRepas("Désert", "Soupe du jour", 5.99, 1);

		/////////// CONVIVE 4: 1 entrée, 2 plats principaux, 1 deserts
		//listRepas[3][0].LoadRepas("Entrée", "Café", 1.99, 1);
		listRepas[3][1].LoadRepas("Entrée", "Jus", 2.99, 2);
		//listRepas[3][2].LoadRepas("Entrée", "Boisson gazeuse", 1.99, 1);

		listRepas[3][3].LoadRepas("Principal", "Hamburger du chef", 8.99, 2);
		//listRepas[3][4].LoadRepas("Principal", "Burrito", 7.99, 1);
		listRepas[3][0].LoadRepas("Principal", "Frites", 3.99, 2);

		//listRepas[3][5].LoadRepas("Désert", "Galettes de sarrazin", 11.99, 4);
		//listRepas[3][6].LoadRepas("Désert", "Scones", 6.99, 2);
		listRepas[3][7].LoadRepas("Désert", "Soupe du jour", 5.99, 1);
	
		
		// associer ces repas à une facture spécifique
		// Dans l'ordre les attribues sont: prénom du serveur(euse),
		// numero de table, numero du convive
			facture[0].loadFacture("Jane", 1, 1, listRepas[0]);
			facture[1].loadFacture("Jane", 1, 2, listRepas[1]);
			facture[2].loadFacture("Jane", 1, 3, listRepas[2]);
			facture[3].loadFacture("Jane", 1, 4, listRepas[3]);		

	}

}
