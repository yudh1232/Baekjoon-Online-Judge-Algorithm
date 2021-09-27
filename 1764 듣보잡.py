import sys
input = sys.stdin.readline

# n, m을 입력받음
n, m = map(int, input().split())

# 듣도 못한 사람 set 생성
not_heard = set()

# 보도 못한 사람 set 생성
not_seen = set()

# 듣도 못한 사람을 입력받음
for _ in range(n):
    not_heard.add(input().rstrip())

# 보도 못한 사람을 입력받음
for _ in range(m):
    not_seen.add(input().rstrip())

# 듣도 보도 못한 사람을 교집합을 이용해서 만들고 리스트화 시킴 
list1 = list(not_heard & not_seen)

# 사전순으로 정렬
list1.sort()

# 결과 출력
print(len(list1))
for name in list1:
    print(name)
