package zooNew;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

	private static BGM bgm = new BGM("src/BackGroundMusic.wav");

	private static JLabel label = new JLabel("EXP¡G0");
	private static JLabel title = new JLabel("Mutanat Slime");
	private static JButton startButton = new JButton("Start");
	private static JPanel background = new JPanel() {
		
		public void paintComponent(Graphics g) {
			ImageIcon icon = new ImageIcon("src/background.jpg");
			g.drawImage(icon.getImage(), 0, 0, this.getSize().width, this.getSize().height, this);
		}
	};

	private static Setting gaming = new Setting();

	public static void main(String[] args) {

		Project zoo = new Project();
		zoo.setVisible(true);
		zoo.setResizable(false);
	}

	public Project() {

		setSize(360, 560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);

		background.setLayout(null);
		background.setSize(360, 560);
		background.setLocation(0, 0);

		startButton.setSize(180, 50);
		startButton.setLocation(90, 240);
		startButton.addActionListener(this);
		startButton.setVisible(true);

		title.setSize(240,50);
		title.setLocation(70,150);
		title.setFont(new Font(null,Font.BOLD, 32));
		
		label.setSize(250, 50);
		label.setLocation(10, 10);
		label.setFont(new Font(null,Font.BOLD, 24));

		background.add(startButton);
		background.add(label);
		background.add(title);

		add(background);
	}

	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();
		if (command.equals("Start")) {
			gaming.start();
			bgm.start();
			startButton.setVisible(false);
			title.setVisible(false);
			
			Item slime = new Slime();
			slime.createItem(background);
			
			Item food = new Food();
			food.createItem(background);
		}
	}
}

