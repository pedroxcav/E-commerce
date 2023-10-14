/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Eletronics.view;

import com.Eletronics.model.Celular;
import com.Eletronics.model.Cliente;
import com.Eletronics.model.Endereco;
import com.Eletronics.services.CelularServices;
import com.Eletronics.services.ClienteServices;
import com.Eletronics.services.EnderecoServices;
import com.Eletronics.services.exceptions.Exception_Cadastro;
import com.Eletronics.services.renderers.RenderizadorCinco;
import com.Eletronics.services.tools.Warning;
import java.awt.Color;
import javax.swing.DefaultListModel;

/**
 *
 * @author pedro
 */
public class ClientePerfil extends javax.swing.JFrame {
    private Cliente cliente;
    private Celular celular;
    private boolean permitirEdicao = false;
    
    /**
     * Creates new form AdministratorManagement
     */
    public ClientePerfil() {
        super("ELETRONICS");
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        profileField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/profileIcon.png")));
        logoTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/logoTop.png")));
    }
    
    public ClientePerfil(Cliente cliente) {
        super("ELETRONICS");
        initComponents();
        this.cliente = cliente;
        getContentPane().setBackground(Color.WHITE);
        profileField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/profileIcon.png")));
        logoTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/logoTop.png")));
        Campo_Nome.setText(cliente.getNome());
        Texto_Nome.setText(cliente.getNome().toUpperCase());
        Campo_ID.setText(cliente.getID());
        Campo_Senha.setText(cliente.getSenha());
        celular = CelularServices.trazerCelular(cliente.getID());
        if (celular != null)
            Campo_Celular.setText(celular.getDDD()+celular.getCelular());
        Campo_Lista.setCellRenderer(new RenderizadorCinco());
        Campo_Lista.setModel(EnderecoServices.trazerEnderecos(cliente));
    }
    
    private void atualizarDados() throws Exception_Cadastro {
        String nome = Campo_Nome.getText();
        String ID_Cliente = Campo_ID.getText();
        String senha = Campo_Senha.getText();
        if (!nome.equals(cliente.getNome()) || !ID_Cliente.equals(cliente.getID()) || !senha.equals(cliente.getSenha())) {
            ClienteServices.atualizar(new Cliente(ID_Cliente, nome, cliente.getCPF(), senha));
            cliente.setNome(nome);
            Texto_Nome.setText(nome.toUpperCase());
            cliente.setID(ID_Cliente);
            cliente.setSenha(senha);
        }
    }
    
