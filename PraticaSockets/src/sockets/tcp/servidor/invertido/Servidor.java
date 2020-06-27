package sockets.tcp.servidor.invertido;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		ServerSocket serverSocket=new ServerSocket(5000);
		System.out.println("\n\nIniciando servidor TCP...\n");
		System.out.println("Servidor pronto para receber conexões...\n\n");
		// O metodo accept retorna um socket para comunicação com o próximo
		// cliente a conectar.
		// A execução do método bloqueia até que algum cliente conecte no
		// servidor.
		Socket socket = serverSocket.accept();

		// imprime o ip do cliente
		System.out.println("Nova conexão com o cliente " +
				socket.getInetAddress().getHostAddress());
		//Cria um canal para receber dados.
		DataInputStream fluxoEntrada = new
				DataInputStream(socket.getInputStream());
		//Cria um canal para enviar dados.
		DataOutputStream fluxoSaida = new
				DataOutputStream(socket.getOutputStream());
		String msg = fluxoEntrada.readUTF(); //Aguarda o recebimento de uma string.

		System.out.println("--> Mensagem recebida do cliente: " + msg);

		Inverte inv = new Inverte(msg);
		
		String msgInvertida = inv.inverter(msg);

		System.out.println("--> Servidor enviando mensagem: " + msgInvertida);

		fluxoSaida.writeUTF(msg); //Envia uma string. 
		//Fecha os canais in e out do socket que estão atendendo ao cliente
		fluxoEntrada.close();
		fluxoSaida.close();
		//Fecha o socket para o cliente.
		socket.close();
		System.out.println("*****Conexão finalizada*****\n");
		//Fechando o servidor.
		serverSocket.close(); 
	}

}
