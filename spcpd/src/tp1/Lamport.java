package tp1;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Lamport extends Thread {

	EjecutarLamport parent;
	Boolean want = false;
	Integer number;
	Integer ejecuciones = 20;

	public Lamport(EjecutarLamport el, Integer n) {
		parent = el;
		number = n;
	}

	public Lamport(EjecutarLamport el, Integer n, Integer veces) {
		parent = el;
		number = n;
		ejecuciones = veces;
	}

	@Override
	public void run() {

		for (int i = 0; i < ejecuciones; i++) {// loop infinito
			seccionNoCritica();// SNC
			// esperar();
			prueba();// for hasta el go to
			esperar();
			seccionCritica();// seccion Critica
			esperar();
			want = false;
		}
	}

//	private void prueba() {
//		want = true;
//		Lamport aux = primeroQueCumpla();
//		if (aux != null) {
//			want = false;
//			while (aux.want) {
//			}
//			prueba();
//		}
//		while (algunoEsVerdadero()) {
//		}
//	}

	private void prueba() {
		want = true;
		if (algunoEsVerdadero()) {
			want = false;
			while (algunoEsVerdadero()) {
			}
			want = true;
			 prueba();
		}
		while (algunoEsVerdadero()) {
		}
	}

	private void seccionCritica() {
		System.err.println("\nEntra Seccion Critica " + number);
		System.err.println("Ejecuta Seccion Critica " + number);
		System.err.println("Sale Seccion Critica " + number + "\n");
		parent.vecesSeccionCritica++;
	}

	private void seccionNoCritica() {
		System.out.println("\nSeccion No Critica " + number + "\n");
	}

	private Boolean algunoEsVerdadero() {
		// ArrayList<Lamport> aux = new ArrayList<>(parent.procesos);
		// aux.remove(this);
		for (Lamport lamp : parent.procesos) {
			if (lamp.want && !lamp.equals(this)) {
				return true;
			}
		}
		return false;
	}

	private Lamport primeroQueCumpla() {
		for (Lamport lamp : parent.procesos) {
			if (lamp.want && !lamp.equals(this)) {
				return lamp;
			}
		}

		return null;
	}

	private void esperar() {
		// Random random = new Random();
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
