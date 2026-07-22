/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ec.edu.espe.safestore.view;

import ec.edu.espe.safestore.controller.interfaces.IAuthController;
import ec.edu.espe.safestore.utils.ServiceFactory;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class FrmRegister extends javax.swing.JFrame {

    private IAuthController authController;

    public FrmRegister() {
        authController = ServiceFactory.getAuthController();
        initComponents();
        setTitle("SafeStore - Registro");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        formPanel = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPass = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        lblConfirm = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        lblRole = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox<>();
        btnRegister = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        titlePanel.setBackground(java.awt.Color.WHITE);
        titlePanel.setPreferredSize(new java.awt.Dimension(450, 60));

        titleLabel.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        titleLabel.setForeground(java.awt.Color.BLACK);
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("REGISTRO DE USUARIO"); // NOI18N

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        formPanel.setBackground(java.awt.Color.WHITE);
        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 30, 20, 30));

        lblUser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblUser.setForeground(java.awt.Color.BLACK);
        lblUser.setText("Usuario:"); // NOI18N

        txtUsername.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtUsername.setPreferredSize(new java.awt.Dimension(200, 30));

        lblEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEmail.setForeground(java.awt.Color.BLACK);
        lblEmail.setText("Email:"); // NOI18N

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(200, 30));

        lblPass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPass.setForeground(java.awt.Color.BLACK);
        lblPass.setText("Contraseña:"); // NOI18N

        txtPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPassword.setPreferredSize(new java.awt.Dimension(200, 30));

        lblConfirm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblConfirm.setForeground(java.awt.Color.BLACK);
        lblConfirm.setText("Confirmar:"); // NOI18N

        txtConfirmPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtConfirmPassword.setPreferredSize(new java.awt.Dimension(200, 30));

        lblRole.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblRole.setForeground(java.awt.Color.BLACK);
        lblRole.setText("Rol:"); // NOI18N

        cbRole.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cashier", "Manager" }));
        cbRole.setPreferredSize(new java.awt.Dimension(200, 30));

        btnRegister.setBackground(new java.awt.Color(46, 204, 113));
        btnRegister.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnRegister.setForeground(java.awt.Color.WHITE);
        btnRegister.setText("Registrar"); // NOI18N
        btnRegister.setPreferredSize(new java.awt.Dimension(120, 35));
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnCancel.setBackground(java.awt.Color.WHITE);
        btnCancel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnCancel.setForeground(java.awt.Color.RED);
        btnCancel.setText("Cancelar"); // NOI18N
        btnCancel.setPreferredSize(new java.awt.Dimension(120, 35));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblStatus.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(255, 0, 0));
        lblStatus.setText(" ");

        javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
        formPanel.setLayout(formPanelLayout);
        formPanelLayout.setHorizontalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser)
                    .addComponent(lblEmail)
                    .addComponent(lblPass)
                    .addComponent(lblConfirm)
                    .addComponent(lblRole))
                .addGap(18, 18, 18)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, formPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblStatus)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        formPanelLayout.setVerticalGroup(
            formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUser)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPass)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirm)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRole)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(titlePanel, java.awt.BorderLayout.NORTH);
        getContentPane().add(formPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            String username = txtUsername.getText().trim();
            String email = txtEmail.getText().trim();
            String password = new String(txtPassword.getPassword());
            String confirm = new String(txtConfirmPassword.getPassword());
            String role = (String) cbRole.getSelectedItem();

            if (authController.registerUser(username, password, confirm, email, role)) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "✅ Usuario registrado exitosamente!\n\n" +
                    "Usuario: " + username + "\n" +
                    "Rol: " + role + "\n\n" +
                    "Ahora puede iniciar sesión.",
                    "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (IllegalArgumentException ex) {
            lblStatus.setText(ex.getMessage());
        }
    }                                        

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();
    }                                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration                   
}