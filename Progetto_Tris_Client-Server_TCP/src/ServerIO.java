import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerIO implements Runnable {
	private static int howManyMoves = 0;
	private static int player = 0;
	private Socket sock;
	private ArrayList<ServerIO> players;
	private PrintWriter out;
	private String name;
	private Scanner sc;
	private InputStream inStr;
	private OutputStream outStr;

	public ServerIO(Socket incoming, ArrayList<ServerIO> players) {
		this.sock = incoming;
		this.players = players;
	}

	public void run() {
		try {
			try {
				inStr = sock.getInputStream();
				outStr = sock.getOutputStream();

				sc = new Scanner(inStr);
				out = new PrintWriter(outStr, true);

				boolean done = false;

				if (sc.hasNextLine())
					name = sc.nextLine();

				System.out.println("[Server]: Name received: \"" + name + "\"");

				while (!done && sc.hasNextLine()) {
					String line;

					line = sc.nextLine();

					if (line.equals("A_0")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("A_0->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("A_0->O");
							}
						}
					}

					else if (line.equals("B_0")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("B_0->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("B_0->O");
							}
						}
					}

					else if (line.equals("C_0")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("C_0->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("C_0->O");
							}
						}
					}

					else if (line.equals("A_1")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("A_1->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("A_1->O");
							}
						}
					}

					else if (line.equals("B_1")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("B_1->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("B_1->O");
							}
						}
					}

					else if (line.equals("C_1")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("C_1->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("C_1->O");
							}
						}
					}

					else if (line.equals("A_2")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("A_2->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("A_2->O");
							}
						}
					}

					else if (line.equals("B_2")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("B_2->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("B_2->O");
							}
						}
					}

					else if (line.equals("C_2")) {
						if (player % 2 == 0) {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("C_2->X");
							}
						} else {
							for (int i = 0; i < players.size(); i++) {
								players.get(i).out.println("C_2->O");
							}
						}
					}

					else if (line.equals("Win")) {
						done = true;
						players.removeAll(players);
						System.out.println("[Server]: Win");
					}

					if (howManyMoves >= 4) {
						for (int i = 0; i < players.size(); i++) {
							players.get(i).out.println("Check");
						}
					}

					if (howManyMoves >= 8) {
						for (int i = 0; i < players.size(); i++) {
							players.get(i).out.println("End");
							System.out.println("[Server]: 9 moves & nobody wins!");
						}

						done = true;
						players.removeAll(players);
					}

					player++;
					howManyMoves++;
				}
			} finally {
				sock.close();
				sc.close();
				out.close();
				player = howManyMoves = 0;
				System.out.println("[Server]: Client disconnected! ");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}