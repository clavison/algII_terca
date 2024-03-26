package vetores.correcoes;

import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {
		String menu = "1 - Cadastrar carro\n" + 
				"2 - Carro mais novo\n" + 
				"3 - Buscar por placa\n\n" + 
				"4 - sair";
		int op = 0;
		String[] marcas = new String[3];
		String[] placas = new String[3];
		int[] anos = new int[3];
		int count = 0;
		do {
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));

			if (op == 1) {
				if (count < marcas.length) {
					marcas[count] = JOptionPane.showInputDialog("Marca");
					placas[count] = JOptionPane.showInputDialog("Placa");
					anos[count] = Integer.parseInt(JOptionPane.showInputDialog("Ano"));
					count++;
				}else {
					JOptionPane.showMessageDialog(null, "Memória cheia");
				}
			}
			
			if( op == 2) {
				int posNovo = 0;
				int anoNovo = anos[0];
				for(int i=0; i<count; i++) {
					if(anos[i] < anoNovo) {
						posNovo = i;
						anoNovo = anos[i];
					}
				}
				JOptionPane.showMessageDialog(null, placas[posNovo]+"-"+marcas[posNovo]);
			}
			
			if(op == 3) {
				String placaBusca = JOptionPane.showInputDialog("Qual placa?");
				String res = "Placa não encontrada";
				for(int i=0; i<count; i++) {
					if(placas[i].equalsIgnoreCase(placaBusca)) {
						res = marcas[i] + "-" + anos[i];
					}
				}
				JOptionPane.showMessageDialog(null, res);
			}
		} while (op != 4);
	}

}
