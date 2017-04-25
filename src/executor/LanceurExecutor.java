package executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LanceurExecutor {

	public static void main(String[] args) {

		/**
		 * Comme un runnable mais avec un type de retour et je peux balancer
		 * uneexception.
		 */
		Callable<Integer> monCallable = new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {

				System.out.println(Thread.currentThread().getName());
				Thread.sleep(4000);
				return 3;
			}
		};

		ExecutorService execs = Executors.newSingleThreadExecutor();

		Future<Integer> f = execs.submit(monCallable);
		System.out.println("suite");
		try {
			Integer retour = f.get();
			System.out.printf("j'ai eu le retour %s%n", retour);

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		execs.shutdown();
		
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		pool.submit(monCallable);
		pool.submit(monCallable);
		pool.submit(monCallable);
		pool.submit(monCallable);
		
		pool.submit(monCallable);
		pool.submit(monCallable);
		pool.shutdown();
		

	}

}
