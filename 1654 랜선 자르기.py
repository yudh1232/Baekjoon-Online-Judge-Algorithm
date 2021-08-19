# k, n을 입력받음
k, n = map(int, input().split())

# 각 랜선길이를 입력받음
data = []
for _ in range(k):
    data.append(int(input()))

# 이진탐색 초기조건 설정
left = 1
right = max(data)

# 이진탐색
while True:
    if left > right:
        break

    middle = (left + right) // 2

    # 랜선을 만들어봄
    count = 0
    for d in data:
        count += d // middle

    # 만든 랜선이 목표보다 작을 경우
    if count < n:
        # 랜선 길이를 줄임
        right = middle - 1
    # 만든 랜선이 목표보다 크거나 같은 경우
    else:
        # 랜선 길이를 늘림
        left = middle + 1

print(right) # 결과 출력
