/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Eletronics.view;

import com.Eletronics.services.ProductServices;
import java.awt.Color;
import com.Eletronics.services.CustomRendererOne;
import com.Eletronics.services.CustomRendererTwo;

/**
 *
 * @author pedro
 */
public class CustomerMangement extends javax.swing.JFrame {

    /**
     * Creates new form AdministratorManagement
     */
    public CustomerMangement() {
        super("ELETRONICS");
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        productList.setCellRenderer(new CustomRendererOne());
        list.setCellRenderer(new CustomRendererTwo());
        logoTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/logoTop.png"))); 
        scrollPane.setVisible(false);
        productList.setModel(ProductServices.getProductDatabase());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new HomeScreen.jPanelGradient();
        logoTop = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        profileButton = new javax.swing.JLabel();
        aboutButton = new javax.swing.JLabel();
        logOutButton = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        list = new javax.swing.JList<>();
        scrollPane2 = new javax.swing.JScrollPane();
        productList = new javax.swing.JList<>();

        jLabel2.setFont(new java.awt.Font("Nortar", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("LOGIN");

        jLabel3.setFont(new java.awt.Font("Nortar", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("LOGIN");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(java.awt.Color.darkGray);

        jLabel1.setFont(new java.awt.Font("Nortar", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ELETRONICS");

        profileButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profileButton.setForeground(new java.awt.Color(204, 204, 204));
        profileButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileButton.setText("MEU PERFIL");
        profileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileButtonMouseExited(evt);
            }
        });

        aboutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aboutButton.setForeground(new java.awt.Color(204, 204, 204));
        aboutButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aboutButton.setText("SOBRE");
        aboutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutButtonMouseExited(evt);
            }
        });

        logOutButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        logOutButton.setForeground(java.awt.Color.pink);
        logOutButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logOutButton.setText("SAIR");
        logOutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                            .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(logoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(profileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(logOutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addGap(40, 40, 40))
        );

        jLabel4.setFont(new java.awt.Font("Nortar", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ELETRONICS");

        jLabel5.setFont(new java.awt.Font("Nortar", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("SHOPPING");

        searchField.setBackground(new java.awt.Color(255, 255, 255));
        searchField.setForeground(new java.awt.Color(0, 0, 0));
        searchField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setBorder(null);
        scrollPane.setForeground(new java.awt.Color(0, 0, 0));

        list.setBackground(new java.awt.Color(255, 255, 255));
        list.setBorder(null);
        list.setForeground(new java.awt.Color(0, 0, 0));
        list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(list);

        scrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane2.setBorder(null);
        scrollPane2.setForeground(new java.awt.Color(0, 0, 0));
        scrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        productList.setBackground(new java.awt.Color(255, 255, 255));
        productList.setBorder(null);
        productList.setForeground(new java.awt.Color(0, 0, 0));
        productList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productListMouseClicked(evt);
            }
        });
        scrollPane2.setViewportView(productList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addComponent(searchField)
                    .addComponent(scrollPane))
                .addGap(30, 30, 30)
                .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(0, 0, 0)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void profileButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseEntered
        // TODO add your handling code here:
        profileButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_profileButtonMouseEntered

    private void profileButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseExited
        // TODO add your handling code here:
        profileButton.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_profileButtonMouseExited

    private void aboutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseEntered
        // TODO add your handling code here:
        aboutButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_aboutButtonMouseEntered

    private void aboutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutButtonMouseExited
        // TODO add your handling code here:
        aboutButton.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_aboutButtonMouseExited

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        // TODO add your handling code here:
        logOutButton.setForeground(Color.red);
    }//GEN-LAST:event_logOutButtonMouseEntered

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        // TODO add your handling code here:
        logOutButton.setForeground(Color.pink);
    }//GEN-LAST:event_logOutButtonMouseExited

    private void logOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseClicked
        // TODO add your handling code here:
        HomeScreen home = new HomeScreen();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutButtonMouseClicked

    private void listMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listMouseClicked
        // TODO add your handling code here:
        ProductServices.showProduct(this, list);
    }//GEN-LAST:event_listMouseClicked

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        // TODO add your handling code here:
        list.setModel(ProductServices.searchProductDatabase(searchField, scrollPane));
    }//GEN-LAST:event_searchFieldKeyReleased

    private void productListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productListMouseClicked
        // TODO add your handling code here:
        if (productList.getModel().getSize() >  0)
            ProductServices.showProduct(this, productList);
    }//GEN-LAST:event_productListMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CustomerMangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerMangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerMangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerMangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerMangement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JList<String> list;
    private javax.swing.JLabel logOutButton;
    private javax.swing.JLabel logoTop;
    private javax.swing.JList<String> productList;
    private javax.swing.JLabel profileButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPane2;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables
}