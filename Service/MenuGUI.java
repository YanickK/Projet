package Service;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class MenuGUI extends javax.swing.JFrame implements ActionListener {

	final String DATABASEPATH="jdbc:sqlite:./src/Service/Repas.sqlite";
	private JButton cmdAnnuler, cmdConfirmer, cmdRecommencer;
	private String[] nomRepas = {"Entrées", "Plats principaux","Desserts"};
	private JLabel[] lRepas = new JLabel[nomRepas.length];

	//constructeur
	public MenuGUI(JButton source) {
		initComponents();
	}

	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setBounds(0,0,screenWidth, screenHeight);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {screenWidth/4, screenWidth/4, screenWidth/4, screenWidth/4};
		
		//Max, les 2 lignes ci-dessous devraient te trouver le nb max de plats tel que demandé
		NbMaxMenu monMenu = new NbMaxMenu(DATABASEPATH);
		public int monMenu.comparerMenu();
		
		layout.rowHeights = new int[] {screenHeight};
		getContentPane().setLayout(layout);


		//libellés pour identifier les convives
		gridBagConstraints.gridy=0;
		for (int i = 0; i<lRepas.length; i++){
			lRepas[i]= new JLabel(nomRepas[i]);
			lRepas[i].setFont(new java.awt.Font("Tahoma",0,14));
			gridBagConstraints.gridx=i;
			getContentPane().add(lRepas[i],gridBagConstraints);
		}


		Connection connRepas;
		try {
			connRepas = DriverManager.getConnection(DATABASEPATH);
			Statement stat = connRepas.createStatement();

			//boucle pour les entrees
			ResultSet rs=stat.executeQuery("SELECT * from Repas WHERE Menu = 'Entrée'");
			while(rs.next()){
				
				//ici, on pourra instancier chacun des items du menu
				System.out.println(rs.getString("Nom_Repas"));
			}

			connRepas.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}











		cmdRecommencer = new JButton("Recommencer");
		cmdConfirmer = new JButton("Confirmer");
		cmdAnnuler = new JButton("Annuler");

		cmdAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				annuler();
			}
		});

		pack();
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
			java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(MenuGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MenuGUI(new JButton()).setVisible(true);
			}
		});
	}

	//bouton pour revenir au menu précédent
	public void annuler(){
		this.setVisible(false);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

	}

}
