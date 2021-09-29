import sys
input = sys.stdin.readline
from collections import deque

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1 ,1]

# n, m을 입력받음
n, m = map(int, input().split())

# 미로정보를 입력받음
maze = []
for _ in range(n):
    maze.append(list(input().rstrip()))

# 시작지점을 저장
start_x, start_y = 0, 0
for i in range(n):
    for j in range(m):
        if maze[i][j] == '0':
            start_x, start_y = i, j
            maze[i][j] = '.'
            break

# x, y좌표와 열쇠획득여부까지 더해 3차원으로 visited 리스트를 생성
# 비트마스킹, 111111 => 열쇠 f, e, d, c, b, a 소유
visited = [[[0] * 64 for _ in range(m)] for _ in range(n)]

# 큐에 첫 노드 삽입
q = deque()
visited[start_x][start_y][0] = 1
q.append((start_x, start_y, 0))

# 결과값
answer = 0

# 탈출에 성공했는지 나타내는 변수 
finish_flag = False

# bfs
while q:
    # 큐에서 노드를 하나 꺼냄
    x, y, z = q.popleft()

    # 상하좌우
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        # 리스트를 벗어나면 통과
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        # 이미 방문했으면 통과
        if visited[nx][ny][z] != 0:
            continue

        # .을 만나면
        if maze[nx][ny] == '.':
            # 다음노드를 넣음
            visited[nx][ny][z] = visited[x][y][z] + 1
            q.append((nx, ny, z))
        # 1을 만나면
        elif maze[nx][ny] == '1':
            # 결과값 갱신하고 for문 탈출
            answer = visited[x][y][z]
            finish_flag = True
            break
        # a~f를 만나면
        elif maze[nx][ny].islower():
            # 키 비트 갱신, 다음노드를 넣음
            nz = z | (1 << ord(maze[nx][ny]) - ord('a'))
            visited[nx][ny][nz] = visited[x][y][z] + 1
            q.append((nx, ny, nz))
        # A~F를 만나면
        elif maze[nx][ny].isupper():
            # 키 비트를 통해 들어갈 수 있는지 체크
            if z & (1 << ord(maze[nx][ny]) - ord('A')):
                # 다음노드를 넣음
                visited[nx][ny][z] = visited[x][y][z] + 1
                q.append((nx, ny, z))

    # 탈출에 성공했다면 while문 탈출
    if finish_flag:
        break

# 결과 출력
if finish_flag:
    print(answer)
else:
    print(-1)
