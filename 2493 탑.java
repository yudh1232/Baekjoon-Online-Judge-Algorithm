import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] towers = new int[n + 1];
		int[] answer = new int[n + 1];
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i < n + 1; i++) {
			towers[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = n; i > 0; i--) {
			if (stack.isEmpty()) {
				stack.push(towers[i]);
				stack2.push(i);
			}
			else if (towers[i] < stack.peek()) {
				stack.push(towers[i]);
				stack2.push(i);
			}
			else if (towers[i] > stack.peek()) {
				while(true) {
					stack.pop();
					answer[stack2.pop()] = i;
					if (stack.isEmpty() || towers[i] < stack.peek()) break;
				}
				stack.push(towers[i]);
				stack2.push(i);
			}
		}
		
		while (!stack.isEmpty()) {
			stack.pop();
			answer[stack2.pop()] = 0;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < n + 1; i++) {
			sb.append(answer[i]).append(" ");
		}
		System.out.println(sb);
	}

}

