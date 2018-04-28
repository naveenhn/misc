/**
 * 
 */
package me.naveenhn.practice.java89.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author naveen
 *
 */
public class LamdaExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Thread th = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Running thread with innner class, this will create a separate class when compiled");
				
			}
		});
		
		
	Thread th1 = new Thread(() -> System.out.println("Runnable thread using lamda"));
	
	th.start();
	th1.start();
	
	
	Adder adder = (a, b) -> a + b; //definition of sum as lambda expression
	
	System.out.println("Sum of two number 1,5 = " + adder.sum(1, 5));
	
	
	List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 6,7,8);
	a.forEach(t -> System.out.print(t)); //consumer functional interface accepts 1 item and expression does the work on that item
	
	a.forEach(t -> { if(t%2 == 0) System.out.println(t + " is even number!");});
	
	
	

	}
	
	@FunctionalInterface
	public interface Adder{
		
		int sum(int a, int b);
	}

}
