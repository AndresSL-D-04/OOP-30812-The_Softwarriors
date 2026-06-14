SafeStoreAplicationpackage ec.edu.espe.safestore.view;
import ec.edu.espe.safestore.view.panels.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
/**
 *
 * @author Adrian Vizcaino <The-Softwarriors at ESPE>
 */
public class SafeStoreGUI extends JFrame {
    
    private JPanel mainPanel;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    private JLabel statusLabel;
    
    public SafeStoreGUI() {
        initComponents();
        setTitle("SafeStore System - The Softwarriors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void initComponents() {
        mainPanel = new JPanel(new BorderLayout());
        
        createMenuBar();
        
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setBackground(new Color(240, 240, 240));
        
        JPanel welcomePanel = createWelcomePanel();
        contentPanel.add(welcomePanel, "welcome");
        
        contentPanel.add(new PnlBackup(), "backup");
        contentPanel.add(new PnlCash(), "cash");
        contentPanel.add(new PnlCombo(), "combo");
        contentPanel.add(new PnlCredit(), "credit");
        contentPanel.add(new PnlExpiration(), "expiration");
        contentPanel.add(new PnlReport(), "report");
        contentPanel.add(new PnlStock(), "stock");
        contentPanel.add(new PnlUI(), "ui");
        contentPanel.add(new PnlProduct(), "product");
        contentPanel.add(new PnlSale(), "sale");
        contentPanel.add(new PnlSupplier(), "supplier");
        contentPanel.add(new PnlReservation(), "reservation");
        contentPanel.add(new PnlCloudSync(), "cloud");
        
        mainPanel.add(contentPanel, BorderLayout.CENTER);
        
        statusLabel = new JLabel("Listo | SafeStore System | The Softwarriors");
        statusLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        statusLabel.setBackground(new Color(220, 220, 220));
        statusLabel.setOpaque(true);
        mainPanel.add(statusLabel, BorderLayout.SOUTH);
        
        add(mainPanel);
        cardLayout.show(contentPanel, "welcome");
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        JMenu fileMenu = new JMenu("Archivo");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        
        JMenuItem exportDataItem = new JMenuItem("Exportar Datos");
        JMenuItem exitItem = new JMenuItem("Salir");
        
        exportDataItem.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Exportando datos a JSON...");
            statusLabel.setText("Datos exportados");
        });
        exitItem.addActionListener(e -> System.exit(0));
        
