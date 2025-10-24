package multiResImgAPI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MultiResImageExample extends JPanel {
	
	private MultiResolutionImage multiImage;

    public MultiResImageExample() {
        // Load multiple resolution images
        Image lowRes  = new ImageIcon("C:/Users/naga prasad/Pictures/murthy.jpeg").getImage();
        Image highRes = new ImageIcon("C:/Users/naga prasad/Pictures/murthy6.jpeg").getImage();

        // Create a BaseMultiResolutionImage
        multiImage = new BaseMultiResolutionImage(lowRes, highRes);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw at different sizes, Java will choose the right resolution automatically
        Image image1 = multiImage.getResolutionVariant(100, 100);
        g.drawImage(image1, 10, 10, 100, 100, this);

        Image image2 = multiImage.getResolutionVariant(200, 200);
        g.drawImage(image2, 150, 10, 200, 200, this);
    }

	

	public static void main(String[] args) {
        JFrame frame = new JFrame("Java 9 Multi-Resolution Image Example");
        frame.add(new MultiResImageExample());
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


	}

}
