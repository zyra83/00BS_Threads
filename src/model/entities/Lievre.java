package model.entities;

public class Lievre {

	/**
	 * 1 seconde pour faire 10 mètres.
	 */
	static int TEMPS = 1000;

	public void courir() {
		for (int i = 0; i <= 10; i++) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("Le %s a parcouru %sm%n", this.getClass().getSimpleName(), i * 10);
		}
	}
}
