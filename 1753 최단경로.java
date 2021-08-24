import java.io.*;
import java.util.*;

public class Main {
	
	static class Node implements Comparable<Node> {
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Node other) {
			if (this.distance < other.distance) {
				return -1;
			}
			return 1;
		}
	}
	
	static final int INF = Integer.MAX_VALUE;
	static int v, e, start;
	static ArrayList<ArrayList<Node>> graph;
	static int[] d;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// v, e, 시작 정점 번호를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		v = Integer.parseInt(st.nextToken()); 
		e = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(in.readLine());
		
		// graph 2차원 ArrayList 생성
		graph = new ArrayList<ArrayList<Node>>();
		for (int i = 0; i <= v; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		// distance 배열을 생성하고 무한으로 초기화
		d = new int[v + 1];
		Arrays.fill(d, INF);
		
		// graph 정보를 입력받음
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new Node(b, w));
		}
		
		// 다익스트라 알고리즘 수행
		dijkstra(start);
		
		// 출력문 생성
		for (int i = 1; i <= v; i++) {
			if (d[i] == INF) {
				sb.append("INF");
			}
			else {
				sb.append(d[i]);
			}
			sb.append("\n");
		}
		
		// 결과 출력
		System.out.println(sb);
	}
	
	// 다익스트라 알고리즘
	private static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			int dist = node.distance;
			int now = node.index;
			
			if (d[now] < dist) continue;
			
			for (int i = 0; i < graph.get(now).size(); i++) {
				int cost = d[now] + graph.get(now).get(i).distance;
				if (cost < d[graph.get(now).get(i).index]) {
					d[graph.get(now).get(i).index] = cost;
					pq.offer(new Node(graph.get(now).get(i).index, cost));
				}
			}
		}
	}
	
}
