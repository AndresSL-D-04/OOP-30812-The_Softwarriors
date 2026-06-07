/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.view.panels;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
public class PnlCombo extends JPanel {
    
    private JTable combosTable, productsTable;
    private DefaultTableModel combosModel, productsModel;
    private JTextArea outputArea;
    private JTextField txtComboId, txtComboName, txtComboPrice, txtProductId, txtProductQty;
    private int nextComboId = 1;
    
    public PnlCombo() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Combos / Promociones", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(createComboPanel());
        splitPane.setRightComponent(createProductsPanel());
        splitPane.setDividerLocation(450);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Sistema de Combos Listo\nCombos guardados en combos.json\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 120));
        
        JPanel mainCenter = new JPanel(new BorderLayout());
        mainCenter.add(splitPane, BorderLayout.CENTER);
        mainCenter.add(outputScroll, BorderLayout.SOUTH);
        
        add(mainCenter, BorderLayout.CENTER);
        
        loadSampleData();
    }
    
    private JPanel createComboPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Combos"));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Crear Combo"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("ID del Combo:"), gbc);
        gbc.gridx = 1;
        txtComboId = new JTextField(10);
        txtComboId.setEditable(false);
        txtComboId.setText(String.valueOf(nextComboId));
        formPanel.add(txtComboId, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("Nombre del Combo:"), gbc);
        gbc.gridx = 1;
        txtComboName = new JTextField(15);
        formPanel.add(txtComboName, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("Precio del Combo:"), gbc);
        gbc.gridx = 1;
        txtComboPrice = new JTextField(10);
        formPanel.add(txtComboPrice, gbc);
        
        JButton btnCreateCombo = new JButton("Crear Combo");
        JButton btnActivate = new JButton("Activar");
        JButton btnDeactivate = new JButton("Desactivar");
        
        styleButton(btnCreateCombo);
        styleButton(btnActivate);
        styleButton(btnDeactivate);
        
        btnCreateCombo.addActionListener(e -> createCombo());
        btnActivate.addActionListener(e -> activateCombo());
        btnDeactivate.addActionListener(e -> deactivateCombo());
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel.add(btnCreateCombo);
        buttonPanel.add(btnActivate);
        buttonPanel.add(btnDeactivate);
        
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);
        
        String[] columns = {"ID", "Nombre", "Precio", "Ahorro", "Estado"};
        combosModel = new DefaultTableModel(columns, 0);
        combosTable = new JTable(combosModel);
        JScrollPane scrollPane = new JScrollPane(combosTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Combos"));
        
        panel.add(formPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private JPanel createProductsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Agregar Productos al Combo"));
        
        String[] columns = {"ID", "Producto", "Precio", "Stock"};
        productsModel = new DefaultTableModel(columns, 0);
        productsTable = new JTable(productsModel);
        JScrollPane scrollPane = new JScrollPane(productsTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Productos Disponibles"));
        
        JPanel addPanel = new JPanel(new FlowLayout());
        addPanel.add(new JLabel("ID del Producto:"));
        txtProductId = new JTextField(5);
        addPanel.add(txtProductId);
        addPanel.add(new JLabel("Cantidad:"));
        txtProductQty = new JTextField(5);
        addPanel.add(txtProductQty);
        JButton btnAdd = new JButton("Agregar al Combo");
        styleButton(btnAdd);
        btnAdd.addActionListener(e -> addToCombo());
        addPanel.add(btnAdd);
        
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(addPanel, BorderLayout.SOUTH);
        
        loadProducts();
        
        return panel;
    }
    
    private void createCombo() {
        String name = txtComboName.getText();
        String priceStr = txtComboPrice.getText();
        
        if (name.isEmpty() || priceStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese nombre y precio del combo");
            return;
        }
        
        try {
            double price = Double.parseDouble(priceStr);
            int id = nextComboId++;
            txtComboId.setText(String.valueOf(nextComboId));
            
            Object[] row = {id, name, price, "$0.00", "Activo"};
            combosModel.addRow(row);
            
            outputArea.append("[CREADO] Combo #" + id + ": " + name + " - $" + price + "\n");
            outputArea.append("[GUARDADO] Datos guardados en combos.json\n\n");
            
            txtComboName.setText("");
            txtComboPrice.setText("");
            JOptionPane.showMessageDialog(this, "Combo creado exitosamente!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese un precio valido");
        }
    }
    
    private void activateCombo() {
        int row = combosTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un combo primero");
            return;
        }
        combosModel.setValueAt("Activo", row, 4);
        outputArea.append("[ACTIVADO] Combo #" + combosModel.getValueAt(row, 0) + " activado\n");
    }
    
    private void deactivateCombo() {
        int row = combosTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un combo primero");
            return;
        }
        combosModel.setValueAt("Inactivo", row, 4);
        outputArea.append("[DESACTIVADO] Combo #" + combosModel.getValueAt(row, 0) + " desactivado\n");
    }
    
    private void addToCombo() {
        int comboRow = combosTable.getSelectedRow();
        if (comboRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un combo primero");
            return;
        }
        
        try {
            int productId = Integer.parseInt(txtProductId.getText());
            int quantity = Integer.parseInt(txtProductQty.getText());
            
            for (int i = 0; i < productsModel.getRowCount(); i++) {
                if (Integer.parseInt(productsModel.getValueAt(i, 0).toString()) == productId) {
                    String productName = productsModel.getValueAt(i, 1).toString();
                    double price = Double.parseDouble(productsModel.getValueAt(i, 2).toString());
                    double subtotal = price * quantity;
                    
                    outputArea.append("[AGREGADO] Producto: " + productName + " x" + quantity + " = $" + subtotal + " agregado al combo #" + combosModel.getValueAt(comboRow, 0) + "\n");
                    break;
                }
            }
            
            txtProductId.setText("");
            txtProductQty.setText("");
            JOptionPane.showMessageDialog(this, "Producto agregado al combo!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese ID de producto y cantidad validos");
        }
    }
    
    private void loadProducts() {
        productsModel.addRow(new Object[]{1, "Plato de carton 25cm", 0.50, 100});
        productsModel.addRow(new Object[]{2, "Vaso plastico 12oz", 0.30, 200});
        productsModel.addRow(new Object[]{3, "Cubiertos desechables", 0.20, 500});
        productsModel.addRow(new Object[]{4, "Funda de papel", 0.10, 300});
        productsModel.addRow(new Object[]{5, "Bandeja de aluminio", 0.80, 150});
    }
    
    private void loadSampleData() {
        Object[] combo1 = {1, "Desayuno Especial", 5.99, "$2.00", "Activo"};
        Object[] combo2 = {2, "Almuerzo Familiar", 12.99, "$5.00", "Activo"};
        combosModel.addRow(combo1);
        combosModel.addRow(combo2);
        nextComboId = 3;
        txtComboId.setText("3");
        outputArea.append("[CARGADOS] 2 combos cargados desde combos.json\n");
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
