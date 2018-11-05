package tp1;

import java.util.ArrayList;

public class EjecutarLamport {

	static Thread t1, t2, t3, t4, t5;
	Integer vecesSeccionCritica = 0;

	Lamport proceso1 = new Lamport(this, 1);
	Lamport proceso2 = new Lamport(this, 2);
	Lamport proceso3 = new Lamport(this, 3);
	Lamport proceso4 = new Lamport(this, 4);
	Lamport proceso5 = new Lamport(this, 5);

	ArrayList<Lamport> procesos = new ArrayList<>();

	public EjecutarLamport() {
		procesos.add(proceso1);
		procesos.add(proceso2);
		procesos.add(proceso3);
		procesos.add(proceso4);
		procesos.add(proceso5);

		t1 = new Thread(proceso1);
		t2 = new Thread(proceso2);
		t3 = new Thread(proceso3);
		t4 = new Thread(proceso4);
		t5 = new Thread(proceso5);

	}

	public static void main(String[] Args) {

		new EjecutarLamport();

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

}
