import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		// N을 입력받음
		int N = Integer.parseInt(in.readLine());
		
		// 큐 생성
		LinkedList<Integer> q = new LinkedList<Integer>();
		
		for (int n = 0; n < N; n++) {
			// 명령을 입력받음
			String command = in.readLine();
			
			// 명령이 push일 때
			if (command.length() >= 6) {
				st = new StringTokenizer(command, " ");
				st.nextToken();
				q.offer(Integer.parseInt(st.nextToken()));
			}
			// 명령이 pop일 때
			else if (command.equals("pop")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(q.poll()).append("\n");
				}
			}
			// 명령이 size일 때
			else if (command.equals("size")) {
				sb.append(q.size()).append("\n");
			}
			// 명령이 empty일 때
			else if (command.equals("empty")) {
				if (q.isEmpty()) {
					sb.append(1).append("\n");
				}
				else {
					sb.append(0).append("\n");
				}
			}
			// 명령이 front일 때
			else if (command.equals("front")) {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(q.peekFirst()).append("\n");
				}
			}
			// 명령이 back일 때
			else {
				if (q.isEmpty()) {
					sb.append(-1).append("\n");
				}
				else {
					sb.append(q.peekLast()).append("\n");
				}
			}
		}
		
		System.out.println(sb); // 결과 출력
	}
	
}
