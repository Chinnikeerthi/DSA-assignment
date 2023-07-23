
import java.util.*;
import java.io.*;
import java.util.*;

public class Stack2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			String input = in.next();
			System.out.println(balanaced(input));
		}
	}
	
	public static boolean balanaced(String s) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c =='[' || c == '(' || c == '{') {
				stack.push(c);
			}else if(c == ']') {
				if(stack.isEmpty() || stack.pop() != '[') {
					return false;
				}
			}else if(c == ')') {
				if(stack.isEmpty() || stack.pop() != '(') {
					return false;
				}
			}else if(c == '}') {
				if(stack.isEmpty() || stack.pop() != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
		
	}
}