package com.Eletronics.view;

import com.Eletronics.model.Cliente;
import com.Eletronics.model.Produto;
import com.Eletronics.services.ProdutoServices;
import com.Eletronics.services.renderers.RenderizadorDois;
import java.awt.Color;
import javax.swing.DefaultListModel;

public class ClienteMain extends javax.swing.JFrame {
    private Cliente cliente;
    
    public ClienteMain() {
        super("ELETRONICS");
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        Campo_Lista.setCellRenderer(new RenderizadorDois());
        logoTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/logoTop.png")));
        Campo_Lista.setModel(ProdutoServices.trazerProdutos());
    }
    
    public ClienteMain(Cliente cliente) {
        super("ELETRONICS");
        initComponents();
        this.cliente = cliente;
        getContentPane().setBackground(Color.WHITE);
        Campo_Lista.setCellRenderer(new RenderizadorDois());
        logoTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/logoTop.png")));
        Campo_Lista.setModel(ProdutoServices.trazerProdutos());
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
        perfil = new javax.swing.JLabel();
        aboutButton = new javax.swing.JLabel();
        logOutButton = new javax.swing.JLabel();
        cartButton = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Campo_Pesquisa = new javax.swing.JTextField();
        scrollPane = new javax.swing.JScrollPane();
        Campo_Lista = new javax.swing.JList<>();

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

        perfil.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        perfil.setForeground(new java.awt.Color(204, 204, 204));
        perfil.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        perfil.setText("MEU PERFIL");
        perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                perfilMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                perfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                perfilMouseExited(evt);
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

        cartButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cartButton.setForeground(new java.awt.Color(204, 204, 204));
        cartButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cartButton.setText("CARRINHO");
        cartButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cartButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cartButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cartButtonMouseExited(evt);
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
                            .addComponent(aboutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cartButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(perfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))))
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
                .addComponent(perfil)
                .addGap(40, 40, 40)
                .addComponent(cartButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
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

        Campo_Pesquisa.setBackground(new java.awt.Color(255, 255, 255));
        Campo_Pesquisa.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Pesquisa.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        Campo_Pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Campo_PesquisaActionPerformed(evt);
            }
        });
        Campo_Pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Campo_PesquisaKeyReleased(evt);
            }
        });

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setBorder(null);
        scrollPane.setForeground(new java.awt.Color(0, 0, 0));
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        Campo_Lista.setBackground(new java.awt.Color(255, 255, 255));
        Campo_Lista.setBorder(null);
        Campo_Lista.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Campo_ListaMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(Campo_Lista);

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
                    .addComponent(Campo_Pesquisa)
                    .addComponent(scrollPane))
                .addContainerGap(316, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(0, 0, 0)
                .addComponent(Campo_Pesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void perfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilMouseEntered
        // TODO add your handling code here:
        perfil.setForeground(Color.WHITE);
    }//GEN-LAST:event_perfilMouseEntered

    private void perfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilMouseExited
        // TODO add your handling code here:
        perfil.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_perfilMouseExited

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
        TelaInicial home = new TelaInicial();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutButtonMouseClicked

    private void Campo_PesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Campo_PesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Campo_PesquisaActionPerformed

    private void Campo_PesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Campo_PesquisaKeyReleased
        // TODO add your handling code here:
        Campo_Lista.setModel(ProdutoServices.trazerProdutos(Campo_Pesquisa.getText()));
    }//GEN-LAST:event_Campo_PesquisaKeyReleased

    private void Campo_ListaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Campo_ListaMouseClicked
        // TODO add your handling code here:
        if (Campo_Lista.getModel().getSize() > 0) {
            DefaultListModel modelo = (DefaultListModel) Campo_Lista.getModel();
            Produto produto = (Produto) modelo.get(Campo_Lista.getSelectedIndex());
            ClienteProduto clienteProduto = new ClienteProduto(produto, cliente);
            clienteProduto.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_Campo_ListaMouseClicked

    private void cartButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseClicked
        // TODO add your handling code here:
        ClienteCarrinho clienteCarrinho = new ClienteCarrinho(cliente);
        clienteCarrinho.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cartButtonMouseClicked

    private void cartButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseEntered
        // TODO add your handling code here:
        cartButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_cartButtonMouseEntered

    private void cartButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cartButtonMouseExited
        // TODO add your handling code here:
        cartButton.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_cartButtonMouseExited

    private void perfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_perfilMouseClicked
        // TODO add your handling code here:
        ClientePerfil clientePerfil = new ClientePerfil(cliente);
        clientePerfil.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_perfilMouseClicked

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
            java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ClienteMain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> Campo_Lista;
    private javax.swing.JTextField Campo_Pesquisa;
    private javax.swing.JLabel aboutButton;
    private javax.swing.JLabel cartButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logOutButton;
    private javax.swing.JLabel logoTop;
    private javax.swing.JLabel perfil;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}