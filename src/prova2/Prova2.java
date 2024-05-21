package prova2;

import javax.swing.JOptionPane;

public class Prova2 {
	
	public static void main(String[] args) {
        int op = 0;
        int maxProdutos = 4;
        int maxMes = 4;
        String[] nomes = new String[maxProdutos];
        double[] qtdEstoques = new double[maxProdutos];
        double[] valorProdutos = new double[maxProdutos];
        double[][] qtdVendidos = new double[maxProdutos][maxMes];
        int indice = 0;

        do {
            op = Integer.parseInt(menu());

            switch (op){
                case 1:
                    cadastrar(qtdVendidos, nomes, qtdEstoques, valorProdutos, indice++, maxProdutos, maxMes);
                    break;
                case 2:
                    buscarNome(qtdVendidos, nomes, qtdEstoques, valorProdutos, indice++, maxProdutos, maxMes);
                    break;
                case 3:
                    buscarMes(qtdVendidos, valorProdutos, indice, maxProdutos, maxMes);
                    break;
                case 4:
                    mostrarEstoque(qtdEstoques, nomes, indice, maxMes);
                    break;
            }

        }while(op != 5);

    }
    public static void msg(){
        JOptionPane.showMessageDialog(null,"Quantidade incorreta!\nPor favor, digite uma quantidade positiva!" );
    }

    public static void mostrarEstoque(double[] qtdEstoques, String[] nomes, int indice, int maxMes){
        StringBuilder estoque = new StringBuilder("O estoque geral está com: \n");
        for (int i = 0; i < indice; i++){
            estoque.append("Nome: ").append(nomes[i]).append("\n").append("Quantidade: ").append(qtdEstoques[i]).append("\n");
        }

        JOptionPane.showMessageDialog(null, estoque.toString());
    }

    public static void buscarMes(double[][] qtdVendidos, double[]valorProdutos, int indice, int maxProdutos, int maxMes){
        int  mes = insMes();
        valorVendido(qtdVendidos, valorProdutos, indice, mes);
    }
    public static void valorVendido(double[][] qtdVendidos, double[]valorProdutos, int indice, int mes){
        double total = 0;
        for (int i = 0; i < indice; i++){
          total += valorProdutos[i] * qtdVendidos[i][mes -1];
        }
        JOptionPane.showMessageDialog(null, "O total vendido foi: " + total);
    }
    public static void buscarNome(double[][] qtdVendidos, String[] nomes, double[] qtdEstoques, double[]valorProdutos, int indice, int maxProdutos, int maxMes){
        StringBuilder dados = new StringBuilder("O produto não foi encontrado!");
        String nome = insNome();
        for (int i = 0; i < indice; i++){
            if (nome.equalsIgnoreCase(nomes[i])){
                dados.delete(0, dados.length());
                dados.append("Os dados do produto são:  \n");
                dados.append("Nome: ").append(nomes[i]).append("\n");
                dados.append("Quantidade em estoque: ").append(qtdEstoques[i]).append("\n");
                dados.append("Valor desse produto: ").append(valorProdutos[i]).append("\n");
                dados.append("A quantidade vendida por cada mês: ").append("\n");
                for (int j =0; j < maxMes; j++){
                	dados.append("Mês ").append(j + 1).append(": ").append(qtdVendidos[i    ][j]).append(" \n");
                }
            }
        }
        JOptionPane.showMessageDialog(null, dados.toString());
    }
    public static void cadastrar(double[][] qtdVendidos, String[] nomes, double[] qtdEstoques, double[]valorProdutos, int indice, int maxProdutos, int maxMes){
        if (indice < maxProdutos){
            nomes[indice] = insNome();
            qtdEstoques[indice] = insQtd();
            valorProdutos[indice] = insValor();
            for (int j = 0; j < maxMes; j++){
                qtdVendidos[indice][j] = insQtdVendida();
            }
        }else {
            JOptionPane.showMessageDialog(null, "Não é possivel, número máximo foi alcançado.");
        }
    }
    public static int insMes(){
        int mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o mês: \n" +
                "1 - Janeiro \n" +
                "2 - Fevereiro \n" +
                "3 - Março \n" +
                "4 - Abril"));
        return mes;
    }
    public static double insQtdVendida(){
        double qtdvendida = Double.parseDouble(JOptionPane.showInputDialog(null,
                "Digite a quantidade em vendida do produto nos últimos 4 meses: "));
        if (qtdvendida < 0){
            msg();
            return insQtdVendida();
        }

        return qtdvendida;
    }
    public static String insNome(){
        String nome = JOptionPane.showInputDialog(null, "Digite o nome do produto: ");
        if (nome.trim().length() < 3) {
            JOptionPane.showMessageDialog(null, "Nome incorreto!\nPor favor, digite um nome!");
            return insNome();
        }
        return nome;
    }
    public static double insQtd(){
        double qtd = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite a quantidade em estoque: "));
        if (qtd < 0){
            msg();
            return insQtd();
        }
        return qtd;
    }

    public static double insValor(){
        double valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o valor do produto: "));
        if (valor <= 0){
            msg();
            return insValor();
        }
        return valor;
    }
    public static String menu(){
        String op = "1 - Cadastrar \n" +
                 "2 - Buscar por nome \n" +
                "3 - Total de vendas do mês \n" +
                "4 - Mostrar estoque de todos os produtos cadastrados \n" +
                "5 - Sair";

        return JOptionPane.showInputDialog(null, op);
    }

}
