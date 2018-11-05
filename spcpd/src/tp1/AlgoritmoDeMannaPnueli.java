package tp1;

public class AlgoritmoDeMannaPnueli extends Algoritmo {
	
	public AlgoritmoDeMannaPnueli(int C) {
		super(C);
	}
	
	public AlgoritmoDeMannaPnueli(int C, int repeticiones) {
		super(C, repeticiones);
	}

	public void setOtroAlgoritmoDeMannaPnueli(AlgoritmoDeMannaPnueli otro) {
		super.setOtroAlgoritmo(otro);
	}
	
	@Override
	void precondicion(){
		if(otro.want == -1) {
			if(this.turno == 1) {
				this.logger.println("P" + turno + ".2: this.want = -1; INICIO");
				this.want = -1;
				this.logger.println("P" + turno + ".2: this.want = -1; FIN");
				esperar();
			}
			else {
				this.logger.println("P" + turno + ".2: this.want = 1; INICIO");
				this.want = 1;
				this.logger.println("P" + turno + ".2: this.want = 1; FIN");
				esperar();
			}
		}
		else {
			if(this.turno == 1) {
				this.logger.println("P" + turno + ".2: this.want = 1; INICIO");
				this.want = 1;
				this.logger.println("P" + turno + ".2: this.want = 1; FIN");
				esperar();
			}
			else {
				this.logger.println("P" + turno + ".2: this.want = -1; INICIO");
				this.want = -1;
				this.logger.println("P" + turno + ".2: this.want = -1; FIN");
				esperar();
			}
		}
		
		this.logger.println("P" + turno + ".3: this.want = " + this.want + " | otro.want = " + otro.want + ";");
		if(this.turno == 1) {
			while(otro.want == this.want) {
				esperar();
			}
		} else {
			while(otro.want == -this.want) {
				esperar();
			}
		}
	}
	
	@Override
	void postcondicion() {
		this.logger.println("P" + turno + ".3: this.want = 0; INICIO");
		this.want = 0;
		this.logger.println("P" + turno + ".3: this.want = 0; FIN");	
	}
}