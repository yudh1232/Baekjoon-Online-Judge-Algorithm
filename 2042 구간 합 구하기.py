import sys
input = sys.stdin.readline

# n, m, k를 입력받음
n, m, k = map(int, input().split())

number = [0] * 1000001
s = [0] * 1000001

# n개의 숫자들을 입력받고, number[1] ~ number[i]까지의 합 s[i]를 계산
for i in range(1, n + 1):
    number[i] = int(input())
    s[i] = s[i - 1] + number[i]

# 변경된 사항을 담는 리스트, (x, y): x번째 숫자가 기존과 y만큼의 차이로 변경됨
changed = []

for _ in range(m + k):
    # a, b, c를 입력받음
    a, b, c = map(int, input().split())

    # a가 1이면
    if a == 1:
        # 변경된 사항을 담음, b번째 숫자가 c - number[b]만큼의 차이로 변경됨
        changed.append((b, c - number[b]))
        # number[b]를 업데이트
        number[b] = c
    else:
        # 변경사항을 고려하지 않은 구간합이었으면 s[c] - s[b - 1]임
        right = s[c]
        left = s[b - 1]

        # 변경사항을 살펴보며
        for ch in changed:
            # ch[0]번째가 변경됐으면 그 이후의 숫자는 모두 변경되므로 c >= ch[0]이면
            if c >= ch[0]:
                right += ch[1]
            # b - 1 >= ch[0]이면
            if b - 1 >= ch[0]:
                left += ch[1]
        
        # 결과 출력
        print(right - left)
