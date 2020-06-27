package sockets.tcp.servidor.invertido;

public class Inverte {
	String msg;

	public Inverte(String msg) {
		super();
		this.msg = msg;
	}
	
	public String inverter(String msg) {
		String msgInvertida;
		
		msgInvertida = new StringBuilder(msg).reverse().toString();
		
		return msgInvertida;
	}
	
	
}
