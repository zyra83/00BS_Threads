package executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LanceurExecutor {
    
        public static final Logger log = Logger.getLogger(LanceurExecutor.class.getName());

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
		try {
			Integer retour = f.get();
			log.log(Level.INFO, String.format("j'ai eu le retour %s%n", retour));
		} catch (Exception e ) {
			log.log(Level.WARNING, e.getMessage(), e);
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
