package sockets.tcp.cliente.invertido;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	private static Scanner scanner;

	public static void main(String[] args) throws UnknownHostException, IOException{
		// TODO Auto-generated method stub
		
		Socket socketCliente = new Socket("localhost", 5000);
		DataInputStream fluxoEntrada = new DataInputStream(socketCliente.getInputStream());
		DataOutputStream fluxoSaida = new DataOutputStream(socketCliente.getOutputStream());
		
		scanner = new Scanner(System.in);
		
		System.out.println("Digite uma mensagem: ");
		String msg = scanner.nextLine();
		
		System.out.println("\n \n Mensagem enviada ao servidor: " + msg);
		
		fluxoSaida.writeUTF(msg);
		
		msg = fluxoEntrada.readUTF();
		
		System.out.println("\n \n Mensagem recebida do servidor: " + msg);
		
		fluxoEntrada.close();
		fluxoSaida.close();
		socketCliente.close();
	}

}
