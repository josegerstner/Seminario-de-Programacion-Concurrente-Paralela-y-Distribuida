package tp1;

import java.util.concurrent.TimeUnit;

public class DoranThomas implements Runnable {

	Boolean want = false;
	Integer turn;
	private Integer number;
	private DoranThomas otro;
	private Integer cantidadDeVecesQueSeEjecuta = 100;

	public DoranThomas(Integer numero) {
		number = numero;
	}

	public DoranThomas(Integer numero, Integer cant) {
		number = numero;
		cantidadDeVecesQueSeEjecuta = cant;
	}

	public void seccionNoCritica() {
		System.out.println("Seccion NO Critica " + number);
	}

	public void seccionCritica() {
		System.out.println("\n");

		System.err.println("Entra en Seccion Critica" + number);
		System.err.println("Ejecuta Seccion Critica" + number);
		System.err.println("Sale de Seccion Critica" + number);

		System.out.println("\n");
	}

	public Boolean want() {
		return want;
	}

	@Override
	public void run() {

		for (int i = 0; i < cantidadDeVecesQueSeEjecuta; i++) {
			seccionNoCritica();
			esperar();
			want = true;
			if (otro.want()) {
				comprobarTurno();
			}
			seccionCritica();
			terminarEjecucion();
		}

	}

	private void comprobarTurno() {
		if (turn == otro.number) {
			want = false;
			while (turn != number) {
				esperar();
			}
			want = true;
		}
		while (otro.want) {
			esperar();
		}
	}

	void terminarEjecucion() {
		want = false;
		turn = otro.number;
		otro.turn = otro.number;
	}

	public void setOtro(DoranThomas otro) {
		this.otro = otro;
	}

	private void esperar() {
		// Random random = new Random();
		try {
			TimeUnit.MILLISECONDS.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
