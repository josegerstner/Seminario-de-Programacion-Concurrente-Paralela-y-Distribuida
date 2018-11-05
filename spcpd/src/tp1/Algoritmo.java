package tp1;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Algoritmo implements Runnable {
	public int turno;
	public TP1 tp;
	protected int i = 0;
	protected int repeticiones = 100;
	protected String caracterEspecial = "";
	protected PrintStream logger;
	protected int tiempoAEsperar = 10;

	
	public Algoritmo(int C) {
		this.turno = C;
		if( turno == 1) {
			this.caracterEspecial = "***************************";
			this.logger = System.err;
		} else {
			this.caracterEspecial = "---------------------------";
			this.logger = System.out;
		}
	}
	
	public Algoritmo(int C, int repeticiones) {
		this.repeticiones = repeticiones;
		this.turno = C;
		if( turno == 1) {
			this.caracterEspecial = "***************************";
			this.logger = System.err;
		} else {
			this.caracterEspecial = "---------------------------";
			this.logger = System.out;
		}
	}
	
	public void setej(TP1 tp) {
		this.tp = tp;
	}
	
	void seccion_no_critica() {
		this.logger.println("P" + turno + ".1: Seccion NO Critica");
	}

	void seccion_critica() {
		this.logger.println("");
		this.logger.println(this.caracterEspecial + "Seccion Critica " + turno + " Paso 1" + this.caracterEspecial);
		this.logger.println(this.caracterEspecial + "Seccion Critica " + turno + " Paso 2" + this.caracterEspecial);
		this.logger.println(this.caracterEspecial + "Seccion Critica " + turno + " Paso 3" + this.caracterEspecial);
		this.logger.println("");
	}
	
	@Override
	public void run() {
		while (this.i < this.repeticiones)
		{
			this.logger.println("");
			this.logger.println("P" + turno + " ITERACION " + i );
			this.logger.println("");
			seccion_no_critica();
			
			// precondicion
			precondicion();
			
			seccion_critica();
			esperar();

			
			// postcondicion
			postcondicion();			
			esperar();
			i++;
		}
	}

	void precondicion() {}
	
	void postcondicion() {}
	
	void esperar() {
		Random random = new Random();
		try {
			TimeUnit.MILLISECONDS.sleep( random.nextInt(tiempoAEsperar) );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
