import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// n, r, c를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		double r = Integer.parseInt(st.nextToken());
		double c = Integer.parseInt(st.nextToken());
		
		// 결과 출력
		System.out.println((int) solution(r, c, n));		
	}
	
	public static double solution(double r, double c, int n) {
		// 기저 조건
		if (n == 1) {
			if (r == 0 && c == 0) return 0;
			if (r == 0 && c == 1) return 1;
			if (r == 1 && c == 0) return 2;
			if (r == 1 && c == 1) return 3;
		}
		
		// 4부분으로 나누어서 재귀적으로 해결
		if (r < Math.pow(2, n - 1) && c < Math.pow(2, n - 1)) {
			return solution(r, c, n - 1);
		}
		else if (r < Math.pow(2, n - 1) && c >= Math.pow(2, n - 1)) {
			return Math.pow(2,  2 * (n - 1)) + solution(r, c - Math.pow(2, n - 1), n - 1);
		}
		else if (r >= Math.pow(2, n - 1) && c < Math.pow(2, n - 1)) {
			return 2 * Math.pow(2,  2 * (n - 1)) + solution(r - Math.pow(2, n - 1), c, n - 1);
		}
		else {
			return 3 * Math.pow(2,  2 * (n - 1)) + solution(r - Math.pow(2, n - 1), c - Math.pow(2, n - 1), n - 1);
		}
	}
	
}