        fileMenu.add(exportDataItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        
        JMenu modulesMenu = new JMenu("Modulos");
        modulesMenu.setMnemonic(KeyEvent.VK_M);
        
        JMenuItem itemBackup = new JMenuItem("Sistema de Respaldos");
        JMenuItem itemCash = new JMenuItem("Control de Caja");
        JMenuItem itemCombo = new JMenuItem("Combos");
        JMenuItem itemCredit = new JMenuItem("Gestion de Creditos");
        JMenuItem itemExpiration = new JMenuItem("Control de Caducidad");
        JMenuItem itemReport = new JMenuItem("Reporte Lenta Rotacion");
        JMenuItem itemStock = new JMenuItem("Alertas de Stock");
        JMenuItem itemUI = new JMenuItem("Interfaz Adaptativa");
        JMenuItem itemProduct = new JMenuItem("Gestion de Productos");
        JMenuItem itemSale = new JMenuItem("Sistema de Ventas");
        JMenuItem itemSupplier = new JMenuItem("Gestion de Proveedores");
        JMenuItem itemReservation = new JMenuItem("Reservas");
        JMenuItem itemCloud = new JMenuItem("Sincronizacion con la Nube");
        
        itemBackup.addActionListener(e -> {
            cardLayout.show(contentPanel, "backup");
            statusLabel.setText("Modulo: Sistema de Respaldos");
        });
        itemCash.addActionListener(e -> {
            cardLayout.show(contentPanel, "cash");
            statusLabel.setText("Modulo: Control de Caja");
        });
        itemCombo.addActionListener(e -> {
            cardLayout.show(contentPanel, "combo");
            statusLabel.setText("Modulo: Combos");
        });
        itemCredit.addActionListener(e -> {
            cardLayout.show(contentPanel, "credit");
            statusLabel.setText("Modulo: Gestion de Creditos");
        });
        itemExpiration.addActionListener(e -> {
            cardLayout.show(contentPanel, "expiration");
            statusLabel.setText("Modulo: Control de Caducidad");
        });
        itemReport.addActionListener(e -> {
            cardLayout.show(contentPanel, "report");
            statusLabel.setText("Modulo: Reporte Lenta Rotacion");
        });
        itemStock.addActionListener(e -> {
            cardLayout.show(contentPanel, "stock");
            statusLabel.setText("Modulo: Alertas de Stock");
        });
        itemUI.addActionListener(e -> {
            cardLayout.show(contentPanel, "ui");
            statusLabel.setText("Modulo: Interfaz Adaptativa");
        });
        itemProduct.addActionListener(e -> {
            cardLayout.show(contentPanel, "product");
            statusLabel.setText("Modulo: Gestion de Productos");
        });
        itemSale.addActionListener(e -> {
            cardLayout.show(contentPanel, "sale");
            statusLabel.setText("Modulo: Sistema de Ventas");
        });
        itemSupplier.addActionListener(e -> {
            cardLayout.show(contentPanel, "supplier");
            statusLabel.setText("Modulo: Gestion de Proveedores");
        });
        itemReservation.addActionListener(e -> {
            cardLayout.show(contentPanel, "reservation");
            statusLabel.setText("Modulo: Reservas");
        });
        itemCloud.addActionListener(e -> {
            cardLayout.show(contentPanel, "cloud");
            statusLabel.setText("Modulo: Sincronizacion con la Nube");
        });
        
        modulesMenu.add(itemBackup);
        modulesMenu.add(itemCash);
        modulesMenu.add(itemCombo);
        modulesMenu.add(itemCredit);
        modulesMenu.add(itemExpiration);
        modulesMenu.add(itemReport);
        modulesMenu.add(itemStock);
        modulesMenu.add(itemUI);
        modulesMenu.add(itemProduct);
        modulesMenu.add(itemSale);
        modulesMenu.add(itemSupplier);
        modulesMenu.add(itemReservation);
        modulesMenu.add(itemCloud);
        
        JMenu toolsMenu = new JMenu("Herramientas");
        toolsMenu.setMnemonic(KeyEvent.VK_T);
        
        JMenuItem settingsItem = new JMenuItem("Configuracion");
        JMenuItem logsItem = new JMenuItem("Ver Registros");
        
        settingsItem.addActionListener(e -> showSettingsDialog());
        logsItem.addActionListener(e -> showLogsDialog());
        
        toolsMenu.add(settingsItem);
        toolsMenu.add(logsItem);
        
        JMenu helpMenu = new JMenu("Ayuda");
        helpMenu.setMnemonic(KeyEvent.VK_H);
        
        JMenuItem userManualItem = new JMenuItem("Manual de Usuario");
        JMenuItem aboutItem = new JMenuItem("Acerca de");
        JMenuItem shortcutsItem = new JMenuItem("Atajos de Teclado");
        
        userManualItem.addActionListener(e -> showHelpDialog());
        aboutItem.addActionListener(e -> showAboutDialog());
        shortcutsItem.addActionListener(e -> showShortcutsDialog());
        
        helpMenu.add(userManualItem);
        helpMenu.add(shortcutsItem);
        helpMenu.addSeparator();
        helpMenu.add(aboutItem);
        
        menuBar.add(fileMenu);
        menuBar.add(modulesMenu);
        menuBar.add(toolsMenu);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
    }
    
    private void showSettingsDialog() {
        JDialog dialog = new JDialog(this, "Configuracion", true);
        dialog.setSize(400, 300);
        dialog.setLocationRelativeTo(this);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        
        String[] labels = {"Idioma:", "Tema:", "Auto-guardado:", "Notificaciones:"};
        String[] options = {"Espanol/Ingles", "Claro/Oscuro", "Cada 5 min", "Activo/Inactivo"};
        
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0;
            gbc.gridy = i;
            panel.add(new JLabel(labels[i]), gbc);
            gbc.gridx = 1;
            JComboBox<String> combo = new JComboBox<>(new String[]{options[i]});
            panel.add(combo, gbc);
        }
        
        JButton btnSave = new JButton("Guardar");
        btnSave.addActionListener(e -> {
            statusLabel.setText("Configuracion guardada");
            dialog.dispose();
        });
        
        gbc.gridx = 0;
        gbc.gridy = labels.length;
        gbc.gridwidth = 2;
        panel.add(btnSave, gbc);
        
