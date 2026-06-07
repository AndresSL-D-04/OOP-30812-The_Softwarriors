
package ec.edu.espe.safestore.view.panels;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class PnlCash extends JPanel {
    
    private JTextField txtInitialBalance, txtAmount, txtDescription;
    private JLabel lblBalance, lblStatus;
    private JTextArea outputArea;
    private double currentBalance = 0;
    private boolean isOpen = false;
    
    public PnlCash() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Control de Caja", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JPanel infoPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Estado de la Caja"));
        lblBalance = new JLabel("Saldo Actual: $0.00");
        lblStatus = new JLabel("Estado: CERRADA");
        lblBalance.setFont(new Font("Arial", Font.BOLD, 14));
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
        infoPanel.add(lblBalance);
        infoPanel.add(lblStatus);
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Transaccion"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("Monto:"), gbc);
        gbc.gridx = 1;
        txtAmount = new JTextField(10);
        formPanel.add(txtAmount, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Descripcion:"), gbc);
        gbc.gridx = 1;
        txtDescription = new JTextField(15);
        formPanel.add(txtDescription, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Monto Inicial:"), gbc);
        gbc.gridx = 1;
        txtInitialBalance = new JTextField(10);
        formPanel.add(txtInitialBalance, gbc);
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton btnOpen = new JButton("Abrir Caja");
        JButton btnClose = new JButton("Cerrar Caja");
        JButton btnIncome = new JButton("Registrar Ingreso");
        JButton btnExpense = new JButton("Registrar Egreso");
        JButton btnViewBalance = new JButton("Ver Saldo");
        JButton btnDifference = new JButton("Calcular Diferencia");
        
        styleButton(btnOpen);
        styleButton(btnClose);
        styleButton(btnIncome);
        styleButton(btnExpense);
        styleButton(btnViewBalance);
        styleButton(btnDifference);
        
        btnOpen.addActionListener(e -> openCash());
        btnClose.addActionListener(e -> closeCash());
        btnIncome.addActionListener(e -> registerIncome());
        btnExpense.addActionListener(e -> registerExpense());
        btnViewBalance.addActionListener(e -> viewBalance());
        btnDifference.addActionListener(e -> calculateDifference());
        
        buttonPanel.add(btnOpen);
        buttonPanel.add(btnClose);
        buttonPanel.add(btnIncome);
        buttonPanel.add(btnExpense);
        buttonPanel.add(btnViewBalance);
        buttonPanel.add(btnDifference);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Control de Caja Listo\n\n");
        
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Consola"));
        scrollPane.setPreferredSize(new Dimension(0, 150));
        
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(infoPanel, BorderLayout.NORTH);
        topPanel.add(formPanel, BorderLayout.CENTER);
        
        add(topPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);
    }
    
    private void openCash() {
        String input = JOptionPane.showInputDialog(this, "Ingrese el monto inicial:");
        if (input != null) {
            try {
                double amount = Double.parseDouble(input);
                currentBalance = amount;
                isOpen = true;
                lblBalance.setText(String.format("Saldo Actual: $%.2f", currentBalance));
                lblStatus.setText("Estado: ABIERTA");
                outputArea.append("[ABRIR] Caja abierta con $" + amount + "\n\n");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Monto invalido");
            }
        }
    }
    
    private void closeCash() {
        if (!isOpen) {
            JOptionPane.showMessageDialog(this, "La caja no esta abierta");
            return;
        }
        String input = JOptionPane.showInputDialog(this, "Ingrese el conteo fisico del efectivo:");
        if (input != null) {
            try {
                double physical = Double.parseDouble(input);
                double difference = physical - currentBalance;
                isOpen = false;
                outputArea.append("[CIERRE] Caja cerrada\n");
                outputArea.append("  Esperado: $" + currentBalance + "\n");
                outputArea.append("  Fisico: $" + physical + "\n");
                outputArea.append("  Diferencia: $" + difference + "\n");
                if (difference > 0) {
                    outputArea.append("  [ADVERTENCIA] Sobrante de $" + difference + "\n");
                } else if (difference < 0) {
                    outputArea.append("  [ADVERTENCIA] Faltante de $" + Math.abs(difference) + "\n");
                } else {
                    outputArea.append("  [OK] La caja esta cuadrada\n");
                }
                outputArea.append("\n");
                currentBalance = 0;
                lblBalance.setText("Saldo Actual: $0.00");
                lblStatus.setText("Estado: CERRADA");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Monto invalido");
            }
        }
    }
    
    private void registerIncome() {
        if (!isOpen) {
            JOptionPane.showMessageDialog(this, "Primero debe abrir la caja");
            return;
        }
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            String desc = txtDescription.getText();
            currentBalance += amount;
            lblBalance.setText(String.format("Saldo Actual: $%.2f", currentBalance));
            outputArea.append("[INGRESO] +$" + amount + " | " + desc + "\n");
            outputArea.append("  Nuevo saldo: $" + currentBalance + "\n\n");
            txtAmount.setText("");
            txtDescription.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto valido");
        }
    }
    
    private void registerExpense() {
        if (!isOpen) {
            JOptionPane.showMessageDialog(this, "Primero debe abrir la caja");
            return;
        }
        try {
            double amount = Double.parseDouble(txtAmount.getText());
            String desc = txtDescription.getText();
            if (amount > currentBalance) {
                JOptionPane.showMessageDialog(this, "Saldo insuficiente");
                return;
            }
            currentBalance -= amount;
            lblBalance.setText(String.format("Saldo Actual: $%.2f", currentBalance));
            outputArea.append("[EGRESO] -$" + amount + " | " + desc + "\n");
            outputArea.append("  Nuevo saldo: $" + currentBalance + "\n\n");
            txtAmount.setText("");
            txtDescription.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un monto valido");
        }
    }
    
    private void viewBalance() {
        outputArea.append("[SALDO] Saldo actual: $" + currentBalance + "\n");
        outputArea.append("  Estado: " + (isOpen ? "ABIERTA" : "CERRADA") + "\n\n");
    }
    
    private void calculateDifference() {
        if (!isOpen) {
            JOptionPane.showMessageDialog(this, "Primero debe abrir la caja");
            return;
        }
        String input = JOptionPane.showInputDialog(this, "Ingrese el conteo fisico del efectivo:");
        if (input != null) {
            try {
                double physical = Double.parseDouble(input);
                double difference = physical - currentBalance;
                outputArea.append("[DIFERENCIA] Esperado: $" + currentBalance + "\n");
                outputArea.append("  Fisico: $" + physical + "\n");
                outputArea.append("  Diferencia: $" + difference + "\n\n");
                if (Math.abs(difference) > 5) {
                    outputArea.append("  [ADVERTENCIA] Diferencia significativa detectada!\n\n");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Monto invalido");
            }
        }
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
