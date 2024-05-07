package simulado;

import javax.swing.JOptionPane;

public class Programa {
	
	public static void main(String[] args) {
		String[] nomes   = new String[20];
		int[] idades     = new int[20];
		String[] sexos   = new String[20];
		double[][] notas = new double[20][3];
		int qtdCadastro = 0;
		int op = 0;
			if(op==1) cadastrar(nomes, idades, sexos, notas, qtdCadastro++);
			if(op==2) calculaMediaTodosAlunos(nomes, notas, qtdCadastro);
			if(op==3) verificaSituacaoTodosAlunos(nomes, notas, qtdCadastro);
			if(op==4) mostraPercentualReprovados(sexos, notas, qtdCadastro);
			if(op==5) mediaIdades(idades, qtdCadastro);
			if(op==6) mostraPorSexo(sexos, nomes, qtdCadastro);
			if(op==7) mostraPorIdade(idades, nomes, qtdCadastro);
		do {
			op = escolheMenu();
		}while(op!=8);
	}
	
	private static int escolheMenu() {
		String menu = "1 - Cadastrar\n"
				+ "2 - Calcular a média de todos os alunos\n"
				+ "3 - Exibir situação dos alunos\n"
				+ "4 - Percentual de mulheres e homens reprovados\n"
				+ "5 - Média das idades da turma\n"
				+ "6 - Listar alunos por sexo\n"
				+ "7 - Listar alunos por idade\n"
				+ "8 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(menu));
	}
	
	private static void mostraPorSexo(String[] sexos,String[] nomes, int qt ) {
		String sexoBusca = lerSexo();
		String ret = "";
		for(int i=0; i<qt; i++){
			if(sexos[i].equals(sexoBusca)) {
				ret += nomes[i]+"\n";
			}
		}
		msg(ret);
	}
	private static void mostraPorIdade(int[] idades,String[] nomes, int qt ) {
		int idadeBusca = lerIdade();
		String ret = "";
		for(int i=0; i<qt; i++){
			if(idades[i]==idadeBusca) {
				ret += nomes[i]+"\n";
			}
		}
		msg(ret);
	}
	
	private static void mediaIdades(int[] idades, int qt) {
		int soma = 0;
		for(int i=0; i<qt; i++){
			soma += idades[i];
		}
		msg("Média idades: "+(soma/qt));
	}
	
	private static void mostraPercentualReprovados(String[] sexos, double[][]notas, int qt) {
		String ret = "Percentual Reprovados Masculinos:"+
				percentualReprovados(sexos, notas, "M", qt);
		ret+="\nPercentual Reprovados Femininos:"+
				percentualReprovados(sexos, notas, "F", qt);
		msg(ret);
		
	}
	
	private static double percentualReprovados(String[] sexos, double[][]notas, String sexo, int qt) {
		double perc = 0;
		int qtSexo = 0;
		int qtRep = 0;
		for(int i=0; i< qt; i++) {
			if(sexos[i].equals(sexo)) {
				qtSexo++;
				if(verificaSituacao(notas, i).equals("Reprovado")) {
					qtRep++;
				}
			}
		}
		perc = qtRep/qtSexo*100;
		return perc;
	}
	
	private static void calculaMediaTodosAlunos(String[] nomes, double[][]notas, int qtd) {
		String s = "";
		for(int i=0; i<qtd; i++) {
			s += nomes[i] + "-" + calculaMedia(notas, i)+"\n";
		}
		msg(s);
	}
	private static void verificaSituacaoTodosAlunos(String[] nomes, double[][]notas, int qtd) {
		String s = "";
		for(int i=0; i<qtd; i++) {
			s += nomes[i] + "-" + verificaSituacao(notas, i)+"\n";
		}
		msg(s);
	}
	
	private static double calculaMedia(double[][]notas, int linha) {
		double soma = 0;
		for(int i=0; i<3; i++) {
			soma += notas[linha][i];
		}
		return soma / 3;
	}
	
	private static String verificaSituacao(double[][]notas, int linha) {
		double media = calculaMedia(notas, linha);
		if(media >= 7) return "Aprovado";
		if(media < 3) return "Reprovado";
		return "Recuperação";
	}
	
	private static void cadastrar(String[] nomes, int[] idades, String[] sexos, double[][] notas, int qtdCadastro ) {
		if(qtdCadastro < 20) {
			nomes[qtdCadastro] = lerNome();
			idades[qtdCadastro] = lerIdade();
			sexos[qtdCadastro] = lerSexo();
			for(int i=0; i<3; i++) {
				notas[qtdCadastro][i] = lerNota();
			}
		}else {
			msg("Memoria cheia");
		}
	}
	
	private static void msg(String txt) {
		JOptionPane.showMessageDialog(null, txt);
	}
	
	
	private static String lerNome() {
		String nome = JOptionPane.showInputDialog("Nome:");
		if(nome.trim().equals("")) {
			return lerNome();
		}
		return nome.trim();
	}
	private static String lerSexo() {
		String sexo = JOptionPane.showInputDialog("Sexo(M/F):").toUpperCase();
		if(sexo.trim().equals("M") || sexo.trim().equals("F")) {
			return sexo.trim();
		}
		return lerSexo();
		
	}
	private static int lerIdade() {
		int idade = Integer.parseInt(JOptionPane.showInputDialog("Idade (17-99):"));
		if(idade >=17 && idade <=99) {
			return idade;
		}
		return lerIdade();
	}
	private static double lerNota() {
		double nota = Double.parseDouble(JOptionPane.showInputDialog("Nota:"));
		if(nota >=0 && nota <=10) {
			return nota;
		}
		return lerNota();
	}

}
