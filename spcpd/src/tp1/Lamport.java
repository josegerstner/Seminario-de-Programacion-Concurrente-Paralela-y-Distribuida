package tp1;

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
			if (algunoEsVerdadero()) {
				want = false;
				while (algunoEsVerdadero()) {
				}
				run();
			}
			while (algunoEsVerdadero()) {
			}
			seccionCritica();
			want = false;
		}

	}

	private void seccionCritica() {
		System.err.println("Entra Seccion Critica " + number);
		System.err.println("Ejecuta Seccion Critica " + number);
		System.err.println("Sale Seccion Critica " + number + "\n");
	}

	private void seccionNoCritica() {
		System.out.println("Seccion No Critica " + number + "\n");
	}

	private Boolean algunoEsVerdadero() {
		for (Lamport lamp : parent.procesos) {
			if (lamp.want) {
				return true;
			}
		}
		return false;
	}

}
