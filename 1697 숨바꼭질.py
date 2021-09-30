from collections import deque

# n, k를 입력받음
n, k = map(int, input().split())

# bfs를 위한 visited 리스트 생성
visited = [False] * 100001

# 큐를 생성하고 첫 노드를 넣음
q = deque()
q.append((n, 0))
visited[n] = True

# bfs
answer = 0
while q:
    # 노드를 하나 꺼냄
    x, t = q.popleft()

    # 동생을 찾았으면 answer를 업데이트하고 반복종료
    if x == k:
        answer = t
        break

    # x - 1로 걷기
    if x - 1 >= 0 and not visited[x - 1]:
        q.append((x - 1, t + 1))
        visited[x - 1] = True
    
    # x + 1로 걷기
    if x + 1 <= 100000 and not visited[x + 1]:
        q.append((x + 1, t + 1))
        visited[x + 1] = True
    
    # 2 * x로 순간이동
    if 2 * x <= 100000 and not visited[2 * x]:
        q.append((2 * x, t + 1))
        visited[2 * x] = True

# 결과 출력
print(answer)
