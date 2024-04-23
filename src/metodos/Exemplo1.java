package metodos;

public class Exemplo1 {
	
	public static void main(String[] args) {
		somarDoisNumeros(5, 6);
		somarDoisNumeros(1.5, 1.8);
		int r = multiplicaDoisNumeros(5, 5);
		System.out.println(r);
	}
	
	private static void somarDoisNumeros(double n1, double n2) {
		double soma = n1 + n2;
		System.out.println("Executando double e double "+soma);
	}
	
	private static void somarDoisNumeros(int n1, int n2) {
		int soma = n1 + n2;
		System.out.println("Executando int e int "+soma);
	}
	
	private static int multiplicaDoisNumeros(int n1, int n2) {
		int result = n1 * n2;
		return result;
	}
	
	

}
