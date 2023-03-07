
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;

public class ClientIO implements Runnable {
	private Socket sock;
	private PrintWriter out;
	private Scanner sc;
	private InputStream inStr;
	private OutputStream outStr;

	public ClientIO(Socket s) {
		sock = s;
	}

	public void run() {
		try {
			try {
				inStr = sock.getInputStream();
				outStr = sock.getOutputStream();

				sc = new Scanner(inStr);
				out = new PrintWriter(outStr, true);

				boolean exit = false;

				String line = JOptionPane.showInputDialog("Welcome, please enter your name here: ");
				out.println(line);

				TrisGrid grid = new TrisGrid(outStr, line);
				grid.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				grid.setVisible(true);

				while (!exit && sc.hasNextLine()) {
					line = sc.nextLine();
					System.out.println("[Client]: " + line);
					grid.printOnGrid(line);

					if (line.equals("Check")) {
						boolean win = grid.victoryCheck();

						if (win == true) {
							out.println("Win");
							exit = true;
							grid.dispose();
						}
					} else if (line.equals("End")) {
						exit = true;
						JOptionPane.showMessageDialog(grid, "Nobody Wins!");
						grid.dispose();
					}
				}
			} finally {
				sock.close();
				sc.close();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}