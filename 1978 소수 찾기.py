def is_prime(num):
    if num == 1:
        return False
    for i in range(2, int(num ** 0.5) + 1):
        if num % i == 0:
            return False
    return True

n = int(input())
data = list(map(int, input().split()))

count = 0
for i in data:
    if is_prime(i):
        count += 1
print(count)
