import javax.swing.*;
import java.awt.*;
 
public class BurnsyMain extends JFrame {
    private Image titleImage;
    private int x, y;

    public void paint(Graphics g) {
        g.drawImage(titleImage,0,0,this);
	}

    public BurnsyMain() {
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleImage = new ImageIcon("titlescreen.png").getImage();
        setResizable(false);

        x = 0;
		y = 100;

        JButton start = new JButton("Start!");
        getContentPane().add(start);
        start.setSize(100,50);
        start.setVisible(true);
    }
     
	public static void main(String[] args) {
		BurnsyMain f = new BurnsyMain();
		f.setVisible(true);
		f.animate();
	}



	   public void animate() {
		while (true) {
			repaint();
			try {
				Thread.sleep(100);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}