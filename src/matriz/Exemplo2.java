package matriz;

import javax.swing.JOptionPane;

public class Exemplo2 {
	
	public static void main(String[] args) {
		int[][] atend = new int[7][3];
		String[] dias = new String[] {"Seg","Terç","Qua","Qui","Sex","Sab","Dom"};
		String[] turnos = new String[] {"Mat","Vesp","Not"};
		
		for(int i=0; i<7; i++) {
			for(int j=0; j<3; j++) {
				atend[i][j] = Integer.parseInt(
						JOptionPane.showInputDialog(dias[i]+" "+turnos[j]+":"));
			}
		}
	}

}
