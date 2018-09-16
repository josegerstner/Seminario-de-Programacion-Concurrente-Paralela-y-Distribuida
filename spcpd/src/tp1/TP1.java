package tp1;

/*
 * Se pide: 2 métodos diferentes de exclusión mutua entre los vistos 
 */
public class TP1 {
	
	public int C = 1;
	
	AlgoritmoDeTurno p1;
	AlgoritmoDeTurno p2;
	Runnable r1;
	Runnable r2;
	static Thread t1, t2;

	public TP1() {
		// le doy los turnos a los algoritmos
		p1 = new AlgoritmoDeTurno(1);
		p2 = new AlgoritmoDeTurno(2);
		p1.setej(this);
		p2.setej(this);
		p1.setOtroAlgoritmoDeTurno(p2);
		p2.setOtroAlgoritmoDeTurno(p1);
		t1 = new Thread(p1);
		t2 = new Thread(p2);
	}

	public static void main(String[] args) {
		new TP1();
		
		t2.start();
		t1.start();
	}

}