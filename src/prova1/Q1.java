package prova1;

import javax.swing.JOptionPane;

public class Q1 {
	
	public static void main(String[] args) {
		String meses[] = new String[] {
				"Janeiro",
				"Fevereiro",
				"Março",
				"Abril",
				"Maio",
				"Junho",
				"Julho",
				"Agosto",
				"Setembro",
				"Outubro",
				"Novembro",
				"Dezembro",
				};
		int[] vitimas = new int[12];
		
		for(int i=0; i<12; i++) {
			vitimas[i] = Integer.parseInt(JOptionPane
					.showInputDialog("Vítimas fatais no mês de "+meses[i]));
		}
		
		int qtMaisVitimas = vitimas[0];
		String mesMaisVitimas = "";
		int qtMenosVitimas = vitimas[0];
		String mesMenosVitimas = "";
		int totalVitimas = 0;
		
		for(int i=0; i<12; i++) {
			totalVitimas += vitimas[i];
			if(vitimas[i] > qtMaisVitimas) {
				qtMaisVitimas= vitimas[i];
				mesMaisVitimas = meses[i];
			}
			if(vitimas[i] < qtMenosVitimas) {
				qtMenosVitimas = vitimas[i];
				mesMenosVitimas = meses[i];
			}
		}
		
		String msg = "mês teve mais acidentes: "+mesMaisVitimas+"\n"
				+ "mês teve menos acidentes:" + mesMenosVitimas+"\n"
				+ "Total acidentes:" + totalVitimas+"\n"
				+ "Percentual de acidentes no mês de fevereiro :" + ((double)vitimas[1]/totalVitimas)*100+"\n";
		JOptionPane.showMessageDialog(null, msg);
	}

}
