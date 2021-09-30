# 식을 입력받고 '-'로 구분하여 분리
split_by_minus = list(input().split('-'))

# '-'로 분리된 식 각각을 '+'로 분리
split_by_plus = []
for s in split_by_minus:
    split_by_plus.append(list(s.split('+')))

# '-'로 분리한 것 중 첫번째는 answer에 더함
answer = 0
for n in split_by_plus[0]:
    answer += int(n)

# 첫번째가 아닌 나머지는 answer에 뺌
for i in range(1, len(split_by_plus)):
    for n in split_by_plus[i]:
        answer -= int(n)

# 결과 출력
print(answer)
