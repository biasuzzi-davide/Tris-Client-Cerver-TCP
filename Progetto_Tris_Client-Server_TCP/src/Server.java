import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
	private static ArrayList<ServerIO> players = new ArrayList<ServerIO>();
	private static final int port = 20000;
	private static final int backLog = 2;

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource") // -> Perchè c'era un warning a causa della non chiusura del socket
			ServerSocket serverSocket = new ServerSocket(port, backLog);

			System.out.println("[Server]: Server Started!\n" + "[Server]: Listening ... [Port: "
					+ serverSocket.getLocalPort() + "]");
			Boolean flag = true;
			while (flag) {
				if (players.size() < 2) {
					if (players.size() == 1)
						flag = !flag;

					Socket newSocket = serverSocket.accept();
					System.out.println("[Server]: Connection accepted!");

					players.add(new ServerIO(newSocket, players));
					Thread t = new Thread(players.get(players.size() - 1));
					t.start();

					System.out.println(
							"[Server]: There are currently " + players.size() + " connection handler runnings");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("[Server]: Shutting down!");
	}
}