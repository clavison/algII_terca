package matriz;

import java.util.Random;

public class Exemplo1 {
	
	public static void main(String[] args) {
		Random r = new Random();
		double [][] gastos = new double[12][4];
		
		for(int i=0; i<gastos.length; i++) {
			for(int j=0; j<gastos[0].length; j++) {
				gastos[i][j] = r.nextInt(1000);
			}
		}
		
		for(int i=0; i<gastos.length; i++) {
			System.out.println("");
			for(int j=0; j<gastos[0].length; j++) {
				System.out.print(gastos[i][j]+"\t");
			}
		}
		System.out.println("\n");
		
		for(int i=0; i<gastos.length; i++) {
			double totalMes = 0;
			for(int j=0; j<gastos[0].length; j++) {
				totalMes += gastos[i][j];
			}
			System.out.println("Mês "+(i+1)+":"+totalMes);
		}
		
	}

}
