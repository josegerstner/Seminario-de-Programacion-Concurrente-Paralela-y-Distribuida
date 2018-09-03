package spcpd;

//9. Indicar si el siguiente mecanismo entre P1 y P2 resuelve para ellos: 
// exclusión mutua, starvation, deadlock y si funciona si alguno termina
// es decir si deja de pedir recursos (contención).
//
public class Ej9 {

	public int C1 = 1, C2 = 1;
//	public int c = 1;
//	public int c2 = 1;
	P1 p1;
	P2 p2;
	Runnable r1;
	Runnable r2;
	static Thread t1, t2;

	public Ej9() {
		p1 = new P1();
		p2 = new P2();
		p1.setej(this);
		p2.setej(this);
		t1 = new Thread(p1);
		t2 = new Thread(p2);

	}

	public static void main(String[] args) {
		new Ej9();
		
		t2.start();
		t1.start();
	}

}

class P1 implements Runnable {
	public Ej9 ej;

	public void setej(Ej9 a) {
		ej = a;
	}

	void seccion_no_critica_1() {
		System.out.println("SNC1");
	}

	void seccion_critica_1() {
		System.out.println("SC1");
	}

	@Override
	public void run() {
		while (true)

		{
			seccion_no_critica_1();
			while (ej.C2 != 1) {
			}
			ej.C1 = 0;
			seccion_critica_1();
			ej.C1 = 1;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class P2 implements Runnable {
	public int C2 = 1;

	public Ej9 ej;

	public void setej(Ej9 a) {
		ej = a;
	}

	void seccion_no_critica_2() {
		System.out.println("\tSNC2");
	}

	void seccion_critica_2() {
		System.out.println("SC2");
	}

	@Override
	public void run() {
		while (true)

		{
			seccion_no_critica_2();
			while (ej.C1 != 1) {
			}
			ej.C2 = 0;
			seccion_critica_2();
			ej.C2 = 1;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
