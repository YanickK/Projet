package Service;


import java.awt.*;

public class RestaurantGUI extends javax.swing.JFrame {

    ServiceGUI table1;
    ServiceGUI table2;
    ServiceGUI table3;
    ServiceGUI table4;
 
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

        cmdLogout = new javax.swing.JButton();
        cmdTable1 = new javax.swing.JButton();
        cmdTable2 = new javax.swing.JButton();
        cmdTable3 = new javax.swing.JButton();
        cmdTable4 = new javax.swing.JButton();
        lblLegende = new javax.swing.JLabel();
        lblOccupe = new javax.swing.JLabel();
        lblLibre = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 830));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        
        //Bouton logout
        cmdLogout.setText("Logout");
        cmdLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogoutActionPerformed(evt);
            }
        });
        cmdLogout.setBounds(40, 620, 80, 80);
        
        //Table 1
        cmdTable1.setText("Table 1");
        cmdTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTable1ActionPerformed(evt);
            }
        });
        cmdTable1.setBounds(430, 460, 100, 100);
        
        
        //Table 2
        cmdTable2.setText("Table 2");
        cmdTable2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTable2ActionPerformed(evt);
            }
        });
        cmdTable2.setBounds(610, 460, 100, 100);
        
        
        //Table 3
        cmdTable3.setText("Table 3");
        cmdTable3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTable3ActionPerformed(evt);
            }
        });
        cmdTable3.setBounds(430, 620, 100, 100);
        

        //Table 4
        cmdTable4.setText("Table 4");
        cmdTable4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdTable4ActionPerformed(evt);
            }
        });
        cmdTable4.setBounds(610, 620, 100, 100);
        lblOccupe.isFocusOwner();
        

        //Label légende
        lblLegende.setFont(new java.awt.Font("Tahoma", 0, 18));
        lblLegende.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLegende.setText("Légende");
        lblLegende.setBounds(30, 250, 100, 40);

        //Label occupé
        lblOccupe.setBackground(new java.awt.Color(255, 0, 0));
        lblOccupe.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblOccupe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOccupe.setText("Occupé");
        lblOccupe.setOpaque(true);
        lblOccupe.setBounds(40, 310, 80, 80);

        //Label libre
        lblLibre.setBackground(new java.awt.Color(0, 255, 0));
        lblLibre.setFont(new java.awt.Font("Tahoma", 0, 14));
        lblLibre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLibre.setText("Libre");
        lblLibre.setOpaque(true);
        lblLibre.setBounds(40, 410, 80, 80);

        //Image background du restaurant.
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Service/Restaurant.jpg")));
        lblImage.setBounds(0, 0, 800, 790);
        
        //Ajoute les éléments à la fenêtre.
        getContentPane().add(cmdLogout);
        getContentPane().add(cmdTable1);
        getContentPane().add(cmdTable2);
        getContentPane().add(cmdTable3);
        getContentPane().add(cmdTable4);
        getContentPane().add(lblLegende);
        getContentPane().add(lblOccupe);
        getContentPane().add(lblLibre);
        getContentPane().add(lblImage);

        pack();
    }
   
    private void setColor(){
        
        //Code qui va chercher les disponibiliés des 4 tables dans SQL
        //et affiche la couleur en conséquence.
        cmdTable1.setBackground(Color.GREEN);
        cmdTable2.setBackground(Color.RED);
        
    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        setColor();
    }
    
    private void cmdLogoutActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

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

    }
    
    //Déclaration des variables.
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdTable1;
    private javax.swing.JButton cmdTable2;
    private javax.swing.JButton cmdTable3;
    private javax.swing.JButton cmdTable4;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblLegende;
    private javax.swing.JLabel lblOccupe;
    private javax.swing.JLabel lblLibre;
}