import heapq
import sys
input = sys.stdin.readline
INF = int(1e9) # 무한 값 10억으로 설정

# v, e, 시작 정점 번호를 입력받음
v, e = map(int, input().split())
start = int(input())

# graph 2차원 리스트 생성
graph = [[] for _ in range(v + 1)]

# distance 리스트 생성
distance = [INF] * (v + 1)

# graph 정보를 입력받음
for _ in range(e):
    a, b, w = map(int, input().split())
    graph[a].append((b, w))

# 다익스트라 알고리즘
def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0
    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))

# 다익스트라 알고리즘 수행
dijkstra(start)

# 결과 출력
for i in range(1, v + 1):
    if distance[i] == INF:
        print('INF')
    else:
        print(distance[i])
