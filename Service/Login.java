/**
 * Commentaires de Maxime:
 * 
 * Java peut avoir un problème avec la ligne
 * Class.forName("org.sqlite.JDBC");
 * 
 * Si c'est le cas, voici ce qu'il faut faire (adapté à Eclipse Juno):
 * Project -> Properties -> Java Build Path -> Libraries -> Add JARs -> MYPATH/sqlite-jdbc-3.7.2
 * 
 * Pour fins de testing, il est possible d'utiliser le nom d'utilisateur / mot de passe suivant:
 * Marko
 * ZM12345
 */

package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login extends JFrame implements ActionListener{


	final String CHEMIN_POUR_ACCEDER_A_LA_BD="jdbc:sqlite:./src/Service/Employes.sqlite";

	private JButton cmdConfirmer;
	private JLabel lUsername;
	private JLabel lMotdepasse;
	private JLabel lConnexion;
	private JPasswordField txtPassword;
	private JTextField txtUserName;

	public Login() {
		initComponents();
	}

	private void initComponents() {

		txtPassword = new JPasswordField();
		txtUserName = new JTextField();
		lUsername = new JLabel("Nom d'usager : ");
		lMotdepasse = new JLabel("Mot de passe : ");
		lConnexion = new JLabel("Veuillez vous connecter au système");
		cmdConfirmer = new JButton("Confirmer");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lConnexion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N


		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGap(70, 70, 70)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lConnexion)
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(lUsername)
												.addComponent(lMotdepasse))
												.addGap(37, 37, 37)
												.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(cmdConfirmer)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(txtUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
																.addComponent(txtPassword)))))
																.addContainerGap(90, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(56, Short.MAX_VALUE)
						.addComponent(lConnexion)
						.addGap(45, 45, 45)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lUsername))
								.addGap(18, 18, 18)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(lMotdepasse))
										.addGap(27, 27, 27)
										.addComponent(cmdConfirmer)
										.addGap(71, 71, 71))
				);

		cmdConfirmer.addActionListener(this);
		pack();
	}// </editor-fold>//GEN-END:initComponents

	private boolean DBConnect(String username, char[] motdepasseArr){
		boolean success = false;
		
		String password = "";
		for (int i = 0; i < motdepasseArr.length; i++)
			password+=motdepasseArr[i];
		//Charger le JDBC driver:
		try{
			Class.forName("org.sqlite.JDBC");

			//Connecter à la BD
			Connection conn = DriverManager.getConnection(CHEMIN_POUR_ACCEDER_A_LA_BD);

			//Préparation des requêtes
			Statement stat = conn.createStatement();
			ResultSet rs=stat.executeQuery("SELECT User_Name, MotDePasse from Employes");

			//Loop pour les résultats
			while(rs.next()){
				if(username.equals(rs.getString("User_Name"))&& password.equals(rs.getString("MotDePasse"))){
					success=true;
					break;
				}
			}
			
			//Terminer la connection
			conn.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		return success;
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	public void actionPerformed(ActionEvent ev) {
		if (DBConnect(txtUserName.getText(), txtPassword.getPassword())){
			setVisible(false);
			dispose();
			RestaurantGUI resto = new RestaurantGUI();
			resto.setVisible(true);
		}

	}
}
