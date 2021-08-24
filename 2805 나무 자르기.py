# n, m을 입력받음
n, m = map(int, input().split())

# 나무의 높이를 입력받아 리스트에 넣음
data = list(map(int, input().split()))

# 이진탐색을 위한 left, right값 초기화
left = 0
right = max(data)

# 이진탐색
while left <= right:
    # 절단기의 높이
    middle = (left + right) // 2
    
    # 잘라낸 나무의 높이의 합
    wood_sum = 0

    # 잘라낸 나무의 높이의 합 계산
    for d in data:
        if d - middle > 0:
            wood_sum += d - middle
    
    # 합이 충분하다면
    if wood_sum >= m:
        # 절단기 높이를 높임
        left = middle + 1
    # 합이 모자르다면
    else:
        # 절단기 높이를 낮춤
        right = middle - 1

# 결과 출력
print(right)
