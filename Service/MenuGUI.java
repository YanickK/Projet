package Service;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class MenuGUI extends javax.swing.JFrame implements ActionListener {


	public MenuGUI() {
		initComponents();
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:sqlite:/path/to/your/db/demo.db");


			//Préparation des requêtes
			Statement stat = conn.createStatement();
			ResultSet rs=stat.executeQuery("SELECT * from notre_table");

			//Loop pour les résultats
			while(rs.next()){
				System.out.println(rs.getString("nom_de_la_colonne"));
			}

			//Terminer la connection
			conn.close();		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	private void initComponents() {

		cmdRecommencer = new JButton();
		cmdConfimer = new JButton();
		cmdAnnuler = new JButton();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel5 = new JLabel();
		jButton1 = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		cmdRecommencer.setText("Recommencer");

		cmdConfimer.setText("Confirmer");

		cmdAnnuler.setText("Annuler");

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel1.setText("Entrées");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel2.setText("Plats");

		jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel3.setText("Desserts");

		jLabel5.setText("qtéEntré1");

		jButton1.setText("Entrée 1");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(cmdRecommencer)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(cmdConfimer)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(cmdAnnuler)
						.addContainerGap())
						.addGroup(layout.createSequentialGroup()
								.addGap(38, 38, 38)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jButton1)
												.addGap(44, 44, 44)
												.addComponent(jLabel5)
												.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
												.addGroup(layout.createSequentialGroup()
														.addComponent(jLabel1)
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
														.addComponent(jLabel2)
														.addGap(249, 249, 249)
														.addComponent(jLabel3)
														.addGap(194, 194, 194))))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1)
								.addComponent(jLabel2)
								.addComponent(jLabel3))
								.addGap(24, 24, 24)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel5)
										.addComponent(jButton1))
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 324, Short.MAX_VALUE)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(cmdRecommencer)
												.addComponent(cmdConfimer)
												.addComponent(cmdAnnuler))
												.addContainerGap())
				);

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
				new MenuGUI().setVisible(true);
			}
		});
	}

	private JButton cmdAnnuler;
	private JButton cmdConfimer;
	private JButton cmdRecommencer;
	private JButton jButton1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel5;

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

	}

}
