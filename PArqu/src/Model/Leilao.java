package Model;
import java.util.ArrayList;
import java.util.HashMap;

import Controller.GerLances;

public class Leilao {
	
	private double taxaVenda;
	private double taxaCompra;
	private Produto produto;
	private double precoFinal;
	private Usuario vendedor;
	private HashMap<Integer, Usuario> compradores;	
	private Transacao[] transacoes;	
	private GerLances gerLances;
	
	public Leilao (Produto produto, Usuario vendedor, Usuario admin, double taxaVenda, double taxaCompra) {
		gerLances = new GerLances(produto.getPrecoInicial());		
		this.produto = produto;
		this.vendedor = vendedor;
		this.taxaVenda = taxaVenda;
		
		//mover para gerTransacoes como método registrarTransacao
		//transacoes[0] = new Transacao(this.produto, this.produto.getPrecoInicial(), this.vendedor, admin, taxaVenda);
		
		this.taxaCompra = taxaCompra;
		this.compradores = new HashMap<Integer, Usuario>();
		this.precoFinal = produto.getPrecoInicial();
		
	}
	
	public double getTaxaVenda() {
		return taxaVenda;
	}

	public double getTaxaCompra() {
		return taxaCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public Usuario getVendedor() {
		return vendedor;
	}
	
	public boolean registrarComprador(Usuario novoComprador) {
		return compradores.putIfAbsent(novoComprador.getID(), novoComprador) != null;
	}

	public HashMap<Integer, Usuario> getCompradores() {
		return compradores;
	}

	public Transacao[] getTransacoes() {
		return transacoes;
	}

	private String exibeStatus() {
		
		String aux = gerLances.apuraVencedor();
		
		if(aux != null)		
			return "Valor do maior lance é: " + aux.getValor() + " (Usuário " + aux.getComprador().getUserName() + ")";
		
		return "Nenhum lance válido até o momento";
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("====== Leilão encerrado ======\n\n");
		sb.append("Produto: " + produto.getDescricao() + "\n");
		sb.append("Preço inicial: " + produto.getPrecoInicial() + "\n");
		sb.append("Preço final: " + precoFinal + "\n");	
		sb.append("Ágio: " + gerLances.calculaAgio(produto.getPrecoInicial()) + "%\n");
		sb.append("Vencedor: " + gerLances.apuraVencedor() + "\n\n");
		
		
		
		
		sb.append("====== Detalhamento do valor da compra ======\n");
		sb.append("Valor do produto: " + precoFinal + "\n");
		double taxaComprador = precoFinal*taxaCompra;
		sb.append("Taxa de compra(" + (taxaCompra*100) + "%): R$ " + taxaComprador + "\n");
		sb.append("Total a pagar: " + (precoFinal+taxaComprador) + "\n");
		
		return sb.toString();		
	}
		
}
