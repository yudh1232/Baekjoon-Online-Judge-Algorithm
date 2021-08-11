import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 4; i++) {
			// 2개의 직사각형의 좌표를 입력받음
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int p1 = Integer.parseInt(st.nextToken());
			int q1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken());
			int q2 = Integer.parseInt(st.nextToken());
			
			// 겹치는 부분이 직사각형
			if (x1 < p2 && y1 < q2 && p1 > x2 && q1 > y2) {
				sb.append("a").append("\n");
			}
			// 겹치는 부분이 선분
			else if ((x1 == p2 && ((y1 < y2 && y2 < q1) || (y1 < q2 && q2 < q1) || (y1 >= y2 && q1 <= q2))) || 
					(y1 == q2 && ((x1 < x2 && x2 < p1) || (x1 < p2 && p2 < p1) || (x1 >= x2 && p1 <= p2))) || 
					(p1 == x2 && ((y1 < y2 && y2 < q1) || (y1 < q2 && q2 < q1) || (y1 >= y2 && q1 <= q2))) || 
					(q1 == y2 && ((x1 < x2 && x2 < p1) || (x1 < p2 && p2 < p1) || (x1 >= x2 && p1 <= p2)))) {
				sb.append("b").append("\n");		
			}
			// 겹치는 부분이 점
			else if ((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || 
					(p1 == x2 && y1 == q2) || (p1 == x2 && q1 == y2)) {
				sb.append("c").append("\n");
			}
			// 겹치는 부분이 없음
			else if (x1 > p2 || y1 > q2 || p1 < x2 || q1 < y2) {
				sb.append("d").append("\n");
			}
		}
		
		System.out.println(sb); // 결과 출력
	}
	
}
