from itertools import product

# n을 입력받음
n = int(input())

# m을 입력받음
m = int(input())

# m이 0이면
if m == 0:
    wrong = []
# m이 0이 아니면 고장난 버튼을 입력받음
else:
    wrong = list(map(int, input().split()))

# 고장나지 않은 버튼들의 리스트
button = [x for x in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] if x not in wrong]

# 결과값
answer = abs(n - 100)

# n의 길이
length = len(str(n))

# length - 1 <= i <= length + 1인 i에 대하여
for i in range(length - 1, length + 2):
    # 0자리나 7자리는 통과
    if i == 0 or i == 7:
        continue
    
    # 중복순열로 가능한 숫자를 만듦
    for p in product(button, repeat = i):
        k = 0
        for j in range(i):
            k += p[j] * (10 ** (i - j - 1))
        # 결과값을 최소로 갱신해 감
        answer = min(answer, abs(n - k) + i)

# 결과 출력
print(answer)
