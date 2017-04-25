package model.entities;

public class Lanceur {

	public static void main(String[] args) {
		go();
	}

	/**
	 * Instancier un {@link Lievre} et une {@link Tortue} et les faire courir.
	 */
	private static void go() {
		new Tortue().courir();
		new Lievre().courir();
	}

}
