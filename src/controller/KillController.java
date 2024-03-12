package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	
	public KillController() {
		super();
	}
	
	private String os() {
		
		return System.getProperty("os.name");
		
	}
	
	public void listaProcessos() {
		
		String nomeSO = os();
		
		if (nomeSO.contains("Windows")) {
			
			try {
				
				Process p = Runtime.getRuntime().exec("TASKLIST /FO TABLE");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				while (linha != null) {
					
					System.out.println(linha);
					linha = buffer.readLine();
					
				}
			
			} catch (IOException e) {
				
				e.printStackTrace();
			
			}
			
		}
		else if (nomeSO.contains("Linux")) {
			
			try {
				
				Process p = Runtime.getRuntime().exec("ps -ef");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String linha = buffer.readLine();
				
				while (linha != null) {
					
					System.out.println(linha);
					linha = buffer.readLine();
					
				}
			
			} catch (IOException e) {
				
				e.printStackTrace();
			
			}
			
		}
		else {
			
			System.err.println("Não há versão para este sistema operacional...");
			
		}
		
	}
	
}
