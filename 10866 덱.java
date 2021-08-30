import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 덱 생성
		LinkedList<Integer> deque = new LinkedList<Integer>();
		
		// N을 입력받음
		int n = Integer.parseInt(in.readLine());
		
		for (int i = 0; i < n; i++) {
			// 명령을 입력받음
			String command = in.readLine();
			
			// 명령이 push_front일 때
			if (command.contains("push_front")) {
				deque.offerFirst(Integer.parseInt(command.substring(11)));
			}
			// 명령이 push_back일 때
			else if (command.contains("push_back")) {
				deque.offerLast(Integer.parseInt(command.substring(10)));
			}
			// 명령이 pop_front일 때
			else if (command.equals("pop_front")) {
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.pollFirst()).append("\n");
				}
			}
			// 명령이 pop_back일 때
			else if (command.equals("pop_back")) {
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.pollLast()).append("\n");
				}
			}
			// 명령이 size일 때
			else if (command.equals("size")) {
				sb.append(deque.size()).append("\n");
			}
			// 명령이 empty일 때
			else if (command.equals("empty")) {
				if (deque.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			// 명령이 front일 때
			else if (command.equals("front")) {
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.peekFirst()).append("\n");
				}
			}
			// 명령이 back일 때
			else {
				if (deque.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(deque.peekLast()).append("\n");
				}
			}
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
}
