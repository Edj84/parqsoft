package View;
import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import java.util.InputMismatchException;
import java.util.Scanner;

import Model.Usuario;

public class AppCliente {
	
	private static Model.Usuario cliente = new Usuario("Lombardi", 2);
	private static DatagramSocket clientSocket;
	private static InetAddress IPAddress;	
	
	public static void main(String args[]) throws Exception {
      
		conectar();
		executar();
		closeConnection();    
   }

	private static void executar() throws Exception {		
		enviarLance();		
	}

	private static void conectar() throws Exception {

		clientSocket = new DatagramSocket();
		IPAddress = InetAddress.getByName("localhost");
	    
	    //byte[] receiveData = new byte[1024];		
	}
	
	private static void enviarLance() throws Exception {
		byte[] sendData = new byte[1024];        
		String lance = null;
		
		do { 
			lance = gerarLance();
		}
		while(lance.equals("-1"));
		
		sendData = lance.getBytes();       
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        clientSocket.send(sendPacket);
	}
	
	private static String gerarLance() {
		
		System.out.println("Digite o valor do lance (digite apenas números, separados por vírgula): ");		
		double valorLance = -1;		
		try (Scanner scan = new Scanner(System.in)){			
			valorLance = scan.nextDouble();
			if(valorLance <= 0)
				throw new Exception("lanceNegativo");
			
			System.out.println("Lance " + valorLance);
			return String.valueOf(valorLance);
		}
		
		catch(Exception e ) {
			System.out.println("Entrada inválida. Digite apenas números positivos, separando as casas decimais por vírgula");
			return "-1";
		}
	}
	
	private static String receberResposta() throws Exception {	
		DatagramSocket serverSocket = new DatagramSocket(9876);		
		byte[] receiveData = new byte[1024];
	    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);	
	    serverSocket.receive(receivePacket);	    	
	    return new String(receivePacket.getData());    
	}

	private static void closeConnection() {
		clientSocket.close();		
	}
	
}