    private void atualizarCelular() {
        Celular contato = CelularServices.formatarCelular(cliente, Campo_Celular.getText());
        
        String potencialCelular = contato == null ? null : contato.getDDD()+contato.getCelular();
        String celularCliente = celular == null ? null : celular.getDDD()+celular.getCelular();
        
        if (potencialCelular == null || celularCliente == null) {
            if ((potencialCelular == null && celularCliente == null)) {
                Campo_Celular.setText(null);
            } else if (potencialCelular != null && celularCliente == null) {
                CelularServices.registrar(contato);
                celular = contato;
            } else if (potencialCelular == null && celularCliente != null) {
                CelularServices.excluir(celular);
                Campo_Celular.setText(null);
                celular = null;
            }
        } else if (!potencialCelular.equals(celularCliente)) {
            CelularServices.atualizar(contato);
            celular = contato;
        }
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
        sobre = new javax.swing.JLabel();
        voltar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        profileField = new javax.swing.JLabel();
        Texto_Nome = new javax.swing.JLabel();
        editar = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        Campo_Lista = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        Campo_Nome = new javax.swing.JTextField();
        Campo_ID = new javax.swing.JTextField();
        Campo_Senha = new javax.swing.JTextField();
        editar1 = new javax.swing.JButton();
        Campo_Celular = new javax.swing.JTextField();

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

        sobre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sobre.setForeground(new java.awt.Color(204, 204, 204));
        sobre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sobre.setText("SOBRE");
        sobre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                sobreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                sobreMouseExited(evt);
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
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sobre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(voltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sobre)
                .addGap(40, 40, 40))
        );

        jLabel4.setFont(new java.awt.Font("Nortar", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("BEM VINDO");

        profileField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        Texto_Nome.setFont(new java.awt.Font("Nortar", 0, 30)); // NOI18N
        Texto_Nome.setForeground(new java.awt.Color(102, 102, 102));
        Texto_Nome.setText("NOME CLIENTE");

        editar.setBackground(new java.awt.Color(0, 0, 0));
        editar.setFont(new java.awt.Font("Nortar", 0, 14)); // NOI18N
        editar.setForeground(new java.awt.Color(255, 255, 255));
        editar.setText("EDITAR");
        editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarActionPerformed(evt);
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
        Campo_Lista.setFixedCellHeight(30);
        scrollPane.setViewportView(Campo_Lista);

        jLabel5.setFont(new java.awt.Font("Nortar", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("MEUS LOCAIS");

        Campo_Nome.setEditable(false);
        Campo_Nome.setBackground(new java.awt.Color(255, 255, 255));
        Campo_Nome.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Nome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "nome", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        Campo_ID.setEditable(false);
        Campo_ID.setBackground(new java.awt.Color(255, 255, 255));
        Campo_ID.setForeground(new java.awt.Color(0, 0, 0));
        Campo_ID.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        Campo_Senha.setEditable(false);
        Campo_Senha.setBackground(new java.awt.Color(255, 255, 255));
        Campo_Senha.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Senha.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "senha", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        editar1.setBackground(new java.awt.Color(255, 255, 255));
        editar1.setFont(new java.awt.Font("Nortar", 0, 14)); // NOI18N
        editar1.setForeground(new java.awt.Color(0, 0, 0));
        editar1.setText("EXCLUIR");
        editar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editar1ActionPerformed(evt);
            }
        });

        Campo_Celular.setEditable(false);
        Campo_Celular.setBackground(new java.awt.Color(255, 255, 255));
        Campo_Celular.setForeground(new java.awt.Color(0, 0, 0));
        Campo_Celular.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "celular", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(profileField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(Texto_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(editar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Campo_ID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Campo_Senha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Campo_Nome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Campo_Celular, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(scrollPane)
                            .addComponent(editar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Texto_Nome))
                    .addComponent(profileField, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Campo_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Campo_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void sobreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sobreMouseEntered
        // TODO add your handling code here:
        sobre.setForeground(Color.WHITE);
    }//GEN-LAST:event_sobreMouseEntered

    private void sobreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sobreMouseExited
        // TODO add your handling code here:
        sobre.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_sobreMouseExited

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
        ClienteMain clienteMain = new ClienteMain(cliente);
        clienteMain.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_voltarMouseClicked

    private void editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarActionPerformed
        // TODO add your handling code here:
        try {
            String nome = Campo_Nome.getText();
            String ID_Cliente = Campo_ID.getText();
            String senha = Campo_Senha.getText();
            if (nome.isEmpty() || ID_Cliente.isEmpty() || senha.isEmpty()) {
                Warning warning = new Warning("Dados incorretos.");
                warning.setVisible(true);
            } else if (this.permitirEdicao) {
                this.atualizarDados();

                this.permitirEdicao = false;

                editar.setForeground(Color.WHITE);
                editar.setBackground(Color.BLACK);
                editar.setText("EDITAR");

                Campo_Nome.setEditable(this.permitirEdicao);
                Campo_ID.setEditable(this.permitirEdicao);
                Campo_Senha.setEditable(this.permitirEdicao);
                Campo_Celular.setEditable(this.permitirEdicao);

                this.atualizarCelular();
            } else { 
                this.permitirEdicao = true;

                editar.setForeground(Color.BLACK);
                editar.setBackground(Color.WHITE);
                editar.setText("SALVAR");

                Campo_Nome.setEditable(this.permitirEdicao);
                Campo_ID.setEditable(this.permitirEdicao);
                Campo_Senha.setEditable(this.permitirEdicao);
                Campo_Celular.setEditable(this.permitirEdicao);
            }
        } catch (Exception_Cadastro e) {
            Warning warning = new Warning(e.getMessage());
            warning.setVisible(true);
        }
    }//GEN-LAST:event_editarActionPerformed

    private void editar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editar1ActionPerformed
        // TODO add your handling code here:
        if (Campo_Lista.getSelectedIndex() != -1) {
            DefaultListModel modelo = (DefaultListModel) Campo_Lista.getModel();
            Endereco endereco = (Endereco) modelo.getElementAt(Campo_Lista.getSelectedIndex());
            
            EnderecoServices.excluir(endereco);
            
            Campo_Lista.setModel(EnderecoServices.trazerEnderecos(cliente));
        }
    }//GEN-LAST:event_editar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ClientePerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientePerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientePerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientePerfil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ClientePerfil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Campo_Celular;
    private javax.swing.JTextField Campo_ID;
    private javax.swing.JList<String> Campo_Lista;
    private javax.swing.JTextField Campo_Nome;
    private javax.swing.JTextField Campo_Senha;
    private javax.swing.JLabel Texto_Nome;
    private javax.swing.JButton editar;
    private javax.swing.JButton editar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logoTop;
    private javax.swing.JLabel profileField;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JLabel sobre;
    private javax.swing.JLabel voltar;
    // End of variables declaration//GEN-END:variables
}
