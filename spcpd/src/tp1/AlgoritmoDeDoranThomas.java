package tp1;

public class AlgoritmoDeDoranThomas extends Algoritmo {
	
	AlgoritmoDeDoranThomas otro;
	public boolean want = false;
	public int turn = 1;
	
	public AlgoritmoDeDoranThomas(int C) {
		super(C);
	}
	
	public AlgoritmoDeDoranThomas(int C, int repeticiones) {
		super(C, repeticiones);
	}

	public void setOtroAlgoritmoDeDoranThomas(AlgoritmoDeDoranThomas otro) {
		this.otro = otro;
	}
	
	@Override
	void precondicion(){
		want = true;
		if (otro.want) {
			comprobarTurno();
		}
	}
	
	@Override
	void postcondicion() {
		this.logger.println("P" + turno + ".3: this.want = 0; INICIO");
		want = false;
		turn = otro.turno;
		otro.turn = otro.turno;
		this.logger.println("P" + turno + ".3: this.want = 0; FIN");	
	}
	
	private void comprobarTurno() {
		if (turn == otro.turno) {
			want = false;
			while (turn != turno) {
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
		turn = otro.turno;
		otro.turn = otro.turno;
	}
}