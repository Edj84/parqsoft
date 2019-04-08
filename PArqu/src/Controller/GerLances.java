package Controller;
import java.util.ArrayList;

import Model.Lance;

public class GerLances {
	
	private ArrayList<Double> historicoDeLances;
	private static double lanceMaisAlto;
	private double precoInicial;
	
	
	public GerLances(double precoInicial) {
		historicoDeLances = new ArrayList<Double>();
		this.precoInicial = precoInicial;
		lanceMaisAlto = precoInicial;		
	}
	
	public double getLanceMaisAlto() {
		return lanceMaisAlto;
	}
	
	public ArrayList<Double> getHistorico(){
		return historicoDeLances;
	}
	
	public static boolean recebeLance(double novoLance) {
		System.out.println("Recebendo lance no gerenciador");		
		return comparaLances(novoLance);
	}	
			
	/* Inativado. Depende de futura implementação
	public boolean recebeLance(Lance novoLance) {
		System.out.println("Recebendo lance no gerenciador");
		
		incluiHistorico(novoLance);
		
		boolean aux = comparaLances(novoLance);
		System.out.println("retornando " + aux + " em recebeLance");
		
		return aux; 		
	}
	
	private void incluiHistorico(Double novoLance) {
		historicoDeLances.add(novoLance);
	}
	
	*/
	
	private static boolean comparaLances(double novoLance) {
		System.out.println("Comparando lances");		
		
		if(novoLance > lanceMaisAlto) {
			atualizaLanceMaisAlto(novoLance);
			return true;
		}
		else
			return false;
	}
	
	private static void atualizaLanceMaisAlto(double novoLance) {
		lanceMaisAlto = novoLance;		
		System.out.println("Lance mais alto atualizado para " + lanceMaisAlto);
	}
	
	public double calculaAgio(double precoInicial) {
		if(precoInicial == lanceMaisAlto)
			return 0.0;
		else
			return Math.round((lanceMaisAlto * 100 / precoInicial) - 100); 
	}

	public String apuraVencedor() {
		if(precoInicial < lanceMaisAlto)
			return "O lance vencedor foi de R$ " + lanceMaisAlto;
		else 
			return "Não houve vencedor. Nenhum lance superou o preço inicial (R$ " + precoInicial + ")";
	}
	
}
