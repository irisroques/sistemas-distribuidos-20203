package exercicio;

public class Soma implements Runnable {
	private int soma = 0;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSoma() {
		return soma;
	}

	public void setSoma(int soma) {
		this.soma = soma;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i <= 1000; i = i + 2) {
			soma =+i;
			System.out.println(soma);
		}
	}

}
