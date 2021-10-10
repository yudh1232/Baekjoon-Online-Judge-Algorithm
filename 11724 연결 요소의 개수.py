import sys
input = sys.stdin.readline
sys.setrecursionlimit(1000000)

# 연결된 노드들을 탐색하며 방문표시
def dfs(start):
    # 방문표시
    visited[start] = True
    
    # 현재와 연결된 노드를 모두 방문
    for next in graph[start]:
        if not visited[next]:
            dfs(next)

# n, m을 입력받음
n, m = map(int, input().split())

# 그래프 생성
graph = [[] for _ in range(n + 1)]

# 그래프 정보를 입력받음
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# dfs를 위해 visited 리스트 생성
visited = [False] * (n + 1)

# 결과값 변수
count = 0
# 1번노드부터 n번노드까지
for i in range(1, n + 1):
    # i번 노드가 아직 방문되지 않았다면 i와 연결된 노드를 모두 방문
    if not visited[i]:
        dfs(i)
        count += 1 # 연결요소 개수 증가

# 결과 출력
print(count)
