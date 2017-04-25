package model.entities;

public class ThreadTortue extends Thread {

	/**
	 * 1 seconde pour faire 10 mètres.
	 */
	static int TEMPS = 2000;

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

	@Override
	public void run() {
		courir();
		System.out.println("Arrivée de la Tortue.");
	}

}
