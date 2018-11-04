package tp1;

class Ejecutar {
	static Thread t1, t2;

	DoranThomas proceso1;
	DoranThomas proceso2;

	public Ejecutar() {

		proceso1 = new DoranThomas(1, 200);
		proceso2 = new DoranThomas(2, 100);

		proceso1.setOtro(proceso2);
		proceso2.setOtro(proceso1);

		t1 = new Thread(proceso1);
		t2 = new Thread(proceso2);
	}

	public static void main(String[] args) {
		new Ejecutar();
		System.out.println("Algoritmo de Doran Thomas.");

		t1.start();
		t2.start();
	}

}