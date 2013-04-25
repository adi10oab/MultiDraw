package mainclient;
import gui.PaintPanel;
import gui.MultiDrawFrame;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.UIManager;

import network.ClientReceiver;
import network.ClientSender;
import network.SendBuffer;

class MultiDrawClient {
	public static void main(String[] args) {
		try {
			// Fix look and feel of GUI.
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Socket s = null;
		try {
			s = new Socket("localhost", 30001);
		} catch (UnknownHostException e) {
			System.out.println("Did not find a host at the specified address.");
		} catch (IOException e) {
			System.out.println("Connection error.");
		}
		
		SendBuffer buffer = new SendBuffer(10);
		PaintPanel paintpanel = new PaintPanel(buffer);
		ClientReceiver receiver = new ClientReceiver(s, paintpanel);
		ClientSender sender = new ClientSender(s, buffer);	
		new MultiDrawFrame(paintpanel);

		receiver.start();
		sender.start();
	}
}