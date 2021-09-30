import sys
input = sys.stdin.readline
from collections import deque

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# n, m을 입력받음
n, m = map(int, input().split())

# 미로정보를 입력받음
maze = []
for _ in range(n):
    maze.append(list(input().rstrip()))

# bfs를 위한 visited 리스트 생성
visited = [[False] * m for _ in range(n)]

# 큐 생성하고 첫 노드를 넣음
q = deque()
q.append((0, 0, 1))
visited[0][0] = True

# bfs
while q:
    # 큐에서 노드를 하나 꺼냄
    x, y, t = q.popleft()

    # 도착지에 도착했다면 반복종료
    if x == n - 1 and y == m - 1:
        break

    # 상하좌우로 다음위치 탐색
    for d in range(4):
        # 다음위치
        nx = x + dx[d]
        ny = y + dy[d]
        
        # 미로를 벗어난다면 통과
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        # 이미 방문했다면 통과
        if visited[nx][ny]:
            continue
        
        # 이동할 수 있는 칸이면 이동
        if maze[nx][ny] == '1':
            q.append((nx, ny, t + 1))
            visited[nx][ny] = True

# 결과 출력
print(t)
