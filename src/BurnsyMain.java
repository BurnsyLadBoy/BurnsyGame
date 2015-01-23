import javax.swing.*;
import java.awt.*;
 
public class BurnsyMain extends JFrame {
	private Image titleImage;
    private int x, y, state;
	private GameCanvas burnsyCanvas;
	
	public void startGame() {
		setState(1);
		try {
			new Thread(new Runnable() {
				public void run() {
					animate();
				}
			}).start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void setState(int s) {
		state = s;
	}
	
	public int getState() {
		return state;
	}

    public BurnsyMain() {
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleImage = new ImageIcon("titlescreen.png").getImage();
        setResizable(false);

        x = 0;
		y = 100;
		
		state = 0;
		
		burnsyCanvas = new GameCanvas();
		burnsyCanvas.addMouseListener(new MouseClickDetector(this));
		getContentPane().add(burnsyCanvas);
    }

	public static void main(String[] args) {
		BurnsyMain f = new BurnsyMain();
		f.setVisible(true);
	}

	   public void animate() {
		while (true) {
			SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					burnsyCanvas.repaint();
				}
			});
			try {
				Thread.sleep(30);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	private class GameCanvas extends Canvas {
		private Image dbImage;
		private Graphics dbg; 

		public void update(Graphics g) {
			if (dbImage == null) {
				dbImage = createImage(this.getSize().width, this.getSize().height);
				dbg = dbImage.getGraphics();
			}

			dbg.setColor(getBackground());
			dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

			dbg.setColor(getForeground());
			paint(dbg);

			g.drawImage(dbImage, 0, 0, this); 
		}

		public void paint (Graphics g) {
			switch (state) {
				case 0:
					g.drawImage(titleImage, 0, 0, this);
				break;
				case 1:
					g.setColor(Color.WHITE);
					g.fillRect(0, 0, 640, 480);
				break;
			}
		}
	}
}