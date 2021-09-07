import sys
input = sys.stdin.readline

# 땅 높이 정보를 담을 리스트
land = []

# n, m, b를 입력받음
n, m, b = map(int, input().split())

# 땅 높이 정보를 입력받음
for _ in range(n):
    land.append(list(map(int, input().split())))

# 땅 높이의 최댓값과 최솟값을 구함
max_h = max(map(max, land))
min_h = min(map(min, land))

# 답 시간과 높이 초기화
answer_t = int(1e9)
answer_h = min_h

# h: 고르게 했을 때의 높이
for h in range(min_h, max_h + 1):
    t = 0
    temp_b = b
    for i in range(n):
        for j in range(m):
            # 고르게 했을 때의 높이가 땅 높이보다 큰 경우 블록을 놓아야함
            if h > land[i][j]:
                t += h - land[i][j]
                temp_b -= h - land[i][j]
            # 고르게 했을 때의 높이가 땅 높이보다 크지 않은 경우 블록을 제거해야 함
            else:
                t += 2 * (land[i][j] - h)
                temp_b += land[i][j] - h
    
    # 블록을 채워넣을 수 없거나, 이전에 비해 시간이 많이 걸린 경우 break
    if temp_b < 0 or t > answer_t:
        break
    
    answer_t = t
    answer_h = h

# 결과 출력
print(answer_t, answer_h)

# 풀이 2
"""
import sys
input = sys.stdin.readline

# 땅 높이 정보를 담을 리스트
land = [0] * 257

# n, m, b를 입력받음
n, m, b = map(int, input().split())

max_h = 0
min_h = 256

# 땅 높이 정보를 입력받음
for _ in range(n):
    data = list(map(int, input().split()))
    for d in data:
        max_h = max(max_h, d)
        min_h = min(min_h, d)
        land[d] += 1

# 답 시간과 높이 초기화
answer_t = int(1e9)
answer_h = min_h

# h: 고르게 했을 때의 높이
for h in range(min_h, max_h + 1):
    t = 0
    temp_b = b

    for i in range(min_h, max_h + 1):
        # 블록을 놓는 경우
        if h > i:
            t += (h - i) * land[i]
            temp_b -= (h - i) * land[i]
        # 블록을 제거하는 경우
        else:
            t += 2 * (i - h) * land[i]
            temp_b += (i - h) * land[i]
    
    # 블록을 채워넣을 수 없거나, 이전에 비해 시간이 많이 걸린 경우 break
    if temp_b < 0 or t > answer_t:
        break
    
    answer_t = t
    answer_h = h

# 결과 출력
print(answer_t, answer_h)
"""
