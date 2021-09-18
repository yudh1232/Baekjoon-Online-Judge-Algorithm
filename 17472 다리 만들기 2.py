import sys
input = sys.stdin.readline

# 무한으로 10억을 설정
INF = int(1e9)

# 상하좌우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

# board에서 섬 번호를 매김
def dfs(x, y, number):
    visited[x][y] = True
    board[x][y] = number
    for d in range(4):
        nx = x + dx[d]
        ny = y + dy[d]
        if nx < 0 or nx >= n or ny < 0 or ny >= m:
            continue
        if visited[nx][ny]:
            continue
        if board[nx][ny] != 1:
            continue
        dfs(nx, ny, number)

# 가로로 섬과의 거리를 체크
def row_check(x, y, count):
    if y + 1 >= m:
        return
    if board[x][y + 1] == 0:
        count += 1
        row_check(x, y + 1, count)
    else:
        if board[x][y + 1] == k:
            return
        else:
            if count >= 2:
                graph[k][board[x][y + 1]] = min(graph[k][board[x][y + 1]], count)
                graph[board[x][y + 1]][k] = min(graph[board[x][y + 1]][k], count)

# 세로로 섬과의 거리를 체크
def col_check(x, y, count):
    if x + 1 >= n:
        return
    if board[x + 1][y] == 0:
        count += 1
        col_check(x + 1, y, count)
    else:
        if board[x + 1][y] == k:
            return
        else:
            if count >= 2:
                graph[k][board[x + 1][y]] = min(graph[k][board[x + 1][y]], count)
                graph[board[x + 1][y]][k] = min(graph[board[x + 1][y]][k], count)

# 특정 원소가 속한 집합을 찾기
def find_parent(parent, x):
    # 루트 노드가 아니라면, 루트 노드를 찾을 때까지 재귀적으로 호출
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

# 두 원소가 속한 집합을 합치기
def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a < b:
        parent[b] = a
    else:
        parent[a] = b

# n, m을 입력받음
n, m = map(int, input().split())

# 지도를 입력받음
board = []
for _ in range(n):
    board.append(list(map(int, input().split())))\

# dfs를 위한 visited 리스트
visited = [[False] * m for _ in range(n)]

# 섬 번호를 매김
number = 1
for i in range(n):
    for j in range(m):
        if board[i][j] != 0 and not visited[i][j]:
            dfs(i, j, number)
            number += 1

# 각 섬과의 거리를 저장하는 그래프 생성
graph = [[INF] * number for _ in range(number)]
for k in range(1, number):
    for i in range(n):
        for j in range(m):
            if board[i][j] == k:
                row_check(i, j, 0)
                col_check(i, j, 0)

# 크루스칼 알고리즘을 수행
edges = []
parent = [0] * number

# 부모 테이블상에서, 부모를 자기 자신으로 초기화
for i in range(1, number):
    parent[i] = i

for i in range(1, number):
    for j in range(i + 1, number):
        if graph[i][j] != INF:
            edges.append((graph[i][j], i, j))
    
edges.sort()

result = 0
selected_edgecount = 0
# 간선을 하나씩 확인하며
for edge in edges:
    cost, a, b = edge
    # 사이클이 발생하지 않는 경우에만 집합에 포함
    if find_parent(parent, a) != find_parent(parent, b):
        union_parent(parent, a, b)
        result += cost
        selected_edgecount += 1

# MST가 완성되지 않았다면
if selected_edgecount != number - 2:
    print(-1)
# MST가 완성됐다면
else:
    print(result)
