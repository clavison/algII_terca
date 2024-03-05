package revisao_algoritmo_1;

import javax.swing.JOptionPane;

public class Exemplo3 {

	public static void main(String[] args) {
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Digite a idade"));

		if (idade >= 60) {
			JOptionPane.showMessageDialog(null, "Idoso(a)");
		} else {
			if(idade >= 18) {
				JOptionPane.showMessageDialog(null, "Adulto");
			}else {
				if(idade > 12) {
					JOptionPane.showMessageDialog(null, "Jovem");
				}else {
					JOptionPane.showMessageDialog(null, "Criança");
				}
			}
		}
	}
}
