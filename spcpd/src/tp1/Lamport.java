package tp1;

import java.util.ArrayList;

public class Lamport implements Runnable {

	EjecutarLamport parent;
	Boolean want = false;
	Integer number;
	Integer ejecuciones = 100;

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

		for (int i = 0; i < ejecuciones; i++) {
			seccionNoCritica();
			prueba();
			seccionCritica();
			want = false;
		}
		System.out.println(parent.vecesSeccionCritica);
	}

	private void prueba() {
		want = true;
		if (algunoEsVerdadero()) {
			want = false;
			while (algunoEsVerdadero()) {
			}
			want = true;
//			prueba();
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
		System.out.println("Seccion No Critica " + number + "\n");
	}

	private Boolean algunoEsVerdadero() {
//		ArrayList<Lamport> aux = new ArrayList<>(parent.procesos);
//		aux.remove(this);
		for (Lamport lamp : parent.procesos) {
			if (lamp.want && !lamp.equals(this)) {
				return true;
			}
		}
		return false;
	}

}
