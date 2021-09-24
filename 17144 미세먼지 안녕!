import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 상하좌우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		// r, c, t를 입력받음
		StringTokenizer st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		// 공기청정기의 행좌표
		int top = 0;
		int bottom = 0;
		
		// 방의 정보를 입력받고 공기청정기의 행좌표를 저장
		int[][] room = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < c; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
				if (room[i][j] == -1) {
					if (top == 0) top = i;
					else bottom = i;
				}
			}
		}
		
		// 미세먼지 확산에 사용되는 배열
		int[][] delta = new int[r][c];
		
		while (t > 0) {
			// 미세먼지 확산
			for (int x = 0; x < r; x++) {
				for (int y = 0; y < c; y++) {
					if (room[x][y] >= 5) {
						int diffusion = room[x][y] / 5;
						for(int d = 0; d < 4; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
							if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
							if (room[nx][ny] == -1) continue;
							delta[nx][ny] += diffusion;
							room[x][y] -= diffusion;
						}
					}
				}
			}
			for (int x = 0; x < r; x++) {
				for (int y = 0; y < c; y++) {
					room[x][y] += delta[x][y];
					delta[x][y] = 0;
				}
			}
			
			// 공기청정기 작동
			// 위쪽, 반시계방향
			for (int i = top; i > 0; i--) room[i][0] = room[i - 1][0];
			for (int i = 0; i < c - 1; i++) room[0][i] = room[0][i + 1];
			for (int i = 0; i < top; i++) room[i][c - 1] = room[i + 1][c - 1];
			for (int i = c - 1; i > 0; i--) room[top][i] = room[top][i - 1];
			room[top][0] = -1;
			room[top][1] = 0;
			
			// 아래쪽, 시계방향
			for (int i = bottom; i < r - 1; i++) room[i][0] = room[i + 1][0];
			for (int i = 0; i < c - 1; i++) room[r - 1][i] = room[r - 1][i + 1];
			for (int i = r - 1; i > bottom; i--) room[i][c - 1] = room[i - 1][c - 1];
			for (int i = c - 1; i > 0; i--) room[bottom][i] = room[bottom][i - 1];
			room[bottom][0] = -1;
			room[bottom][1] = 0;
			
			// 시간 감소
			t--;
		}
		
		// 남아있는 미세먼지의 양 계산
		int sum = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sum += room[i][j];
			}
		}
		sum += 2;
		
		// 결과 출력
		System.out.println(sum);
	}
	
}
