package tp1;

public class AlgoritmoDeDekker implements Runnable {
	public int turno;
	public Boolean want = false;
	public TP1 tp;
	AlgoritmoDeDekker otro;
	String turnoTxt = "0";
	private int i = 0;
	
	public AlgoritmoDeDekker(int C) {
		this.turno = C;
	}

	public void setOtroAlgoritmoDeDekker(AlgoritmoDeDekker otro) {
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
			this.want = true;
			while(otro.want) {
				if(tp.C == otro.turno) {
					this.want = false;
					while (tp.C != this.turno) {}
					this.want = true;
				}
			}
			
			seccion_critica();
			
			// postcondición
			tp.C = otro.turno;
			
			i++;
		}
	}
}