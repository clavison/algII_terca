package metodos;

import javax.swing.JOptionPane;

/*
 Faça um programa que apresente o seguinte menu:
1 - Cadastrar pessoa (nome, idade e sexo)
2 - Buscar por nome
3 - Média das idades dos homens
4 - Média das idades das mulheres
5 - Quantidade de mulheres com menos de 18 anos 
6 - Sair

Deve ser utilizado sub-rotinas.
 */
public class Exercicio1 {

	public static void main(String[] args) {
		String[] nomes = new String[20];
		int[] idades = new int[20];
		String[] sexos = new String[20];
		int count = 0;
		int op = 0;
		do {
			op = mostraMenu();
			
			if(op == 1) cadastra(nomes, idades, sexos, count++);
			if(op == 2) buscarPorNome(nomes, count);
			if(op == 3) mediaIdades(idades, sexos, count, "M");
			if(op == 4) mediaIdades(idades, sexos, count, "F");
			if(op == 5) qtdMulheresMenos18(idades, sexos, count);
			
		}while(op != 6);
	}

	private static int mostraMenu() {
		String m = "1 - Cadastrar\n" + 
				"2 - Buscar por nome\n" + 
				"3 - Média idade homens\n"+ 
				"4 - Média idade mulheres\n" + 
				"5 - Qtd mulheres abaixo de 18 anos\n\n" + 
				"6 - sair";
		return Integer.parseInt(JOptionPane.showInputDialog(m));
	}

	private static String lerNome() {
		String nome = JOptionPane.showInputDialog("Nome");
		return nome;
	}

	private static String lerSexo() {
		String sexo = JOptionPane.showInputDialog("Sexo");
		return sexo;
	}

	private static int lerIdade() {
		String idade = JOptionPane.showInputDialog("Sexo");
		return Integer.parseInt(idade);
	}

	private static void cadastra(String[] nomes, int[] idades, String[] sexos, int pos) {
		if (pos < 20) {
			nomes[pos] = lerNome();
			idades[pos] = lerIdade();
			sexos[pos] = lerSexo();
		}else {
			msg("Memória cheia");
		}
	}
	
	private static void msg(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
	
	private static void buscarPorNome(String[] nomes, int count) {
		String nmBusca = lerNome();
		String ret = "Não encontrei "+nmBusca;
		for (int i=0; i<count; i++) {
			if(nomes[i].equalsIgnoreCase(nmBusca)) {
				ret = nmBusca+" localizado na posição "+ (i+1) ;
			}
		}
		msg(ret);
	}
	
	private static void mediaIdades(int[] idades, String[] sexos, int count, String sexo) {
		int qtdSexo = 0;
		int somaIdades = 0;
		for (int i = 0; i < count; i++) {
			if (sexos[i].equalsIgnoreCase(sexo)) {
				qtdSexo++;
				somaIdades += idades[i];
			}
		}
		double media = somaIdades / qtdSexo;
		msg("Média das idades do sexo "+ sexo+": "+media);
	}
	
	private static void qtdMulheresMenos18(int[] idades, String[] sexos, int count) {
		int qtd = 0;
		for (int i = 0; i < count; i++) {
			if (sexos[i].equalsIgnoreCase("F") && idades[i] < 18) {
				qtd++;
			}
		}
		msg(qtd+" mulheres abaixo de 18 anos");
	}

}
