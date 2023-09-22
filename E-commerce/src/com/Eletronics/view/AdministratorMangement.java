/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.Eletronics.view;

import com.Eletronics.model.Product;
import com.Eletronics.services.CustomRendererThree;
import com.Eletronics.services.Exception_Data;
import com.Eletronics.services.ProductServices;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author pedro
 */
public class AdministratorMangement extends javax.swing.JFrame {
    BufferedImage image;
    /**
     * Creates new form AdministratorProduct
     */
    public AdministratorMangement() {
        super("ELETRONICS");
        initComponents();
        selectImage.setVisible(false);
        getContentPane().setBackground(Color.WHITE);
        productList.setCellRenderer(new CustomRendererThree());
        logoTop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/logoTop.png")));
        imageField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/noProduct.png")));
        productList.setModel(ProductServices.searchProductDatabase(""));
        if (productList.getModel().getSize() != 0) {;
            productList.setSelectedIndex(0);
            this.productListClicked();
        }
        updateButton.setVisible(false);
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
        productButton = new javax.swing.JLabel();
        logOutButton = new javax.swing.JLabel();
        customerButton = new javax.swing.JLabel();
        administratorButton = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        productList = new javax.swing.JList<>();
        selectImage = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        imageField = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        descriptionField = new javax.swing.JTextField();
        priceField = new javax.swing.JTextField();

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

        productButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        productButton.setForeground(new java.awt.Color(204, 204, 204));
        productButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        productButton.setText("PRODUTOS");
        productButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                productButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productButtonMouseExited(evt);
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

        customerButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        customerButton.setForeground(new java.awt.Color(204, 204, 204));
        customerButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        customerButton.setText("CLIENTES");
        customerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                customerButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                customerButtonMouseExited(evt);
            }
        });

        administratorButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        administratorButton.setForeground(new java.awt.Color(204, 204, 204));
        administratorButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        administratorButton.setText("GESTORES");
        administratorButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                administratorButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                administratorButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                administratorButtonMouseExited(evt);
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
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                                    .addComponent(productButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(logOutButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(customerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(administratorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGap(40, 40, 40)
                .addComponent(productButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(customerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(administratorButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aboutButton)
                .addGap(40, 40, 40))
        );

        jLabel4.setFont(new java.awt.Font("Nortar", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("PRODUTO");

        jLabel5.setFont(new java.awt.Font("Nortar", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("AREA");

        scrollPane.setBackground(new java.awt.Color(255, 255, 255));
        scrollPane.setBorder(null);
        scrollPane.setForeground(new java.awt.Color(0, 0, 0));
        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        productList.setBackground(new java.awt.Color(255, 255, 255));
        productList.setBorder(null);
        productList.setForeground(new java.awt.Color(0, 0, 0));
        productList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productListMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(productList);

        selectImage.setBackground(new java.awt.Color(255, 255, 255));
        selectImage.setFont(new java.awt.Font("Nortar", 0, 14)); // NOI18N
        selectImage.setForeground(new java.awt.Color(0, 0, 0));
        selectImage.setText("NOVA FOTO");
        selectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImageActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(0, 0, 0));
        deleteButton.setFont(new java.awt.Font("Nortar", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("EXCLUIR");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        imageField.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageField.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                imageFieldPropertyChange(evt);
            }
        });

        nameField.setBackground(new java.awt.Color(255, 255, 255));
        nameField.setForeground(new java.awt.Color(0, 0, 0));
        nameField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "nome:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        nameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameFieldKeyReleased(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(255, 255, 255));
        updateButton.setFont(new java.awt.Font("Nortar", 0, 14)); // NOI18N
        updateButton.setForeground(new java.awt.Color(0, 0, 0));
        updateButton.setText("ATUALIZAR");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        descriptionField.setBackground(new java.awt.Color(255, 255, 255));
        descriptionField.setForeground(new java.awt.Color(0, 0, 0));
        descriptionField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        descriptionField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "descrição:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        descriptionField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionFieldKeyReleased(evt);
            }
        });

        priceField.setBackground(new java.awt.Color(255, 255, 255));
        priceField.setForeground(new java.awt.Color(0, 0, 0));
        priceField.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "valor:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        priceField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                priceFieldKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(selectImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(imageField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(descriptionField, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(priceField, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(deleteButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(0, 40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(descriptionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(priceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imageField, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(selectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
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

    private void selectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImageActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser chooser = new JFileChooser();
            chooser.showOpenDialog(null);
            File file = chooser.getSelectedFile();
            String path = file.getAbsolutePath();
            image = ImageIO.read(new File(path));
            Image img = image.getScaledInstance(180, 234, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            imageField.setIcon(icon);
        } catch (Exception e) {
            Warning warning = new Warning("Imagem não encontrada!");
            warning.setVisible(true);
        }
    }//GEN-LAST:event_selectImageActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        try {
            String name = nameField.getText();
            String description = descriptionField.getText();
            double price = Double.parseDouble(priceField.getText());
            if (name.isEmpty() || description.isEmpty() || price <= 0 || imageField.getIcon() == null){
                throw new Exception_Data("Informe os dados corretamente!");
            } else {
                DefaultListModel listModel = (DefaultListModel) productList.getModel();
                Product product = (Product) listModel.get(productList.getSelectedIndex());
                product.setName(nameField.getText());
                product.setDescription(descriptionField.getText());
                product.setPrice(Double.parseDouble(priceField.getText()));
                if (image != null) product.setImage(image);
                ProductServices.updateProducts(product);
                int index = productList.getSelectedIndex();
                productList.setModel(ProductServices.searchProductDatabase(""));
                updateButton.setVisible(false);
                productList.setSelectedIndex(index);
            }
        } catch (Exception_Data e) {
            Warning warning = new Warning(e.getMessage());
            warning.setVisible(true);
        } catch (NumberFormatException e) {
            Warning warning = new Warning("Informe os dados corretamente!");
            warning.setVisible(true);
            priceField.setText("");
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        if (productList.getSelectedIndex() != -1) {
            DefaultListModel listModel = (DefaultListModel) productList.getModel();
            Product product = (Product) listModel.getElementAt(productList.getSelectedIndex());
            ProductServices.deleteProduct(product);
            
            productList.setModel(ProductServices.searchProductDatabase(""));
            if (productList.getModel().getSize() != 0){
                productList.setSelectedIndex(0);
                this.productListClicked();
            } else {
                nameField.setText("");
                descriptionField.setText("");
                priceField.setText("");
                imageField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/Eletronics/view/midias/noProduct.png")));
                selectImage.setVisible(false);
                updateButton.setVisible(false);
            }
        }
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    private void productListClicked(){
        DefaultListModel listModel = (DefaultListModel) productList.getModel();
        Product product = (Product) listModel.get(productList.getSelectedIndex());
        nameField.setText(product.getName());
        descriptionField.setText(product.getDescription());
        priceField.setText(String.valueOf(product.getPrice()));
        Image image = product.getImage().getScaledInstance(180, 234, Image.SCALE_SMOOTH);
        imageField.setIcon(new ImageIcon(image));
        selectImage.setVisible(true);
        updateButton.setVisible(false);
    }
    
    private void productListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productListMouseClicked
        // TODO add your handling code here:
        this.productListClicked();
    }//GEN-LAST:event_productListMouseClicked
    
    private void setUpdateButtonVisibilty(){
        if (productList.getSelectedIndex() != -1) {
        DefaultListModel listModel = (DefaultListModel) productList.getModel();
            Product product = (Product) listModel.get(productList.getSelectedIndex());
            if (!nameField.getText().equals(product.getName()) || !descriptionField.getText().equals(product.getDescription()) || !priceField.getText().equals(String.valueOf(product.getPrice()))){
                updateButton.setVisible(true);
            } else {
                updateButton.setVisible(false);
            }
        }
    }
    
    private void nameFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameFieldKeyReleased
        // TODO add your handling code here:
        this.setUpdateButtonVisibilty();
    }//GEN-LAST:event_nameFieldKeyReleased

    private void descriptionFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionFieldKeyReleased
        // TODO add your handling code here:
        this.setUpdateButtonVisibilty();
    }//GEN-LAST:event_descriptionFieldKeyReleased

    private void priceFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceFieldKeyReleased
        // TODO add your handling code here:
        this.setUpdateButtonVisibilty();
    }//GEN-LAST:event_priceFieldKeyReleased

    private void imageFieldPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_imageFieldPropertyChange
        // TODO add your handling code here:
        updateButton.setVisible(true);
    }//GEN-LAST:event_imageFieldPropertyChange

    private void productButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseClicked
        // TODO add your handling code here:
        AdministratorProduct administratorProduct = new AdministratorProduct();
        administratorProduct.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_productButtonMouseClicked

    private void productButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseEntered
        // TODO add your handling code here:
        productButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_productButtonMouseEntered

    private void productButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productButtonMouseExited
        // TODO add your handling code here:
        productButton.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_productButtonMouseExited

    private void logOutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseClicked
        // TODO add your handling code here:
        HomeScreen home = new HomeScreen();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logOutButtonMouseClicked

    private void logOutButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseEntered
        // TODO add your handling code here:
        logOutButton.setForeground(Color.red);
    }//GEN-LAST:event_logOutButtonMouseEntered

    private void logOutButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutButtonMouseExited
        // TODO add your handling code here:
        logOutButton.setForeground(Color.pink);
    }//GEN-LAST:event_logOutButtonMouseExited

    private void customerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseClicked
        // TODO add your handling code here:
        AdministratorCustomer administratorCustomer = new AdministratorCustomer();
        administratorCustomer.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_customerButtonMouseClicked

    private void customerButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseEntered
        // TODO add your handling code here:
        customerButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_customerButtonMouseEntered

    private void customerButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerButtonMouseExited
        // TODO add your handling code here:
        customerButton.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_customerButtonMouseExited

    private void administratorButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_administratorButtonMouseEntered
        // TODO add your handling code here:
        administratorButton.setForeground(Color.WHITE);
    }//GEN-LAST:event_administratorButtonMouseEntered

    private void administratorButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_administratorButtonMouseExited
        // TODO add your handling code here:
        administratorButton.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_administratorButtonMouseExited

    private void administratorButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_administratorButtonMouseClicked
        // TODO add your handling code here:
        AdministratorProfiles administratorProfiles = new AdministratorProfiles();
        administratorProfiles.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_administratorButtonMouseClicked

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
            java.util.logging.Logger.getLogger(AdministratorMangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorMangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorMangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorMangement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new AdministratorMangement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel aboutButton;
    private javax.swing.JLabel administratorButton;
    private javax.swing.JLabel customerButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descriptionField;
    private javax.swing.JLabel imageField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logOutButton;
    private javax.swing.JLabel logoTop;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField priceField;
    private javax.swing.JLabel productButton;
    private javax.swing.JList<String> productList;
    private javax.swing.JLabel profileButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton selectImage;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
