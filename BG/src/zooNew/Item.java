package zooNew;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class Item implements ActionListener {

	Icon icon = new Icon();
	
	public abstract void createItem(JPanel background);

}
