package ec.edu.espe.safestore.view.panels;

import ec.edu.espe.safestore.model.CloudSyncManager;
import ec.edu.espe.safestore.model.MongoDBConnection;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author Joel Sanchez, The Softwarriors, @ESPE
 */
public class PnlCloudSync extends JPanel {
    
    private JTextArea outputArea;
    private JLabel lblStatus;
    
    public PnlCloudSync() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Sincronizacion con la Nube", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JPanel infoPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        infoPanel.setBorder(BorderFactory.createTitledBorder("Estado de Conexion"));
        
        lblStatus = new JLabel("Estado: Desconectado");
        lblStatus.setFont(new Font("Arial", Font.BOLD, 14));
        
        JLabel dbLabel = new JLabel("Base de datos: safestore (MongoDB Atlas)");
        JLabel clusterLabel = new JLabel("Cluster: cluster0.aex8od4.mongodb.net");
        
        infoPanel.add(lblStatus);
        infoPanel.add(dbLabel);
        infoPanel.add(clusterLabel);
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        JButton btnConnect = new JButton("Conectar");
        JButton btnDisconnect = new JButton("Desconectar");
        JButton btnUpload = new JButton("Subir a la Nube");
        JButton btnDownload = new JButton("Descargar de la Nube");
        
        styleButton(btnConnect);
        styleButton(btnDisconnect);
        styleButton(btnUpload);
        styleButton(btnDownload);
        
        btnConnect.addActionListener(e -> connectToCloud());
        btnDisconnect.addActionListener(e -> disconnect());
        btnUpload.addActionListener(e -> uploadAll());
        btnDownload.addActionListener(e -> downloadAll());
        
        buttonPanel.add(btnConnect);
        buttonPanel.add(btnDisconnect);
        buttonPanel.add(btnUpload);
        buttonPanel.add(btnDownload);
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("=== SISTEMA DE SINCRONIZACION CON LA NUBE ===\n\n");
        outputArea.append("MongoDB Atlas configurado\n");
        outputArea.append("Base de datos: safestore\n\n");
        outputArea.append("Presione 'Conectar' para iniciar\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 200));
        
        add(infoPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputScroll, BorderLayout.SOUTH);
    }
    
    private void connectToCloud() {
        try {
            MongoDBConnection.connect();
            if (MongoDBConnection.isConnected()) {
                lblStatus.setText("Estado: Conectado a MongoDB Atlas");
                lblStatus.setForeground(new Color(0, 150, 0));
                appendOutput("Conexion exitosa a MongoDB Atlas");
                JOptionPane.showMessageDialog(this, "Conectado a MongoDB Atlas!");
            } else {
                appendOutput("Error: No se pudo conectar");
                JOptionPane.showMessageDialog(this, "Error de conexion");
            }
        } catch (Exception ex) {
            appendOutput("Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
    
    private void disconnect() {
        MongoDBConnection.close();
        lblStatus.setText("Estado: Desconectado");
        lblStatus.setForeground(Color.RED);
        appendOutput("Conexion cerrada");
        JOptionPane.showMessageDialog(this, "Desconectado de MongoDB Atlas");
    }
    
    private void uploadAll() {
        if (!MongoDBConnection.isConnected()) {
            JOptionPane.showMessageDialog(this, "Primero conectese a MongoDB Atlas");
            return;
        }
        
        appendOutput("\n=== SUBIENDO DATOS A LA NUBE ===");
        CloudSyncManager.uploadAll();
        appendOutput("=== SUBIDA COMPLETADA ===\n");
        JOptionPane.showMessageDialog(this, "Datos subidos a la nube!");
    }
    
    private void downloadAll() {
        if (!MongoDBConnection.isConnected()) {
            JOptionPane.showMessageDialog(this, "Primero conectese a MongoDB Atlas");
            return;
        }
        
        appendOutput("\n=== DESCARGANDO DATOS DESDE LA NUBE ===");
        CloudSyncManager.downloadAll();
        appendOutput("=== DESCARGA COMPLETADA ===\n");
        refreshProductPanel();
        JOptionPane.showMessageDialog(this, "Datos descargados desde la nube!");
    }
    
    private void appendOutput(String message) {
        outputArea.append(message + "\n");
        outputArea.setCaretPosition(outputArea.getDocument().getLength());
    }
    
    private void refreshProductPanel() {
        Component[] components = getParent().getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                Component[] subComps = ((JPanel) comp).getComponents();
                for (Component subComp : subComps) {
                    if (subComp instanceof PnlProduct) {
                        try {
                            java.lang.reflect.Method method = subComp.getClass().getMethod("loadProductTable");
                            method.invoke(subComp);
                        } catch (Exception e) {
                            System.out.println("No se pudo refrescar: " + e.getMessage());
                        }
                    }
                }
            }
        }
    }
    
    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(new Color(52, 152, 219));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
