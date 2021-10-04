import sys
input = sys.stdin.readline

# 각 단지에 속하는 집의 수를 구함
def dfs(x, y):
    # 집의 수를 전역변수로 선언
    global count

    # 방문 표시
    visited[x][y] = True
    # 집의 수 + 1
    count += 1

    # 상하좌우에 대하여
    for d in range(4):
        # 다음 좌표
        nx = x + dx[d]
        ny = y + dy[d]
        
        # 다음 좌표가 리스트를 벗어나면 패스
        if nx < 0 or nx >= n or ny < 0 or ny >= n:
            continue
        
        # 다음 좌표가 집이고, 방문하지 않았다면
        if data[nx][ny] == 1 and not visited[nx][ny]:
            # 방문하러 감
            dfs(nx, ny)
        

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# n을 입력받음
n = int(input())

# 지도 정보를 입력받음
data = [[0] * n for _ in range(n)]
for i in range(n):
    s = list(input().rstrip())
    for j in range(len(s)):
        data[i][j] = int(s[j])

# visited 리스트 생성
visited = [[False] * n for _ in range(n)]

# 단지별 집의 수 리스트 생성
answer = []

# 지도의 각 칸을 살펴보며
for i in range(n):
    for j in range(n):
        # 칸이 집이면서 아직 방문하지 않았다면, dfs로 그 단지의 집의 수를 셈 
        if data[i][j] == 1 and not visited[i][j]:
            count = 0
            dfs(i, j)
            answer.append(count)

# 단지내 집의 수를 오름차순으로 정렬
answer.sort()

# 결과 출력
print(len(answer))
for c in answer:
    print(c)
