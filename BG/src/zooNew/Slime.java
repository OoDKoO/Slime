package zooNew;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Slime extends Item implements ActionListener{
	
	private FreeMove slimeFreeMove;
	
	public void createItem(JPanel background) {
		
		JButton slimeButton = new JButton("Slime");
		
		slimeButton.setSize(80, 80);
		slimeButton.setContentAreaFilled(false);
		slimeButton.setBorderPainted(false);
		
		icon.setIcon("src/Slime0.png", slimeButton);
		//slimeButton.setText("Slime");
		
		slimeFreeMove = new FreeMove(slimeButton);
		slimeButton.addActionListener(this);
		
		background.add(slimeButton);
		
		slimeFreeMove.start();

	}
	
	public void actionPerformed(ActionEvent e2) {
		String command = e2.getActionCommand();

		if (command.equals("Slime")) {
			try {
				synchronized (this) {
					if (slimeFreeMove.suspended == false) {
						slimeFreeMove.suspend();
					} else {
						slimeFreeMove.resume();

					}
				}
			} catch (Exception e3) {
				e3.printStackTrace();
			}
		}
	}
}
