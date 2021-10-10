from collections import deque

# n, m을 입력받음
n, m = map(int, input().split())

# 뱀과 사다리정보를 담는 dict => key: 출발점, value: 도착점
dic = {}
for _ in range(n + m):
    a, b = map(int, input().split())
    dic[a] = b

# bfs를 위한 visited 리스트 생성
visited = [False] * 101

# 큐 생성, 첫 노드를 넣음
q = deque()
visited[1] = True
q.append((1, 0))

# bfs
while q:
    # 큐에서 노드를 하나 꺼냄
    now, t = q.popleft()

    # 도착했으면 결과 출력 후 종료
    if now == 100:
        print(t)
        break

    # 현재 노드에서 +1 ~ +6을 가봄
    for i in range(1, 7):
        # 다음노드
        next = now + i
        # 100을 넘거나 이미 방문했으면 통과
        if next > 100 or visited[next]:
            continue
        
        # 다음노드 방문표시
        visited[next] = True
        # 사다리나 뱀의 시작점이 있는 곳이면, 사다리나 뱀을 타고 도착한 위치도 방문표시
        if next in dic:
            next = dic[next]
            visited[next] = True

        # 다음노드를 큐에 넣음
        q.append((next, t + 1))
