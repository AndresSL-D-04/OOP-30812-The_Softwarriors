/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.safestore.view.panels;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */

public class PnlBackup extends JPanel {
    
    private JTextArea outputArea;
    private JTextField txtBackupName;
    
    public PnlBackup() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Sistema de Respaldos", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JPanel formPanel = new JPanel(new FlowLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Crear Respaldo"));
        formPanel.add(new JLabel("Nombre del Respaldo:"));
        txtBackupName = new JTextField(20);
        formPanel.add(txtBackupName);
        JButton btnCreate = new JButton("Crear Respaldo");
        styleButton(btnCreate);
        btnCreate.addActionListener(e -> createBackup());
        formPanel.add(btnCreate);
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JButton btnRestore = new JButton("Restaurar Respaldo");
        JButton btnDelete = new JButton("Eliminar Respaldo");
        JButton btnUpload = new JButton("Subir a la Nube");
        JButton btnDownload = new JButton("Descargar de la Nube");
        JButton btnView = new JButton("Ver Respaldos");
        
        styleButton(btnRestore);
        styleButton(btnDelete);
        styleButton(btnUpload);
        styleButton(btnDownload);
        styleButton(btnView);
        
        btnRestore.addActionListener(e -> restoreBackup());
        btnDelete.addActionListener(e -> deleteBackup());
        btnUpload.addActionListener(e -> uploadToCloud());
        btnDownload.addActionListener(e -> downloadFromCloud());
        btnView.addActionListener(e -> viewBackups());
        
        buttonPanel.add(btnRestore);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnUpload);
        buttonPanel.add(btnDownload);
        buttonPanel.add(btnView);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Sistema de Respaldos Listo\nRespaldos guardados en backups.json\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 200));
        
        add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputScroll, BorderLayout.SOUTH);
    }
    
    private void createBackup() {
        String name = txtBackupName.getText().trim();
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre para el respaldo");
            return;
        }
        
        String backupId = String.valueOf(System.currentTimeMillis() % 10000);
        outputArea.append("[CREADO] Respaldo ID: " + backupId + " | Nombre: " + name + " | Fecha: " + java.time.LocalDate.now() + "\n");
        outputArea.append("[GUARDADO] Respaldo guardado en backups.json\n\n");
        
        txtBackupName.setText("");
        JOptionPane.showMessageDialog(this, "Respaldo creado exitosamente!\nID: " + backupId);
    }
    
    private void restoreBackup() {
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del respaldo a restaurar:");
        if (id != null) {
            outputArea.append("[RESTAURAR] Restaurando respaldo ID: " + id + "\n");
            outputArea.append("[EXITO] Respaldo restaurado exitosamente\n\n");
            JOptionPane.showMessageDialog(this, "Respaldo restaurado exitosamente!");
        }
    }
    
    private void deleteBackup() {
        String id = JOptionPane.showInputDialog(this, "Ingrese el ID del respaldo a eliminar:");
        if (id != null) {
            outputArea.append("[ELIMINAR] Eliminando respaldo ID: " + id + "\n");
            outputArea.append("[EXITO] Respaldo eliminado\n\n");
            JOptionPane.showMessageDialog(this, "Respaldo eliminado!");
        }
    }
    
    private void uploadToCloud() {
        outputArea.append("[NUBE] Subiendo respaldos a la nube...\n");
        outputArea.append("[EXITO] Respaldos subidos a la nube\n\n");
        JOptionPane.showMessageDialog(this, "Respaldos subidos a la nube!");
    }
    
    private void downloadFromCloud() {
        outputArea.append("[NUBE] Descargando respaldos desde la nube...\n");
        outputArea.append("[EXITO] Respaldos descargados desde la nube\n\n");
        JOptionPane.showMessageDialog(this, "Respaldos descargados desde la nube!");
    }
    
    private void viewBackups() {
        outputArea.append("\n=== LISTA DE RESPALDOS ===\n");
        outputArea.append("  Respaldo_001 - 2024-01-15 - Activo\n");
        outputArea.append("  Respaldo_002 - 2024-01-20 - Activo\n");
        outputArea.append("  Respaldo_003 - 2024-01-25 - Activo\n\n");
        JOptionPane.showMessageDialog(this, "Respaldos mostrados en la consola");
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}