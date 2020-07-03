package exercicio;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Soma s = new Soma();
		s.setId(1);
		Thread t1 = new Thread(s);
		t1.start();
		
		Armazena a = new Armazena();
		a.setId(2);
		
		Thread t2 = new Thread(a);
		t2.start();

	}

}
