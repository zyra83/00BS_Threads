package model.entities;

public class Lanceur {

	public static void main(String[] args) {
//		go();
		goThread();
	}

	/**
	 * Instancier un {@link Lievre} et une {@link Tortue} et les faire courir.
	 */
	private static void go() {
		new Tortue().courir();
		new Lievre().courir();
	}

	/**
	 * Instancier un {@link Lievre} et une {@link Tortue} et les faire courir.
	 */
	private static void goThread() {
		Thread tt = new ThreadTortue();
		Thread tl = new ThreadLievre();
		tt.start();
		tl.start();

		
		// ça c'est dans le Thread principal, pas bloqué par les 2 autres Thread.
		System.out.println("FIN DE LA COURSE");
		try {
			tt.join();
			tl.join();
		} catch (Exception e) {
		}
		System.out.println("FIN DE LA COURSE EN VRAI");
		
		System.out.println("REVANCHE");
		tt.start();
		tl.start();
		
		
	}

}
