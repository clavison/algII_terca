package vetores;

import javax.swing.JOptionPane;

public class Exemplo1 {
	
	public static void main(String[] args) {
		
		String[] nomes = new String[10];
		int[] idades = new int[10];
		
		for(int i=0; i<10; i++) {
			nomes[i] = JOptionPane.showInputDialog("Informe o nome "+(i+1)+"/10");
			idades[i] = Integer.parseInt(JOptionPane.showInputDialog("Idade de "+nomes[i]));
		}
		
		String nomeMaisVelho = nomes[0];
		int idadeMaisVelho = idades[0];
		
		for(int i=0; i<10; i++) {
			if(idades[i] > idadeMaisVelho) {
				nomeMaisVelho = nomes[i];
				idadeMaisVelho = idades[i];
			}
		}
		
		System.out.println("A pwessoa mais velha é "+nomeMaisVelho);
		
		
		
	}

}
