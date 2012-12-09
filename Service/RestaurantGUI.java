/**
 * Commentaires de Maxime:
 * 
 * Normalement, RestaurantGUI ne devrait pas être appelé directement.
 * Je n'ai pas encore enlevé la fonction qui override run() pour des fins de testing uniquement.
 * Elle devra être enlevée plus tard.
 */

package Service;


import java.awt.*;

public class RestaurantGUI extends javax.swing.JFrame {

    ServiceGUI table1;
    ServiceGUI table2;
    ServiceGUI table3;
    ServiceGUI table4;
    /**
     * Creates new form Restaurant
     */
    public RestaurantGUI() {
        initComponents();
        table1 = new ServiceGUI();
        table2 = new ServiceGUI();
        table3 = new ServiceGUI();
        table4 = new ServiceGUI();
    }

    private void initComponents() {
    	setUndecorated(true);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        setBounds(0,0,screenSize.width, screenSize.height);
        
        cmdTable2 = new javax.swing.JButton();
        cmdTable4 = new javax.swing.JButton();
        cmdTable1 = new javax.swing.JButton();
        cmdTable3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 830));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        
        cmdTable1.setText("Table 1");
        cmdTable1.setMaximumSize(new java.awt.Dimension(100, 100));
        cmdTable1.setMinimumSize(new java.awt.Dimension(100, 100));
        cmdTable1.setPreferredSize(new java.awt.Dimension(100, 100));
        cmdTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTable1ActionPerformed(evt);
            }
        });
        getContentPane().add(cmdTable1);
        cmdTable1.setBounds(430, 460, 100, 100);
        
        
        cmdTable2.setText("Table 2");
        cmdTable2.setMaximumSize(new java.awt.Dimension(100, 100));
        cmdTable2.setMinimumSize(new java.awt.Dimension(100, 100));
        cmdTable2.setPreferredSize(new java.awt.Dimension(100, 100));
        cmdTable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTable2ActionPerformed(evt);
            }
        });
        getContentPane().add(cmdTable2);
        cmdTable2.setBounds(610, 460, 100, 100);
        
        
        cmdTable3.setText("Table 3");
        cmdTable3.setMaximumSize(new java.awt.Dimension(100, 100));
        cmdTable3.setMinimumSize(new java.awt.Dimension(100, 100));
        cmdTable3.setPreferredSize(new java.awt.Dimension(100, 100));
        cmdTable3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTable3ActionPerformed(evt);
            }
        });
        getContentPane().add(cmdTable3);
        cmdTable3.setBounds(430, 620, 100, 100);
        

        cmdTable4.setText("Table 4");
        cmdTable4.setMaximumSize(new java.awt.Dimension(100, 100));
        cmdTable4.setMinimumSize(new java.awt.Dimension(100, 100));
        cmdTable4.setPreferredSize(new java.awt.Dimension(100, 100));
        cmdTable4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTable4ActionPerformed(evt);
            }
        });
        getContentPane().add(cmdTable4);
        cmdTable4.setBounds(610, 620, 100, 100);
        

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Légende");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 250, 100, 40);

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Occupé");
        jLabel3.setToolTipText("");
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 310, 80, 80);

        jLabel4.setBackground(new java.awt.Color(0, 255, 0));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Libre");
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 410, 80, 80);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Service/Restaurant.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 790);

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void setColor(){
        
        //Code qui va chercher les disponibiliés des 4 tables dans SQL
        //et affiche la couleur en conséquence.
        cmdTable1.setBackground(Color.GREEN);
        cmdTable2.setBackground(Color.RED);
        
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        setColor();
    }//GEN-LAST:event_formWindowOpened

    
    private void cmdTable1ActionPerformed(java.awt.event.ActionEvent evt) {
        table1.setVisible(true);
    }

    private void cmdTable2ActionPerformed(java.awt.event.ActionEvent evt) {
        table2.setVisible(true);     
    }

    private void cmdTable3ActionPerformed(java.awt.event.ActionEvent evt) {
        table3.setVisible(true);
    }

    private void cmdTable4ActionPerformed(java.awt.event.ActionEvent evt) {
        table4.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RestaurantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestaurantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestaurantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestaurantGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RestaurantGUI().setVisible(true);
            }
        });
    }
    
    private javax.swing.JButton cmdTable1;
    private javax.swing.JButton cmdTable2;
    private javax.swing.JButton cmdTable3;
    private javax.swing.JButton cmdTable4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
}
