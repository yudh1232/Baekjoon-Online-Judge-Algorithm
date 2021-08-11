import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int c = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(in.readLine());
		
		if (k > c * r) {
			System.out.println(0);
		}
		else {
			int x = 1, y = 0; // 시작점
			int count = 0; // 한칸씩 움직일때마다 count 1 증가

			// r만큼 위로 가고, c - 1만큼 오른쪽으로 가고,
			// r - 1만큼 아래로 가고, c - 2만큼 왼쪽으로 가는 것을 반복
			// 위 싸이클을 돌때마다 r과 c를 2씩 줄임 
			// count가 k가되면 반복 종료
			loop:
			while (true) {
				// r또는 c가 0일 때
				if (r == 0 || c == 0) break;
				// r과 c 모두 0이 아니고, r이 1일 때
				else if (r == 1) {
					y += 1;
					if (count == k) {
						break loop;
					}
					for (int i = 1; i <= c - 1; i++) {
						x += 1;
						count += 1;
						if (count == k) {
							break loop;
						}
					}
				}
				// r과 c 모두 0이 아니고, r이 1이 아니고, c가 1일 때
				else if (c == 1) {
					for (int i = 1; i <= r; i++) {
						y += 1;
						count += 1;
						if (count == k) {
							break loop;
						}
					}
				}
				
				// r만큼 위로
				for (int i = 1; i <= r; i++) {
					y += 1;
					count += 1;
					if (count == k) {
						break loop;
					}
				}
				
				// c - 1만큼 오른쪽으로
				for (int i = 1; i <= c - 1; i++) {
					x += 1;
					count += 1;
					if (count == k) {
						break loop;
					}
				}
				
				// r - 1만큼 아래로
				for (int i = 1; i <= r - 1; i++) {
					y -= 1;
					count += 1;
					if (count == k) {
						break loop;
					}
				}
				
				// c - 2만큼 왼쪽으로
				for (int i = 1; i <= c - 2; i++) {
					x -= 1;
					count += 1;
					if (count == k) {
						break loop;
					}
				}
				
				// 싸이클을 돌았으면 r과 c를 2씩 줄임
				r -= 2;
				c -= 2;
				
			}
			
		System.out.println(x + " " + y); // 결과 출력
		}
	}
	
}
