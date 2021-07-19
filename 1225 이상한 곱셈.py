# 문자열 a, b를 입력받음
string_a, string_b = input().split()
a, b = 0, 0

# 문자열 a의 각 자리를 더함
for i in range(len(string_a)):
    a += int(string_a[i])

# 문자열 b의 각 자리를 더함
for i in range(len(string_b)):
    b += int(string_b[i])

print(a * b) # 결과 출력
