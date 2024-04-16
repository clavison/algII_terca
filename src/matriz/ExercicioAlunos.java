package matriz;

import java.text.DecimalFormat;
import java.util.Random;

import javax.swing.JOptionPane;

public class ExercicioAlunos {
//	Uma turma com N alunos realizou M provas. 
//	Faça um programa que leia todas as notas 
//	obtidas pelos alunos e ao final mostre 
//	a média de cada aluno (trate os alunos como 1, 2, 3 ...)
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("#0.00");
		
		int n = Integer.parseInt(JOptionPane.showInputDialog("Qt Alunos:"));
		int m = Integer.parseInt(JOptionPane.showInputDialog("Qt Notas:"));
		
		double[][] notas = new double[n][m];
		String[] nomes = new String[n];
		
		for(int i=0; i<n; i++) {
			nomes[i] = JOptionPane.showInputDialog("Aluno(a) " +(i+1));
			for(int j=0; j<m; j++) {
				notas[i][j] = new Random().nextDouble()*10;
			}
		}
		
		String ret = "";
		
		for(int i=0; i<n; i++) {
			double soma = 0;
			for(int j=0; j<m; j++) {
				soma += notas[i][j];
			}
			ret += nomes[i]+" - "+df.format(soma/m)+"\n";
		}
		
		JOptionPane.showMessageDialog(null, ret);
	}
}
