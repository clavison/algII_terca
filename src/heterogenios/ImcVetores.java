package heterogenios;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class ImcVetores {
	
	public static void main(String[] args) {
		String[] nomes = new String[10];
		double[] pesos = new double[10];
		double[] alturas = new double[10];
		int count = 0;
		int op = 0;
		do {
			op = menu();
			if(op == 1) cadastrar(nomes, pesos, alturas, count++);
			if(op == 2) buscarNome(nomes, pesos, alturas, count);
			if(op == 3) ListarTodos(nomes, pesos, alturas, count);
			if(op == 4) nomePessoaImc(nomes, pesos, alturas, count, 0);
			if(op == 5) nomePessoaImc(nomes, pesos, alturas, count, 1);
		} while (op != 6);
	}
	
	public static String formata(double d) {
		DecimalFormat df = new DecimalFormat("###,00");
		return df.format(d);
	}
	
	public static int menu() {
		String m = "1 - Cadastrar\n"
				+ "2 - Buscar por nome\n"
				+ "3 - Listar todos\n"
				+ "4 - Nome da pessoa com maior IMC\n"
				+ "5 - Nome da pessoa com menor IMC\n"
				+ "6 - SAIR";
		return Integer.parseInt(JOptionPane.showInputDialog(m));
	}
	
	public static void msg(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	public static String lerNome() {
		String nome = JOptionPane.showInputDialog("Nome");
		if(nome.equals("")) {
			msg("Nome incorreto!");
			return lerNome();
		}
		return nome;
	}
	
	public static double lerDouble(String campo) {
		double d = Double.parseDouble(JOptionPane.showInputDialog(campo));
		if(d <= 0) {
			msg(campo +" incorreto!");
			return lerDouble(campo);
		}
		return d;
	}
	
	public static void cadastrar(String[] n, double[] p, double[] a, int count ) {
		n[count] = lerNome();
		p[count] = lerDouble("Peso");
		a[count] = lerDouble("Altura");
	}
	
	public static double calcularImc(double peso, double altura) {
		return peso / (altura * altura);
	}
	
	public static void buscarNome(String[] n, double[] p, double[] a, int count) {
		String ret = "Não encontado";
		String nome = lerNome();
		for(int i=0; i<count; i++) {
			if(nome.equals(n[i])) {
				ret = n[i] + " IMC: " + formata(calcularImc(p[i], a[i]));
			}
		}
		msg(ret);
	}
	
	public static void ListarTodos(String[] n, double[] p, double[] a, int count) {
		String ret = "Não encontado";
		for (int i = 0; i < count; i++) {
			ret += n[i] + " IMC: " + formata(calcularImc(p[i], a[i])) + "\n";
		}
		msg(ret);
	}
	
	public static void nomePessoaImc(String[] n, double[] p, double[] a, int count, int op) {
		double maiorImc = calcularImc(p[0], a[0]);
		String nomeMaior = n[0];
		double menorImc = calcularImc(p[0], a[0]);
		String nomeMenor = n[0];
		for (int i = 0; i < count; i++) {
			double imc = calcularImc(p[i], a[i]);
			if(imc > maiorImc) {
				maiorImc = imc;
				nomeMaior = n[i];
			}
			if(imc < menorImc) {
				menorImc = imc;
				nomeMenor = n[i];
			}
		}
		if(op == 0)
			msg(nomeMaior + " IMC: " + formata(maiorImc));
		if(op == 1)
			msg(nomeMenor + " IMC: " + formata(menorImc));
	}
	

}
