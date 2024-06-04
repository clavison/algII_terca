package heterogeneos.jogadores;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PrincipalJogadores {
	
	public static void main(String[] args) {
		ArrayList<Jogador> lista = new ArrayList<Jogador>();
		int op = 0;
		do {
			op = menu();
			if(op == 1) lista.add(lerJogador());
			if(op == 2) maisMenosGols(lista, 2);
			if(op == 3) maisMenosGols(lista, 3);
			if(op == 4) goleiroMaisGols(lista);
			if(op == 5) camisasDez(lista);
		}while(op != 6);
	}
	
	private static int menu() {
		String m = "1 - Cadastrar\n"
				+ "2 - Maior número de gols\n"
				+ "3 - Menor número de gols\n"
				+ "4 - Goleiros que fizeram gols\n"
				+ "5 - Camisas 10\n"
				+ "6 - Sair";
		return Integer.parseInt(JOptionPane.showInputDialog(m));
	}
	
	
	
	private static void msg(String txt) {
		JOptionPane.showMessageDialog(null, txt);
	}
	
	private static String escreveJogador(Jogador j) {
		 return "Nome: " + j.nome + "\n" +
				"Camisa: " + j.camisa + "\n" +
				"Posição: " + j.posicao + "\n" +
				"Time: " + j.time + "\n" +
				"Gols: " + j.gols;
	}
	
	private static void maisMenosGols(ArrayList<Jogador> lista, int op) {
		Jogador mais = lista.get(0);
		Jogador menos = lista.get(0);
		for (Jogador j : lista) {
			if(j.gols > mais.gols) {
				mais = j;
			}
			if(j.gols < menos.gols) {
				menos = j;
			}
		}
		if( op == 2) {
			msg(escreveJogador(mais));
		}else {
			msg(escreveJogador(menos));
		}
	}
	
	private static Jogador lerJogador() {
		Jogador j = new Jogador();
		j.nome = lerString("Nome");
		j.camisa = lerInt("Camisa");
		j.posicao = lerPosicao();
		j.time = lerString("Time");
		j.gols = lerInt("Gols");
		return j;
	}
	
	private static String lerString(String txt) {
		String str = JOptionPane.showInputDialog(txt);
		if (str.trim().equals("")) {
			return (lerString(txt));
		}
		return str.toUpperCase();
	}
	
	private static String lerPosicao() {
		String str = JOptionPane.showInputDialog("Posição").trim().toUpperCase();
		if (str.equals("ATACANTE") || str.equals("ZAGUEIRO") || str.equals("GOLEIRO")) {
			return str;
		}
		return lerPosicao();
	}
	
	private static int lerInt(String txt) {
		int i = Integer.parseInt(JOptionPane.showInputDialog(txt));
		if (i < 0) {
			return (lerInt(txt));
		}
		return i;
	}
	
	private static void goleiroMaisGols(ArrayList<Jogador> jogadores) {
		Jogador goleiro = null;
		for (Jogador j : jogadores) {
			if(j.posicao.equals("GOLEIRO")) {
				if(goleiro == null) {
					goleiro = j;
				}
				
				if(j.gols > goleiro.gols) {
					goleiro = j;
				}
			}
		}
		msg(escreveJogador(goleiro));
	}
	
	private static void camisasDez(ArrayList<Jogador> jogadores) {
		String ret = "";
		for (Jogador j : jogadores) {
			if(j.camisa == 10 ) {
				ret += escreveJogador(j)+"\n\n";
			}
		}
		msg(ret);
	}

}
