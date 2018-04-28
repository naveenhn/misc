import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 
 */

/**
 * @author naveen
 *
 */
public class RainWaterStorageProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] a = { 1, 4, 2, 5, 0, 6, 2, 3, 4}; 
		int n = a.length;
		int [] left = new int [n];
		int [] right = new int [n];
		
	
		
		left[0] = a[0];		
		right[n-1] = a[n-1];
		for (int i = 1, j = n-2; i < n && j >= 0; i++, j--) {
			left[i] = Math.max(left[i-1], a[i]);
			right[j] = Math.max(right[j+1], a[j]);
			
		}
		
		int []result = new int[n];
		int total = 0;
		for (int i = 0; i < a.length; i++) {
			result [i] = Math.min(left[i], right[i]) - a[i];
			total += result[i];
		}
		
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		System.out.println(Arrays.toString(result));
		System.out.println(total);
	}

}
