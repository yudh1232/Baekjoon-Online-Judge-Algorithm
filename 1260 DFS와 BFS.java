import java.io.*;
import java.util.*;

public class Main {

	static boolean[][] graph;
	static boolean[] visited;
	static int n, m, v;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		// n, m, v를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		// 그래프를 행렬로 표현
		graph = new boolean[n + 1][n + 1];
		
		// 간선정보를 입력받음(양방향)
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = true;
			graph[b][a] = true;
		}
		
		// dfs 수행
		visited = new boolean[n + 1];
		visited[v] = true;
		dfs(v);
		sb.append("\n");
		
		// bfs 수행
		visited = new boolean[n + 1];
		bfs();
		
		// 결과 출력
		System.out.println(sb);
	}
	
	private static void dfs(int now) {
		sb.append(now).append(" ");
		for (int i = 1; i <= n; i++) {
			if (!visited[i] && graph[now][i]) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(v);
		visited[v] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();			
			sb.append(now).append(" ");
			
			for (int i = 1; i <= n; i++) {
				if (!visited[i] && graph[now][i]) {
					q.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	
}
