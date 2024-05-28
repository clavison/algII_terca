package heterogeneos;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class ImcHeterogeneo {
	
	public static void main(String[] args) {
		Pessoa[] pessoas = new Pessoa[10];
		int count = 0;
		int op = 0;
		do {
			op = menu();
			if(op == 1) cadastrar(pessoas, count++);
			if(op == 2) buscarNome(pessoas, count);
			if(op == 3) ListarTodos(pessoas, count);
			if(op == 4) nomePessoaImc(pessoas, count, 0);
			if(op == 5) nomePessoaImc(pessoas, count, 1);
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
	
	public static void cadastrar(Pessoa[] pessoas, int count ) {
		Pessoa p = new Pessoa();
		p.nome = lerNome();
		p.peso = lerDouble("Peso");
		p.altura = lerDouble("Altura");
		pessoas[count] = p;
	}
	
	public static double calcularImc(Pessoa p) {
		return p.peso / (p.altura * p.altura);
	}
	
	public static void buscarNome(Pessoa[] pessoas, int count) {
		String ret = "Não encontado";
		String nome = lerNome();
		for(int i=0; i<count; i++) {
			if(nome.equals(pessoas[i].nome)) {
				ret = pessoas[i].nome + " IMC: " + formata(calcularImc(pessoas[i]));
			}
		}
		msg(ret);
	}
	
	public static void ListarTodos(Pessoa[] pessoas, int count) {
		String ret = "";
		for (int i = 0; i < count; i++) {
			ret += pessoas[i].nome + " IMC: " + formata(calcularImc(pessoas[i])) + "\n";
		}
		msg(ret);
	}
	
	public static void nomePessoaImc(Pessoa[] pessoas, int count, int op) {
		Pessoa maiorImc = pessoas[0];
		Pessoa menorImc = pessoas[0];
		for (int i = 0; i < count; i++) {
			double imc = calcularImc(pessoas[i]);
			if(imc > calcularImc(maiorImc)) {
				maiorImc = pessoas[i];
			}
			if(imc < calcularImc(menorImc)) {
				menorImc = pessoas[i];
			}
		}
		if(op == 0)
			msg(maiorImc.nome + " IMC: " + formata(calcularImc(maiorImc)));
		if(op == 1)
			msg(menorImc.nome + " IMC: " + formata(calcularImc(menorImc)));
	}

}
