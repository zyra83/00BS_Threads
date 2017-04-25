package model.entities;

public class ThreadLievre extends Thread {

	public ThreadLievre() {
		super("Thread lièvre");
	}

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

			System.out.printf("[Thread:%s] Le %s a parcouru %sm%n", Thread.currentThread().getName(),
					this.getClass().getSimpleName(), i * 10);
		}
	}

	@Override
	public void run() {
		courir();
		System.out.println("Arrivée du Lièvre.");
	}

}
