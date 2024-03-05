package revisao_algoritmo_1;

import javax.swing.JOptionPane;

public class Exemplo5 {
	
	public static void main(String[] args) {
		int n1 = Integer.parseInt(JOptionPane.showInputDialog("N1"));
		int n2 = Integer.parseInt(JOptionPane.showInputDialog("N2"));
		
		for(int i = n1; i <= n2; i++) {
			if( i % 2 == 1) {
				System.out.print(i+ " ");
			}
		}
	}

}
