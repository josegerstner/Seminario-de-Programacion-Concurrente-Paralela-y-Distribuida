package tp1;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AlgoritmoDeMannaPnueli implements Runnable {
	public int turno;
	public int want = 0;
	public TP1 tp;
	AlgoritmoDeMannaPnueli otro;
	String turnoTxt = "0";
	private int i = 0;
	private String caracterEspecial = "";
	private PrintStream logger;
	
	public AlgoritmoDeMannaPnueli(int C) {
		this.turno = C;
		if( turno == 1) {
			this.caracterEspecial = "***************************";
			this.logger = System.err;
		} else {
			this.caracterEspecial = "---------------------------";
			this.logger = System.out;
		}
	}

	public void setOtroAlgoritmoDeMannaPnueli(AlgoritmoDeMannaPnueli otro) {
		this.otro = otro;
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
		while (i < 100)
		{
			this.logger.println("");
			this.logger.println("P" + turno + " ITERACION " + i );
			this.logger.println("");
			seccion_no_critica();
			
			// precondicion
			if(otro.want == -1) {
				if(this.turno == 1) {
					this.logger.println("P" + turno + ".2: this.want = -1; INICIO");
					this.want = -1;
					this.logger.println("P" + turno + ".2: this.want = -1; FIN");
				}
				else {
					this.logger.println("P" + turno + ".2: this.want = 1; INICIO");
					this.want = 1;
					this.logger.println("P" + turno + ".2: this.want = 1; FIN");
				}
			}
			else
				if(this.turno == 1) {
					this.logger.println("P" + turno + ".2: this.want = 1; INICIO");
					this.want = 1;
					this.logger.println("P" + turno + ".2: this.want = 1; FIN");
				}
				else {
					this.logger.println("P" + turno + ".2: this.want = -1; INICIO");
					this.want = -1;
					this.logger.println("P" + turno + ".2: this.want = -1; FIN");
				}
			
			while(otro.want == this.want) {
				try {
					Random random = new Random();
					TimeUnit.MILLISECONDS.sleep( random.nextInt(1000) );
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
			}
			
			seccion_critica();
			
			// postcondicion
			this.logger.println("P" + turno + ".3: this.want = 0; INICIO");
			this.want = 0;
			this.logger.println("P" + turno + ".3: this.want = 0; FIN");			
			i++;
		}
	}
}