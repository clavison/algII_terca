package vetores;

import javax.swing.JOptionPane;

public class Exercicio1 {
	
	public static void main(String[] args) {
		String[] cores = new String[5];
		
		for(int i = 0; i < cores.length; i++) {
			cores[i] = JOptionPane.showInputDialog((i+1)+"ª Cor");
		}
		
		for(int i = cores.length-1; i >= 0; i--) {
			System.out.println(cores[i]);
		}
	}

}
