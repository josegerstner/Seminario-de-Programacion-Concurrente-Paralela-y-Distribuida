package spcpd;

public class RandezVous {
	public Integer S1 = 1, S2 = 1;
	RandezVousAlgorithm p1, p2;
	static Thread t1, t2;

	public RandezVous() {
		p1 = new RandezVousAlgorithm(S1);
		p2 = new RandezVousAlgorithm(S2);
		p1.setej(this);
		p2.setej(this);
		p1.setOtro(p2);
		p2.setOtro(p1);
		
		t1 = new Thread(p1);
		t2 = new Thread(p2);

	}

	public static void main(String[] args) {
		new RandezVous();
		
		t2.start();
		t1.start();
	}

}

class RandezVousAlgorithm implements Runnable {
	public Integer S = 1;
	public RandezVous ej;
	RandezVousAlgorithm otro;
	
	public RandezVousAlgorithm(int S) {
		this.S = S;
	}

	public void setej(RandezVous a) {
		ej = a;
	}
	
	void setOtro(RandezVousAlgorithm p) {
		this.otro = p;
	}
	void seccion_no_critica() {
		System.out.println("\tSNC" + String.valueOf(S));
	}

	void seccion_critica() {
		System.out.println("SC" + String.valueOf(S));
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 100)

		{
			seccion_no_critica();
			otro.S = 1;
			while (this.S != 1) {
			}
			
			seccion_critica();
			
			this.S = 0;
			
			i++;
		}
	}
}
