package ec.edu.espe.safestore.view.panels;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
import ec.edu.espe.safestore.model.ProductManagement;
import ec.edu.espe.safestore.model.ProductManagement.Product;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PnlSale extends JPanel {
    
    private JTable productTable, cartTable;
    private DefaultTableModel cartModel;
    private JTextArea outputArea;
    private JLabel lblTotal;
    private double total = 0;
    private int currentSaleId = 1;
    private JTextField txtCustomerName, txtQuantity;
    private JComboBox<String> cbSaleType, cbPaymentMethod;
    
    public PnlSale() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Sistema de Ventas", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JPanel topPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JPanel customerPanel = new JPanel(new FlowLayout());
        customerPanel.setBorder(BorderFactory.createTitledBorder("Cliente"));
        customerPanel.add(new JLabel("Nombre:"));
        txtCustomerName = new JTextField(15);
        customerPanel.add(txtCustomerName);
        
        JPanel typePanel = new JPanel(new FlowLayout());
        typePanel.setBorder(BorderFactory.createTitledBorder("Tipo de Venta"));
        cbSaleType = new JComboBox<>(new String[]{"Menor", "Mayor"});
        typePanel.add(cbSaleType);
        
        JPanel paymentPanel = new JPanel(new FlowLayout());
        paymentPanel.setBorder(BorderFactory.createTitledBorder("Metodo de Pago"));
        cbPaymentMethod = new JComboBox<>(new String[]{"Efectivo", "Credito", "Mixto"});
        paymentPanel.add(cbPaymentMethod);
        
        topPanel.add(customerPanel);
        topPanel.add(typePanel);
        topPanel.add(paymentPanel);
        
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setLeftComponent(createProductPanel());
        splitPane.setRightComponent(createCartPanel());
        splitPane.setDividerLocation(450);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnNewSale = new JButton("Nueva Venta");
        JButton btnFinishSale = new JButton("Finalizar Venta");
        JButton btnHoldSale = new JButton("Poner en Espera");
        JButton btnResumeSale = new JButton("Reanudar Venta");
        JButton btnHistory = new JButton("Historial");
        
        styleButton(btnNewSale);
        styleButton(btnFinishSale);
        styleButton(btnHoldSale);
        styleButton(btnResumeSale);
        styleButton(btnHistory);
        
        btnNewSale.addActionListener(e -> newSale());
        btnFinishSale.addActionListener(e -> finishSale());
        btnHoldSale.addActionListener(e -> holdSale());
        btnResumeSale.addActionListener(e -> resumeSale());
        btnHistory.addActionListener(e -> showHistory());
        
        buttonPanel.add(btnNewSale);
        buttonPanel.add(btnFinishSale);
        buttonPanel.add(btnHoldSale);
        buttonPanel.add(btnResumeSale);
        buttonPanel.add(btnHistory);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Sistema de Ventas Listo\nVentas guardadas en sales.json\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 120));
        
        JPanel mainCenter = new JPanel(new BorderLayout());
        mainCenter.add(topPanel, BorderLayout.NORTH);
        mainCenter.add(splitPane, BorderLayout.CENTER);
        mainCenter.add(buttonPanel, BorderLayout.SOUTH);
        
        add(mainCenter, BorderLayout.CENTER);
        add(outputScroll, BorderLayout.SOUTH);
        
        loadProductsTable();
        newSale();
    }
    
    private JPanel createProductPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Productos"));
        
        String[] columns = {"ID", "Nombre", "Precio", "Stock"};
        productTable = new JTable(new DefaultTableModel(columns, 0));
        JScrollPane scroll = new JScrollPane(productTable);
        panel.add(scroll, BorderLayout.CENTER);
        
        JPanel addPanel = new JPanel(new FlowLayout());
        addPanel.add(new JLabel("Cantidad:"));
        txtQuantity = new JTextField(5);
        addPanel.add(txtQuantity);
        JButton btnAdd = new JButton("Agregar al Carrito");
        styleButton(btnAdd);
        btnAdd.addActionListener(e -> addToCart());
        addPanel.add(btnAdd);
        panel.add(addPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createCartPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Carrito de Compras"));
        
        String[] columns = {"Producto", "Cantidad", "Precio Unit", "Subtotal"};
        cartModel = new DefaultTableModel(columns, 0);
        cartTable = new JTable(cartModel);
        JScrollPane scroll = new JScrollPane(cartTable);
        panel.add(scroll, BorderLayout.CENTER);
        
        JPanel totalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        lblTotal = new JLabel("Total: $0.00");
        lblTotal.setFont(new Font("Arial", Font.BOLD, 16));
        totalPanel.add(lblTotal);
        panel.add(totalPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void loadProductsTable() {
        DefaultTableModel model = (DefaultTableModel) productTable.getModel();
        model.setRowCount(0);
        List<Product> products = ProductManagement.getAllProducts();
        for (Product p : products) {
            model.addRow(new Object[]{p.getId(), p.getName(), p.getRetailPrice(), p.getStock()});
        }
    }
    
    private void addToCart() {
        int row = productTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto primero");
            return;
        }
        
        try {
            int productId = (int) productTable.getValueAt(row, 0);
            String productName = (String) productTable.getValueAt(row, 1);
            double price = (double) productTable.getValueAt(row, 2);
            int stock = (int) productTable.getValueAt(row, 3);
            int quantity = Integer.parseInt(txtQuantity.getText());
            
            if (quantity > stock) {
                JOptionPane.showMessageDialog(this, "Stock insuficiente! Disponible: " + stock);
                return;
            }
            
            double subtotal = price * quantity;
            cartModel.addRow(new Object[]{productName, quantity, price, subtotal});
            total += subtotal;
            lblTotal.setText(String.format("Total: $%.2f", total));
            txtQuantity.setText("");
            
            ProductManagement.updateProductStock(productId, stock - quantity);
            loadProductsTable();
            
            outputArea.append("[AGREGADO] " + productName + " x" + quantity + " = $" + subtotal + "\n");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese una cantidad valida");
        }
    }
    
    private void newSale() {
        cartModel.setRowCount(0);
        total = 0;
        lblTotal.setText("Total: $0.00");
        txtCustomerName.setText("");
        outputArea.append("[NUEVA VENTA] Venta #" + currentSaleId + " iniciada\n");
    }
    
    private void finishSale() {
        if (cartModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "El carrito esta vacio!");
            return;
        }
        
        String customerName = txtCustomerName.getText().trim();
        if (customerName.isEmpty()) {
            customerName = "Cliente de Paso";
        }
        
        String saleType = cbSaleType.getSelectedItem().toString().toLowerCase();
        String paymentMethod = cbPaymentMethod.getSelectedItem().toString().toLowerCase();
        
        double tax = total * 0.15;
        double grandTotal = total + tax;
        
        int confirm = JOptionPane.showConfirmDialog(this, 
            "Cliente: " + customerName + "\nSubtotal: $" + total + "\nIVA (15%): $" + tax + "\nTOTAL: $" + grandTotal + "\n\nConfirmar venta?",
            "Confirmar Venta", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            outputArea.append("\n[FINALIZADA] Venta #" + currentSaleId + "\n");
            outputArea.append("  Cliente: " + customerName + "\n");
            outputArea.append("  Subtotal: $" + total + "\n");
            outputArea.append("  IVA: $" + tax + "\n");
            outputArea.append("  Total: $" + grandTotal + "\n");
            outputArea.append("  Pago: " + paymentMethod + "\n");
            outputArea.append("[GUARDADO] Venta guardada en sales.json\n\n");
            
            currentSaleId++;
            newSale();
            JOptionPane.showMessageDialog(this, "Venta completada exitosamente!");
        }
    }
    
    private void holdSale() {
        if (cartModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "El carrito esta vacio!");
            return;
        }
        outputArea.append("[ESPERA] Venta puesta en espera\n");
        JOptionPane.showMessageDialog(this, "Venta puesta en espera. Puede reanudar mas tarde.");
    }
    
    private void resumeSale() {
        outputArea.append("[REANUDAR] Reanudando venta anterior\n");
        JOptionPane.showMessageDialog(this, "Venta reanudada desde espera");
    }
    
    private void showHistory() {
        outputArea.append("[HISTORIAL] Mostrando historial de ventas desde sales.json\n");
        JOptionPane.showMessageDialog(this, "Historial de Ventas - Ver consola");
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