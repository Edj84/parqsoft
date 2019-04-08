package Controller;

import Model.Leilao;

public class GerLeilao {
	
	private Leilao leilao;
	
	public GerLeilao(Leilao leilao) {
		this.leilao = leilao;
	}
	
	public void finalizaLeilao() {
		System.out.println("Leilão encerrado!");
		
	
	}
}
