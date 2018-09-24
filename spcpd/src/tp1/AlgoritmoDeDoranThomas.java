package tp1;

public class AlgoritmoDeDoranThomas implements Runnable {
	public int turno;
	public Boolean want = false;
	public TP1 tp;
	AlgoritmoDeDoranThomas otro;
	String turnoTxt = "0";
	private int i = 0;
	
	public AlgoritmoDeDoranThomas(int C) {
		this.turno = C;
	}

	public void setOtroAlgoritmoDeDoranThomas(AlgoritmoDeDoranThomas otro) {
		this.otro = otro;
	}
	
	public void setej(TP1 tp) {
		this.tp = tp;
	}
	
	void seccion_no_critica() {
		turnoTxt = String.valueOf(Integer.valueOf(turno));
		System.out.println("SNC" + turnoTxt);
	}

	void seccion_critica() {
		turnoTxt = String.valueOf(Integer.valueOf(turno));
		System.out.println("Entra SC" + turnoTxt);
		System.out.println("Sale SC" + turnoTxt);
	}

	@Override
	public void run() {
		while (i < 100)
		{
			seccion_no_critica();
			
			// precondición
			if(tp.C == otro.turno) {
				this.want = false;
				while(tp.C != this.turno) {}
				this.want = true;
			}
			while(otro.want != false) {}
			
			seccion_critica();
			
			// postcondición
			this.want = false;
			tp.C = otro.turno;
			i++;
		}
	}
}