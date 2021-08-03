import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] switchs = new int[n + 1];
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}
		
		int s = Integer.parseInt(in.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int g = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			if (g == 1) {
				int q = n / value;
				for (int j = 1; j <= q; j++) {
					change(switchs, j * value);
				}
			}
			else {
				change(switchs, value);
				for (int j = 1; j <= (n - 1) / 2; j++) {
					if (value - j < 1 || value + j > n || switchs[value - j] != switchs[value + j]) {
						break;
					}
					else {
						change(switchs, value - j);
						change(switchs, value + j);
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(switchs[i]);
			sb.append(" ");
			if (i % 20 == 0) {
				sb.setLength(sb.length() - 1);
				System.out.println(sb);
				sb = new StringBuilder();
			}
		}
		if (sb.length() != 0) {
			sb.setLength(sb.length() - 1);
			System.out.println(sb);
		}
		
	}

	private static void change(int[] switchs, int i) {
		if (switchs[i] == 0) switchs[i] = 1;
		else switchs[i] = 0;
	}
	
}
