/**
 * Commentaires de Maxime:
 * 
 * Vous noterez qu'il est désormais impossible de lancer ServiceGUI directement.
 * Pour le tester, il faut passer par RestaurantGUI, qui est lui-même appelé à partir de Login.java.
 * 
 */

package Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServiceGUI extends JFrame implements ActionListener {
    
	private JButton entreeConv1,entreeConv2,entreeConv3,entreeConv4,principalConv1,principalConv2,principalConv3,principalConv4,
	dessertConv1,dessertConv2,dessertConv3,dessertConv4;
    private JButton cmdFacture, cmdRetour, cmdValider;
    private JLabel lConvive1, lConvive2, lConvive3, lConvive4;

    public ServiceGUI() {
        initComponents();
    }

    private void initComponents() {
    	setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setBounds(0,0,screenSize.width, screenSize.height);
        
        GridBagConstraints gridBagConstraints;

        lConvive1 = new JLabel("Convive 1");
        lConvive2 = new JLabel("Convive 2");
        lConvive3 = new JLabel("Convive 3");
        lConvive4 = new JLabel("Convive 4");
        entreeConv1 = new JButton();
        entreeConv2 = new JButton();
        entreeConv3 = new JButton();
        entreeConv4 = new JButton();
        principalConv1 = new JButton();
        principalConv2 = new JButton();
        principalConv3 = new JButton();
        principalConv4 = new JButton();
        dessertConv1 = new JButton();
        dessertConv2 = new JButton();
        dessertConv3 = new JButton();
        dessertConv4 = new JButton();
        cmdFacture = new JButton("Facture");
        cmdRetour = new JButton("Retour");
        cmdValider = new JButton("Valider");
        
        entreeConv1.addActionListener(this);
        entreeConv2.addActionListener(this);
        entreeConv3.addActionListener(this);
        entreeConv4.addActionListener(this);
        principalConv1.addActionListener(this);
        principalConv2.addActionListener(this);
        principalConv3.addActionListener(this);
        principalConv4.addActionListener(this);
        dessertConv1.addActionListener(this);
        dessertConv2.addActionListener(this);
        dessertConv3.addActionListener(this);
        dessertConv4.addActionListener(this);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GridBagLayout layout = new GridBagLayout();
        layout.columnWidths = new int[] {screenWidth/5, screenWidth/5, screenWidth/5, screenWidth/5, screenWidth/5};
        layout.rowHeights = new int[] {screenHeight/10, screenHeight*3/10, screenHeight*3/10, screenHeight*3/10};
        getContentPane().setLayout(layout);

        lConvive1.setFont(new java.awt.Font("Tahoma", 0, 14));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(lConvive1, gridBagConstraints);

        lConvive2.setFont(new java.awt.Font("Tahoma", 0, 14));
        gridBagConstraints.gridx = 1;
        getContentPane().add(lConvive2, gridBagConstraints);

        lConvive3.setFont(new java.awt.Font("Tahoma", 0, 14));
        gridBagConstraints.gridx = 2;
        getContentPane().add(lConvive3, gridBagConstraints);

        lConvive4.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        gridBagConstraints.gridx = 3;
        getContentPane().add(lConvive4, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(entreeConv1, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(entreeConv2, gridBagConstraints);
        
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(entreeConv3, gridBagConstraints);
        
        gridBagConstraints.gridx = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(entreeConv4, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(principalConv1, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(principalConv2, gridBagConstraints);
        
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(principalConv3, gridBagConstraints);
        
        gridBagConstraints.gridx = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(principalConv4, gridBagConstraints);
        
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(dessertConv1, gridBagConstraints);
        
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(dessertConv2, gridBagConstraints);
        
        gridBagConstraints.gridx = 2;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(dessertConv3, gridBagConstraints);
        
        gridBagConstraints.gridx = 3;
        gridBagConstraints.fill = GridBagConstraints.BOTH;
        getContentPane().add(dessertConv4, gridBagConstraints);

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
    	new MenuGUI((JButton) source);
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
