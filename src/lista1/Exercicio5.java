package lista1;

import javax.swing.JOptionPane;

public class Exercicio5 {
	
	public static void main(String[] args) {
		
		String menu = "1 - Cadastrar\n"
				+ "2 - Exibir estatísticas\n\n"
				+ "3 - Sair";
		int op = 0;
		int qtAzul = 0;
		int qt2021Preto = 0;
		int qt2010e2020 = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			if(op == 1) {
				String cor = JOptionPane.showInputDialog("Cor");
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano"));
				
				if(cor.equalsIgnoreCase("azul")) {
					qtAzul++;
				}
				
				if(cor.equalsIgnoreCase("preto") && ano == 2021) {
					qt2021Preto++;
				}
				
				if(ano >=2010 && ano<=2020) {
					qt2010e2020 ++;
				}
			}
			
			if(op == 2) {
				String retorno = "Qtdade de carros da cor azul: "+qtAzul+"\n"
						+"Qtdade de carros pretos fab em 2021: "+qt2021Preto+"\n"
						+"Qtdade de carros fab entre 2010 e 2020: "+qt2010e2020;
				JOptionPane.showMessageDialog(null, retorno);
			}
			
		}while( op != 3);
		
	}

}
