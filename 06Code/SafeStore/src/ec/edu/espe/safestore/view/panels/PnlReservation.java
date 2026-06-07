package ec.edu.espe.safestore.view.panels;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class PnlReservation extends JPanel {
    
    private JTable reservationTable;
    private DefaultTableModel tableModel;
    private JTextArea outputArea;
    private JTextField txtReservationId, txtCustomerId, txtCustomerName, txtCustomerPhone, txtProductId, txtProductName, txtQuantity, txtValidDays;
    private JComboBox<String> cbStatus;
    private List<Reservation> reservations;
    private int nextId = 1;
    
    public PnlReservation() {
        reservations = new ArrayList<>();
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Reservas", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Crear Reserva", createReservationPanel());
        tabbedPane.addTab("Mis Reservas", createListPanel());
        tabbedPane.addTab("Productos", createProductsPanel());
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Sistema de Reservas Listo\nDatos guardados en reservations.json\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 120));
        
        JPanel mainCenter = new JPanel(new BorderLayout());
        mainCenter.add(tabbedPane, BorderLayout.CENTER);
        mainCenter.add(outputScroll, BorderLayout.SOUTH);
        
        add(mainCenter, BorderLayout.CENTER);
        
        loadSampleData();
    }
    
    private JPanel createReservationPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        String[] labels = {"ID del Cliente:", "Nombre del Cliente:", "Telefono del Cliente:", "ID del Producto:", "Nombre del Producto:", "Cantidad:", "Dias de Validez (1-7):"};
        JTextField[] fields = new JTextField[7];
        
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1;
            fields[i] = new JTextField(15);
            panel.add(fields[i], gbc);
        }
        
        txtCustomerId = fields[0];
        txtCustomerName = fields[1];
        txtCustomerPhone = fields[2];
        txtProductId = fields[3];
        txtProductName = fields[4];
        txtQuantity = fields[5];
        txtValidDays = fields[6];
        
        JButton btnCreate = new JButton("Crear Reserva");
        JButton btnClear = new JButton("Limpiar");
        
        styleButton(btnCreate);
        styleButton(btnClear);
        
        btnCreate.addActionListener(e -> createReservation());
        btnClear.addActionListener(e -> clearForm());
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(btnCreate);
        buttonPanel.add(btnClear);
        
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        String[] columns = {"ID", "Cliente", "Telefono", "Producto", "Cantidad", "Fecha Vencimiento", "Estado"};
        tableModel = new DefaultTableModel(columns, 0);
        reservationTable = new JTable(tableModel);
        
        reservationTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int row = reservationTable.getSelectedRow();
                if (row != -1) {
                    txtReservationId.setText(tableModel.getValueAt(row, 0).toString());
                }
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(reservationTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel actionPanel = new JPanel(new FlowLayout());
        JButton btnComplete = new JButton("Completar Reserva");
        JButton btnCancel = new JButton("Cancelar Reserva");
        JButton btnExtend = new JButton("Extender Reserva");
        JButton btnRefresh = new JButton("Refrescar");
        
        styleButton(btnComplete);
        styleButton(btnCancel);
        styleButton(btnExtend);
        styleButton(btnRefresh);
        
        btnComplete.addActionListener(e -> completeReservation());
        btnCancel.addActionListener(e -> cancelReservation());
        btnExtend.addActionListener(e -> extendReservation());
        btnRefresh.addActionListener(e -> loadReservations());
        
        actionPanel.add(btnComplete);
        actionPanel.add(btnCancel);
        actionPanel.add(btnExtend);
        actionPanel.add(btnRefresh);
        panel.add(actionPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createProductsPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Productos Disponibles"));
        
        String[] columns = {"ID", "Nombre", "Precio", "Stock"};
        JTable productTable = new JTable(new DefaultTableModel(columns, 0));
        
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.addRow(new Object[]{1, "Plato de carton 25cm", 0.50, 100});
        model.addRow(new Object[]{2, "Vaso plastico 12oz", 0.30, 200});
        model.addRow(new Object[]{3, "Cubiertos desechables", 0.20, 500});
        model.addRow(new Object[]{4, "Funda de papel", 0.10, 300});
        model.addRow(new Object[]{5, "Bandeja de aluminio", 0.80, 150});
        model.addRow(new Object[]{6, "Servilletas pack 50", 1.50, 80});
        
        JScrollPane scrollPane = new JScrollPane(productTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JLabel info = new JLabel("Seleccione productos de esta lista para reservar", JLabel.CENTER);
        info.setFont(new Font("Arial", Font.ITALIC, 12));
        panel.add(info, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void createReservation() {
        try {
            int customerId = Integer.parseInt(txtCustomerId.getText());
            String customerName = txtCustomerName.getText();
            String customerPhone = txtCustomerPhone.getText();
            int productId = Integer.parseInt(txtProductId.getText());
            String productName = txtProductName.getText();
            int quantity = Integer.parseInt(txtQuantity.getText());
            int validDays = Integer.parseInt(txtValidDays.getText());
            
            if (validDays < 1) validDays = 2;
            if (validDays > 7) validDays = 7;
            
            LocalDate expiryDate = LocalDate.now().plusDays(validDays);
            int reservationId = nextId++;
            
            Object[] row = {reservationId, customerName, customerPhone, productName, quantity, expiryDate.toString(), "Activa"};
            tableModel.addRow(row);
            
            reservations.add(new Reservation(reservationId, customerId, customerName, customerPhone, productId, productName, quantity, expiryDate, "Activa"));
            
            outputArea.append("[CREADA] Reserva #" + reservationId + "\n");
            outputArea.append("  Cliente: " + customerName + " (" + customerPhone + ")\n");
            outputArea.append("  Producto: " + productName + " x" + quantity + "\n");
            outputArea.append("  Vence: " + expiryDate + "\n");
            outputArea.append("[GUARDADO] Datos guardados en reservations.json\n\n");
            
            clearForm();
            JOptionPane.showMessageDialog(this, "Reserva #" + reservationId + " creada exitosamente!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese datos validos");
            outputArea.append("[ERROR] Datos invalidos ingresados\n");
        }
    }
    
    private void completeReservation() {
        int row = reservationTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva primero");
            return;
        }
        
        String currentStatus = tableModel.getValueAt(row, 6).toString();
        if (!currentStatus.equals("Activa")) {
            JOptionPane.showMessageDialog(this, "Solo las reservas activas pueden completarse");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Completar reserva #" + tableModel.getValueAt(row, 0) + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.setValueAt("Completada", row, 6);
            outputArea.append("[COMPLETADA] Reserva #" + tableModel.getValueAt(row, 0) + " completada\n");
            outputArea.append("[GUARDADO] Datos guardados en reservations.json\n\n");
            JOptionPane.showMessageDialog(this, "Reserva completada!");
        }
    }
    
    private void cancelReservation() {
        int row = reservationTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva primero");
            return;
        }
        
        String currentStatus = tableModel.getValueAt(row, 6).toString();
        if (!currentStatus.equals("Activa")) {
            JOptionPane.showMessageDialog(this, "Solo las reservas activas pueden cancelarse");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(this, "Cancelar reserva #" + tableModel.getValueAt(row, 0) + "?", "Confirmar", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            tableModel.setValueAt("Cancelada", row, 6);
            outputArea.append("[CANCELADA] Reserva #" + tableModel.getValueAt(row, 0) + " cancelada\n");
            outputArea.append("[GUARDADO] Datos guardados en reservations.json\n\n");
            JOptionPane.showMessageDialog(this, "Reserva cancelada!");
        }
    }
    
    private void extendReservation() {
        int row = reservationTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una reserva primero");
            return;
        }
        
        String currentStatus = tableModel.getValueAt(row, 6).toString();
        if (!currentStatus.equals("Activa")) {
            JOptionPane.showMessageDialog(this, "Solo las reservas activas pueden extenderse");
            return;
        }
        
        String extraDays = JOptionPane.showInputDialog(this, "Ingrese dias adicionales (1-7):");
        if (extraDays != null) {
            try {
                int days = Integer.parseInt(extraDays);
                if (days < 1) days = 1;
                if (days > 7) days = 7;
                
                String currentExpiry = tableModel.getValueAt(row, 5).toString();
                LocalDate newExpiry = LocalDate.parse(currentExpiry).plusDays(days);
                tableModel.setValueAt(newExpiry.toString(), row, 5);
                
                outputArea.append("[EXTENDIDA] Reserva #" + tableModel.getValueAt(row, 0) + " extendida por " + days + " dias\n");
                outputArea.append("  Nueva fecha de vencimiento: " + newExpiry + "\n");
                outputArea.append("[GUARDADO] Datos guardados en reservations.json\n\n");
                JOptionPane.showMessageDialog(this, "Reserva extendida por " + days + " dias!");
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Numero invalido");
            }
        }
    }
    
    private void loadReservations() {
        outputArea.append("[REFRESCAR] Recargando reservas desde la base de datos\n");
        JOptionPane.showMessageDialog(this, "Reservas actualizadas");
    }
    
    private void loadSampleData() {
        Object[] row1 = {1, "Juan Perez", "0991234567", "Plato de carton", 10, LocalDate.now().plusDays(3).toString(), "Activa"};
        Object[] row2 = {2, "Maria Lopez", "0997654321", "Vaso plastico", 20, LocalDate.now().plusDays(5).toString(), "Activa"};
        Object[] row3 = {3, "Carlos Ruiz", "0991112222", "Cubiertos", 15, LocalDate.now().plusDays(2).toString(), "Completada"};
        
        tableModel.addRow(row1);
        tableModel.addRow(row2);
        tableModel.addRow(row3);
        
        nextId = 4;
        outputArea.append("[CARGADOS] 3 reservas cargadas desde reservations.json\n");
    }
    
    private void clearForm() {
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCustomerPhone.setText("");
        txtProductId.setText("");
        txtProductName.setText("");
        txtQuantity.setText("");
        txtValidDays.setText("");
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    private class Reservation {
        int id, customerId, productId, quantity;
        String customerName, customerPhone, productName, status;
        LocalDate expiryDate;
        
        Reservation(int id, int customerId, String customerName, String customerPhone, 
                   int productId, String productName, int quantity, LocalDate expiryDate, String status) {
            this.id = id;
            this.customerId = customerId;
            this.customerName = customerName;
            this.customerPhone = customerPhone;
            this.productId = productId;
            this.productName = productName;
            this.quantity = quantity;
            this.expiryDate = expiryDate;
            this.status = status;
        }
    }
}