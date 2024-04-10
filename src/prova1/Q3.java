package prova1;

import javax.swing.JOptionPane;

public class Q3 {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(JOptionPane.showInputDialog("N"));
		
		int[] vetorA = new int[n];
		int[] vetorB = new int[n];
		int[] somas  = new int[n];
		int[] subs   = new int[n];
		int[] mults  = new int[n];
		int[] divs   = new int[n];
		
		for(int i=0; i<n; i++) {
			vetorA[i] = Integer.parseInt(JOptionPane.showInputDialog("NAº"));
			vetorB[i] = Integer.parseInt(JOptionPane.showInputDialog("NBº"));
			
			somas[i] = vetorA[i] + vetorB[i];
			subs[i]  = vetorA[i] - vetorB[i];
			mults[i] = vetorA[i] * vetorB[i];
			divs[i]  = vetorA[i] / vetorB[i];
		}
		
		String linha1 = "Vetor A: ";
		String linha2 = "Vetor B: ";
		String linha3 = "Soma: ";
		String linha4 = "Subtração: ";
		String linha5 = "Multiplicação: ";
		String linha6 = "Divisão: ";
		
		for(int i=0; i<n; i++) {
			linha1 += vetorA[i] + " | ";
			linha2 += vetorB[i] + " | ";
			linha3 += somas[i] + " | ";
			linha4 += subs[i] + " | ";
			linha5 += mults[i] + " | ";
			linha6 += divs[i] + " | ";
		}
		
		JOptionPane.showMessageDialog(null, 
				linha1 + "\n" + linha2 + "\n" +
				linha3 + "\n" + linha4 + "\n" +
				linha5 + "\n" + linha6
		);
		
	}

}
