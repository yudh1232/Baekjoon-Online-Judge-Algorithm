n = int(input())
data = set(input().split())

m = int(input())
data2 = list(input().split())

for num in data2:
    if num in data:
        print(1)
    else:
        print(0)
