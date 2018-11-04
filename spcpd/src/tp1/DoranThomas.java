package tp1;

public class DoranThomas implements Runnable {

	Boolean want = false;
	Boolean turn = true;
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
		System.out.println("Seccion NO Critica" + number);
	}

	public void seccionCritica() {
		System.out.println("\n");

		System.out.println("Entra en Seccion Critica" + number);
		System.out.println("Ejecuta Seccion Critica" + number);
		System.out.println("Sale de Seccion Critica" + number);

		System.out.println("\n");
	}

	public Boolean want() {
		return want;
	}

	@Override
	public void run() {

		for (int i = 0; i < cantidadDeVecesQueSeEjecuta; i++) {
			seccionNoCritica();
			want = true;
			if (getOtro().want()) {
				comprobarTurno();
			}

			seccionCritica();
			terminarEjecucion();
		}

	}

	private void comprobarTurno() {
		if (turn) {
			want = false;
			while (turn) {
			}
			want = true;
			while (getOtro().want) {
			}
		}
	}

	void terminarEjecucion() {
		want = false;
		turn = !turn;
		getOtro().turn = !getOtro().turn;
	}

	public DoranThomas getOtro() {
		return otro;
	}

	public void setOtro(DoranThomas otro) {
		this.otro = otro;
	}

}
