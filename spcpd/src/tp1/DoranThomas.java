package tp1;

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
			while (turn == otro.number) {
			}
			want = true;
			while (otro.want) {
			}
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

}
