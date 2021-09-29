import java.io.*;
import java.util.*;

public class Main {

	// x, y, distance를 담는 클래스 생성
	static class Node implements Comparable<Node> {
		int x, y;
		int distance;
		
		public Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
		
		// distance를 기준으로 sort할 예정
		@Override
		public int compareTo(Node other) {
			if (this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
	}
	
	// 무한으로 10억을 설정
	static final int INF = (int) 1e9;
	
	// 상하좌우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int pNum = 1; // 문제 번호
		
		while (true) {
			// n을 입력받음, 0이 입력되면 반복종료
			int n = Integer.parseInt(in.readLine());
			if (n == 0) break;
			
			// 동굴정보를 입력받음
			int[][] cave = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(in.readLine());
				for (int j = 0; j < n; j++) {
					cave[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// distance 배열 생성, distance[0][0] <- cave[0][0], 나머지 무한
			int distance[][] = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					distance[i][j] = INF;
				}
			}
			distance[0][0] = cave[0][0];
			
			// 우선순위큐 생성하고 (0, 0)노드를 넣음
			PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.offer(new Node(0, 0, distance[0][0]));
			
			// 다익스트라
			while (!pq.isEmpty()) {
				// 우선순위큐에서 노드를 하나 꺼냄 
				Node now = pq.poll();
				int x = now.x;
				int y = now.y;
				int dist = now.distance;
				
				// 이미 처리된 노드면 통과
				if (dist > distance[x][y]) continue;
				
				// 상하좌우 탐색
				for (int d = 0; d < 4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					// 배열을 벗어나면 통과
					if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
					
					// 현재노드를 거쳐 다음 위치로의 비용 계산
					int cost = dist + cave[nx][ny];
					// 다음 위치로의 비용이 distance 배열의 값보다 작다면 갱신하고 큐에넣음
					if (cost < distance[nx][ny]) {
						distance[nx][ny] = cost;
						pq.offer(new Node(nx, ny, cost));
					}
				}
			}
			
			// 출력문 생성
			sb.append("Problem ").append(pNum).append(": ").append(distance[n - 1][n - 1]).append("\n");
			pNum++;
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
}
