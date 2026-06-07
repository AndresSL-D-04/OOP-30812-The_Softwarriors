/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.view.panels;
import ec.edu.espe.safestore.model.ProductManagement;
import ec.edu.espe.safestore.model.ProductManagement.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
public class PnlProduct extends JPanel {
    
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JTextField txtId, txtName, txtWholesale, txtRetail, txtStock, txtMinStock, txtExpiry;
    private JTextArea outputArea;
    
    public PnlProduct() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Gestion de Productos", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(createFormPanel());
        splitPane.setRightComponent(createTablePanel());
        splitPane.setDividerLocation(400);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Gestion de Productos Listo\nDatos guardados en products.json\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 120));
        
        JPanel mainCenter = new JPanel(new BorderLayout());
        mainCenter.add(splitPane, BorderLayout.CENTER);
        mainCenter.add(outputScroll, BorderLayout.SOUTH);
        
        add(mainCenter, BorderLayout.CENTER);
        
        loadProductTable();
    }
    
    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Producto"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        String[] labels = {"ID:", "Nombre:", "Precio Mayor:", "Precio Menor:", "Stock:", "Stock Minimo:", "Fecha Caducidad (AAAA-MM-DD):"};
        JTextField[] fields = new JTextField[7];
        
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1;
            fields[i] = new JTextField(15);
            panel.add(fields[i], gbc);
        }
        
        txtId = fields[0];
        txtName = fields[1];
        txtWholesale = fields[2];
        txtRetail = fields[3];
        txtStock = fields[4];
        txtMinStock = fields[5];
        txtExpiry = fields[6];
        
        JButton btnAdd = new JButton("Agregar Producto");
        JButton btnUpdate = new JButton("Actualizar Producto");
        JButton btnDelete = new JButton("Eliminar Producto");
        JButton btnClear = new JButton("Limpiar");
        
        styleButton(btnAdd);
        styleButton(btnUpdate);
        styleButton(btnDelete);
        styleButton(btnClear);
        
        btnAdd.addActionListener(e -> addProduct());
        btnUpdate.addActionListener(e -> updateProduct());
        btnDelete.addActionListener(e -> deleteProduct());
        btnClear.addActionListener(e -> clearForm());
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnClear);
        
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista de Productos"));
        
        String[] columns = {"ID", "Nombre", "Stock", "Precio", "Caducidad"};
        tableModel = new DefaultTableModel(columns, 0);
        productTable = new JTable(tableModel);
        
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = productTable.getSelectedRow();
                if (row != -1) {
                    txtId.setText(tableModel.getValueAt(row, 0).toString());
                    txtName.setText(tableModel.getValueAt(row, 1).toString());
                    txtStock.setText(tableModel.getValueAt(row, 2).toString());
                    txtRetail.setText(tableModel.getValueAt(row, 3).toString());
                    txtExpiry.setText(tableModel.getValueAt(row, 4).toString());
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(productTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JButton btnRefresh = new JButton("Refrescar Lista");
        btnRefresh.addActionListener(e -> loadProductTable());
        panel.add(btnRefresh, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void loadProductTable() {
        tableModel.setRowCount(0);
        List<Product> products = ProductManagement.getAllProducts();
        for (Product p : products) {
            Object[] row = {p.getId(), p.getName(), p.getStock(), p.getRetailPrice(), p.getExpiryDate()};
            tableModel.addRow(row);
        }
        outputArea.append("[INFO] Cargados " + products.size() + " productos desde products.json\n");
    }
    
    private void addProduct() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            double wholesale = Double.parseDouble(txtWholesale.getText());
            double retail = Double.parseDouble(txtRetail.getText());
            int stock = Integer.parseInt(txtStock.getText());
            int minStock = Integer.parseInt(txtMinStock.getText());
            String expiry = txtExpiry.getText();
            
            Product existing = ProductManagement.findById(id);
            if (existing != null) {
                JOptionPane.showMessageDialog(this, "Ya existe un producto con ese ID");
                return;
            }
            
            Product p = new Product(id, name, wholesale, retail, stock, minStock, expiry);
            ProductManagement.addProduct(p);
            
            loadProductTable();
            clearForm();
            outputArea.append("[AGREGADO] Producto: " + name + " (ID: " + id + ")\n");
            outputArea.append("[GUARDADO] Datos guardados en products.json\n\n");
            JOptionPane.showMessageDialog(this, "Producto agregado exitosamente!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            outputArea.append("[ERROR] " + ex.getMessage() + "\n");
        }
    }
    
    private void updateProduct() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            double wholesale = Double.parseDouble(txtWholesale.getText());
            double retail = Double.parseDouble(txtRetail.getText());
            int stock = Integer.parseInt(txtStock.getText());
            int minStock = Integer.parseInt(txtMinStock.getText());
            String expiry = txtExpiry.getText();
            
            Product existing = ProductManagement.findById(id);
            if (existing == null) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
                return;
            }
            
            existing.setName(name);
            existing.setWholesalePrice(wholesale);
            existing.setRetailPrice(retail);
            existing.setStock(stock);
            existing.setMinStock(minStock);
            existing.setExpiryDate(expiry);
            
            ProductManagement.saveToFile();
            
            loadProductTable();
            outputArea.append("[ACTUALIZADO] Producto: " + name + " (ID: " + id + ")\n");
            outputArea.append("[GUARDADO] Datos guardados en products.json\n\n");
            JOptionPane.showMessageDialog(this, "Producto actualizado exitosamente!");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
    private void deleteProduct() {
        try {
            int id = Integer.parseInt(txtId.getText());
            Product existing = ProductManagement.findById(id);
            if (existing == null) {
                JOptionPane.showMessageDialog(this, "Producto no encontrado");
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this, "Eliminar " + existing.getName() + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                ProductManagement.deleteProduct(id);
                
                loadProductTable();
                clearForm();
                outputArea.append("[ELIMINADO] Producto ID: " + id + "\n");
                outputArea.append("[GUARDADO] Datos guardados en products.json\n\n");
                JOptionPane.showMessageDialog(this, "Producto eliminado exitosamente!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtWholesale.setText("");
        txtRetail.setText("");
        txtStock.setText("");
        txtMinStock.setText("");
        txtExpiry.setText("");
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
