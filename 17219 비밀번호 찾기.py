import sys
input = sys.stdin.readline

# n, m을 입력받음
n, m = map(int, input().split())
# dict 생성 => key: 주소, value: 비밀번호
dic = {}

# 주소와 비밀번호를 입력받고 dict에 넣음
for _ in range(n):
    address, password = input().split()
    dic[address] = password

# 입력받은 주소에 따른 비밀번호를 출력
for _ in range(m):
    address = input().rstrip()
    print(dic[address])
