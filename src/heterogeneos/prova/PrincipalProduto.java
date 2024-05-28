package heterogeneos.prova;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrincipalProduto {

	public static void main(String[] args) {
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		int op = 0;
		do {
			op = menu();
			if(op == 1) produtos.add(leProduto());
			if(op == 2) buscarNome(produtos);
			if(op == 3) totalVendasMes(produtos);
			if(op == 4) mostraEstoque(produtos);
		}while(op != 5);
				
	}

	public static int menu() {
		String op = "1 - Cadastrar \n" + 
					"2 - Buscar por nome \n" + 
					"3 - Total de vendas do mês \n"+ 
					"4 - Mostrar estoque de todos os produtos cadastrados \n" + 
					"5 - Sair";

		return Integer.parseInt(JOptionPane.showInputDialog(null, op));
	}
	
	public static void mostraEstoque(ArrayList<Produto> produtos) {
		String ret = "";
		for(Produto p: produtos) {
			ret += p.nome+" - "+p.estoque+"\n";
		}
		msg(ret);
	}
	public static void buscarNome(ArrayList<Produto> produtos) {
		String nomeBusca = insNome();
		String ret = "Não encontrado";
		for(Produto p: produtos) {
			if(p.nome.equals(nomeBusca)) {
				ret = "Nome: " + p.nome + "\n" +
						"Estoque: " + p.estoque + "\n" +	
						"Valor: " + p.valor + "\nVendas:\n" ;
				for(int i=0; i<4; i++) {
					ret += p.vendas[i] + "\n";
				}
			}
		}
		msg(ret);
	}
	
	public static void totalVendasMes(ArrayList<Produto> produtos) {
		int mesBusca = insQtd();
		double soma = 0;
		for(Produto p: produtos) {
			soma += p.vendas[mesBusca-1];
		}
		msg(soma+"");
	}

	public static Produto leProduto() {
		Produto p = new Produto();
		p.nome = insNome();
		p.estoque = insQtd();
		p.valor = insValor();
		for(int i=0; i<4; i++) {
			p.vendas[i] = insQtd();
		}
		return p;
	}

	
	public static String insNome() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto: ");
		if (nome.trim().length() < 3) {
			msg("Nome incorreto!\nPor favor, digite um nome!");
			return insNome();
		}
		return nome;
	}

	public static int insQtd() {
		int qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade: "));
		if (qtd < 0) {
			msg("Quantidade incorreta!\nPor favor, digite uma quantidade positiva!");
			return insQtd();
		}
		return qtd;
	}

	public static double insValor() {
		double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do produto: "));
		if (valor <= 0) {
			msg("Quantidade incorreta!\nPor favor, digite uma quantidade positiva!");
			return insValor();
		}
		return valor;
	}

	public static void msg(String txt) {
		JOptionPane.showMessageDialog(null, txt);
	}

}
