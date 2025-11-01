import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * macOS Rendering Before Java 17
 * Uses legacy OpenGL-based rendering pipeline
 */
public class RenderingBefore extends JFrame {
    public static void main(String[] args) {
        System.out.println("=== macOS Rendering Before Java 17 ===\n");
        
        // Check rendering pipeline
        checkRenderingPipeline();
        
        SwingUtilities.invokeLater(() -> {
            new RenderingBefore().createAndShowGUI();
        });
    }
    
    private static void checkRenderingPipeline() {
        System.out.println("1. Rendering Pipeline Information:");
        
        // Check if running on macOS
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("  Operating System: " + os);
        
        // Check Java2D pipeline
        String pipeline = System.getProperty("sun.java2d.opengl");
        System.out.println("  OpenGL Pipeline: " + (pipeline != null ? pipeline : "default"));
        
        // Graphics environment info
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] devices = ge.getScreenDevices();
        System.out.println("  Graphics Devices: " + devices.length);
        
        for (int i = 0; i < devices.length; i++) {
            GraphicsDevice device = devices[i];
            System.out.println("    Device " + i + ": " + device.getIDstring());
        }
        System.out.println();
    }
    
    private void createAndShowGUI() {
        setTitle("Legacy Rendering Pipeline Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        add(new RenderingPanel());
        setLocationRelativeTo(null);
        setVisible(true);
        
        System.out.println("2. Legacy Features:");
        System.out.println("  - Uses OpenGL-based rendering");
        System.out.println("  - May have performance issues on newer macOS");
        System.out.println("  - Limited Metal API support");
    }
    
    class RenderingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            // Enable antialiasing
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            
            // Draw shapes to test rendering
            g2d.setColor(Color.BLUE);
            g2d.fillOval(50, 50, 100, 100);
            
            g2d.setColor(Color.RED);
            g2d.fillRect(200, 50, 100, 100);
            
            g2d.setColor(Color.GREEN);
            g2d.drawString("Legacy OpenGL Rendering", 50, 200);
            
            // Gradient
            GradientPaint gradient = new GradientPaint(50, 220, Color.YELLOW, 300, 220, Color.ORANGE);
            g2d.setPaint(gradient);
            g2d.fillRect(50, 220, 250, 30);
        }
    }
}