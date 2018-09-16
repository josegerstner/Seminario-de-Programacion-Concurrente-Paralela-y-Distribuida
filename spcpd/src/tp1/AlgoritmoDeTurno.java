package tp1;

/* 
 * Crear rutina que implemente el "algoritmo de turno" (p y q)
 * loop forever = 1000 veces
 * ver que cumpla las 4 propiedades (exclusión mutua, deadlock, inanición, contención) 
 */
public class AlgoritmoDeTurno implements Runnable {
	public int turno = 0;
	public TP1 tp;
	AlgoritmoDeTurno otro;
	String turnoTxt = "0";
	int i = 0;
	
	public AlgoritmoDeTurno(int C) {
		this.turno = C;
	}

	public void setOtroAlgoritmoDeTurno(AlgoritmoDeTurno otro) {
		this.otro = otro;
	}
	
	public void setej(TP1 tp) {
		this.tp = tp;
	}
	
	void seccion_no_critica() {
		turnoTxt = String.valueOf(Integer.valueOf(turno));
		System.out.println("SNC" + turnoTxt);
	}

	void seccion_critica() {
		turnoTxt = String.valueOf(Integer.valueOf(turno));
		System.out.println("SC" + turnoTxt);
	}

	@Override
	public void run() {
		while (i < 100)
		{
			seccion_no_critica();
			while (tp.C != this.turno) { }
			tp.C = 0;
			seccion_critica();
			tp.C = otro.turno;
			i++;
		}
	}
}
