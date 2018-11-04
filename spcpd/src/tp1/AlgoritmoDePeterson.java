package tp1;

import java.io.PrintStream;
import java.util.Random;
import java.util.concurrent.TimeUnit;
//import java.util.function.Function;

public class AlgoritmoDePeterson implements Runnable {
	public int id;
	public Boolean want = false;
	public TP1 tp;
	AlgoritmoDePeterson otro;
	private int i = 0;
	private String caracterEspecial = "";
	private PrintStream logger;
	private int tiempoAEsperar = 10;
	
	public AlgoritmoDePeterson(int id) {
		this.id = id;
		if( id == 1) {
			this.caracterEspecial = "***************************";
			this.logger = System.err;
		} else {
			this.caracterEspecial = "---------------------------";
			this.logger = System.out;
		}
	}

	public void setOtroAlgoritmoDePeterson(AlgoritmoDePeterson otro) {
		this.otro = otro;
	}
	
	public void setej(TP1 tp) {
		this.tp = tp;
	}
	
	void seccion_no_critica() {
		this.logger.println("P" + id + ".1: Seccion NO Critica");
	}

	void seccion_critica() {
		this.logger.println("");
		this.logger.println(this.caracterEspecial + "Seccion Critica " + id + " Paso 1" + this.caracterEspecial);
		this.logger.println(this.caracterEspecial + "Seccion Critica " + id + " Paso 2" + this.caracterEspecial);
		this.logger.println(this.caracterEspecial + "Seccion Critica " + id + " Paso 3" + this.caracterEspecial);
		this.logger.println("");
	}

	@Override
	public void run() {
		while (i < 100)
		{
			this.logger.println("");
			this.logger.println("P" + id + " ITERACION " + i );
			this.logger.println("");
			seccion_no_critica();
			
			// precondici�n
			this.logger.println("P" + id + ".2: this.want = true; INICIO");
			this.want = true;//Activo el flag de que quiero entrar a la seccion critica
			esperar();
			this.logger.println("P" + id + ".2: this.want = true; FIN");
			
			this.logger.println("P" + id + ".3: tp.last = this.id; INICIO");
			tp.last = this.id;//Me notifico como el ultimo
			esperar();
			this.logger.println("P" + id + ".3: tp.last = this.id; FIN");
			
			this.logger.println("P" + id + ".4: while(otro.want && tp.last == this.id) {}| "  + (otro.want && tp.last == this.id) + " | want = " + want + " | otro.want = " + otro.want + " | tp.last = " + tp.last + "| ");
			while(otro.want && tp.last == this.id) { 
				esperar(); 
			}//Si el otro tambien quiere, y el ultimo soy yo, me quedo esperando hasta que cambie uno de los dos flags. 
			
			seccion_critica();
			esperar();
			
			this.logger.println("P" + id + ".5: this.want = false; INICIO");
			// postcondici�n
			this.want = false;// Notifico que termine poniendo que no quiero mas la seccion critica.
			esperar();
			this.logger.println("P" + id + ".5: this.want = false; FIN");
			
			i++;
			
			/**
			 * 			// precondici�n
			ejecutarSincronizado( ()->{this.want = true;}, "P" + turnoTxt + ".2: this.want = true;" );
			ejecutarSincronizado( ()->{tp.last = this.last;}, "P" + turnoTxt + ".3: tp.last = this.last;" );
			
			ejecutarSincronizado( ()->{while(otro.want && tp.last == otro.last) {}}, "P" + turnoTxt + ".4: while(otro.want && tp.last == otro.last) {}| want = " + want + " | otro.want = " + otro.want + " | tp.last = " + tp.last + "|" );
			
			seccion_critica();
			
			// postcondici�n
			ejecutarSincronizado( ()->{this.want = false;}, "P" + turnoTxt + ".5: this.want = false;" );

			ejecutarSincronizado( ()->{i++;}, "P" + turnoTxt + ".6: i++;" );
			 */
		}
	}
	
	private void esperar() {
		Random random = new Random();
		try {
			TimeUnit.MILLISECONDS.sleep( random.nextInt(tiempoAEsperar) );
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected synchronized void ejecutarSincronizado(Runnable codigo , String log) {
		this.logger.println(log);
		codigo.run();
	}
}