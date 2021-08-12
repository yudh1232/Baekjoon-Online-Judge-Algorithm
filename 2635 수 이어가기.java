import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 첫번째 수를 입력받음
		int n = Integer.parseInt(in.readLine());
		
		int max = 0; // 수들의 최대 개수
		int maxI = 0; // 두번째 수
		
		// 두번째 수로 1부터 n까지를 해보고,
		// 그 중에서 최대 개수를 나오게 하는 두번째 수를 maxI에 넣음
		for (int i = 1; i <= n; i++) {
			int prePre = n;
			int pre = i;
			int count = 2;
			while (true) {
				int now = prePre - pre;
				if (now < 0) break;
				
				prePre = pre;
				pre = now;
				count++;
			}
			if (count > max) {
				max = count;
				maxI = i;
			}
		}
		
		// 출력문 생성
		sb.append(max).append("\n");
		sb.append(n).append(" ").append(maxI).append(" ");
		// maxI를 이용해서 수열 생성
		int prePre = n;
		int pre = maxI;
		while (true) {
			int now = prePre - pre;
			if (now < 0) break;
			sb.append(now).append(" ");
			
			prePre = pre;
			pre = now;
		}
		
		System.out.println(sb); // 결과 출력
	}
	
}
