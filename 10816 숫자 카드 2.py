# 각 숫자의 카운트를 셀 배열을 만듦
count = [0] * 20000001

# n을 입력받음
n = int(input())
# 숫자 카드에 적힌 수를 입력받음
data = list(map(int, input().split()))

# 각 숫자의 카운트를 셈
for d in data:
    count[d + 10000000] += 1

# m을 입력받음
m = int(input())
# 몇개 가지고 있는지 구해야 할 숫자를 입력받음
data2 = list(map(int, input().split()))

# 결과 출력
for d in data2:
    print(count[d + 10000000], end = ' ')
