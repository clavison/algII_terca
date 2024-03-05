package revisao_algoritmo_1;

import javax.swing.JOptionPane;

public class Exemplo1 {
	
	public static void main(String[] args) {
		//System.out.println("Olá mundo");
		//JOptionPane.showMessageDialog(null, "Olá Mundo");
		
		String nome = JOptionPane.showInputDialog("Informe seu nome");
		int idade = Integer.parseInt(
				JOptionPane.showInputDialog("Informe sua idade"));
		JOptionPane.showMessageDialog(
				null, "Seu nome: "+nome+"\nSua idade:"+idade);
	}

}
