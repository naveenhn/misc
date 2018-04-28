/**
 * 
 */
package me.naveenhn.practice.java89.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * @author naveen
 *
 */
public class StreamExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Without stream API
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		           
		
		System.out.println("Without lamda/streams");
		for(int i:numbers){
		    if(i%2 ==0)
		    System.out.println(i);
		}
		
		//with just lambda
		System.out.println("Using Lamda");
		numbers.forEach(n -> { if(n%2 ==0) System.out.println(n);});
		
		System.out.println("Using streams");
		//with streams
		numbers.stream().filter(n -> n%2 == 0).forEach(System.out::println);
		
		System.out.println("Square even number");
		numbers.stream().filter(n -> n%2 == 0).mapToInt(m -> m*m).forEach(System.out::println);
		
		// demonstration of reduce method add neven numbers
	    int even =
	       numbers.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
	 
	    System.out.println(even);
	    
	    System.out.println(numbers.parallelStream().filter(x-> x%2==0).mapToInt(x->x*x).sum());
		
		
		System.out.println("Chars number");
		IntStream s = "Hello123".chars();
		s.forEach(e -> System.out.print((char)e));
		
		
		String str = "My name is Naveen";
		
	
		Stream<String> words1 = Arrays.stream(str.split(" "));
		
		Map<String, Long> wordToCountMap = words1.collect(groupingBy(n -> n, counting()));
		wordToCountMap.forEach((k, v) -> System.out.println(k + "-" + v));
		
		
		
		
		
		
	}

}
