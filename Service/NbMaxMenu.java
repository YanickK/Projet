

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;

public class NbMaxMenu{
	private int resultat=0;
	private String DBString="";
	public NbMaxMenu(String DBString){
		this.DBString=DBString;
	}
	
	public int DBConnect(String param){
		
		//Charger le JDBC driver:
		try{
		Class.forName("org.sqlite.JDBC");

		//Connecter à la BD
		Connection conn = DriverManager.getConnection(DBString);
                
        //Préparation des requêtes
		Statement stat = conn.createStatement();
        ResultSet rs=stat.executeQuery("SELECT COUNT(*) FROM Repas WHERE Menu='"+param+"'");
        
        //Loop pour les résultats
        while(rs.next()){
        	resultat=Integer.parseInt(rs.getString(1));
        	
         }
        
        //Terminer la connection
        conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return resultat;
	}
	
	public int getPlatPrincipal(){
		return this.DBConnect("Plat principal");
	}
	public int getDessert(){
		return this.DBConnect("Dessert");
		
	}
	public int getEntree(){
		return this.DBConnect("Entrée");
	}
	public int comparerMenu(){
		int[] items={getEntree(),getDessert(),getPlatPrincipal()};
		Arrays.sort(items);
		return items[items.length-1];
	}
}
