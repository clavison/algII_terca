package lista1;

import javax.swing.JOptionPane;

public class Exercicio3 {

	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("Qt Números"));
		String pares = "";
		String impares = "";
		int somaPares = 0;
		double somaImPares = 0;
		double qtImpares = 0;
		for (int i = 0; i < n; i++) {
			int nr = Integer.parseInt(JOptionPane.showInputDialog("Nº " + (i + 1)));
			if (nr % 2 == 0) {
				pares += nr + " ";
				somaPares += nr;
			} else {
				impares += nr + " ";
				somaImPares += nr;
				qtImpares ++;
			}
		}

		String resultado = "Números pares: " + pares + "\n" 
		+ "Soma dos pares: " + somaPares + "\n" 
		+ "Números ímpares: " + impares + "\n"
		+ "Média dos ímpares: " + (somaImPares/qtImpares);
		
		JOptionPane.showMessageDialog(null, resultado);
	}

}
