package model.entities;

public class Lanceur {

	public static void main(String[] args) {
		// go();
		// goThread();
		goRunnable();
	}

	private static void goRunnable() {
		Lievre l = new Lievre();
		Tortue t = new Tortue();

//		// Classe anonyme
//		Runnable rla = new Runnable() {
//
//			@Override
//			public void run() {
//				l.courir();
//			}
//		};

		// Version lambda
		Runnable rll = () -> l.courir();
		Runnable rlt = () -> t.courir();
		
		new Thread(rll, "Course du lièvre").start();;
		new Thread(rlt, "Course de la tortue").start();

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

		// Appelle RUN dans un autre Thread
		tt.start();
		tl.start();

		// Appelle RUN dans le même Thread, c'est pas bon !!
		// tt.run();
		// tl.run();

		// ça c'est dans le Thread principal, pas bloqué par les 2 autres
		// Thread.
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
