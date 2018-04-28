/**
 * 
 */
package me.naveenhn.practice.java89.concurrent;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @author naveen
 *
 */
public class CompletableFutureExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		List<String> names = Arrays.asList("a", "b", "c");
		
	List<CompletableFuture<String>> upperNames =	
			names.stream().map(name -> CompletableFuture.supplyAsync(() -> {
				try {
					
					return doSomething(name);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return name;
			}, executorService).thenApply(str -> {
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return name;
			})
					
					
					
					.thenApply(str -> {
				System.out.println(Thread.currentThread().getName() + "- DOing somemore thing -" + str);
				return str;
			})).collect(Collectors.toList());
		
	upperNames = upperNames.stream().map(t -> {
			if(!t.isDone()) t.join();
			return t;
			
		}).collect(Collectors.toList());
	
		executorService.shutdown();
	
		
		/* List<String> list = Arrays.asList("A","B","C","D");
	        list.stream().map(data->CompletableFuture.supplyAsync(()->"Processing:"+data)).
	                map(compFuture->compFuture.thenAccept(s->System.out.println(s))).map(t->t.join())
	                .count();*/
	
	
		
	}
	
	private static String doSomething(String s) throws Exception {
		System.out.println(Thread.currentThread().getName());
		if(s.hashCode() % 2 == 0) throw new Exception("Exception");
		return s.toUpperCase();
	}
	
	
	/*public static void main(String[] args) throws InterruptedException {
        List<Integer> list = Arrays.asList(10,20,30,40);
        list.stream().map(data->CompletableFuture.supplyAsync(()->getNumber(data))).
             map(t->t.join())
                .forEach(s->System.out.println(s));
    }
    private static int getNumber(int a){
        return a*a;
    }*/

}
