package zooNew;

import java.awt.*;
import javax.swing.*;

public class EatMove implements Runnable {

	public Thread t;
	boolean suspended = false;

	private JButton slimeButton = new JButton();
	private FreeMove slimeFreeMove = new FreeMove(slimeButton);
	private JButton foodButton = new JButton();
	private FreeMove foodFreeMove = new FreeMove(foodButton);
	private int exp;
	private BGM eatSound = new BGM("src/eatingSoundEffect.wav");

	public EatMove(JButton slimeButton, FreeMove slimeFreeMove, JButton foodButton, FreeMove foodFreeMove, int exp) {

		this.slimeFreeMove = slimeFreeMove;
		this.slimeButton = slimeButton;
		this.foodFreeMove = foodFreeMove;
		this.foodButton = foodButton;
		this.exp = exp;
	}

	public void run() {
		Point pc = slimeButton.getLocation();
		Point pf = foodButton.getLocation();
		int xdir = (pf.x - pc.x) / 10;
		int ydir = (pf.y - pc.y) / 10;

		if (exp < 5)
			setIcon("src/Slime" + exp + "Eat.png", slimeButton);
		else
			setIcon("src/Slime4Eat.png", slimeButton);

		for (int i = 0; i < 10; i++) {
			pc.x += xdir;
			pc.y += ydir;
			slimeButton.setLocation(pc.x, pc.y);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e2) {
				e2.printStackTrace();
			}
		}

		if (exp < 5)
			setIcon("src/Slime" + exp + ".png", slimeButton);
		else
			setIcon("src/Slime4.png", slimeButton);

		eatSound.start();
		slimeFreeMove.resume();
	}

	public void start() {
		if (t == null) {
			t = new Thread(this);
			t.start();
		}
	}

	public static void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		icon.getImage();
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(), iconButton.getHeight(),
				Image.SCALE_AREA_AVERAGING);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}
}
