# 풀이 1
l = int(input())
s = input()

# 나머지끼리 더한 후 한번더 나머지를 구해준다
answer = 0
for i in range(l):
    answer += (ord(s[i]) - 96) * (31 ** i) % 1234567891
answer %= 1234567891

print(answer)

# 풀이 2
"""
# 31의 50승은 숫자가 너무 크므로 dp를 이용해 나머지를 구해준다

l = int(input())
s = input()

# dp를 이용한 나머지 구하기
r = [0] * l
r[0] = 1
for i in range(1, l):
    r[i] = r[i - 1] * 31 % 1234567891

# 구해놓은 나머지 리스트를 통해 answer 계산
answer = 0
for i in range(l):
    answer += (ord(s[i]) - 96) * r[i] % 1234567891
answer %= 1234567891

print(answer)
"""
