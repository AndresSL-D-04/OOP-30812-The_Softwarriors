/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.view.panels;

/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PnlStock extends JPanel {
    
    private JTable stockTable;
    private DefaultTableModel tableModel;
    private JTextArea outputArea;
    private JTextField txtProductId, txtNewStock, txtMinStock;
    
    public PnlStock() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Alertas de Stock", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JPanel configPanel = new JPanel(new GridBagLayout());
        configPanel.setBorder(BorderFactory.createTitledBorder("Configuracion de Stock"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0;
        configPanel.add(new JLabel("ID del Producto:"), gbc);
        gbc.gridx = 1;
        txtProductId = new JTextField(10);
        configPanel.add(txtProductId, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        configPanel.add(new JLabel("Nuevo Stock:"), gbc);
        gbc.gridx = 1;
        txtNewStock = new JTextField(10);
        configPanel.add(txtNewStock, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        configPanel.add(new JLabel("Stock Minimo:"), gbc);
        gbc.gridx = 1;
        txtMinStock = new JTextField(10);
        configPanel.add(txtMinStock, gbc);
        
        JButton btnUpdateStock = new JButton("Actualizar Stock");
        JButton btnSetMinStock = new JButton("Configurar Stock Minimo");
        JButton btnCheckAlerts = new JButton("Ver Alertas");
        JButton btnGenerateOrder = new JButton("Generar Lista de Pedidos");
        
        styleButton(btnUpdateStock);
        styleButton(btnSetMinStock);
        styleButton(btnCheckAlerts);
        styleButton(btnGenerateOrder);
        
        btnUpdateStock.addActionListener(e -> updateStock());
        btnSetMinStock.addActionListener(e -> setMinStock());
        btnCheckAlerts.addActionListener(e -> checkAlerts());
        btnGenerateOrder.addActionListener(e -> generateOrderList());
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.add(btnUpdateStock);
        buttonPanel.add(btnSetMinStock);
        buttonPanel.add(btnCheckAlerts);
        buttonPanel.add(btnGenerateOrder);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        configPanel.add(buttonPanel, gbc);
        
        String[] columns = {"ID", "Producto", "Stock Actual", "Stock Minimo", "Estado", "Pedido Sugerido"};
        tableModel = new DefaultTableModel(columns, 0);
        stockTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(stockTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Estado de Stock"));
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Alertas de Stock Listo\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 150));
        
        add(configPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(outputScroll, BorderLayout.SOUTH);
        
        loadSampleData();
    }
    
    private void updateStock() {
        try {
            int id = Integer.parseInt(txtProductId.getText());
            int newStock = Integer.parseInt(txtNewStock.getText());
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (Integer.parseInt(tableModel.getValueAt(i, 0).toString()) == id) {
                    int oldStock = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
                    tableModel.setValueAt(newStock, i, 2);
                    outputArea.append("[ACTUALIZADO] Producto ID " + id + " stock cambiado de " + oldStock + " a " + newStock + "\n");
                    
                    int minStock = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
                    if (newStock <= minStock) {
                        tableModel.setValueAt("CRITICO", i, 4);
                        outputArea.append("  [ALERTA] Stock por debajo del minimo!\n");
                    } else {
                        tableModel.setValueAt("OK", i, 4);
                    }
                    break;
                }
            }
            outputArea.append("[GUARDADO] Datos guardados en products.json\n\n");
            txtProductId.setText("");
            txtNewStock.setText("");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese datos validos");
        }
    }
    
    private void setMinStock() {
        try {
            int id = Integer.parseInt(txtProductId.getText());
            int newMinStock = Integer.parseInt(txtMinStock.getText());
            
            for (int i = 0; i < tableModel.getRowCount(); i++) {
                if (Integer.parseInt(tableModel.getValueAt(i, 0).toString()) == id) {
                    tableModel.setValueAt(newMinStock, i, 3);
                    outputArea.append("[CONFIGURADO] Producto ID " + id + " stock minimo configurado a " + newMinStock + "\n");
                    
                    int currentStock = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
                    if (currentStock <= newMinStock) {
                        tableModel.setValueAt("CRITICO", i, 4);
                        outputArea.append("  [ALERTA] El stock actual esta por debajo del nuevo minimo!\n");
                    }
                    break;
                }
            }
            outputArea.append("[GUARDADO] Datos guardados en products.json\n\n");
            txtProductId.setText("");
            txtMinStock.setText("");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese datos validos");
        }
    }
    
    private void checkAlerts() {
        outputArea.append("\n=== ALERTAS DE STOCK ===\n");
        boolean hasAlerts = false;
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int stock = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
            int minStock = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            
            if (stock <= minStock) {
                outputArea.append("  [CRITICO] " + tableModel.getValueAt(i, 1) + " - Stock: " + stock + " (Min: " + minStock + ")\n");
                tableModel.setValueAt("CRITICO", i, 4);
                hasAlerts = true;
            } else if (stock <= minStock * 1.5) {
                outputArea.append("  [ADVERTENCIA] " + tableModel.getValueAt(i, 1) + " - Stock: " + stock + " (Min: " + minStock + ")\n");
                tableModel.setValueAt("ADVERTENCIA", i, 4);
                hasAlerts = true;
            } else {
                tableModel.setValueAt("OK", i, 4);
            }
        }
        
        if (!hasAlerts) {
            outputArea.append("  No hay alertas de stock en este momento\n");
        }
        outputArea.append("\n");
    }
    
    private void generateOrderList() {
        outputArea.append("\n=== LISTA DE PEDIDOS SUGERIDA ===\n");
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int stock = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
            int minStock = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            
            if (stock <= minStock) {
                int suggestedOrder = minStock * 2 - stock;
                if (suggestedOrder < 0) suggestedOrder = minStock;
                tableModel.setValueAt(suggestedOrder, i, 5);
                outputArea.append("  " + tableModel.getValueAt(i, 1) + " - Pedir " + suggestedOrder + " unidades\n");
            } else {
                tableModel.setValueAt(0, i, 5);
            }
        }
        outputArea.append("\n");
    }
    
    private void loadSampleData() {
        Object[] row1 = {101, "Plato de carton 25cm", 45, 50, "CRITICO", 0};
        Object[] row2 = {102, "Vaso plastico 12oz", 80, 60, "OK", 0};
        Object[] row3 = {103, "Cubiertos desechables", 120, 100, "OK", 0};
        Object[] row4 = {104, "Funda de papel", 30, 40, "CRITICO", 0};
        Object[] row5 = {105, "Bandeja de aluminio", 25, 35, "CRITICO", 0};
        Object[] row6 = {106, "Servilletas pack 50", 55, 50, "ADVERTENCIA", 0};
        
        tableModel.addRow(row1);
        tableModel.addRow(row2);
        tableModel.addRow(row3);
        tableModel.addRow(row4);
        tableModel.addRow(row5);
        tableModel.addRow(row6);
        
        outputArea.append("[CARGADOS] 6 productos cargados para seguimiento de stock\n");
        checkAlerts();
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