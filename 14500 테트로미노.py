import sys
input = sys.stdin.readline

# i, j에 테트로미노를 놓아보고 합의 최대를 리턴
def calc(i, j):
    # 4x1 모양
    if i + 3 <= n - 1:
        temp1 = paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + paper[i + 3][j]
    else:
        temp1 = 0
    
    # 1x4 모양
    if j + 3 <= m - 1:
        temp2 = paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + paper[i][j + 3]
    else:
        temp2 = 0
    
    # 2x2 모양
    if i + 1 <= n - 1 and j + 1 <= m - 1:
        temp3 = paper[i][j] + paper[i + 1][j] + paper[i][j + 1] + paper[i + 1][j + 1]
    else:
        temp3 = 0
    
    # 3x2 모양 8가지
    if i + 2 <= n - 1 and j + 1 <= m - 1:
        temp4 = max(paper[i][j] + paper[i + 1][j] + paper[i + 2][j] + max(paper[i][j + 1], paper[i + 1][j + 1], paper[i + 2][j + 1]), paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 2][j + 1] + max(paper[i][j], paper[i + 1][j], paper[i + 2][j]), paper[i][j] + paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 2][j + 1], paper[i + 1][j] + paper[i + 2][j] + paper[i][j + 1] + paper[i + 1][j + 1])
    else:
        temp4 = 0

    # 2x3 모양 8가지
    if i + 1 <= n - 1 and j + 2 <= m - 1:
        temp5 = max(paper[i][j] + paper[i][j + 1] + paper[i][j + 2] + max(paper[i + 1][j], paper[i + 1][j + 1], paper[i + 1][j + 2]), paper[i + 1][j] + paper[i + 1][j + 1] + paper[i + 1][j + 2] + max(paper[i][j], paper[i][j + 1], paper[i][j + 2]), paper[i][j] + paper[i][j + 1] + paper[i + 1][j + 1] + paper[i + 1][j + 2], paper[i][j + 1] + paper[i][j + 2] + paper[i + 1][j] + paper[i + 1][j + 1])
    else:
        temp5 = 0
    
    # 최대를 리턴
    return max(temp1, temp2, temp3, temp4, temp5)


# n, m을 입력받음
n, m = map(int, input().split())

# 종이 리스트 생성
paper = []
# 종이 정보를 입력받음
for _ in range(n):
    paper.append(list(map(int, input().split())))

# 결과값 변수
answer = 0

# 각 칸에 테트로미노를 놓아봄
for i in range(n):
    for j in range(m):
        # 테트로미노를 놓아보고 결과값을 최대로 갱신
        answer = max(answer, calc(i, j))

# 결과 출력
print(answer)

# 풀이 2
"""
import sys
input = sys.stdin.readline

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# dfs방식으로 테트로미노를 놓아봄
def dfs(x, y, count, total):
    global answer

    # 프루닝
    if total + (4 - count) * max_val <= answer:
        return

    # 테트로미노를 놓았으면 결과를 최대로 갱신
    if count == 4:
        answer = max(answer, total)
        return
    
    # 상하좌우로 다음칸을 탐색
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        if visited[nx][ny]:
            continue

        # ㅗ, ㅓ, ㅜ, ㅏ 모양 처리
        if count == 2:
            visited[nx][ny] = True
            dfs(x, y, count + 1, total + paper[nx][ny])
            visited[nx][ny] = False

        visited[nx][ny] = True
        dfs(nx, ny, count + 1, total + paper[nx][ny])
        visited[nx][ny] = False

# n, m을 입력받음
n, m = map(int, input().split())

# 종이 리스트 생성
paper = []
# 종이 정보를 입력받음
for _ in range(n):
    paper.append(list(map(int, input().split())))
# 종이에 있는 최대값
max_val = max(map(max, paper))

# dfs를 위한 visited 리스트 생성
visited = [[False] * m for _ in range(n)]

# 결과값 변수
answer = 0

# 각 칸에 테트로미노를 놓아봄
for i in range(n):
    for j in range(m):
        visited[i][j] = True
        dfs(i, j, 1, paper[i][j])
        visited[i][j] = False

# 결과 출력
print(answer)
"""
