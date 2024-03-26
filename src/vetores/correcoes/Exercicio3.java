package vetores.correcoes;

import javax.swing.JOptionPane;

public class Exercicio3 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("QTD"));
		
		String[] nomes = new String[n];
		double[] salarios = new double[n];
		double[] salariosNovos = new double[n];
		
		for(int i=0; i<n; i++) {
			nomes[i] = JOptionPane.showInputDialog("Nome");
			salarios[i]= Double.parseDouble(JOptionPane.showInputDialog("Salário"));
		}
		
		for(int i=0; i<n; i++) {
			if(salarios[i] <= 400) {
				salariosNovos[i] = salarios[i] * 1.25;
			}else {
				if(salarios[i] <= 600) {
					salariosNovos[i] = salarios[i] * 1.20;
				}else {
					if(salarios[i] <= 800) {
						salariosNovos[i] = salarios[i] * 1.15;
					}else {
						salariosNovos[i] = salarios[i] * 1.10;
					}
				}
			}
		}
		//FALTA EXIBIR NOME E SALÁRIO
		
		
	}

}
