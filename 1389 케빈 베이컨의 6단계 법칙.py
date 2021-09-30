import sys
input = sys.stdin.readline
INF = int(1e9) # 무한으로 10억을 설정

# n, m 을 입력받음
n, m = map(int, input().split())
# 그래프 생성하고 무한으로 초기화
graph = [[INF] * (n + 1) for _ in range(n + 1)]

# 자기자신과의 관계는 0으로 설정
for i in range(n + 1):
    graph[i][i] = 0

# 친구관계를 입력받음
for _ in range(m):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

# 플로이드 워셜 알고리즘
for k in range(1, n + 1):
    for a in range(1, n + 1):
        for b in range(1, n + 1):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# i행의 값을 더하여 i의 케빈 베이컨 수를 구함
min_kevin = INF 
min_index = 0
for i in range(1, n + 1):
    kevin = 0
    for j in range(1, n + 1):
        if graph[i][j] != INF:
            kevin += graph[i][j]

    # 케빈 베이컨 수 최소값 갱신
    if kevin < min_kevin:
        min_kevin = kevin
        min_index = i

# 결과 출력
print(min_index)
