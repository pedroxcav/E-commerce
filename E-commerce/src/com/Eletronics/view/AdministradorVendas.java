package com.Eletronics.view;

import com.Eletronics.model.Administrador;
import com.Eletronics.model.Cliente;
import com.Eletronics.services.ClienteServices;
import com.Eletronics.services.CompraServices;
import com.Eletronics.services.VendaServices;
import com.Eletronics.services.renderers.RenderizadorQuatro;
import com.Eletronics.services.renderers.RenderizadorSete;
import java.awt.Color;
import javax.swing.DefaultListModel;

public class AdministradorVendas extends javax.swing.JFrame {
    private Administrador administrador;
    
    public AdministradorVendas() {
        super("ELETRONICS");
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        logoTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/logoTop.png")));
    }
    
    public AdministradorVendas(Administrador administrador) {
        super("ELETRONICS");
        initComponents();
        this.administrador = administrador;
        getContentPane().setBackground(Color.WHITE);
        Campo_Lista1.setCellRenderer(new RenderizadorQuatro());
        Campo_Lista2.setCellRenderer(new RenderizadorSete());
        logoTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/logoTop.png")));
        Campo_Lista1.setModel(ClienteServices.trazerClientes());
        Campo_Lista2.setModel(VendaServices.trazerVendas());
        Campo_Valor.setText("R$ "+CompraServices.definirValortotal(Campo_Lista2));
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
        jPanel1 = new com.Eletronics.view.TelaInicial.jPanelGradient();
        logoTop = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        profileButton = new javax.swing.JLabel();
        aboutButton = new javax.swing.JLabel();
        voltar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Campo_Selecionado = new javax.swing.JLabel();
        Campo_Valor = new javax.swing.JLabel();
        scrollPane1 = new javax.swing.JScrollPane();
        Campo_Lista1 = new javax.swing.JList<>();
        desmarcar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        scrollPane2 = new javax.swing.JScrollPane();
        Campo_Lista2 = new javax.swing.JList<>();

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileButtonMouseClicked(evt);
            }
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

        voltar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        voltar.setForeground(new java.awt.Color(204, 204, 204));
        voltar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        voltar.setText("VOLTAR");
        voltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                voltarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                voltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                voltarMouseExited(evt);
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
                            .addComponent(voltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addComponent(voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addGap(40, 40, 40))
        );

        jLabel4.setFont(new java.awt.Font("Nortar", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("ELETRONICS");

        jLabel6.setFont(new java.awt.Font("Nortar", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("CLIENTES");

        jLabel5.setFont(new java.awt.Font("Nortar", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TOTAL");

        Campo_Selecionado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Campo_Selecionado.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Selecionado.setText("SELECIONADO: TODOS");

        Campo_Valor.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Campo_Valor.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Valor.setText("R$ 000.000,00");

        scrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane1.setBorder(null);
        scrollPane1.setForeground(new java.awt.Color(0, 0, 0));
        scrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Campo_Lista1.setBackground(new java.awt.Color(255, 255, 255));
        Campo_Lista1.setBorder(null);
        Campo_Lista1.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Lista1.setFixedCellHeight(30);
        Campo_Lista1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Campo_Lista1MouseClicked(evt);
            }
        });
        scrollPane1.setViewportView(Campo_Lista1);

        desmarcar.setBackground(new java.awt.Color(255, 255, 255));
        desmarcar.setFont(new java.awt.Font("Nortar", 0, 14)); // NOI18N
        desmarcar.setForeground(new java.awt.Color(0, 0, 0));
        desmarcar.setText("DESMARCAR");
        desmarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desmarcarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Nortar", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("VENDAS");

        scrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane2.setBorder(null);
        scrollPane2.setForeground(new java.awt.Color(0, 0, 0));
        scrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Campo_Lista2.setBackground(new java.awt.Color(255, 255, 255));
        Campo_Lista2.setBorder(null);
        Campo_Lista2.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Lista2.setFixedCellHeight(30);
        scrollPane2.setViewportView(Campo_Lista2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Campo_Selecionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(desmarcar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scrollPane2))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_Selecionado)
                        .addGap(18, 18, 18)
                        .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(desmarcar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(Campo_Valor)))
                .addGap(38, 38, 38))
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

    private void voltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseEntered
        // TODO add your handling code here:
        voltar.setForeground(Color.WHITE);
    }//GEN-LAST:event_voltarMouseEntered

    private void voltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseExited
        // TODO add your handling code here:
        voltar.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_voltarMouseExited

    private void voltarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_voltarMouseClicked
        // TODO add your handling code here:
        AdministradorMain administradorMain = new AdministradorMain(this.administrador);
        administradorMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarMouseClicked

    private void profileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileButtonMouseClicked
        // TODO add your handling code here:
        AdministradorPerfil administradorPerfi = new AdministradorPerfil(this.administrador);
        administradorPerfi.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileButtonMouseClicked

    private void desmarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desmarcarActionPerformed
        // TODO add your handling code here:
        if (Campo_Lista1.getSelectedIndex() != -1) {
            Campo_Lista1.setModel(ClienteServices.trazerClientes());
            Campo_Selecionado.setText("SELECIONADO: TODOS");
            Campo_Lista2.setModel(VendaServices.trazerVendas());
            Campo_Valor.setText("R$ "+CompraServices.definirValortotal(Campo_Lista2));
        }
    }//GEN-LAST:event_desmarcarActionPerformed

    private void Campo_Lista1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Campo_Lista1MouseClicked
        // TODO add your handling code here:
        if (Campo_Lista1.getModel().getSize() > 0) {
            DefaultListModel modelo = (DefaultListModel) Campo_Lista1.getModel();
            Cliente cliente = (Cliente) modelo.getElementAt(Campo_Lista1.getSelectedIndex());
            Campo_Selecionado.setText("SELECIONADO: ("+cliente.getID()+")");
            Campo_Lista2.setModel(VendaServices.trazerVendas(cliente));
            Campo_Valor.setText("R$ "+CompraServices.definirValortotal(Campo_Lista2));
        }
    }//GEN-LAST:event_Campo_Lista1MouseClicked

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
            java.util.logging.Logger.getLogger(AdministradorVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministradorVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministradorVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministradorVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AdministradorVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Campo_Lista1;
    private javax.swing.JList<String> Campo_Lista2;
    private javax.swing.JLabel Campo_Selecionado;
    private javax.swing.JLabel Campo_Valor;
    private javax.swing.JLabel aboutButton;
    private javax.swing.JButton desmarcar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoTop;
    private javax.swing.JLabel profileButton;
    private javax.swing.JScrollPane scrollPane1;
    private javax.swing.JScrollPane scrollPane2;
    private javax.swing.JLabel voltar;
    // End of variables declaration//GEN-END:variables
}