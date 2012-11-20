package whatever;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Charger le JDBC driver:
		Class.forName("org.sqlite.JDBC");
		
		//Connecter à la BD		
		Connection conn = DriverManager.getConnection("jdbc:sqlite:/path/to/your/db/demo.db");
                
        //Préparation des requêtes
		Statement stat = conn.createStatement();
        ResultSet rs=stat.executeQuery("SELECT * from notre_table");
        
        //Loop pour les résultats
        while(rs.next()){
        	System.out.println(rs.getString("nom_de_la_colonne"));
        }
        
        //Terminer la connection
        conn.close();

	}

}
