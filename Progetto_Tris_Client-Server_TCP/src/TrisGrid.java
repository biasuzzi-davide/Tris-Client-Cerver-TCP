import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.io.OutputStream;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.Cursor;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.JPanel;

class TrisGrid extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int width = 500;
	private static final int height = 500;
	private JPanel mainPanel;
	private JButton button_A_0;
	private JButton button_B_0;
	private JButton button_C_0;
	private JButton button_A_1;
	private JButton button_B_1;
	private JButton button_C_1;
	private JButton button_A_2;
	private JButton button_B_2;
	private JButton button_C_2;
	private ArrayList<JButton> buttons;
	private PrintWriter out;

	public TrisGrid(OutputStream outStr, String playerName) throws IOException {
		buttons = new ArrayList<JButton>();
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					break;
				}
			}
		} catch (UnsupportedLookAndFeelException e) {
			// handle exception
		} catch (ClassNotFoundException e) {
			// handle exception
		} catch (InstantiationException e) {
			// handle exception
		} catch (IllegalAccessException e) {
			// handle exception
		}
		out = new PrintWriter(outStr, true);

		setTitle(playerName);
		setSize(width, height);

		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3, 3, 5, 5));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		button_A_0 = setupButton(button_A_0, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("A_0");
			}
		}, mainPanel);

		button_B_0 = setupButton(button_B_0, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("B_0");
			}
		}, mainPanel);

		button_C_0 = setupButton(button_C_0, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("C_0");
			}
		}, mainPanel);

		button_A_1 = setupButton(button_A_1, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("A_1");
			}
		}, mainPanel);

		button_B_1 = setupButton(button_B_1, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("B_1");
			}
		}, mainPanel);

		button_C_1 = setupButton(button_C_1, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("C_1");
			}
		}, mainPanel);

		button_A_2 = setupButton(button_A_2, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("A_2");
			}
		}, mainPanel);

		button_B_2 = setupButton(button_B_2, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("B_2");
			}
		}, mainPanel);

		button_C_2 = setupButton(button_C_2, new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				out.println("C_2");
			}
		}, mainPanel);

		add(mainPanel, BorderLayout.CENTER);
	}

	public void printOnGrid(String line) {
		if (line.startsWith("A_0")) {
			button_A_0.setEnabled(false);
			button_A_0.setText(line.substring(5));
		} else if (line.startsWith("B_0")) {
			button_B_0.setEnabled(false);
			button_B_0.setText(line.substring(5));
		} else if (line.startsWith("C_0")) {
			button_C_0.setEnabled(false);
			button_C_0.setText(line.substring(5));
		} else if (line.startsWith("A_1")) {
			button_A_1.setEnabled(false);
			button_A_1.setText(line.substring(5));
		} else if (line.startsWith("B_1")) {
			button_B_1.setEnabled(false);
			button_B_1.setText(line.substring(5));
		} else if (line.startsWith("C_1")) {
			button_C_1.setEnabled(false);
			button_C_1.setText(line.substring(5));
		} else if (line.startsWith("A_2")) {
			button_A_2.setEnabled(false);
			button_A_2.setText(line.substring(5));
		} else if (line.startsWith("B_2")) {
			button_B_2.setEnabled(false);
			button_B_2.setText(line.substring(5));
		} else if (line.startsWith("C_2")) {
			button_C_2.setEnabled(false);
			button_C_2.setText(line.substring(5));
		}
	}

	public void disableButtons(JButton button_1, JButton button_2, JButton button_3) {
		for (JButton button : buttons) {
			if (button != button_1 && button != button_2 && button != button_3) {
				button.setText("");
			}
		}
	}

	public boolean victoryCheck() {
		// Giocatore "X" -> 1° "-"
		if (button_A_0.getText().contains("X") && button_B_0.getText().contains("X")
				&& button_C_0.getText().contains("X")) {
			disableButtons(button_A_0, button_B_0, button_C_0);
			JOptionPane.showMessageDialog(null, "\"X\" win!");
			return true;
		} else
		// Giocatore "O" -> 1° "-"
		if (button_A_0.getText().contains("O") && button_B_0.getText().contains("O")
				&& button_C_0.getText().contains("O")) {
			disableButtons(button_A_0, button_B_0, button_C_0);
			JOptionPane.showMessageDialog(null, "\"O\" win!");
			return true;
		} else
		// Giocatore "X" -> 2° "-"
		if (button_A_1.getText().contains("X") && button_B_1.getText().contains("X")
				&& button_C_1.getText().contains("X")) {
			disableButtons(button_A_1, button_B_1, button_C_1);
			JOptionPane.showMessageDialog(null, "\"X\" win!");
			return true;
		} else
		// Giocatore "O" -> 2° "-"
		if (button_A_1.getText().contains("O") && button_B_1.getText().contains("O")
				&& button_C_1.getText().contains("O")) {
			disableButtons(button_A_1, button_B_1, button_C_1);
			JOptionPane.showMessageDialog(null, "\"O\" win!");
			return true;
		} else
		// Giocatore "X" -> 3° "-"
		if (button_A_2.getText().contains("X") && button_B_2.getText().contains("X")
				&& button_C_2.getText().contains("X")) {
			disableButtons(button_A_2, button_B_2, button_C_2);
			JOptionPane.showMessageDialog(null, "\"X\" win!");
			return true;
		} else
		// Giocatore "O" -> 3° "-"
		if (button_A_2.getText().contains("O") && button_B_2.getText().contains("O")
				&& button_C_2.getText().contains("O")) {
			disableButtons(button_A_2, button_B_2, button_C_2);
			JOptionPane.showMessageDialog(null, "\"O\" win!");
			return true;
		} else
		// Giocatore "X" -> 1° "|"
		if (button_A_0.getText().contains("X") && button_A_1.getText().contains("X")
				&& button_A_2.getText().contains("X")) {
			disableButtons(button_A_0, button_A_1, button_A_2);
			JOptionPane.showMessageDialog(null, "\"X\" win!");
			return true;
		} else
		// Giocatore "O" -> 1° "|"
		if (button_A_0.getText().contains("O") && button_A_1.getText().contains("O")
				&& button_A_2.getText().contains("O")) {
			disableButtons(button_A_0, button_A_1, button_A_2);
			JOptionPane.showMessageDialog(null, "\"O\" win!");
			return true;
		} else
		// Giocatore "X" -> 2° "|"
		if (button_B_0.getText().contains("X") && button_B_1.getText().contains("X")
				&& button_B_2.getText().contains("X")) {
			disableButtons(button_B_0, button_B_1, button_B_2);
			JOptionPane.showMessageDialog(null, "\"X\" win!");
			return true;
		} else
		// Giocatore "O" -> 2° "|"
		if (button_B_0.getText().contains("O") && button_B_1.getText().contains("O")
				&& button_B_2.getText().contains("O")) {
			disableButtons(button_B_0, button_B_1, button_B_2);
			JOptionPane.showMessageDialog(null, "\"O\" win!");
			return true;
		} else
		// Giocatore "X" -> 3° "|"
		if (button_C_0.getText().contains("X") && button_C_1.getText().contains("X")
				&& button_C_2.getText().contains("X")) {
			disableButtons(button_C_0, button_C_1, button_C_2);
			System.out.println("\"X\"won!");
			return true;
		} else
		// Giocatore "O" -> 3° "|"
		if (button_C_0.getText().contains("O") && button_C_1.getText().contains("O")
				&& button_C_2.getText().contains("O")) {
			disableButtons(button_C_0, button_C_1, button_C_2);
			JOptionPane.showMessageDialog(null, "\"O\" win!");
			return true;
		} else
		// Giocatore "X" -> "\"
		if (button_A_0.getText().contains("X") && button_B_1.getText().contains("X")
				&& button_C_2.getText().contains("X")) {
			disableButtons(button_A_0, button_B_1, button_C_2);
			JOptionPane.showMessageDialog(null, "\"X\" win!");
			return true;
		} else
		// Giocatore "O" -> "\"
		if (button_A_0.getText().contains("O") && button_B_1.getText().contains("O")
				&& button_C_2.getText().contains("O")) {
			disableButtons(button_A_0, button_B_1, button_C_2);
			JOptionPane.showMessageDialog(null, "\"O\" win!");
			return true;
		} else
		// Giocatore "X" -> "/"
		if (button_C_0.getText().contains("X") && button_B_1.getText().contains("X")
				&& button_A_2.getText().contains("X")) {
			disableButtons(button_C_0, button_B_1, button_A_2);
			JOptionPane.showMessageDialog(null, "\"X\" win!");
			return true;
		} else
		// Giocatore "O" -> "/"
		if (button_C_0.getText().contains("O") && button_B_1.getText().contains("O")
				&& button_A_2.getText().contains("O")) {
			disableButtons(button_C_0, button_B_1, button_A_2);
			JOptionPane.showMessageDialog(null, "\"O\" win!");
			return true;
		} else {
			return false;
		}
	}

	private JButton setupButton(JButton btn, ActionListener actionListener, JPanel panel) {
		btn = new JButton();
		try {
			btn.setCursor(Cursor.getSystemCustomCursor("aero link"));
		} catch (HeadlessException | AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btn.setBackground(getForeground());
		btn.addActionListener(actionListener);
		btn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
		/*------------+ Oppure "arial" nel caso non ci sia +-------------*/
		btn.setFont(new Font("Franklin Gothic Heavy", Font.BOLD, 125));
		btn.setForeground(Color.BLACK);
		panel.add(btn);
		buttons.add(btn);
		return btn;
	}
}