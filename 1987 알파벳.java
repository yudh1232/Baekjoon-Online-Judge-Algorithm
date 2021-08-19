import java.io.*;
import java.util.*;

public class Main {

	static int r, c;
	static char[][] board;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// r, c를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		// 보드 정보를 입력받음
		board = new char[r][c];
		for (int i = 0; i < r; i++) {
			board[i] = in.readLine().toCharArray();
		}
		
		visited = new boolean[26]; // 알파벳을 지났는지 확인하는 배열
		result = 0; // 결과값
		
		// 말이 지날 수 있는 최대 칸 수 구하기(DFS)
		solution(0, 0, 0);
		
		System.out.println(result); // 결과 출력
	}

	// 말이 지날 수 있는 최대 칸 수 구하기(DFS)
	private static void solution(int x, int y, int count) {
		// 유효하지 않은 칸이라면 결과값 갱신
		if (x < 0 || y < 0 || x >= r || y >= c || visited[board[x][y] - 'A'] == true) {
			result = Math.max(result, count);
			return;
		}
		
		// 방문 표시
		visited[board[x][y] - 'A'] = true;
		
		// 상하좌우 방문
		solution(x - 1, y, count + 1);
		solution(x + 1, y, count + 1);
		solution(x, y - 1, count + 1);
		solution(x, y + 1, count + 1);
		
		// 방문 표시 해제
		visited[board[x][y] - 'A'] = false;		
	}
	
}
