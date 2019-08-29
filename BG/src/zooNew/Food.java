package zooNew;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Food extends Item implements ActionListener{

	private JButton slimeButton;
	private JButton foodButton;
	private FreeMove slimeFreeMove;
	private FreeMove foodFreeMove;
	private JLabel label = new JLabel();

	private EatMove eatFood;
	private ExpEvol expCal = new ExpEvol();

	public void createItem(JPanel background) {
		
		new Thread(new Runnable() {
			
			public void run() {
				for (int i = 0; i < 8; i++) {
					try {
						JButton foodButton = new JButton("Food");

						foodButton.setSize(90, 90);
						foodButton.setContentAreaFilled(false);
						foodButton.setBorderPainted(false);
						
						foodFreeMove = new FreeMove(foodButton);
						ActionListener Food = null;
						foodButton.addActionListener(Food);
						
						icon.setIcon("src/food.png", foodButton);
						background.add(foodButton);	
						
						foodFreeMove.start();

						Thread.sleep((int) (Math.random() + 2) * 1000);
						
					} catch (Exception e1) {
						e1.getStackTrace();
					}
				}
			}
		}).start();
	}
	
	public void actionPerformed(ActionEvent e2) {
		String command = e2.getActionCommand();
		if (command.equals("Food")) {
			expCal.expAdd();
			label.setText("Exp¡G" + expCal.getExp());
			
			eatFood = new EatMove(slimeButton, slimeFreeMove, foodButton, foodFreeMove, (int) (expCal.getExp() / 10));
			foodFreeMove.suspend();
			slimeFreeMove.suspend();
			eatFood.start();
			expCal.evol(slimeButton);
			recreate();
		}
	}

	public void recreate() {
		new Thread(new Runnable() {
			public void run() {
				try {
					foodButton.setVisible(false);
					Thread.sleep((int) (Math.random() + 1) * 5000);
					foodButton.setVisible(true);
					foodFreeMove.resume();
				} catch (Exception e2) {
					e2.getStackTrace();
				}
			}
		}).start();
	}
}
