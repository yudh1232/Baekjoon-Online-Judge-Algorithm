import sys
input = sys.stdin.readline

# dfs 함수
def dfs(start):
    # 방문 처리
    visited[start] = True

    # 현재노드에서 갈 수 있는 노드 중에
    for next in graph[start]:
        # 아직 방문하지 않았다면 방문하러 감
        if not visited[next]:
            dfs(next)

# v, e를 입력받음
v = int(input())
e = int(input())

# graph와 visited 생성
graph = [[] for _ in range(v + 1)]
visited = [False] * (v + 1)

# 그래프 정보를 입력받음
for _ in range(e):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

# dfs 수행
dfs(1)

# 결과값 계산
answer = 0
# 2부터 v까지
for i in range(2, v + 1):
    # 방문됐다면 결과에 + 1
    if visited[i]:
        answer += 1

# 결과 출력
print(answer)
