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
public class FrmRecoverPassword extends javax.swing.JFrame {

    private IAuthController authController;
    private java.awt.CardLayout cardLayout;

    public FrmRecoverPassword() {
        authController = ServiceFactory.getAuthController();
        initComponents();
        setTitle("SafeStore - Recuperar Contraseña");
        setLocationRelativeTo(null);
        setResizable(false);
        cardLayout.show(mainPanel, "step1");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        step1Panel = new javax.swing.JPanel();
        lblTitle1 = new javax.swing.JLabel();
        lblInstruction1 = new javax.swing.JLabel();
        lblInput = new javax.swing.JLabel();
        txtInput = new javax.swing.JTextField();
        btnSend = new javax.swing.JButton();
        btnBackLogin = new javax.swing.JButton();
        lblStatus1 = new javax.swing.JLabel();
        step2Panel = new javax.swing.JPanel();
        lblTitle2 = new javax.swing.JLabel();
        lblInstruction2 = new javax.swing.JLabel();
        lblToken = new javax.swing.JLabel();
        txtToken = new javax.swing.JTextField();
        lblNewPass = new javax.swing.JLabel();
        txtNewPassword = new javax.swing.JPasswordField();
        lblConfirm = new javax.swing.JLabel();
        txtConfirmPassword = new javax.swing.JPasswordField();
        btnReset = new javax.swing.JButton();
        btnBackStep1 = new javax.swing.JButton();
        lblStatus2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setMinimumSize(new java.awt.Dimension(420, 380));

        cardLayout = new java.awt.CardLayout();
        mainPanel.setLayout(cardLayout);
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 30, 20, 30));

        step1Panel.setBackground(java.awt.Color.WHITE);

        lblTitle1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitle1.setForeground(new java.awt.Color(52, 73, 94));
        lblTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle1.setText("RECUPERAR CONTRASEÑA"); // NOI18N

        lblInstruction1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblInstruction1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstruction1.setText("<html><center>Ingrese su nombre de usuario o email<br>para recibir un código de recuperación.</center></html>"); // NOI18N

        lblInput.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblInput.setForeground(java.awt.Color.BLACK);
        lblInput.setText("Usuario/Email:"); // NOI18N

        txtInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtInput.setPreferredSize(new java.awt.Dimension(200, 30));

        btnSend.setBackground(new java.awt.Color(52, 152, 219));
        btnSend.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSend.setForeground(java.awt.Color.WHITE);
        btnSend.setText("Enviar Código"); // NOI18N
        btnSend.setPreferredSize(new java.awt.Dimension(150, 35));
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        btnBackLogin.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBackLogin.setForeground(java.awt.Color.GRAY);
        btnBackLogin.setText("Volver al Login"); // NOI18N
        btnBackLogin.setBorderPainted(false);
        btnBackLogin.setBackground(java.awt.Color.WHITE);
        btnBackLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackLoginActionPerformed(evt);
            }
        });

        lblStatus1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblStatus1.setForeground(java.awt.Color.RED);
        lblStatus1.setText(" ");

        javax.swing.GroupLayout step1PanelLayout = new javax.swing.GroupLayout(step1Panel);
        step1Panel.setLayout(step1PanelLayout);
        step1PanelLayout.setHorizontalGroup(
            step1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, step1PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(step1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInstruction1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(step1PanelLayout.createSequentialGroup()
                        .addComponent(lblInput)
                        .addGap(18, 18, 18)
                        .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackLogin)
                    .addComponent(lblStatus1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        step1PanelLayout.setVerticalGroup(
            step1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step1PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstruction1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(step1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInput)
                    .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBackLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(step1Panel, "step1");

        step2Panel.setBackground(java.awt.Color.WHITE);

        lblTitle2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTitle2.setForeground(new java.awt.Color(52, 73, 94));
        lblTitle2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle2.setText("NUEVA CONTRASEÑA"); // NOI18N

        lblInstruction2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblInstruction2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInstruction2.setText("<html><center>Ingrese el código de recuperación y su nueva contraseña</center></html>"); // NOI18N

        lblToken.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblToken.setForeground(java.awt.Color.BLACK);
        lblToken.setText("Código:"); // NOI18N

        txtToken.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtToken.setPreferredSize(new java.awt.Dimension(200, 30));

        lblNewPass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNewPass.setForeground(java.awt.Color.BLACK);
        lblNewPass.setText("Nueva Contraseña:"); // NOI18N

        txtNewPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNewPassword.setPreferredSize(new java.awt.Dimension(200, 30));

        lblConfirm.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblConfirm.setForeground(java.awt.Color.BLACK);
        lblConfirm.setText("Confirmar:"); // NOI18N

        txtConfirmPassword.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtConfirmPassword.setPreferredSize(new java.awt.Dimension(200, 30));

        btnReset.setBackground(new java.awt.Color(46, 204, 113));
        btnReset.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnReset.setForeground(java.awt.Color.WHITE);
        btnReset.setText("Restablecer Contraseña"); // NOI18N
        btnReset.setPreferredSize(new java.awt.Dimension(200, 35));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBackStep1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBackStep1.setForeground(java.awt.Color.GRAY);
        btnBackStep1.setText("← Volver"); // NOI18N
        btnBackStep1.setBorderPainted(false);
        btnBackStep1.setBackground(java.awt.Color.WHITE);
        btnBackStep1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackStep1ActionPerformed(evt);
            }
        });

        lblStatus2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblStatus2.setForeground(java.awt.Color.RED);
        lblStatus2.setText(" ");

        javax.swing.GroupLayout step2PanelLayout = new javax.swing.GroupLayout(step2Panel);
        step2Panel.setLayout(step2PanelLayout);
        step2PanelLayout.setHorizontalGroup(
            step2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.CENTER, step2PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(step2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lblTitle2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblInstruction2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(step2PanelLayout.createSequentialGroup()
                        .addGroup(step2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblToken)
                            .addComponent(lblNewPass)
                            .addComponent(lblConfirm))
                        .addGap(18, 18, 18)
                        .addGroup(step2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBackStep1)
                    .addComponent(lblStatus2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        step2PanelLayout.setVerticalGroup(
            step2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step2PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInstruction2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(step2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblToken)
                    .addComponent(txtToken, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(step2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPass)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(step2PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConfirm)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBackStep1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mainPanel.add(step2Panel, "step2");

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>                        

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {                                         
        String input = txtInput.getText().trim();
        if (input.isEmpty()) {
            lblStatus1.setText("Ingrese su usuario o email");
            return;
        }

        if (authController.generateResetToken(input)) {
            lblStatus1.setText("");
            javax.swing.JOptionPane.showMessageDialog(this,
                "✅ Se ha enviado un código de recuperación.\n" +
                "Revise su correo electrónico.",
                "Código Enviado", javax.swing.JOptionPane.INFORMATION_MESSAGE);
            cardLayout.show(mainPanel, "step2");
        } else {
            lblStatus1.setText("❌ Usuario o email no encontrado");
        }
    }                                        

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {                                         
        try {
            String token = txtToken.getText().trim();
            String password = new String(txtNewPassword.getPassword());
            String confirm = new String(txtConfirmPassword.getPassword());

            if (authController.resetPassword(token, password, confirm)) {
                javax.swing.JOptionPane.showMessageDialog(this,
                    "✅ Contraseña restablecida exitosamente!\n\n" +
                    "Ahora puede iniciar sesión con su nueva contraseña.",
                    "Éxito", javax.swing.JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        } catch (IllegalArgumentException ex) {
            lblStatus2.setText(ex.getMessage());
        }
    }                                        

    private void btnBackLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        dispose();
    }                                        

    private void btnBackStep1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        cardLayout.show(mainPanel, "step1");
        lblStatus1.setText(" ");
        lblStatus2.setText(" ");
    }                                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBackLogin;
    private javax.swing.JButton btnBackStep1;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel lblConfirm;
    private javax.swing.JLabel lblInput;
    private javax.swing.JLabel lblInstruction1;
    private javax.swing.JLabel lblInstruction2;
    private javax.swing.JLabel lblNewPass;
    private javax.swing.JLabel lblStatus1;
    private javax.swing.JLabel lblStatus2;
    private javax.swing.JLabel lblTitle1;
    private javax.swing.JLabel lblTitle2;
    private javax.swing.JLabel lblToken;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel step1Panel;
    private javax.swing.JPanel step2Panel;
    private javax.swing.JPasswordField txtConfirmPassword;
    private javax.swing.JTextField txtInput;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JTextField txtToken;
    // End of variables declaration                   
}