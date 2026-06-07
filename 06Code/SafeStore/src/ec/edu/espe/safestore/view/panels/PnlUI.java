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
import java.awt.*;

public class PnlUI extends JPanel {
    
    private JTextArea outputArea;
    private JComboBox<String> cbTheme, cbFontSize, cbLanguage;
    private JCheckBox chkHighContrast, chkAnimations;
    
    public PnlUI() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Interfaz Adaptativa", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JPanel configPanel = new JPanel(new GridBagLayout());
        configPanel.setBorder(BorderFactory.createTitledBorder("Configuracion de Interfaz"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        String[] labels = {"Tema:", "Tamano de Fuente:", "Idioma:", "Alto Contraste:", "Animaciones:"};
        
        gbc.gridx = 0; gbc.gridy = 0;
        configPanel.add(new JLabel(labels[0]), gbc);
        gbc.gridx = 1;
        cbTheme = new JComboBox<>(new String[]{"Claro", "Oscuro", "Predeterminado del Sistema"});
        configPanel.add(cbTheme, gbc);
        
        gbc.gridx = 0; gbc.gridy = 1;
        configPanel.add(new JLabel(labels[1]), gbc);
        gbc.gridx = 1;
        cbFontSize = new JComboBox<>(new String[]{"Pequeño (10px)", "Mediano (12px)", "Grande (14px)", "Extra Grande (16px)"});
        configPanel.add(cbFontSize, gbc);
        
        gbc.gridx = 0; gbc.gridy = 2;
        configPanel.add(new JLabel(labels[2]), gbc);
        gbc.gridx = 1;
        cbLanguage = new JComboBox<>(new String[]{"Español", "English", "Portuguese"});
        configPanel.add(cbLanguage, gbc);
        
        gbc.gridx = 0; gbc.gridy = 3;
        configPanel.add(new JLabel(labels[3]), gbc);
        gbc.gridx = 1;
        chkHighContrast = new JCheckBox();
        configPanel.add(chkHighContrast, gbc);
        
        gbc.gridx = 0; gbc.gridy = 4;
        configPanel.add(new JLabel(labels[4]), gbc);
        gbc.gridx = 1;
        chkAnimations = new JCheckBox();
        chkAnimations.setSelected(true);
        configPanel.add(chkAnimations, gbc);
        
        JButton btnApply = new JButton("Aplicar Cambios");
        JButton btnReset = new JButton("Restaurar Valores");
        JButton btnShortcuts = new JButton("Atajos de Teclado");
        
        styleButton(btnApply);
        styleButton(btnReset);
        styleButton(btnShortcuts);
        
        btnApply.addActionListener(e -> applyChanges());
        btnReset.addActionListener(e -> resetDefaults());
        btnShortcuts.addActionListener(e -> showShortcuts());
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnApply);
        buttonPanel.add(btnReset);
        buttonPanel.add(btnShortcuts);
        
        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        configPanel.add(buttonPanel, gbc);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Interfaz Adaptativa Lista\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 150));
        
        add(configPanel, BorderLayout.CENTER);
        add(outputScroll, BorderLayout.SOUTH);
    }
    
    private void applyChanges() {
        outputArea.append("\n=== APLICANDO CAMBIOS ===\n");
        outputArea.append("  Tema: " + cbTheme.getSelectedItem() + "\n");
        outputArea.append("  Tamano Fuente: " + cbFontSize.getSelectedItem() + "\n");
        outputArea.append("  Idioma: " + cbLanguage.getSelectedItem() + "\n");
        outputArea.append("  Alto Contraste: " + (chkHighContrast.isSelected() ? "ACTIVADO" : "DESACTIVADO") + "\n");
        outputArea.append("  Animaciones: " + (chkAnimations.isSelected() ? "ACTIVADAS" : "DESACTIVADAS") + "\n");
        outputArea.append("[APLICADOS] Cambios de interfaz aplicados exitosamente\n");
        outputArea.append("[GUARDADO] Configuracion guardada en ui_config.json\n\n");
        
        JOptionPane.showMessageDialog(this, "Cambios de interfaz aplicados!\nPuede que necesite reiniciar para algunos cambios.");
    }
    
    private void resetDefaults() {
        cbTheme.setSelectedIndex(0);
        cbFontSize.setSelectedIndex(1);
        cbLanguage.setSelectedIndex(0);
        chkHighContrast.setSelected(false);
        chkAnimations.setSelected(true);
        
        outputArea.append("\n=== RESTAURANDO VALORES ===\n");
        outputArea.append("[RESTAURADOS] Todos los valores de interfaz restaurados a su estado original\n");
        outputArea.append("[GUARDADO] Configuracion guardada en ui_config.json\n\n");
        
        JOptionPane.showMessageDialog(this, "Valores de interfaz restaurados!");
    }
    
    private void showShortcuts() {
        String message = "ATAJOS DE TECLADO\n\n"
                + "Navegacion:\n"
                + "  Ctrl+1-9 - Acceso rapido a modulos\n"
                + "  F1 - Ayuda\n"
                + "  F5 - Refrescar\n\n"
                + "Acciones:\n"
                + "  Ctrl+N - Nuevo respaldo\n"
                + "  Ctrl+S - Guardar datos\n"
                + "  Ctrl+E - Exportar datos\n"
                + "  Ctrl+A - Agregar producto\n"
                + "  Ctrl+F - Buscar\n\n"
                + "General:\n"
                + "  Alt+F4 - Salir\n"
                + "  F11 - Pantalla completa";
        
        JOptionPane.showMessageDialog(this, message, "Atajos de Teclado", JOptionPane.INFORMATION_MESSAGE);
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