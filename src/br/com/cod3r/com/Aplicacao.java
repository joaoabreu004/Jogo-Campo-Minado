package br.com.cod3r.com;

import br.com.cod3r.com.modelo.Tabuleiro;
import br.com.cod3r.com.visao.TabuleiroConsole;

public class Aplicacao {
	public static void main(String[] args) {
		
		
		Tabuleiro tabuleiro = new Tabuleiro(6, 6, 6); 
		new TabuleiroConsole(tabuleiro); 
	}
}
