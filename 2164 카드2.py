from collections import deque

# n을 입력받음
n = int(input())

# 1 ~ n으로 구성된 리스트 생성
data = [0] * n
for i in range(n):
    data[i] = i + 1

# 큐 생성
q = deque(data)

# 위에 카드를 버리고, 그 다음 카드를 아래로 옮김
for _ in range(n - 1):
    q.popleft()
    temp = q.popleft()
    q.append(temp)

# 결과(남은 카드) 출력
print(q.popleft())
