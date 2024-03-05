package revisao_algoritmo_1;

import javax.swing.JOptionPane;

public class Exemplo2 {
	
	public static void main(String[] args) {
		double poupanca = Double.parseDouble(JOptionPane.showInputDialog("Valor investido"));
		double juros = Double.parseDouble(JOptionPane.showInputDialog("Valor Juros"));
		double total = poupanca + (poupanca * juros/100);
		JOptionPane.showMessageDialog(null, total);
	}

}
