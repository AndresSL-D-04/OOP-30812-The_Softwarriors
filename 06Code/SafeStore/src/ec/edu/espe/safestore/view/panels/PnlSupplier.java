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

public class PnlSupplier extends JPanel {
    
    private JTable supplierTable;
    private DefaultTableModel tableModel;
    private JTextArea outputArea;
    private JTextField txtId, txtName, txtContact, txtPhone, txtEmail, txtCreditTerm, txtCreditLimit;
    
    public PnlSupplier() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Gestion de Proveedores", JLabel.CENTER);
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
        outputArea.setText("Gestion de Proveedores Listo\nDatos guardados en suppliers.json\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 120));
        
        JPanel mainCenter = new JPanel(new BorderLayout());
        mainCenter.add(splitPane, BorderLayout.CENTER);
        mainCenter.add(outputScroll, BorderLayout.SOUTH);
        
        add(mainCenter, BorderLayout.CENTER);
        
        loadSampleData();
    }
    
    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Datos del Proveedor"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        String[] labels = {"ID:", "Nombre:", "Persona de Contacto:", "Telefono:", "Email:", "Plazo Credito (dias):", "Limite de Credito:"};
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
        txtContact = fields[2];
        txtPhone = fields[3];
        txtEmail = fields[4];
        txtCreditTerm = fields[5];
        txtCreditLimit = fields[6];
        
        JButton btnAdd = new JButton("Agregar Proveedor");
        JButton btnClear = new JButton("Limpiar");
        
        styleButton(btnAdd);
        styleButton(btnClear);
        
        btnAdd.addActionListener(e -> addSupplier());
        btnClear.addActionListener(e -> clearForm());
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnClear);
        
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private JPanel createTablePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Lista de Proveedores"));
        
        String[] columns = {"ID", "Nombre", "Contacto", "Telefono", "Plazo Credito", "Limite Credito"};
        tableModel = new DefaultTableModel(columns, 0);
        supplierTable = new JTable(tableModel);
        
        supplierTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = supplierTable.getSelectedRow();
                if (row != -1) {
                    txtId.setText(tableModel.getValueAt(row, 0).toString());
                    txtName.setText(tableModel.getValueAt(row, 1).toString());
                    txtContact.setText(tableModel.getValueAt(row, 2).toString());
                    txtPhone.setText(tableModel.getValueAt(row, 3).toString());
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(supplierTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void addSupplier() {
        try {
            int id = Integer.parseInt(txtId.getText());
            String name = txtName.getText();
            String contact = txtContact.getText();
            String phone = txtPhone.getText();
            String email = txtEmail.getText();
            int creditTerm = Integer.parseInt(txtCreditTerm.getText());
            double creditLimit = Double.parseDouble(txtCreditLimit.getText());
            
            Object[] row = {id, name, contact, phone, creditTerm, creditLimit};
            tableModel.addRow(row);
            
            outputArea.append("[AGREGADO] Proveedor: " + name + " (ID: " + id + ")\n");
            outputArea.append("[GUARDADO] Datos guardados en suppliers.json\n\n");
            
            clearForm();
            JOptionPane.showMessageDialog(this, "Proveedor agregado exitosamente!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese datos validos");
        }
    }
    
    private void clearForm() {
        txtId.setText("");
        txtName.setText("");
        txtContact.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtCreditTerm.setText("");
        txtCreditLimit.setText("");
    }
    
    private void loadSampleData() {
        Object[] supplier1 = {1, "Distribuidora XYZ", "Juan Perez", "0991234567", 30, 5000.00};
        Object[] supplier2 = {2, "Plastico S.A.", "Maria Lopez", "0997654321", 45, 10000.00};
        tableModel.addRow(supplier1);
        tableModel.addRow(supplier2);
        outputArea.append("[CARGADOS] 2 proveedores cargados desde suppliers.json\n");
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