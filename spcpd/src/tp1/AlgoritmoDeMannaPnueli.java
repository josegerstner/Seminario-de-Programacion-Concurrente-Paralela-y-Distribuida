package tp1;

public class AlgoritmoDeMannaPnueli implements Runnable {
	public int turno;
	public int want = 0;
	public TP1 tp;
	AlgoritmoDeMannaPnueli otro;
	String turnoTxt = "0";
	private int i = 0;
	
	public AlgoritmoDeMannaPnueli(int C) {
		this.turno = C;
	}

	public void setOtroAlgoritmoDeMannaPnueli(AlgoritmoDeMannaPnueli otro) {
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
		System.out.println("SC" + turnoTxt);
	}

	@Override
	public void run() {
		while (i < 100)
		{
			seccion_no_critica();
			
			// precondición
			if(otro.want == -1) {
				if(this.turno == 1)
					this.want = -1;
				else
					this.want = 1;
			}
			else
				if(this.turno == 1)
					this.want = 1;
				else
					this.want = -1;
			if(this.turno == 1)
				while(otro.want == this.want) {}
			else
				while(otro.want == - this.want) {}
			
			seccion_critica();
			
			// postcondición
			this.want = 0;
			
			i++;
		}
	}
}