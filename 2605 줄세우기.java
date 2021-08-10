import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(in.readLine());
		int[] number = new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		
		LinkedList<Integer> line = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			line.add(i - number[i], i + 1);
		}
		
		for (int i = 0; i < n; i++) {
			sb.append(line.get(i)).append(" ");
		}
		
		sb.setLength(sb.length() - 1);
		System.out.println(sb);
	}
}
