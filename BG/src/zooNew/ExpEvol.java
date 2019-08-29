package zooNew;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExpEvol {
	static int exp = 0;
	BGM levelUp=new BGM("src/levelUpSoundEffect.wav");
	JButton slime = new JButton();

	public void expAdd() {
		exp += 1;
	}

	public int getExp() {
		return exp;
	}

	// public boolean evolve = false;

	public void evol(JButton slime) {
		this.slime = slime;
		if (exp % 10 == 0) {
			if (exp < 50) {
				levelUp.start();
				setIcon("src/Slime" + exp / 10 + ".png", slime);
				slime.setSize(80 + exp / 10 * 20, 80 + exp / 10 * 20);
			} else if (exp >= 50)
				setIcon("src/Slime4.png", slime);
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