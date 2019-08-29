package zooNew;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Icon {
	
	public void setIcon(String file, JButton iconButton) {
		ImageIcon icon = new ImageIcon(file);
		icon.getImage();
		Image temp = icon.getImage().getScaledInstance(iconButton.getWidth(), iconButton.getHeight(),
				Image.SCALE_AREA_AVERAGING);
		icon = new ImageIcon(temp);
		iconButton.setIcon(icon);
	}

}
