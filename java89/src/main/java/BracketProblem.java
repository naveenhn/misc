import java.util.Scanner;
import java.util.Stack;

public class BracketProblem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			System.out.println(isBalancedParanthesis(str));
		}
		
		
	}
	
	static boolean  isBalancedParanthesis(String str){
		 final Stack<Character> st = new Stack<>();
		for (int i = 0; i < str.toCharArray().length; i++) {
			char c = str.charAt(i);
		
			
			if(c == '[' || c == '{' || c == '(') st.push((char) c);
			else if (c == ')' || c == '}' || c == ']') {
				if(st.empty()) return false;
				else if (!isMatchingPair(st.pop(), c)) return false;
				
			}
			
		} 
		
		if(!st.isEmpty()) return false;
		return true;
	}
	
	static boolean isMatchingPair(char a, char b) {
		if(a == '[' && b == ']') return true;
		else if( a == '(' && b == ')') return true;
		else if (a == '{' && b =='}') return true;
		else return false;
	}
	
	

}
