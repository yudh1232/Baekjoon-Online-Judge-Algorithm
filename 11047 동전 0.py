import sys
input = sys.stdin.readline

# n, k를 입력받음
n, k = map(int, input().split())

# 동전의 종류를 입력받음
coin_type = []
for _ in range(n):
    coin_type.append(int(input()))

# 동전의 개수
count = 0

# 큰 가치의 동전부터 살펴봄
for i in range(len(coin_type) - 1, -1, -1):
    # k가 0이면 반복 종료
    if k == 0:
        break
    
    # k를 현재동전의가치로 나눈 몫만큼 count에 더함
    count += k // coin_type[i]
    # k를 현재동전의가치로 나눈 나머지로 갱신
    k %= coin_type[i]

# 결과 출력
print(count)
