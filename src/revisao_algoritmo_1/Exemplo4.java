package revisao_algoritmo_1;

import javax.swing.JOptionPane;

public class Exemplo4 {

	public static void main(String[] args) {
		String chuva = JOptionPane.showInputDialog("Chovendo?");
		String filme = JOptionPane.showInputDialog("Passando filme bom?");

		if ((chuva.equals("s") || chuva.equals("n")) && (filme.equals("s") || filme.equals("n"))) {
			if (chuva.equals("s") && filme.equals("s")) {
				JOptionPane.showMessageDialog(null, "Assistir filme");
			} else {
				if (chuva.equals("n")) {
					JOptionPane.showMessageDialog(null, "Jogar futebol");
				} else {
					JOptionPane.showMessageDialog(null, "Correr");
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Iválido");
		}
	}

}
