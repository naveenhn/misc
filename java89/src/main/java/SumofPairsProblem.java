import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SumofPairsProblem {
	
	
	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(6,2,4,4);
		int sum = 10;
		
		Set<Integer> comps = new HashSet<>();
		boolean foundSumPair = false;
		for (Integer cur : a) {
			
			if(comps.contains(cur)) {
				foundSumPair = true ; break;
			}
			
			comps.add(sum - cur);
		} 
		
		if(foundSumPair) {
			System.out.println("pair found ");
		} else {
			System.out.println("no pair found");
		}
		
	}

}
