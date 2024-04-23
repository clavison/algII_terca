package matriz;

public class Exercicio6 {
	public static void main(String[] args) {
		int linhas = 4;
		int colunas = 4;

		int[][] matriz = new int[linhas][colunas];

		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				matriz[i][j] = (i + 1) * (j + 1);
			}
		}

		for (int i = 0; i < linhas; i++) {
			System.out.println();
			for (int j = 0; j < colunas; j++) {
				System.out.print(matriz[i][j] + "\t");
			}
		}
	}

}
