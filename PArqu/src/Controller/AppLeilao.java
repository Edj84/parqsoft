package Controller;
import java.util.InputMismatchException;
import java.util.Scanner;

import Model.Lance;
import Model.Leilao;
import Model.Produto;
import Model.Usuario;

public class AppLeilao {
	
	private static Usuario admin = new Usuario("Admin", 0);
	private static Usuario vendedor; 	
	private static Produto produto; 	
	private static Leilao leilao;	
	
	public static void main(String args[]) {
		
		vendedor = new Usuario("Silvio Santos", 1);
		produto = new Produto("Telessena", 10.50, vendedor);
		leilao = new Leilao(produto, vendedor, admin, 0.1, 0.025); //taxa de venda estipulada em 10% e de compra em 2,5%, apenas para fins de simulação
		
		run();
		
	}

	private static void run() {
		
		Usuario comprador = new Usuario("Lombardi", 2);
		Scanner scan = new Scanner(System.in);
		int counter = 5;
		
		while(counter >= 0) {
			System.out.println("Digite o valor do lance (digite apenas números, separados por vírgula): ");
			
			try {
				double valorLance = scan.nextDouble();
				System.out.println("Lance " + valorLance);
				System.out.println(leilao.receberLance(new Lance(comprador, produto, valorLance)));
				counter--;
			}
			
			catch(InputMismatchException e) {
				System.out.println("Entrada inválida. Digite apenas números, separados por vírgula");
				break;
			}			
		}
				
		System.out.println(leilao);
		
	}
	
}
