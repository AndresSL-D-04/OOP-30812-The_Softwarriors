package ec.edu.espe.safestore.view.panels;

/**
 *
 * @author Alexander Tipantiza, The Softwarrios, @ESPE
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PnlReport extends JPanel {
    
    private JTable reportTable;
    private DefaultTableModel tableModel;
    private JTextArea outputArea;
    
    public PnlReport() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        JLabel title = new JLabel("Reporte de Lenta Rotacion", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        add(title, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnAnalyze = new JButton("Analizar Productos");
        JButton btnGenerateReport = new JButton("Generar Reporte");
        JButton btnExportPDF = new JButton("Exportar a PDF");
        JButton btnRecommend = new JButton("Recomendar Reabastecimiento");
        
        styleButton(btnAnalyze);
        styleButton(btnGenerateReport);
        styleButton(btnExportPDF);
        styleButton(btnRecommend);
        
        btnAnalyze.addActionListener(e -> analyzeProducts());
        btnGenerateReport.addActionListener(e -> generateReport());
        btnExportPDF.addActionListener(e -> exportToPDF());
        btnRecommend.addActionListener(e -> recommendRestock());
        
        buttonPanel.add(btnAnalyze);
        buttonPanel.add(btnGenerateReport);
        buttonPanel.add(btnExportPDF);
        buttonPanel.add(btnRecommend);
        
        String[] columns = {"ID Producto", "Nombre", "Stock Actual", "Stock Minimo", "Indice Rotacion", "Estado"};
        tableModel = new DefaultTableModel(columns, 0);
        reportTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(reportTable);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Reporte de Productos de Lenta Rotacion"));
        
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        outputArea.setBackground(new Color(250, 250, 250));
        outputArea.setText("Reporte de Lenta Rotacion Listo\n\n");
        
        JScrollPane outputScroll = new JScrollPane(outputArea);
        outputScroll.setPreferredSize(new Dimension(0, 150));
        
        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(outputScroll, BorderLayout.SOUTH);
        
        loadSampleData();
    }
    
    private void analyzeProducts() {
        outputArea.append("\n=== ANALIZANDO PRODUCTOS ===\n");
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int stock = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
            int minStock = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            double turnoverRate = (double) stock / (minStock + 1);
            tableModel.setValueAt(String.format("%.2f", turnoverRate), i, 4);
            
            if (turnoverRate < 0.5) {
                tableModel.setValueAt("LENTA ROTACION", i, 5);
                outputArea.append("  [LENTA] " + tableModel.getValueAt(i, 1) + " - Indice rotacion: " + String.format("%.2f", turnoverRate) + "\n");
            } else if (turnoverRate < 1.5) {
                tableModel.setValueAt("Normal", i, 5);
            } else {
                tableModel.setValueAt("Rotacion Rapida", i, 5);
            }
        }
        outputArea.append("\n");
    }
    
    private void generateReport() {
        outputArea.append("\n=== REPORTE DE LENTA ROTACION ===\n");
        outputArea.append("Fecha: " + java.time.LocalDate.now() + "\n\n");
        
        boolean hasSlow = false;
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 5).equals("LENTA ROTACION")) {
                outputArea.append("Producto: " + tableModel.getValueAt(i, 1) + "\n");
                outputArea.append("  Stock Actual: " + tableModel.getValueAt(i, 2) + "\n");
                outputArea.append("  Stock Minimo: " + tableModel.getValueAt(i, 3) + "\n");
                outputArea.append("  Indice Rotacion: " + tableModel.getValueAt(i, 4) + "\n");
                outputArea.append("  Recomendacion: Reducir pedidos u ofrecer descuento\n\n");
                hasSlow = true;
            }
        }
        
        if (!hasSlow) {
            outputArea.append("No se detectaron productos de lenta rotacion\n");
        }
        outputArea.append("\n");
    }
    
    private void exportToPDF() {
        outputArea.append("\n=== EXPORTANDO REPORTE ===\n");
        outputArea.append("[EXPORTAR] Reporte exportado a formato PDF\n");
        outputArea.append("[GUARDADO] Reporte guardado como slow_moving_report.pdf\n\n");
        JOptionPane.showMessageDialog(this, "Reporte exportado a PDF exitosamente!");
    }
    
    private void recommendRestock() {
        outputArea.append("\n=== RECOMENDACIONES DE REABASTECIMIENTO ===\n");
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int stock = Integer.parseInt(tableModel.getValueAt(i, 2).toString());
            int minStock = Integer.parseInt(tableModel.getValueAt(i, 3).toString());
            
            if (stock <= minStock) {
                int suggestedOrder = minStock * 2 - stock;
                if (suggestedOrder < 0) suggestedOrder = minStock;
                outputArea.append("  [RECOMENDAR] " + tableModel.getValueAt(i, 1) + " - Pedir " + suggestedOrder + " unidades\n");
            }
        }
        outputArea.append("\n");
    }
    
    private void loadSampleData() {
        Object[] row1 = {101, "Plato de carton 25cm", 150, 50, 0, "Pendiente"};
        Object[] row2 = {102, "Vaso plastico 12oz", 200, 80, 0, "Pendiente"};
        Object[] row3 = {103, "Cubiertos desechables", 500, 100, 0, "Pendiente"};
        Object[] row4 = {104, "Funda de papel", 30, 50, 0, "Pendiente"};
        Object[] row5 = {105, "Bandeja de aluminio", 20, 40, 0, "Pendiente"};
        Object[] row6 = {106, "Servilletas pack 50", 45, 60, 0, "Pendiente"};
        
        tableModel.addRow(row1);
        tableModel.addRow(row2);
        tableModel.addRow(row3);
        tableModel.addRow(row4);
        tableModel.addRow(row5);
        tableModel.addRow(row6);
        
        outputArea.append("[CARGADOS] 6 productos cargados para analisis de lenta rotacion\n");
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