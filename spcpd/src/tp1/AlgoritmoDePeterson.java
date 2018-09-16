package tp1;

public class AlgoritmoDePeterson implements Runnable {
	public int last;
	public Boolean want = false;
	public TP1 tp;
	AlgoritmoDePeterson otro;
	String turnoTxt = "0";
	private int i = 0;
	
	public AlgoritmoDePeterson(int C) {
		this.last = C;
	}

	public void setOtroAlgoritmoDePeterson(AlgoritmoDePeterson otro) {
		this.otro = otro;
	}
	
	public void setej(TP1 tp) {
		this.tp = tp;
	}
	
	void seccion_no_critica() {
		turnoTxt = String.valueOf(Integer.valueOf(last));
		System.out.println("SNC" + turnoTxt);
	}

	void seccion_critica() {
		turnoTxt = String.valueOf(Integer.valueOf(last));
		System.out.println("SC" + turnoTxt);
	}

	@Override
	public void run() {
		while (i < 100)
		{
			seccion_no_critica();
			
			// precondición
			this.want = true;
			tp.C = this.last; 
			
			while(!otro.want || tp.C == otro.last) {}
			
			seccion_critica();
			
			// postcondición
			tp.C = otro.last;
			
			i++;
		}
	}
}