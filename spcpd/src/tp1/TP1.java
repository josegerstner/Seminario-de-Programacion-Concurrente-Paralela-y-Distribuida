package tp1;

/*
 * Se pide: 2 métodos diferentes de exclusión mutua entre los vistos 
 */
public class TP1 {
	
	public int C = 1;
	
	AlgoritmoDeTurno turno1, turno2;
	AlgoritmoDeDekker dekker1, dekker2;
	AlgoritmoDePeterson peterson1, peterson2;
	static Thread 
	hiloDeTurno1, hiloDeTurno2,
	hiloDeDekker1, hiloDeDekker2,
	hiloDePeterson1, hiloDePeterson2
	;

	public TP1() {
		// le doy los turnos a los algoritmos de turnos
		turno1 = new AlgoritmoDeTurno(1);
		turno2 = new AlgoritmoDeTurno(2);
		turno1.setej(this);
		turno2.setej(this);
		turno1.setOtroAlgoritmoDeTurno(turno2);
		turno2.setOtroAlgoritmoDeTurno(turno1);
		hiloDeTurno1 = new Thread(turno1);
		hiloDeTurno2 = new Thread(turno2);
		
		// le doy los turnos a los algoritmos de Dekker
		dekker1 = new AlgoritmoDeDekker(1);
		dekker2 = new AlgoritmoDeDekker(2);
		dekker1.setej(this);
		dekker2.setej(this);
		dekker1.setOtroAlgoritmoDeDekker(dekker2);
		dekker2.setOtroAlgoritmoDeDekker(dekker1);
		hiloDeDekker1 = new Thread(dekker1);
		hiloDeDekker2 = new Thread(dekker2);
		
		// le doy los turnos a los algoritmos de Dekker
		peterson1 = new AlgoritmoDePeterson(1);
		peterson2 = new AlgoritmoDePeterson(2);
		peterson1.setej(this);
		peterson2.setej(this);
		peterson1.setOtroAlgoritmoDePeterson(peterson2);
		peterson2.setOtroAlgoritmoDePeterson(peterson1);
		hiloDePeterson1 = new Thread(peterson1);
		hiloDePeterson2 = new Thread(peterson2);
	}

	public static void main(String[] args) {
		new TP1();
		
//		hiloDeTurno2.start();
//		hiloDeTurno1.start();
		
//		hiloDeDekker2.start();
//		hiloDeDekker1.start();
		
		hiloDePeterson2.start();
		hiloDePeterson1.start();
	}

}