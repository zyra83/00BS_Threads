package model.entities;

public class Lanceur {

	public static void main(String[] args) {
		go();
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
		new ThreadTortue().start();
		new ThreadLievre().start();
	}

}
