import sys
input = sys.stdin.readline

# 무한으로 10억을 설정
INF = int(1e9)

# n, m을 입력받음
n, m = map(int, input().split())

# 간선 리스트 생성
edges = []

# distance 리스트 생성
distance = [INF] * (n + 1)

# 간선 정보를 입력받음
for _ in range(m):
    a, b, c = map(int, input().split())
    edges.append((a, b, c))

# 벨만포드 알고리즘
def bf(start):
    # 시작노드의 distance는 0
    distance[start] = 0

    # n번 반복
    for i in range(n):
        # 모든 간선을 확인
        for j in range(m):
            cur_node = edges[j][0]
            next_node = edges[j][1]
            edge_cost = edges[j][2]

            # distance 업데이트
            if distance[cur_node] != INF and distance[cur_node] + edge_cost < distance[next_node]:
                distance[next_node] = distance[cur_node] + edge_cost
                # n번째에도 갱신이 일어났다면 음수순환이 존재
                if i == n - 1:
                    return True
    return False

# 벨만포드 알고리즘 수행
negative_cycle = bf(1)

# 음수순환이 있다면
if negative_cycle:
    print(-1)
# 음수순환이 없다면
else:
    # 결과 출력
    for i in range(2, n + 1):
        if distance[i] == INF:
            print(-1)
        else:
            print(distance[i])
