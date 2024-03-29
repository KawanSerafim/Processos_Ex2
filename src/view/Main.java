package view;

import controller.KillController;
import javax.swing.JOptionPane;

public class Main {
	
	public static void main (String[] args) {
		
		KillController kill = new KillController();
		
		int opc = 0;
		
		while (opc!=9) {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog("MENU\n\n" +
					"1 - Listar processos ativos.\n" +
					"2 - Matar o processo pelo PID.\n" +
					"3 - Matar o processo pelo nome.\n" +
					"9 - Sair."));
			
			switch (opc) {
			case 1:
				
				kill.listaProcessos();
				break;
				
			case 2:
				
				int pid = Integer.parseInt(JOptionPane.showInputDialog("Digite o PID do processo."));
				kill.mataPid(pid);
				
				break;
			
			case 3:
				
				String nome = JOptionPane.showInputDialog("Digite o nome do processo.");
				kill.mataNome(nome);
				
				break;
			
			case 9:
				
				JOptionPane.showMessageDialog(null, "Saindo...");
				break;
			
			default:
				
				JOptionPane.showMessageDialog(null, "Opção não identificada... Digite novamente.");
		
			}
			
		}
	}
}
