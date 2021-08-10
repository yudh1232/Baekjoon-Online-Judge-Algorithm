import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] h;
	static int[] selected;
	static boolean flag = false;
	
	private static void combination(int cnt, int start) {
		// 합이 100인 조합이 완성됐다면
		if (flag == true) return;
		
		// 7개를 뽑았다면
		if (cnt == 7) {
			int sum = 0;
			for (int i = 0; i < 7; i++) {
				sum += selected[i];
			}
			
			// 합이 100이라면 출력
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					System.out.println(selected[i]);
				}
				flag = true;
			}
			
			return;
		}
		
		// 조합
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
		
		// 오름차순으로 조합을 만들기 위해 정렬
		Arrays.sort(h);
		// 조합
		combination(0, 0);
	}
	
}
