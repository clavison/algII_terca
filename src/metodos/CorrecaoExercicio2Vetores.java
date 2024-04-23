package metodos;

import javax.swing.JOptionPane;

public class CorrecaoExercicio2Vetores {

	public static void main(String[] args) {
		String[] marcas = new String[100];
		String[] placas = new String[100];
		int[] anos = new int[100];
		int count = 0;
		
		int op = 0;
		do {
			op = menu();
			if(op == 1) cadastraCarro(marcas, placas, anos, count);
			if(op == 2) System.out.println(marcas[buscaPosicaoCarroMaisNovo(anos, count)]);
			if(op == 3) buscaCarro(marcas, placas, anos, count);
		}while(op!=4);
	}

	private static int menu() {
		String m = "1 - Cadastrar carro\n" + "2 - Carro mais novo\n" + "3 - Buscar por placa\n\n" + "4 - sair";
		return Integer.parseInt(JOptionPane.showInputDialog(m));
	}

	private static void cadastraCarro(String[] marcas, String[] placas, int[] anos, int count) {
		if (count < marcas.length) {
			marcas[count] = JOptionPane.showInputDialog("Marca");
			placas[count] = JOptionPane.showInputDialog("Placa");
			anos[count] = Integer.parseInt(JOptionPane.showInputDialog("Ano"));
			count++;
		} else {
			JOptionPane.showMessageDialog(null, "Memória cheia");
		}
	}
	
	private static int buscaPosicaoCarroMaisNovo(int[] anos, int count) {
		int posNovo = 0;
		int anoNovo = anos[0];
		for(int i=0; i<count; i++) {
			if(anos[i] < anoNovo) {
				posNovo = i;
				anoNovo = anos[i];
			}
		}
		return posNovo;
	}
	
	private static void buscaCarro(String[] marcas, String[] placas, int[] anos, int count) {
		String placaBusca = JOptionPane.showInputDialog("Qual placa?");
		String res = "Placa não encontrada";
		for(int i=0; i<count; i++) {
			if(placas[i].equalsIgnoreCase(placaBusca)) {
				res = marcas[i] + "-" + anos[i];
			}
		}
		JOptionPane.showMessageDialog(null, res);
	}

}
