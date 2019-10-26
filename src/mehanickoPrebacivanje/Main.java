package mehanickoPrebacivanje;

import gui.MainFrame;

public class Main {
	public static void main(String[] args) {
		MainFrame glavniProzor = MainFrame.getInstance();
		glavniProzor.setLocationRelativeTo(null);
		glavniProzor.setVisible(true);
	}
}
