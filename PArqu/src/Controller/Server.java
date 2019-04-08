package Controller;
// Recebe um pacote de algum cliente
// Separa o dado, o endereço IP e a porta deste cliente
// Imprime o dado na tela

import java.io.*;
import java.net.*;

public class Server {
	
	
   
	public static void main(String args[]) throws Exception {
		
		DatagramSocket serverSocket = new DatagramSocket(9876);
		
		while(true) {
			byte[] dadosRecebidos = new byte[1024];
			DatagramPacket pacoteDoCliente = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
	        serverSocket.receive(pacoteDoCliente);
	        int porta = pacoteDoCliente.getPort();
	        double lance = Double.parseDouble(new String(pacoteDoCliente.getData()));
			recebeLance(serverSocket);
			
		}
	}
	
	private static boolean recebeLance(DatagramSocket serverSocket) throws Exception {
		byte[] dadosRecebidos = new byte[1024];
		DatagramPacket pacoteDoCliente = new DatagramPacket(dadosRecebidos, dadosRecebidos.length);
        serverSocket.receive(pacoteDoCliente);
        double lance = Double.parseDouble(new String(pacoteDoCliente.getData()));
        return Controller.GerLances.recebeLance(lance);
        	
        
        
	}
	
	
}