import sys
input = sys.stdin.readline
from collections import deque

# 무한값으로 10억을 설정
INF = int(1e9)

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# 점프(말의 이동)
jump_dx = [-2, -2, -1, -1, 1, 1, 2, 2]
jump_dy = [-1, 1, -2, 2, -2, 2, -1, 1]

k = int(input())
w, h = map(int, input().split())

grid = []
for _ in range(h):
    grid.append(list(map(int, input().split())))

# 점프를 k번했을때의 동작 수
dp = [[[INF] * w for _ in range(h)] for _ in range(k + 1)]
dp[0][0][0] = 0

q = deque()
q.append(((0, 0), k))

# 도착점에 도달했는지 나타내는 플래그
flag = False

# bfs
while q:
    # 큐에서 하나 꺼냄
    now, jumpable_count = q.popleft()
    x, y = now

    # 도착점에 도달한 경우
    if x == h - 1 and y == w - 1:
        # 결과 출력
        print(dp[k - jumpable_count][x][y])
        flag = True
        break

    # 점프를 안하는 경우
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if nx < 0 or ny < 0 or nx >= h or ny >= w:
            continue
        if grid[nx][ny] == 1:
            continue
        # 아직 방문하지 않은 칸을 만나면
        if dp[k - jumpable_count][nx][ny] == INF:
            # dp 테이블 업데이트
            dp[k - jumpable_count][nx][ny] = dp[k - jumpable_count][x][y] + 1
            # 큐에 넣음
            q.append(((nx, ny), jumpable_count))

    # 점프를 하는 경우
    if jumpable_count != 0:
        for d in range(8):
            nx = x + jump_dx[d]
            ny = y + jump_dy[d]
            if nx < 0 or ny < 0 or nx >= h or ny >= w:
                continue
            if grid[nx][ny] == 1:
                continue
            # 아직 방문하지 않은 칸을 만나면
            if dp[k - jumpable_count + 1][nx][ny] == INF:
                # dp 테이블 업데이트
                dp[k - jumpable_count + 1][nx][ny] = dp[k - jumpable_count][x][y] + 1
                # 점프 가능 횟수를 1 감소시켜서 큐에 넣음
                q.append(((nx, ny), jumpable_count - 1))

# 도착점에 도달 못했으면 -1 출력
if flag == False:
    print(-1)
