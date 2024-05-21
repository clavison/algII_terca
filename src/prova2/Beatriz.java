package prova2;

import javax.swing.JOptionPane;

public class Beatriz {
	
	public static void main(String[] args) {
        // variáveis
        int qtdProduto = 3;
        int meses = 4;
        int op = 0;
        int count = 0;

        // vetores e matriz
        String[] nomes = new String[qtdProduto];
        int[] qtdProdutoEstoque = new int[qtdProduto];
        double[] valorUnidadeProduto = new double[qtdProduto];
        int[][] qtdVendasMensal = new int[qtdProduto][meses];

        //Chamada da opção no menu
        do {
            op = menu();

            if (op == 1) cadastro(nomes, qtdProdutoEstoque, valorUnidadeProduto, qtdProduto, count, qtdVendasMensal);
            if (op == 2) buscaPorNome(nomes, qtdProdutoEstoque, valorUnidadeProduto, qtdProduto, count);
            if (op == 3) ;
            if (op == 4) mostraEstoque(nomes, qtdProdutoEstoque, qtdProduto);

        } while (op != 5);
    }

    private static int menu() {
        String m = "1 - Cadastrar\n" + "2 - Buscar por nome\n" + "3 - Total de vendas do mês\n" + "4 - Estoque\n" + "5 - Sair";
        return Integer.parseInt(JOptionPane.showInputDialog(null, m));
    }

    private static void msg(String txt) {
        // Mostra mensagem na tela
        JOptionPane.showMessageDialog(null, txt);
    }

    private static String leituraNomeProduto() {
        // Lê e valida o nome do produto, se o nome do produto for menor que 3 ele chama novamente o método
        String nomeProduto = JOptionPane.showInputDialog(null, "Digite o nome do produto.");
        if (nomeProduto.trim().length() >= 3 && !nomeProduto.trim().equalsIgnoreCase("")) {
            return nomeProduto.trim();
        } else {
            msg("Nome inválido, digite um nome com mais de 3 caracteres");
            return leituraNomeProduto();
        }
    }


    private static int leituraQuantidadeEstoque() {
        // Lê e valida a quantidade em estoque, se a quantidade for negativa ele chama novamente o método
        int lerQtdEstoque = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade do produto em estoque."));
        if (lerQtdEstoque >= 0) {
            return lerQtdEstoque;
        } else {
            msg("Quantidade inválida, digite novamente.");
        }
        return leituraQuantidadeEstoque();
    }

    private static double leituraValorUnidadeProduto() {
        // Lê e valida o valor da unidade do produto, se for menor que zero ele chama novamente o método
        double lerValorUnidade = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor da unidade do produto"));
        if (lerValorUnidade > 0) {
            return lerValorUnidade;
        } else {
            msg("Valor inválido, digite um valor maior que 0.00");
        }
        return leituraValorUnidadeProduto();
    }

    private static int leituraQtdVendasMensal() {
        int qtdVendasMensal = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a quantidade de produto vendida no mês."));
        if (qtdVendasMensal >= 0) {
            return qtdVendasMensal;
        } else {
            msg("Quantidade vendida inválida, digite novamente.");
        }
        return leituraQtdVendasMensal();
    }

    private static void cadastro(String[] nomes, int[] qtdProdutoEstoque, double[] valorUnidadeProduto, int count, int qtdProduto, int[][] qtdVendasMensal) {
        //Guarda o nome, a quantidade de produto em estoque e o valor por unidade
        if (qtdProduto < 3) {
            nomes[qtdProduto] = leituraNomeProduto();
            qtdProdutoEstoque[qtdProduto] = leituraQuantidadeEstoque();
            valorUnidadeProduto[qtdProduto] = leituraValorUnidadeProduto();
            for (int i = 0; i < 4; i++) {
                qtdVendasMensal[qtdProduto][i] = leituraQtdVendasMensal();
            }
            count++;
        } else {
            msg("Memória cheia.");
        }
    }

    private static void buscaPorNome(String[] nomes, int[] qtdProdutoEstoque, double[] valorUnidadeProduto, int count, int qtdProduto) {
        // Busca pelo nome e mostra todos os dados do produto
        String nomeBusca = leituraNomeProduto();
        String retorna = "";
        for (int i = 0; i < qtdProduto; i++) {
            if (nomes[i].equals(nomeBusca)) {
                retorna += nomes[i] + "\n";
            }
        }
        msg(retorna);
    }

    private static void mostraEstoque(String[] nomes, int[] qtdProdutoEstoque, int qtdProduto) {
        // Mostra o estoque dos produtos cadastrados 
        int estoqueBusca = leituraQuantidadeEstoque();
        String retorna = "";
        for (int i = 0; i < qtdProduto; i++) {
            retorna += qtdProdutoEstoque[i] + nomes[i] + "\n";
        }
        msg(retorna);
    }

}
