package spcpd;

//9. Indicar si el siguiente mecanismo entre P1 y P2 resuelve para ellos: 
// exclusión mutua, starvation, deadlock y si funciona si alguno termina
// es decir si deja de pedir recursos (contención).
//
public class Ej9bis {

	public int C = 1;
	P3 p1;
	P4 p2;
	Runnable r1;
	Runnable r2;
	static Thread t1, t2;

	public Ej9bis() {
		p1 = new P3();
		p2 = new P4();
		p1.setej(this);
		p2.setej(this);
		t1 = new Thread(p1);
		t2 = new Thread(p2);

	}

	public static void main(String[] args) {
		new Ej9bis();

		System.out.println(t1.getState());
		t1.start();
		t2.start();
	}

}

class P3 implements Runnable {
	public Ej9bis ej;

	public void setej(Ej9bis a) {
		ej = a;
	}

	void seccion_no_critica_1() {
		System.out.println("SNC1");
	}

	void seccion_critica_1() {
		System.out.println("Entra1");
		System.out.println("SC1");
		System.out.println("Sale1");
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 20)

		{
			seccion_no_critica_1();
			while (ej.C != 1) {
			}
			seccion_critica_1();
			if (ej.t1.getState() == ej.t2.getState()) {
				ej.C = 2;
			}
			i++;
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
	}
}

class P4 implements Runnable {
	public Ej9bis ej;

	public void setej(Ej9bis a) {
		ej = a;
	}

	void seccion_no_critica_2() {
		System.out.println("\tSNC2");
	}

	void seccion_critica_2() {
		System.out.println("\tEntra2");
		System.out.println("\tSC2");
		System.out.println("\tSale2");
	}

	@Override
	public void run() {
		int i = 0;
		while (i < 30)

		{
			seccion_no_critica_2();
			while (ej.C != 2) {
			}
			seccion_critica_2();
			if (ej.t1.getState() == ej.t2.getState()) {
				ej.C = 1;
			}

//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			i++;
		}
	}
}
