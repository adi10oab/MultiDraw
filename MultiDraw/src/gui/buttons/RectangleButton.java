package gui.buttons;

import gui.PaintPanel;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class RectangleButton extends JButton implements ActionListener {
	private PaintPanel paintpanel;

	public RectangleButton(PaintPanel paintpanel) {
		super("");
		this.paintpanel = paintpanel;

		addActionListener(this);
		try {
			Image img = ImageIO.read(getClass().getResource("/res/icons/rectangle.png"));
			this.setIcon(new ImageIcon(img));
		} catch (Exception ex) {
			System.out.println("Exception in RectangleButton.java: "+ex.getMessage());
		}
		
		//set size for button
		setPreferredSize(new Dimension(30, 30));
	}

	public void actionPerformed(ActionEvent e) {
		
		//make the button to appear pressed
		this.getModel().setPressed(true);
	}
}
