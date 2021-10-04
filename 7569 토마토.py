import sys
input = sys.stdin.readline
from collections import deque

# 여섯방향
dz = [0, 0, 0, 0, -1, 1]
dx = [-1, 1, 0, 0, 0, 0]
dy = [0, 0, -1, 1, 0, 0]

# m, n, h를 입력받음
m, n, h = map(int, input().split())

# 토마토 농장 리스트 생성
farm = [[] for _ in range(h)]

# 토마토 농장 정보를 입력받음
for k in range(h):
    for i in range(n):
        farm[k].append(list(map(int, input().split())))

# bfs를 위한 visited 리스트 생성
visited = [[[False] * m for _ in range(n)] for _ in range(h)]

# bfs를 위한 큐 생성
q = deque()

# 안 익은 토마토 수
unripe_count = 0

# 토마토 농장을 한 칸씩 살펴보며
for k in range(h):
    for i in range(n):
        for j in range(m):
            # 안 익은 토마토면
            if farm[k][i][j] == 0:
                # 안 익은 토마토 수 증가
                unripe_count += 1
            # 익은 토마토면
            elif farm[k][i][j] == 1:
                # 큐에 넣고, 방문 처리
                q.append((k, i, j))
                visited[k][i][j] = True

# 일수를 나타내는 변수
level = 0

# bfs
while q:
    # 안 익은 토마토가 없으면 bfs 종료
    if unripe_count == 0:
        break

    # level 별로 bfs를 수행하기 위한 size 변수
    size = len(q)

    # level 별로 bfs 수행
    for _ in range(size):
        # 큐에서 노드를 하나 꺼냄
        now = q.popleft()
        z, x, y = now

        # 여섯방향에 대하여
        for d in range(6):
            nz = z + dz[d]
            nx = x + dx[d]
            ny = y + dy[d]

            # 리스트를 벗어나면 패스
            if nz < 0 or nz >= h or nx < 0 or nx >= n or ny < 0 or ny >= m:
                continue
            # 이미 방문했으면 패스
            if visited[nz][nx][ny]:
                continue
            
            # 다음 위치가 안 익은 토마토이면
            if farm[nz][nx][ny] == 0:
                # 익은 토마토로 바꿈
                farm[nz][nx][ny] = 1
                # 안 익은 토마토 수 감소
                unripe_count -= 1
                # 큐에 넣고, 방문 처리
                q.append((nz, nx, ny))
                visited[nz][nx][ny] = True
    # level 증가
    level += 1

# bfs를 마치고 안 익은 토마토가 없는 경우
if unripe_count == 0:
    # 일수 출력
    print(level)
# 안 익은 토마토가 있는 경우
else:
    # -1 출력
    print(-1)
