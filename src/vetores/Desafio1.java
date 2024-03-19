package vetores;

import javax.swing.JOptionPane;

public class Desafio1 {
	
	public static void main(String[] args) {
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Qtdade"));
		String[] nomes = new String[n];
		int[] alturas = new int[n];
		String[] sexos = new String[n];
		
		String menu = "1 - Cadastrar\n"
				+ "2 - Nome do aluno mais alto(a)\n"
				+ "3 - Mulheres mais altas que a média\n"
				+ "4 - Alunos(as) mais baixos(as) que a média\n\n"
				+ "5 - Sair";
		int op = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			if(op == 1) {
				for(int i=0; i< nomes.length; i++) {
					nomes[i] = JOptionPane.showInputDialog("Nome "+(i+1)+" de "+n);
					alturas[i] = Integer.parseInt(JOptionPane.showInputDialog("Altura de "+nomes[i]));
					sexos[i] = JOptionPane.showInputDialog("Sexo(M/F) de "+nomes[i]);
				}
			}
			
			if(op == 2) {
				String nomeMaisAlto = nomes[0];
				int alturaMaisAlto = alturas[0];
				for(int i=0; i< n; i++) {
					if(alturas[i] > alturaMaisAlto) {
						nomeMaisAlto = nomes[i];
						alturaMaisAlto = alturas[i];
					}
				}
				JOptionPane.showMessageDialog(null, nomeMaisAlto);
			}
			
			if(op == 3) {
				double mediaAlturaMulheres = 0;
				int somaAlturaMulheres = 0;
				int contMulheres = 0;
				for(int i=0; i< n; i++) {
					if(sexos[i].equalsIgnoreCase("F")) {
						somaAlturaMulheres += alturas[i];
						contMulheres++;
					}
				}
				mediaAlturaMulheres = somaAlturaMulheres/contMulheres;
				
				String ret = "Mulheres com altura acima da média\n";
				for(int i=0; i< n; i++) {
					if(sexos[i].equalsIgnoreCase("F") && alturas[i] > mediaAlturaMulheres) {
						ret += nomes[i] + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, ret);
			}
			
			if(op == 4) {
				double mediaAlturas = 0;
				int somaAlturas = 0;
				for(int i=0; i< n; i++) {
					somaAlturas += alturas[i];
				}
				mediaAlturas = somaAlturas/n;
				
				String ret = "Alunos com altura abaixo da média\n";
				for(int i=0; i< n; i++) {
					if(alturas[i] < mediaAlturas) {
						ret += nomes[i] + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, ret);
			}
			
			
			
		}while(op != 5);
		
	}

}
