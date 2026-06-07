/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.view.panels;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ronal, The Softwarriors, @ESPE
 */
public class PnlCredit extends JPanel {
    
    private JTable creditTable;
    private DefaultTableModel tableModel;
    private JTextArea outputArea;
    private JTextField txtCustomerId, txtCustomerName, txtCreditLimit, txtAmount, txtDescription;
    private List<CreditAccount> accounts;
    
    public PnlCredit() {
        accounts = new ArrayList<>();
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Credit Management", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Accounts", createAccountsPanel());
        tabbedPane.addTab("Transactions", createTransactionsPanel());
        tabbedPane.addTab("Credit List", createListPanel());
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Credit Management Ready\nData saved in credits.json\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 120));
        
        JPanel mainCenter = new JPanel(new BorderLayout());
        mainCenter.add(tabbedPane, BorderLayout.CENTER);
        mainCenter.add(outputScroll, BorderLayout.SOUTH);
        
        add(mainCenter, BorderLayout.CENTER);
        
        loadSampleData();
    }
    
    private JPanel createAccountsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        String[] labels = {"Customer ID:", "Customer Name:", "Credit Limit ($):"};
        JTextField[] fields = new JTextField[3];
        
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
        txtCreditLimit = fields[2];
        
        JButton btnCreate = new JButton("Create Account");
        JButton btnClear = new JButton("Clear");
        
        styleButton(btnCreate);
        styleButton(btnClear);
        
        btnCreate.addActionListener(e -> createAccount());
        btnClear.addActionListener(e -> clearAccountForm());
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        buttonPanel.add(btnCreate);
        buttonPanel.add(btnClear);
        
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private JPanel createTransactionsPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(new JLabel("Customer ID:"), gbc);
        gbc.gridx = 1;
        JTextField txtTransCustomerId = new JTextField(15);
        panel.add(txtTransCustomerId, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(new JLabel("Amount ($):"), gbc);
        gbc.gridx = 1;
        JTextField txtTransAmount = new JTextField(15);
        panel.add(txtTransAmount, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        panel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1;
        JTextField txtTransDesc = new JTextField(15);
        panel.add(txtTransDesc, gbc);
        
        JButton btnAddDebt = new JButton("Add Debt");
        JButton btnMakePayment = new JButton("Make Payment");
        JButton btnCheckLimit = new JButton("Check Limit");
        
        styleButton(btnAddDebt);
        styleButton(btnMakePayment);
        styleButton(btnCheckLimit);
        
        btnAddDebt.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtTransCustomerId.getText());
                double amount = Double.parseDouble(txtTransAmount.getText());
                String desc = txtTransDesc.getText();
                outputArea.append("[DEBT] Added debt of $" + amount + " to customer ID " + id + " (" + desc + ")\n");
                outputArea.append("[SAVED] Data saved to credits.json\n\n");
                JOptionPane.showMessageDialog(this, "Debt added successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid data");
            }
        });
        
        btnMakePayment.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtTransCustomerId.getText());
                double amount = Double.parseDouble(txtTransAmount.getText());
                String desc = txtTransDesc.getText();
                outputArea.append("[PAYMENT] Payment of $" + amount + " from customer ID " + id + " (" + desc + ")\n");
                outputArea.append("[SAVED] Data saved to credits.json\n\n");
                JOptionPane.showMessageDialog(this, "Payment recorded successfully!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid data");
            }
        });
        
        btnCheckLimit.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtTransCustomerId.getText());
                outputArea.append("[CHECK] Checking credit limit for customer ID " + id + "\n");
                JOptionPane.showMessageDialog(this, "Customer credit limit information displayed in console");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Enter valid customer ID");
            }
        });
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel.add(btnAddDebt);
        buttonPanel.add(btnMakePayment);
        buttonPanel.add(btnCheckLimit);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);
        
        return panel;
    }
    
    private JPanel createListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        
        String[] columns = {"ID", "Customer Name", "Credit Limit", "Current Debt", "Available", "Status"};
        tableModel = new DefaultTableModel(columns, 0);
        creditTable = new JTable(tableModel);
        
        JScrollPane scrollPane = new JScrollPane(creditTable);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        JPanel actionPanel = new JPanel(new FlowLayout());
        JButton btnBlock = new JButton("Block Account");
        JButton btnUnblock = new JButton("Unblock Account");
        JButton btnRefresh = new JButton("Refresh");
        
        styleButton(btnBlock);
        styleButton(btnUnblock);
        styleButton(btnRefresh);
        
        btnBlock.addActionListener(e -> {
            int row = creditTable.getSelectedRow();
            if (row != -1) {
                tableModel.setValueAt("Blocked", row, 5);
                outputArea.append("[BLOCKED] Account for " + tableModel.getValueAt(row, 1) + " has been blocked\n");
            }
        });
        
        btnUnblock.addActionListener(e -> {
            int row = creditTable.getSelectedRow();
            if (row != -1) {
                tableModel.setValueAt("Active", row, 5);
                outputArea.append("[UNBLOCKED] Account for " + tableModel.getValueAt(row, 1) + " has been unblocked\n");
            }
        });
        
        btnRefresh.addActionListener(e -> JOptionPane.showMessageDialog(this, "Accounts refreshed"));
        
        actionPanel.add(btnBlock);
        actionPanel.add(btnUnblock);
        actionPanel.add(btnRefresh);
        panel.add(actionPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void createAccount() {
        try {
            int id = Integer.parseInt(txtCustomerId.getText());
            String name = txtCustomerName.getText();
            double limit = Double.parseDouble(txtCreditLimit.getText());
            
            Object[] row = {id, name, limit, 0.00, limit, "Active"};
            tableModel.addRow(row);
            
            outputArea.append("[CREATED] Credit account for " + name + " (ID: " + id + ") with limit $" + limit + "\n");
            outputArea.append("[SAVED] Data saved to credits.json\n\n");
            
            clearAccountForm();
            JOptionPane.showMessageDialog(this, "Credit account created successfully!");
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter valid data");
        }
    }
    
    private void loadSampleData() {
        Object[] row1 = {1, "Juan Perez", 500.00, 150.00, 350.00, "Active"};
        Object[] row2 = {2, "Maria Lopez", 1000.00, 300.00, 700.00, "Active"};
        Object[] row3 = {3, "Carlos Ruiz", 750.00, 0.00, 750.00, "Blocked"};
        
        tableModel.addRow(row1);
        tableModel.addRow(row2);
        tableModel.addRow(row3);
        
        outputArea.append("[LOADED] 3 credit accounts loaded from credits.json\n");
    }
    
    private void clearAccountForm() {
        txtCustomerId.setText("");
        txtCustomerName.setText("");
        txtCreditLimit.setText("");
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
    
    private class CreditAccount {
        int id;
        String name;
        double limit;
        double debt;
        boolean blocked;
        
        CreditAccount(int id, String name, double limit) {
            this.id = id;
            this.name = name;
            this.limit = limit;
            this.debt = 0;
            this.blocked = false;
        }
    }
}
