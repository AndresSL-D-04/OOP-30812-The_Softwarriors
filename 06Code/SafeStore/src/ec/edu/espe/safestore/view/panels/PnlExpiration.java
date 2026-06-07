/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.view.panels;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
public class PnlExpiration {
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JTextArea outputArea;
    private JTextField txtAlertDays;
    
    public PnlExpiration() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Control de Caducidad", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JPanel configPanel = new JPanel(new FlowLayout());
        configPanel.setBorder(BorderFactory.createTitledBorder("Configuracion de Alertas"));
        configPanel.add(new JLabel("Dias de Alerta:"));
        txtAlertDays = new JTextField("30", 5);
        configPanel.add(txtAlertDays);
        JButton btnConfig = new JButton("Configurar Dias");
        styleButton(btnConfig);
        btnConfig.addActionListener(e -> {
            outputArea.append("[CONFIGURAR] Dias de alerta configurados a " + txtAlertDays.getText() + "\n");
        });
        configPanel.add(btnConfig);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnCheckAlerts = new JButton("Ver Alertas de Caducidad");
        JButton btnCalculateDiscount = new JButton("Calcular Descuentos");
        JButton btnViewExpired = new JButton("Ver Productos Vencidos");
        
        styleButton(btnCheckAlerts);
        styleButton(btnCalculateDiscount);
        styleButton(btnViewExpired);
        
        btnCheckAlerts.addActionListener(e -> checkAlerts());
        btnCalculateDiscount.addActionListener(e -> calculateDiscounts());
        btnViewExpired.addActionListener(e -> viewExpired());
        
        buttonPanel.add(btnCheckAlerts);
        buttonPanel.add(btnCalculateDiscount);
        buttonPanel.add(btnViewExpired);
        
        String[] columns = {"ID", "Producto", "Fecha Caducidad", "Dias Restantes", "Estado", "Descuento"};
        tableModel = new DefaultTableModel(columns, 0);
        productTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Estado de Caducidad de Productos"));
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Control de Caducidad Listo\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 150));
        
        JPanel northPanel = new JPanel(new BorderLayout());
        northPanel.add(configPanel, BorderLayout.NORTH);
        northPanel.add(buttonPanel, BorderLayout.CENTER);
        
        add(northPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(outputScroll, BorderLayout.SOUTH);
        
        loadSampleProducts();
    }
    
    private void checkAlerts() {
        int alertDays = Integer.parseInt(txtAlertDays.getText());
        outputArea.append("\n=== ALERTAS DE CADUCIDAD ===\n");
        outputArea.append("Productos que vencen en " + alertDays + " dias:\n\n");
        
        boolean hasAlerts = false;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String expiryStr = tableModel.getValueAt(i, 2).toString();
            if (!expiryStr.isEmpty()) {
                LocalDate expiry = LocalDate.parse(expiryStr);
                long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), expiry);
                
                if (daysLeft <= alertDays && daysLeft > 0) {
                    outputArea.append("  [ALERTA] " + tableModel.getValueAt(i, 1) + " - Vence en " + daysLeft + " dias\n");
                    tableModel.setValueAt("Por Vencer", i, 4);
                    hasAlerts = true;
                }
            }
        }
        
        if (!hasAlerts) {
            outputArea.append("  No hay productos que venzan en " + alertDays + " dias\n");
        }
        outputArea.append("\n");
    }
    
    private void calculateDiscounts() {
        outputArea.append("\n=== DESCUENTOS PROGRESIVOS ===\n");
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String expiryStr = tableModel.getValueAt(i, 2).toString();
            if (!expiryStr.isEmpty()) {
                LocalDate expiry = LocalDate.parse(expiryStr);
                long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), expiry);
                double discount = 0;
                String discountText = "";
                
                if (daysLeft <= 7 && daysLeft > 3) {
                    discount = 30;
                    discountText = "30% (Ultima semana)";
                } else if (daysLeft <= 15 && daysLeft > 7) {
                    discount = 20;
                    discountText = "20% (Dos semanas)";
                } else if (daysLeft <= 30 && daysLeft > 15) {
                    discount = 10;
                    discountText = "10% (Un mes)";
                } else if (daysLeft <= 0) {
                    discount = 50;
                    discountText = "50% (VENCIDO - No vender)";
                } else {
                    discountText = "Sin descuento";
                }
                
                tableModel.setValueAt(discountText, i, 5);
                
                if (discount > 0) {
                    outputArea.append("  " + tableModel.getValueAt(i, 1) + ": " + discountText + "\n");
                }
            }
        }
        outputArea.append("\n");
    }
    
    private void viewExpired() {
        outputArea.append("\n=== PRODUCTOS VENCIDOS ===\n");
        
        boolean hasExpired = false;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String expiryStr = tableModel.getValueAt(i, 2).toString();
            if (!expiryStr.isEmpty()) {
                LocalDate expiry = LocalDate.parse(expiryStr);
                if (expiry.isBefore(LocalDate.now())) {
                    outputArea.append("  [VENCIDO] " + tableModel.getValueAt(i, 1) + " - Vencido el " + expiryStr + "\n");
                    tableModel.setValueAt("VENCIDO", i, 4);
                    hasExpired = true;
                }
            }
        }
        
        if (!hasExpired) {
            outputArea.append("  No hay productos vencidos\n");
        }
        outputArea.append("\n");
    }
    
    private void loadSampleProducts() {
        Object[] row1 = {1, "Plato de carton 25cm", "2025-03-15", 0, "Bueno", "Sin descuento"};
        Object[] row2 = {2, "Vaso plastico 12oz", "2024-12-20", 0, "Bueno", "Sin descuento"};
        Object[] row3 = {3, "Cubiertos desechables", "2024-11-10", 0, "Bueno", "Sin descuento"};
        Object[] row4 = {4, "Bandeja de aluminio", "2024-10-05", 0, "Bueno", "Sin descuento"};
        
        tableModel.addRow(row1);
        tableModel.addRow(row2);
        tableModel.addRow(row3);
        tableModel.addRow(row4);
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String expiry = tableModel.getValueAt(i, 2).toString();
            if (!expiry.isEmpty()) {
                long daysLeft = ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.parse(expiry));
                tableModel.setValueAt(daysLeft, i, 3);
                if (daysLeft < 0) {
                    tableModel.setValueAt("VENCIDO", i, 4);
                } else if (daysLeft < 30) {
                    tableModel.setValueAt("Por Vencer", i, 4);
                } else {
                    tableModel.setValueAt("Bueno", i, 4);
                }
            }
        }
        
        outputArea.append("[CARGADOS] 4 productos cargados para seguimiento de caducidad\n");
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}

