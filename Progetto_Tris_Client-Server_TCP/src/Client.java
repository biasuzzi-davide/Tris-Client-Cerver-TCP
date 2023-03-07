import java.net.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	private static Socket socket;
	private static final int port = 20000;
	private static final String localAddress = "127.0.0.1";

	public static void main(String[] args) {
		try {
			int opt = JOptionPane.showConfirmDialog(null, "Do you want to use local ip address?");
			socket = new Socket(opt == 0 ? InetAddress.getByName(localAddress)
					: InetAddress.getByName(JOptionPane.showInputDialog("Insert the ip address: ")), port);
			Thread t = new Thread(new ClientIO(socket));
			t.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}