from collections import deque

# t를 입력받음
t = int(input())

for _ in range(t):
    
    # n, m을 입력받음
    n, m = map(int, input().split())
    
    # 중요도를 입력받아 리스트에 넣음
    importance = list(map(int, input().split()))

    # 큐 생성
    q = deque()

    # 큐에 (중요도, 알고 싶은 문서인지 여부)를 넣음
    for i in range(n):
        # 알고 싶은 문서라면
        if i == m:
            q.append((importance[i], 1))
        # 알고 싶은 문서가 아니면
        else:
            q.append((importance[i], 0))
    
    # 인쇄횟수
    count = 0


    while True:
        # 큐에서 하나 꺼냄
        p = q.popleft()

        # 큐가 비었거나 중요도가 가장 큰 문서일 경우 
        if len(q) == 0 or p[0] >= max(q)[0]:
            # 인쇄횟수 증가
            count += 1
            # 알고 싶은 문서였다면
            if p[1] == 1:
                print(count) # 결과 출력
                break

        # 중요도가 가장 큰 문서가 아닌 경우 큐에 다시 넣음
        else:
            q.append(p)
