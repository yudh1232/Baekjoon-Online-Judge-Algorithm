def is_prime(num):
    if num == 1:
        return False
    else:
        # num의 제곱근까지만 살펴보면 됨
        for k in range(2, int(num ** 0.5) + 1):
            # num이 1 이외의 약수가 있다면
            if num % k == 0:
                return False

        # num의 약수가 1 뿐이라면
        return True

# m, n을 입력받음
m, n = map(int, input().split())

for i in range(m, n + 1):
    # 소수이면 출력
    if is_prime(i):
        print(i)
