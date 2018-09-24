package tp1;

/*
 * Se pide: 2 métodos diferentes de exclusión mutua entre los vistos 
 */
public class TP1 {
	
	public int C = 1;
	
	AlgoritmoDeTurno turno1, turno2;
	AlgoritmoDeDekker dekker1, dekker2;
	AlgoritmoDePeterson peterson1, peterson2;
	AlgoritmoDeMannaPnueli mannaPnueli1, mannaPnueli2;
	AlgoritmoDeDoranThomas doranThomas1, doranThomas2;
	static Thread 
	hiloDeTurno1, hiloDeTurno2,
	hiloDeDekker1, hiloDeDekker2,
	hiloDePeterson1, hiloDePeterson2,
	hiloDeMannaPnueli1, hiloDeMannaPnueli2,
	hiloDeDoranThomas1, hiloDeDoranThomas2
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
		
		// le doy los turnos a los algoritmos de Manna-Pnueli
		mannaPnueli1 = new AlgoritmoDeMannaPnueli(1);
		mannaPnueli2 = new AlgoritmoDeMannaPnueli(2);
		mannaPnueli1.setej(this);
		mannaPnueli2.setej(this);
		mannaPnueli1.setOtroAlgoritmoDeMannaPnueli(mannaPnueli2);
		mannaPnueli2.setOtroAlgoritmoDeMannaPnueli(mannaPnueli1);
		hiloDeMannaPnueli1 = new Thread(mannaPnueli1);
		hiloDeMannaPnueli2 = new Thread(mannaPnueli2);
		
		// le doy los turnos a los algoritmos de Doran-Thomas
		doranThomas1 = new AlgoritmoDeDoranThomas(1);
		doranThomas2 = new AlgoritmoDeDoranThomas(2);
		doranThomas1.setej(this);
		doranThomas2.setej(this);
		doranThomas1.setOtroAlgoritmoDeDoranThomas(doranThomas2);
		doranThomas2.setOtroAlgoritmoDeDoranThomas(doranThomas1);
		hiloDeDoranThomas1 = new Thread(doranThomas1);
		hiloDeDoranThomas2 = new Thread(doranThomas2);
	}

	public static void main(String[] args) {
		new TP1();
		
//		System.out.println("Prueba con hilos de turno");
//		hiloDeTurno2.start();
//		hiloDeTurno1.start();
		
//		System.out.println("Prueba con hilos de Dekker");
//		hiloDeDekker2.start();
//		hiloDeDekker1.start();
		
//		System.out.println("Prueba con hilos de Peterson");
//		hiloDePeterson2.start();
//		hiloDePeterson1.start();
		
//		System.out.println("Prueba con hilos de Manna-Pnueli");
//		hiloDeMannaPnueli2.start();
//		hiloDeMannaPnueli1.start();
		
		System.out.println("Prueba con hilos de Doran-Thomas");
		hiloDeDoranThomas2.start();
		hiloDeDoranThomas1.start();
	}

}