package prova1;

import javax.swing.JOptionPane;

public class Q4 {
	
	public static void main(String[] args) {
		String nomes[] = new String[100];
		String cpfs[] = new String[100];
		int count = 0;
		String menu = "1 - cadastrar\n"
				+ "2 – Buscar pessoa por nome\n"
				+ "3 – Buscar pessoa por CPF\n"
				+ "4 – Sair\n";
		int op = 0;
		do{
			op = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if(op == 1) {
				if(count<100) {
					nomes[count] = JOptionPane.showInputDialog("Nome");
					cpfs[count] = JOptionPane.showInputDialog("Nome");
					count++;
				}else {
					//msg excedeu tamanho
				}
			}
			if(op == 2) {
				String ret = "Não encontrado(a)";
				String busca = JOptionPane.showInputDialog("Nome");
				for(int i=0; i<count; i++) {
					if(nomes[i].equals(busca)) {
						ret = nomes[i] + "-"+cpfs[i];
					}
				}
				JOptionPane.showMessageDialog(null, ret);
			}
		}while(op!=4);
				
	}

}
