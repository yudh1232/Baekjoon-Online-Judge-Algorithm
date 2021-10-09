import sys
input = sys.stdin.readline
from collections import deque

# t를 입력받음
t = int(input())
# t만큼 반복
for _ in range(t):
    # a, b를 입력받음
    a, b = map(int, input().split())

    # bfs를 위한 visited 리스트 생성
    visited = [False] * 10000

    # 큐 생성 및 초기값 넣기
    q = deque()
    q.append((a, 0))

    # bfs
    while q:
        # 큐에서 노드를 하나 꺼냄
        a, c = q.popleft()

        # a와 b가 같으면
        if a == b:
            # 출력문 생성
            answer = ''
            while c > 0:
                r = c % 10
                if r == 1:
                    answer = 'L' + answer
                elif r == 2:
                    answer = 'R' + answer
                elif r == 3:
                    answer = 'D' + answer
                else:
                    answer = 'S' + answer
                c = c // 10
            # 결과 출력, 큐 비우기, bfs 종료
            print(answer)
            q.clear()
            break
        
        # L인 경우를 큐에 넣고 방문 표시
        next = (a % 1000) * 10 + a // 1000
        if not visited[next]:
            visited[next] = True
            q.append((next, c * 10 + 1))

        # R인 경우를 큐에 넣고 방문 표시
        next = (a % 10) * 1000 + a // 10
        if not visited[next]:
            visited[next] = True
            q.append((next, c * 10 + 2))

        # D인 경우를 큐에 넣고 방문 표시
        next = (2 * a) % 10000
        if not visited[next]:
            visited[next] = True
            q.append((next, c * 10 + 3))

        # S인 경우를 큐에 넣고 방문 표시
        next = a - 1
        if next == -1:
            if not visited[9999]:
                visited[9999] = True
                q.append((9999, c * 10 + 4))
        else:
            if not visited[next]:
                visited[next] = True
                q.append((next, c * 10 + 4))