        dialog.add(panel);
        dialog.setVisible(true);
    }
    
    private void showLogsDialog() {
        JDialog dialog = new JDialog(this, "Registros del Sistema", true);
        dialog.setSize(500, 400);
        dialog.setLocationRelativeTo(this);
        
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        logArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        logArea.setText("=== REGISTROS DEL SISTEMA ===\n\n");
        logArea.append(java.time.LocalDateTime.now() + " - Sistema iniciado\n");
        logArea.append(java.time.LocalDateTime.now() + " - SafeStoreGUI inicializado\n");
        logArea.append(java.time.LocalDateTime.now() + " - Todos los modulos cargados\n");
        
        JScrollPane scrollPane = new JScrollPane(logArea);
        dialog.add(scrollPane);
        dialog.setVisible(true);
    }
    
    private void showAboutDialog() {
        String message = "SafeStore System\n\n"
                + "Version: 2.0\n\n"
                + "Desarrollado por: THE SOFTWARRIORS\n\n"
                + "Integrantes:\n"
                + "  - Joel Sanchez\n"
                + "  - Ronald Tipan\n"
                + "  - Adrian Vizcaino\n"
                + "  - Lenin Tipantiza\n\n"
                + "Instructor: Ing. Jorge Edison Lascano, PhD\n"
                + "NRC: 30812\n\n"
                + "Sangolqui - Ecuador 2024";
        
        JOptionPane.showMessageDialog(this, message, "Acerca de SafeStore", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showHelpDialog() {
        String message = "MANUAL DE USUARIO\n\n"
                + "MODULOS:\n\n"
                + "1. Sistema de Respaldos - Crear, restaurar y eliminar respaldos\n"
                + "2. Control de Caja - Abrir/cerrar caja, registrar ingresos/egresos\n"
                + "3. Combos - Crear paquetes promocionales\n"
                + "4. Gestion de Creditos - Administrar cuentas de credito de clientes\n"
                + "5. Control de Caducidad - Alertas y descuentos por caducidad\n"
                + "6. Reporte Lenta Rotacion - Identificar productos con baja rotacion\n"
                + "7. Alertas de Stock - Alertas de stock minimo y sugerencias\n"
                + "8. Interfaz Adaptativa - Personalizacion de la interfaz\n"
                + "9. Gestion de Productos - CRUD de productos\n"
                + "10. Sistema de Ventas - Ventas mayor/menor con espera\n"
                + "11. Gestion de Proveedores - Proveedores y facturas\n"
                + "12. Reservas - Reservas de productos para clientes\n"
                + "13. Sincronizacion con la Nube - MongoDB Atlas\n\n"
                + "Todos los datos se guardan automaticamente en archivos JSON y en la nube.";
        
        JOptionPane.showMessageDialog(this, message, "Manual de Usuario", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void showShortcutsDialog() {
        String message = "ATAJOS DE TECLADO\n\n"
                + "Ctrl+E   - Exportar Datos\n"
                + "Alt+F4   - Salir\n"
                + "F1       - Ayuda\n"
                + "F5       - Refrescar\n\n"
                + "Navegacion:\n"
                + "Use el menu Modulos en la barra superior para acceder a todas las funciones";
        
        JOptionPane.showMessageDialog(this, message, "Atajos de Teclado", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private JPanel createWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 240, 240));
        
        JLabel title = new JLabel("BIENVENIDO A SAFESTORE", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 32));
        title.setForeground(new Color(45, 45, 45));
        title.setBorder(BorderFactory.createEmptyBorder(80, 0, 30, 0));
        
        JLabel subtitle = new JLabel("Sistema de Gestion para Minimarket de Productos Desechables", JLabel.CENTER);
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setForeground(new Color(100, 100, 100));
        
        JLabel version = new JLabel("Version 2.0 | The Softwarriors", JLabel.CENTER);
        version.setFont(new Font("Arial", Font.ITALIC, 14));
        version.setForeground(new Color(150, 150, 150));
        version.setBorder(BorderFactory.createEmptyBorder(180, 0, 20, 0));
        
        JPanel infoPanel = new JPanel(new GridLayout(5, 1, 10, 10));
        infoPanel.setOpaque(false);
        infoPanel.setBorder(BorderFactory.createEmptyBorder(40, 150, 40, 150));
        
        JLabel info1 = new JLabel("13 modulos funcionales disponibles", JLabel.CENTER);
        JLabel info2 = new JLabel("Persistencia automatica en JSON", JLabel.CENTER);
        JLabel info3 = new JLabel("Sincronizacion con MongoDB Atlas", JLabel.CENTER);
        JLabel info4 = new JLabel("Precios por mayor y menor", JLabel.CENTER);
        JLabel info5 = new JLabel("Sistema de reservas y ventas en espera", JLabel.CENTER);
        info1.setFont(new Font("Arial", Font.PLAIN, 14));
        info2.setFont(new Font("Arial", Font.PLAIN, 14));
        info3.setFont(new Font("Arial", Font.PLAIN, 14));
        info4.setFont(new Font("Arial", Font.PLAIN, 14));
        info5.setFont(new Font("Arial", Font.PLAIN, 14));
        info1.setForeground(new Color(80, 80, 80));
        info2.setForeground(new Color(80, 80, 80));
        info3.setForeground(new Color(80, 80, 80));
        info4.setForeground(new Color(80, 80, 80));
        info5.setForeground(new Color(80, 80, 80));
        
        infoPanel.add(info1);
        infoPanel.add(info2);
        infoPanel.add(info3);
        infoPanel.add(info4);
        infoPanel.add(info5);
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(title, BorderLayout.NORTH);
        centerPanel.add(subtitle, BorderLayout.CENTER);
        centerPanel.add(infoPanel, BorderLayout.SOUTH);
        
        panel.add(centerPanel, BorderLayout.CENTER);
        panel.add(version, BorderLayout.SOUTH);
        return panel;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SafeStoreGUI());
    }
}
