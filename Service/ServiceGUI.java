/**
 * Commentaires de Maxime:
 * 
 * Vous noterez qu'il est désormais impossible de lancer ServiceGUI directement.
 * Pour le tester, il faut passer par Login.java, puis RestaurantGUI.java
 * 
 */

package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceGUI extends JFrame implements ActionListener {
	private JButton[][] typeRepas = new JButton[3][4];
	private JButton cmdFacture, cmdRetour, cmdValider;
	private JLabel[] convives = new JLabel[4];

	public ServiceGUI() {
		initComponents();
	}

	private void initComponents() {
		setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;
		int screenHeight = screenSize.height;
		setBounds(0,0,screenWidth, screenHeight);

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		cmdFacture = new JButton("Facture");
		cmdRetour = new JButton("Retour");
		cmdValider = new JButton("Valider");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] {screenWidth/5, screenWidth/5, screenWidth/5, screenWidth/5, screenWidth/5};
		layout.rowHeights = new int[] {screenHeight/10, screenHeight*3/10, screenHeight*3/10, screenHeight*3/10};
		getContentPane().setLayout(layout);

		//libellés pour identifier les convives
		gridBagConstraints.gridy=0;
		for (int i = 0; i<convives.length; i++){
			convives[i]= new JLabel("Convive "+(i+1));
			convives[i].setFont(new java.awt.Font("Tahoma",0,14));
			gridBagConstraints.gridx=i;
			getContentPane().add(convives[i],gridBagConstraints);
		}
		
		//boutons pour les repas, classés en fonction du type
		for (int i = 0; i < typeRepas.length; i++){
			gridBagConstraints.gridy=i+1;
			for (int j = 0; j < typeRepas[i].length; j++)
			{
				typeRepas[i][j]=new JButton();
				typeRepas[i][j].addActionListener(this);
				gridBagConstraints.gridx=j;
				gridBagConstraints.fill = GridBagConstraints.BOTH;
				getContentPane().add(typeRepas[i][j],gridBagConstraints);
			}
		}

		cmdFacture.setFont(new java.awt.Font("Tahoma", 0, 14));
		cmdFacture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				calculerFacture();
			}
		});
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		getContentPane().add(cmdFacture, gridBagConstraints);

		cmdRetour.setFont(new Font("Tahoma", 0, 14));
		cmdRetour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				retour();
			}
		});
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 1;
		getContentPane().add(cmdRetour, gridBagConstraints);

		cmdValider.setFont(new Font("Tahoma", 0, 14));
		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		getContentPane().add(cmdValider, gridBagConstraints);

		pack();
	}

	private void calculerFacture() {

	}

	private void retour(){
		this.setVisible(false);
	}

	//méthode générale pour tous les boutons de commande
	public void actionPerformed(ActionEvent ev){
		Object source = ev.getSource();
		for (int i = 0; i < typeRepas.length; i++)
			for (int j = 0; j<typeRepas[i].length; j++)
				if (source == typeRepas[i][j]){
					new MenuGUI((JButton) source).setVisible(true);
					break;
				}
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
			java.util.logging.Logger.getLogger(Serveur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Serveur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Serveur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Serveur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
	}
}
