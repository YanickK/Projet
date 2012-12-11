package Service;

/**
 * Cette classe contient des informations relative a une facture
 * 
 * @author Nick
 */

public class Facture {
	
	private String prénomServeur;
	private int tableNum;
	private int conviveNum;
	private Repas[] repas = null; 
	private final double TAXE = 0.15; // taxe de 15%
	private double montantTaxe;
	private double sousTotal;
	private double total;
	
	public Facture() {
		// use the constructor to set the private values from the database
		// or test values
		resetFacture();
	}
	
	// calc/get montant des taxes
	public void calcMontantTaxe() {
		montantTaxe = sousTotal * TAXE;
	}
	public double getMontantTaxe() {
		return montantTaxe;
	}
	
	// calc/get soustotal
	public void calcSousTotal(){
		for (Repas monRepas : repas){
			if(monRepas.getPrixRepas() != 0 &&  monRepas.getQtéRepas() != 0)	
				sousTotal += monRepas.getPrixRepas() * monRepas.getQtéRepas();	
		}
	}	
	public double getSousTotal(){
		return sousTotal;
	}
	
	// calc/get total
	public void calcTotal(){
		total = sousTotal + montantTaxe;		
	}	
	public double getTotal(){
		return total;
	}
	
	// get/set prénom serveur
	public String getPrénomServeur(){
		return prénomServeur;
	}	
	public void setPrénomServeur(String prénom){
		prénomServeur = prénom;
	}
	
	// get/set table number
	public int getTableNum(){
		return tableNum;
	}	
	public void setTableNum(int table){
		tableNum = table;
	}
	
	// get/set convive number
	public int getConviveNum(){
		return conviveNum;
	}	
	public void setConviveNum(int convive){
		conviveNum = convive;
	}	

	public Repas[] getRepas() {
		return repas;
	}
	public void setRepas(Repas[] maListDeRepas) {
		repas = maListDeRepas;
	}
	
	public void resetFacture(){
		prénomServeur = "";
		tableNum = 0;
		conviveNum = 0;
		if(repas == null){
			repas = new Repas[10]; //10 repas par convive maximum
		}
		else{
			for (Repas monRepas : repas){
				monRepas.resetRepas();	
			}
		}
		montantTaxe = 0;
		sousTotal = 0;
		total = 0;
	}
	// for testing purposes
	public void loadFacture(String pré, int tab, int conv, Repas[] listRepas){
		prénomServeur = pré;
		tableNum = tab;
		conviveNum = conv;
		setRepas(listRepas);	
	}
	
	// C'est dans cette methode qu'il faut se connecter à la base de données
	// afin d'enregistrer les données contenu dans l'objet facture 
	// Faire un UPDATE (en sql) et y insérer les attribues privées
	// dans les tables correspondantes
	public void saveFacture(){
		
	}
	
}
