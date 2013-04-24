package networktest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiDrawServer {
	private static ArrayList<ClientConnection> connections;

	public static void main(String[] args) {
		connections = new ArrayList<ClientConnection>();
		try {
			System.out.println("Server commenciated!");
			ServerSocket server = new ServerSocket(30001);
			
			Socket s;
			while ((s = server.accept()) != null) {
				System.out.println("Connected : " + s.getInetAddress());
				ClientConnection cc = new ClientConnection(s.getInetAddress().getHostName(), s, connections);
				cc.start();
				connections.add(cc);
			}
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
