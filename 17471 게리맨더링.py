import sys
input = sys.stdin.readline
from itertools import combinations
from collections import deque


# 선거구가 유효한지 체크하는 함수, bfs
def is_connected(arr):
    visited = [False] * (n + 1)
    
    q = deque()

    # 시작노드를 큐에 넣고 방문처리
    start = arr[0]
    q.append(start)
    visited[start] = True

    # bfs
    while q:
        now = q.popleft()

        for i in range(1, n + 1):
            # 현재에서 갈 수 있는 노드 중에서, arr에 있고, 아직 방문하지 않았다면
            if graph[now][i] == 1 and i in arr and not visited[i]:
                # 큐에 넣고 방문처리
                q.append(i)
                visited[i] = True

    # 해당 선거구의 모든 구역을 방문했다면 
    if visited.count(True) == len(arr):
        return True
    # 해당 선거구의 모든 구역을 방문하지 못했다면
    else:
        return False


# 무한으로 10억을 설정
INF = int(1e9)

# n을 입력받음
n = int(input())

# 조합을 이용하기 위해 1 ~ n 숫자를 담는 리스트
numbers = []
for i in range(1, n + 1):
    numbers.append(i)

# 구역별 인구수를 입력받음
population = [0] + list(map(int, input().split()))

# 전체 인구수 계산
pop_sum = sum(population)

# 그래프 생성
graph = [[0] * (n + 1) for _ in range(n + 1)]

# 그래프 정보를 입력받음
for i in range(1, n + 1):
    data = list(map(int, input().split()))
    for j in range(1, data[0] + 1):
        graph[i][data[j]] = 1
        graph[data[j]][i] = 1

# 결과값, 최소를 구하기 위해 큰값으로 설정
answer = INF

# nC1 ~ nCn//2을 조사
for k in range(1, n // 2 + 1):
    for a in combinations(numbers, k):
        b = [x for x in numbers if x not in a]
        
        # a, b 선거구의 인구 차이가 현재 answer보다 크면 통과
        a_pop_sum = 0
        for i in a:
            a_pop_sum += population[i]
        b_pop_sum = pop_sum - a_pop_sum
        difference = abs(a_pop_sum - b_pop_sum)
        if difference >= answer:
            continue
        
        # a 선거구도 유효하고, b 선거구도 유효하면 answer 갱신
        if is_connected(a) and is_connected(b):
            answer = difference

# 결과 출력
if answer == INF: # 두 선거구로 나눌 수 없었다면
    print(-1)
else: # 나눌 수 있었다면
    print(answer)
