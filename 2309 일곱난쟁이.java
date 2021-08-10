import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] h;
	static int[] selected;
	static boolean flag = false;
	
	private static void combination(int cnt, int start) {
		if (flag == true) return;
		
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += selected[i];
			}
			
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(selected[i]);
				}
				flag = true;
			}
			
			return;
		}
		
		for (int i = start; i < 9; i++) {
			selected[cnt] = h[i];
			combination(cnt + 1, i + 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		h = new int[9];
		selected = new int[7];
		for (int i = 0; i < 9; i++) {
			h[i] = Integer.parseInt(in.readLine());
		}
		
		Arrays.sort(h);
		combination(0, 0);	
	}
	
}
