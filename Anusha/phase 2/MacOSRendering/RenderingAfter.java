import javax.swing.*;
import java.awt.*;

/**
 * macOS Rendering After Java 17
 * Uses new Metal-based rendering pipeline
 */
public class RenderingAfter extends JFrame {
    public static void main(String[] args) {
        System.out.println("=== macOS Rendering After Java 17 ===\n");
        
        // Enable Metal rendering pipeline (Java 17+)
        System.setProperty("sun.java2d.metal", "true");
        
        checkRenderingPipeline();
        
        SwingUtilities.invokeLater(() -> {
            new RenderingAfter().createAndShowGUI();
        });
    }
    
    private static void checkRenderingPipeline() {
        System.out.println("1. Enhanced Rendering Pipeline Information:");
        
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("  Operating System: " + os);
        
        // Check Metal pipeline
        String metalPipeline = System.getProperty("sun.java2d.metal");
        System.out.println("  Metal Pipeline Enabled: " + metalPipeline);
        
        // Check OpenGL fallback
        String openglPipeline = System.getProperty("sun.java2d.opengl");
        System.out.println("  OpenGL Fallback: " + (openglPipeline != null ? openglPipeline : "available"));
        
        // Graphics capabilities
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultDevice = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = defaultDevice.getDefaultConfiguration();
        
        System.out.println("  Color Model: " + gc.getColorModel().getClass().getSimpleName());
        System.out.println("  Pixel Size: " + gc.getColorModel().getPixelSize() + " bits");
        System.out.println();
    }
    
    private void createAndShowGUI() {
        setTitle("Enhanced Metal Rendering Pipeline Demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        
        add(new EnhancedRenderingPanel());
        setLocationRelativeTo(null);
        setVisible(true);
        
        System.out.println("2. Enhanced Features (Java 17+):");
        System.out.println("  - Metal API integration for better performance");
        System.out.println("  - Improved GPU acceleration");
        System.out.println("  - Better memory management");
        System.out.println("  - Enhanced text rendering");
        System.out.println("  - Reduced CPU usage for graphics operations");
    }
    
    class EnhancedRenderingPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            // Enhanced rendering hints
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            
            // Draw enhanced shapes
            g2d.setColor(new Color(0, 123, 255, 200));
            g2d.fillOval(50, 50, 100, 100);
            
            g2d.setColor(new Color(255, 59, 48, 200));
            g2d.fillRect(200, 50, 100, 100);
            
            // Enhanced text rendering
            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("SF Pro Display", Font.BOLD, 14));
            g2d.drawString("Enhanced Metal Rendering", 50, 200);
            
            // Complex gradient with better performance
            RadialGradientPaint radialGradient = new RadialGradientPaint(
                175, 235, 100,
                new float[]{0.0f, 0.5f, 1.0f},
                new Color[]{Color.CYAN, Color.MAGENTA, Color.YELLOW}
            );
            g2d.setPaint(radialGradient);
            g2d.fillRect(50, 220, 250, 30);
        }
    }
}