import sys
input = sys.stdin.readline

# 무한으로 10억을 설정
INF = int(1e9)

# n을 입력받음
n = int(input())

# 그래프 정보를 입력받음
graph = []
for _ in range(n):
    graph.append(list(map(int, input().split())))

# 연결이 안된것은 무한으로 설정
for i in range(n):
    for j in range(n):
        if graph[i][j] == 0:
            graph[i][j] = INF

# 플로이드워셜 알고리즘
for k in range(n):
    for a in range(n):
        for b in range(n):
            graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b])

# 경로가 있는것은 1로 없는것은 0으로 수정
for i in range(n):
    for j in range(n):
        if graph[i][j] == INF:
            graph[i][j] = 0
        elif graph[i][j] >= 1:
            graph[i][j] = 1

# 결과 출력
for i in range(n):
    for j in range(n):
        print(graph[i][j], end = ' ')
    print()
