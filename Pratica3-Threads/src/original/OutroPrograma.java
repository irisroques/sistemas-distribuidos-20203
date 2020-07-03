package original;

public class OutroPrograma implements Runnable {

	private int id;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 1000; i < 2000; i++) {
			System.out.println("outro programa" + id + " valor: " + i);
			
			try {
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
