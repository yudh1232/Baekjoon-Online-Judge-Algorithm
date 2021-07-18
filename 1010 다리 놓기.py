import math

def solution(n, m):
    # nCm 수행
    if n > m:
        result = int(math.factorial(n) / (math.factorial(n - m) * math.factorial(m)))
        return result
    # mCn 수행
    else:
        result = int(math.factorial(m) / (math.factorial(m - n) * math.factorial(n)))
        return result

# 테스트 케이스의 수를 입력받음
t = int(input())

# 테스트 케이스를 입력받고 결과 출력
for _ in range(t):
    n, m = map(int, input().split())
    print(solution(n, m))
